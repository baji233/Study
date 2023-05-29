<template>
  <div class="page">
    <el-row :gutter="20">
      <el-col :span="24" >
        <el-row class="top">
          <el-input placeholder="请输入内容" class="search" v-model="name">
          </el-input>
          <el-button plain class="searchButton" icon="el-icon-search" @click="search">搜索</el-button>
          <el-button type="primary" plain icon="el-icon-plus" @click="addDialogVisible=true" style="border: 1px solid #409EFF">新增</el-button>
          <el-dialog
            :modal="false"
            title="新增"
            :before-close="closeAddDialog"
            width="32%"
            top="10vh"
            :visible.sync="addDialogVisible"
          >
            <el-form :model="form" label-width="80px" :rules="rules" ref="form">
              <el-form-item label="商品图片" prop="image">
                <el-upload
                  class="upload-demo"
                  action="http://localhost:5000/goods/upload/"
                  :on-preview="handlePreview"
                  :on-remove="handleRemove"
                  :before-remove="beforeRemove"
                  :on-success="uploadSuccess"
                  :before-upload="beforeAvatarUpload"
                  :on-exceed="uploadExceed"
                  multiple
                  ref="upload"
                  :limit="1"
                  >
                  <el-button size="small" type="primary">点击上传</el-button>
                  <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
                </el-upload>
              </el-form-item>
              <el-form-item label="商品名称" prop="name">
                <el-input v-model="form.name" placeholder="请输入内容"></el-input>
              </el-form-item>
              <el-form-item label="商品价格" prop="price">
                <el-input-number v-model="form.price" :precision="2" :step="1" :max="10000"></el-input-number>
              </el-form-item>
              <el-form-item label="商品库存" prop="store">
                <el-input-number v-model="form.store" :step="1" :max="10000"></el-input-number>
              </el-form-item>
              <el-form-item label="单位" prop="unit">
                <el-select v-model="form.unit" placeholder="请选择">
                  <el-option
                    v-for="(item,index) in unit"
                    :key="index"
                    :label="item"
                    :value="item">
                  </el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="规格" prop="specs">
                <el-input v-model="form.specs" placeholder="请输入规格"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="onSubmit('rules')">添加</el-button>
                <el-button @click="closeAddDialog">退出</el-button>
              </el-form-item>
            </el-form>
          </el-dialog>
        </el-row>
      </el-col>
      <el-col :span="24" class="center">
        <el-table
          v-loading="listLoading"
          :data="tableData"
          border
          height="100%"
          style="width: 100%;">
          <el-table-column
            prop="image"
            label="商品图片"
            width="180">
            <template v-slot="{row}">
              <el-image
                style="width: 100px; height: 100px"
                :src="`http://localhost:5000/public/${row.image}`"
                fit="fit"></el-image>
            </template>
          </el-table-column>
          <el-table-column
            prop="name"
            label="商品名称"
            width="180">
          </el-table-column>
          <el-table-column
            prop="price"
            label="商品价格">
          </el-table-column>
          <el-table-column
          prop="store"
          label="商品库存">
        </el-table-column>
          <el-table-column
            prop="unit"
            label="单位">
          </el-table-column>
          <el-table-column
            prop="specs"
            label="规格">
          </el-table-column>
          <el-table-column
            label="操作" align="center">
            <template v-slot="{row}">
              <el-button @click="openUpdDialog(row.goods_id)" type="primary" >编辑</el-button>
                <el-popconfirm
                  confirm-button-text='好的'
                  cancel-button-text='不用了'
                  icon="el-icon-info"
                  icon-color="red"
                  title="这是一段内容确定删除吗？"
                  @onConfirm="del(row.goods_id)"
                >
                  <el-button slot="reference" type="danger"  style="background-color: transparent;color: red;margin-left: 10px"  plain>删除</el-button>
                </el-popconfirm>
              </template>
          </el-table-column>
        </el-table>
      </el-col>
      <el-col :span="24">
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          style="text-align: center;margin-top: 20px;"
          :page-sizes="[5, 10, 15, 20, 30, 50]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :current-page="pageNum"
          :total="count"
         >
        </el-pagination>
      </el-col>
    </el-row>
    <el-dialog
      :modal="false"
      title="编辑"
      :before-close="closeUpdDialog"
      width="32%"
      top="10vh"
      :visible.sync="updDialogVisible"
    >
      <el-form :model="form2" label-width="80px" ref="form2" :rules="rules">
        <el-form-item label="商品图片" prop="image">
          <el-upload
            class="upload-demo"
            action="http://localhost:5000/goods/upload/"
            :on-preview="handlePreview"
            :on-remove="handleRemove"
            :before-remove="beforeRemove"
            :on-success="uploadSuccess2"
            :before-upload="beforeAvatarUpload"
            :on-exceed="uploadExceed"
            multiple
            ref="upload2"
            :file-list="fileList2"
            :limit="1"
          >
            <el-button size="small" type="primary">点击上传</el-button>
            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
          </el-upload>
        </el-form-item>
        <el-form-item label="商品名称" prop="name">
          <el-input v-model="form2.name" placeholder="请输入内容"></el-input>
        </el-form-item>
        <el-form-item label="商品价格" prop="price">
          <el-input-number v-model="form2.price" :precision="2" :step="1" :max="10000"></el-input-number>
        </el-form-item>
        <el-form-item label="商品库存" prop="store">
          <el-input-number v-model="form2.store" :step="1" :max="10000"></el-input-number>
        </el-form-item>
        <el-form-item label="单位" prop="unit">
          <el-select v-model="form2.unit" placeholder="请选择">
            <el-option
              v-for="(item,index) in unit"
              :key="index"
              :label="item"
              :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="规格" prop="specs">
          <el-input v-model="form2.specs" placeholder="请输入规格"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit2()">编辑</el-button>
          <el-button @click="closeUpdDialog">退出</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

  </div>
