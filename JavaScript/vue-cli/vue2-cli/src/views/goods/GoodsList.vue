<template>
  <div>
      <!-- 面包屑 -->
      <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item><a href="/">商品管理</a></el-breadcrumb-item>
      <el-breadcrumb-item>商品列表</el-breadcrumb-item>
    </el-breadcrumb>
    <el-card>
      <el-row :gutter="20">
        <el-col :span="16">
        <!-- 搜索栏 -->
        <el-input v-model="queryInfo.query" placeholder="请输入内容">
            <el-button @click="getGoodsList" slot="append" icon="el-icon-search"></el-button>
        </el-input>
        </el-col>
        <el-col :span="8">
          <el-button @click="addGoodsDialog = true" type="primary">添加商品</el-button>
        </el-col>
      </el-row>
      <!-- 商品表格 -->
      <el-table
      border
      :data="goodsList"
      style="width: 100%">
      <el-table-column
        type="index"
        label="#">
      </el-table-column>
      <el-table-column
        prop="goods_name"
        label="商品名称">
      </el-table-column>
      <el-table-column
        prop="goods_price"
        label="商品价格">
      </el-table-column>
      <el-table-column
        prop="goods_weight"
        label="商品重量">
      </el-table-column>
      <el-table-column
        label="创建时间">
        <template slot-scope="scope">
          <p>{{ scope.row.add_time | setTimestamp }}</p>
        </template>
      </el-table-column>
      <el-table-column
      label="操作" width="180px">
      <template slot-scope="scope">
      <el-button @click="showEditGoodsDialog( scope.row )" size="mini" type="primary" icon="el-icon-edit"></el-button>
      <el-button @click="deleteGoods( scope.row )" size="mini" type="danger" icon="el-icon-delete"></el-button>
      </template>
      </el-table-column>
      </el-table>
    </el-card>
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="queryInfo.pagenum"
        :page-sizes="[10, 20, 50, 100, 200, 500]"
        :page-size="queryInfo.pagesize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="totalNum">
      </el-pagination>

      <el-dialog
      title="添加商品"
      :visible.sync="addGoodsDialog"
      width="50%"
      :before-close="handleClose">
        <el-form :model="addGoodsForm" :rules="rules" ref="addGoodsForm" label-width="100px">
          <el-form-item label="名称" prop="goods_name">
            <el-input v-model="addGoodsForm.goods_name"></el-input>
          </el-form-item>
          <el-form-item label="分类" prop="goods_cat">
            <el-checkbox-group v-model="addGoodsForm.goods_cat">
              <el-checkbox label="手机数码" name="42"></el-checkbox>
              <el-checkbox label="家用电器" name="41"></el-checkbox>
              <el-checkbox label="服饰内衣" name="45"></el-checkbox>
              <el-checkbox label="运动户外" name="53"></el-checkbox>
            </el-checkbox-group>
          </el-form-item>  
          <el-form-item label="价格" prop="goods_price">
            <el-input v-model="addGoodsForm.goods_price"></el-input>
          </el-form-item>
          <el-form-item label="数量" prop="goods_number">
            <el-input v-model="addGoodsForm.goods_number"></el-input>
          </el-form-item>
          <el-form-item label="重量" prop="goods_weight">
            <el-input v-model="addGoodsForm.goods_weight"></el-input>
          </el-form-item>
          <el-form-item label="介绍" prop="goods_introduce">
            <el-input v-model="addGoodsForm.goods_introduce"></el-input>
          </el-form-item>
          <el-form-item label="图片" prop="pics">
            <el-input v-model="addGoodsForm.pics"></el-input>
          </el-form-item>
          <el-form-item label="参数" prop="attrs">
            <el-input v-model="addGoodsForm.attrs"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="handleClose">取 消</el-button>
          <el-button @click="addGoods" type="primary">确 定</el-button>
        </span>
      </el-dialog>

      <el-dialog
      title="编辑商品"
      :visible.sync="editGoodsDialog"
      width="50%"
      :before-close="handleClose">
      名称:<el-input v-model="editGoodsList.goods_name"></el-input>
      价格:<el-input v-model="editGoodsList.goods_price"></el-input>
      数量:<el-input v-model="editGoodsList.goods_number"></el-input>
      重量:<el-input v-model="editGoodsList.goods_weight"></el-input>
      介绍:<el-input v-model="editGoodsList.goods_introduce"></el-input>
      图片:<el-input v-model="editGoodsList.pics"></el-input>
      参数:<el-input v-model="editGoodsList.attrs"></el-input>
      <span slot="footer" class="dialog-footer">
          <el-button @click="handleClose">取 消</el-button>
          <el-button @click="editGoods" type="primary">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>
  
  <script>

  export default {
    data() {
      return {
        queryInfo: {
          query: '',
          pagenum: 1,
          pagesize: 10
        },
        goodsList: [],
        add_time: '',
        totalNum: 0,
        addGoodsDialog: false,
        editGoodsDialog: false,
        addGoodsForm: [],
        editGoodsList: [],
        //表单提交规则
        addGoodsForm: {
          goods_name: '',
          goods_cat: [],
          goods_price: '',
          goods_number: '',
          goods_weight: '',
          goods_introduce: '',
          pics: '',
          attrs: ''
        },
        rules: {
          goods_name: [{required: true, message: '不能为空', trigger: 'blur'}],
          goods_cat: [{ type: 'array', required: true, message: '不能为空', trigger: 'change' }],
          goods_price: [{required: true, message: '不能为空', trigger: 'blur'}],
          goods_number: [{required: true, message: '不能为空', trigger: 'blur'}],
          goods_weight: [{required: true, message: '不能为空', trigger: 'blur'}]
        }
      }
    },
     created() {
      this.getGoodsList()
    },
    filters: {
      //定义一个本地过滤器:将商品创建时间戳转化为日期格式
      setTimestamp: function( t ) {
        const timestamp = t;
        const date = new Date(timestamp);
        const year = date.getFullYear();
        const month = date.getMonth() + 1;
        const day = date.getDate();
        const hour = date.getHours();
        const minute = date.getMinutes();
        const second = date.getSeconds();
        const formattedDate = `${year}-${month}-${day} ${hour}:${minute}:${second}`;
        return formattedDate;
      }
    },
    methods: {
      //获取全部商品列表
      async getGoodsList() {
        let ret = await this.http.get('goods', {params: this.queryInfo})
        console.log('商品列表: ', ret);
        this.goodsList = ret.data.goods
        this.totalNum = ret.data.total //商品总条数
      },
      //当页面大小改变时
      handleSizeChange( size ) {
        console.log('每页', size,'条数据');
        this.queryInfo.pagesize = size
        this.getGoodsList()
      },
      //当前页码被改变
      handleCurrentChange( pagenum ) {
        console.log('当前页码: ', pagenum );
        this.queryInfo.pagenum = pagenum
        this.getGoodsList()
      },
      //对话框中的取消和右上角的x
      handleClose() {
        this.addGoodsDialog = false
        this.editGoodsDialog = false
        this.$refs.addGoodsForm.resetFields() //清空表单数据
        this.$refs.editGoodsList.resetFields()
      },
      //添加商品
      async addGoods( ){
        let goodsCat = this.addGoodsForm.goods_cat.join(','); // 将商品类型用逗号隔开
        this.addGoodsForm.goods_cat = goodsCat
        console.log('add: ', this.addGoodsForm);
        let ret = await this.http.post('goods',
        {
          goods_name:this.addGoodsForm.goods_name,
          goods_cat:this.addGoodsForm.goods_cat,
          goods_price:this.addGoodsForm.goods_price,
          goods_number:this.addGoodsForm.goods_number,
          goods_weight:this.addGoodsForm.goods_weight,
          goods_introduce:this.addGoodsForm.goods_introduce,
          pics:[{pic:this.addGoodsForm.pics}],
          attrs:[{attr_id:123,attr_value:this.addGoodsForm.attrs}]
          })
        console.log('添加结果: ', ret );
        if( ret.meta.status == 201 ) {
          this.$message.success( ret.meta.msg )
          this.getGoodsList() //刷新
          this.$refs.addGoodsForm.resetFields()
          this.addGoodsDialog = false
        }
        return this.$message.error( ret.meta.msg )
      },
      //打开编辑商品对话框
      showEditGoodsDialog( goods ) {
        this.editGoodsDialog = true
        this.editGoodsList = goods
      },
      //编辑商品
      async editGoods() {
        console.log( 'id:', this.editGoodsList.goods_id);
        let ret = await this.http.put('goods/'+ this.editGoodsList.goods_id, {
          goods_name:this.editGoodsList.goods_name,
          goods_price:this.editGoodsList.goods_price,
          goods_number:this.editGoodsList.goods_number,
          goods_weight:this.editGoodsList.goods_weight,
          goods_introduce:this.editGoodsList.goods_introduce,
          pics:[{pic:this.editGoodsList.pics}],
          attrs:[{attr_id:123,attr_value:this.editGoodsList.attrs}]
        })
        console.log('结果: ', ret);
        if( ret.meta.status == 201 ) {
          this.$message.success( ret.meta.msg )
          this.getGoodsList() //刷新
          this.editGoodsDialog = false
        }
        return this.$message.error( ret.meta.msg )
      },
      //删除商品
      async deleteGoods( goods ) {
        let ok = await this.$confirm('此操作将永久删除该商品, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).catch( err => err )
        console.log( ok );
        if( ok != 'confirm' ) {
          this.$message({
          type: 'info',
          message: '已取消删除'
          });
          return;
        }
        let ret = await this.http.delete('goods/'+ goods.goods_id)
        if( ret.meta.status !== 200 ) {
          return this.$message.error( ret.meta.msg )
        }
        this.$message.success( ret.meta.msg )
        this.getGoodsList() //刷新
      }
    }
  }
  </script>
  
  <style>
  
  </style>