</template>

<script>
import {selectPage,del} from '@/dao/goods'
export default {
  data(){
    return {
      tableData: [],
      fileList: [],
      rules:{
        name:[
          {
            required:true,message:"商品名称必填",
          }
        ],
        unit:[
          {
            required:true,message:"单位必填",
          }
        ],
        specs:[
          {
            required:true,message:"规格必填",
          }
        ],
        store:[
          {
            required:true,message:"库存必填",
          }
        ],
        price:[
          {
            required:true,message:"价格必填",
          },
        ],
        image:[
          {
            required:true,message:"图片必选",
          },
        ]
      },
      name:'',
      count:0,
      pageSize:5,
      pageNum:1,
      listLoading:false,
      updDialogVisible:false,
      addDialogVisible:false,
      form: {
        name: '',
        price: '',
        store:'',
        details:'',
        unit:'',
        specs:'',
        image:'',
      },
      form2: {
        name: '',
        price: '',
        store:'',
        details:'',
        unit:'',
        specs:'',
        image:'',
        goods_id:''
      },
      num:'',
      input:'',
      searchName:'',
      multiple: false,
      unit:['瓶','本','块','盒','罐','卷','套'],
      fileList2:[]
    }
  },
  methods:{
    openUpdDialog(goodsid){
      this.updDialogVisible=true;
      console.log(goodsid)
      this.$axios.get(`/goods/select?goodsid=${goodsid}`).then((res)=>{
        this.form2=res.data[0];
      }).catch((err)=>{
        console.log(err)
      })
    },
    closeAddDialog(){
      this.addDialogVisible=false;
      for(let item in this.form){
        this.form[item]=''
      }
      this.$refs.upload.fileList.pop();
      this.$refs['form'].resetFields(()=>{
        return false;
      })
    },
    closeUpdDialog(){
      this.updDialogVisible=false;
      // for(let item in this.form2){
      //   this.form2[item]=''
      // }
      // this.$refs.upload2.fileList.pop();
      // this.$refs['form2'].resetFields(()=>{
      //   return false;
      // })
    },
    uploadExceed(files,fileList){
      this.$message.warning('只能上传一个文件')
    },
    uploadSuccess(req){
      this.form.image=req.data;
    },
    uploadSuccess2(req){
      this.form2.image=req.data;
    },
    sendRequestUrl({name,pageNum,pageSize}){
      let url= '/goods/getNamePage?';
      url=name?url+`name=${name}&`:url;
      url=pageNum!=null?url+`pageNum=${pageNum}&`:url;
      url=pageSize!=null?url+`pageSize=${pageSize}&`:url;
      return url;
    },
    del(goodsId){
      del(this,goodsId)
    },
    getdata(){
      selectPage(this,(res)=>{
        console.log('res',res)
        this.pageNum=1;
        this.tableData=res;
      })
    },
    onSubmit() {
      this.$refs['form'].validate((valid) => {
        if (valid) {
          this.$nextTick(()=>{
            this.$axios.post('/goods/insert',this.form).then(res=>{
              selectPage(this,(res)=>{
                console.log('res',res)
                this.tableData=res;
                this.$axios.get(`/goods/getNameAll?name=${this.name}`).then((res)=>{
                  console.log(res.data)
                  this.count=res.data.length;
                }).catch((err)=>{
                  console.log(err)
                })
                  this.pageNum=this.pageNum;
                  this.closeAddDialog()
              })
            })
            this.addDialogVisible=false;
          })
        } else {
          return false;
        }
      });
    },
    onSubmit2() {
      this.$refs['form2'].validate((valid) => {
          if (valid) {
            this.$nextTick(()=>{
              this.$axios.put('/goods/update',this.form2).then(res=>{
                selectPage(this,(res)=>{
                  this.tableData=res;
                  this.$axios.get(`/goods/getNameAll?name=${this.name}`).then((res)=>{
                    this.count=res.data.length;
                  }).catch((err)=>{
                    console.log(err)
                  })
                  this.pageNum=this.pageNum;
                  this.closeUpdDialog();
                })
              })
              this.addDialogVisible=false;
            })
          }
      })
    },
    beforeAvatarUpload(file){
        const isJPEG = file.type === 'image/jpeg';
      const isPng = file.type==='image/png'
      const isJPG = file.type==='image/jpg'
      const isGif = file.type==='image/gif'
      if (!isJPG && !isPng&&!isJPEG&&!isGif ) {
          this.$message.error('上传头像只能是图片!');
      }
        return isJPG || isPng || isJPEG || isGif;
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    },
    handleExceed(files, fileList) {
      this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },
    beforeRemove(file, fileList) {
      return this.$confirm(`确定移除 ${ file.name }？`);
    },
    //每页条数改变时触发 选择一页显示多少行
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.pageNum=1;
      this.pageSize = val;
      this.getdata();
    },
    //当前页改变时触发 跳转其他页
    handleCurrentChange(val) {
      this.pageNum =(val--);
      console.log(`当前页: ${val}`);
      selectPage(this,(res)=>{
        this.tableData=res;
      })
    },
    search(){
      this.$axios.get(`/goods/getNameAll?name=${this.name}`).then((res)=>{
        this.count=res.data.length;
        this.pageNum=1;
        selectPage(this,(res)=>{
          console.log('res',res)
          this.tableData=res;
        })
        // this.name=''
      }).catch((err)=>{
        console.log(err)
      })
    },
    getCount(){
      this.$axios.get('/goods/getAll').then((res) => {
        this.count=res.data.length;
      }).catch((err) => {
        console.log(err)
      })
    }
  },
  mounted() {
    this.getdata();
    this.getCount();
  }
}
</script>

<style lang="less" scoped>
.page{
  padding: 20px;
  /deep/ .el-dialog {
    height: 80%;
    background-color: #F3F7FD;
    border-radius: 10px;
  }

  /deep/ .el-dialog__header {
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    height: 10%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 10px;
  }

  /deep/ .el-dialog__title {
    font-size: 0.5rem;
    position: absolute;

  }
  /deep/ .el-dialog__body {
    padding: 15px;
    height: 90%;
    overflow-y: auto;
  }
  /deep/.el-dialog__body::-webkit-scrollbar {
    width: 4px;
  }
  /deep/.el-dialog__body::-webkit-scrollbar-thumb {
    border-radius: 15px;
    -webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);
    background: #AEE6D6;
  }
  /deep/  .el-dialog__body::-webkit-scrollbar-track {
    -webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);
    border-radius: 10px;
    background: #DAF0EF;
  }

  /deep/ .el-dialog__headerbtn {
    top: unset;
  }
  .top{
    .search{
      width: 400px;
    }
    .searchButton{
      margin-left: 20px;border: 1px solid #DCDFE6;
      color: #606266;
    }
    /deep/.el-button--primary.is-plain{
      background-color:transparent ;
      color:#409EFF;
    }
  }
  .center{
    margin-top: 20px;
    height:calc(100vh - 203px);
  }
}
</style>
