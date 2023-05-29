<template>
  <div class="page">
    <div>
      <el-button @click="addBtn" type="primary">添加</el-button>
    </div>
    <div class="mes">
      <el-table height="100%" :data="tableData" style="width: 100%">
        <el-table-column label="商品名称" prop="name"> </el-table-column>
        <el-table-column label="商品价格" prop="price"> </el-table-column>
        <el-table-column label="商品数量" prop="unit"> </el-table-column>
        <el-table-column label="商品重量" prop="specs"> </el-table-column>
        <el-table-column align="right">
          <template slot="header" slot-scope="scope">
            <el-input
              v-model="body.name"
              @input="handlerInput"
              size="mini"
              placeholder="输入关键字搜索"
            />
          </template>
          <template slot-scope="{ row }">
            <el-button size="mini" @click="handleEdit(row.order_id)"
              >编辑</el-button
            >
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(row.order_id)"
              >删除</el-button
            >
          </template>
        </el-table-column>
      </el-table>
      <div class="block">
        <el-pagination
          style="text-align: center"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page.sync="body.pageIndex"
          :page-size="3"
          :page-sizes="[3, 5, 7, 10]"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
        >
        </el-pagination>
      </div>
    </div>
    <el-dialog :title="title" :visible.sync="dialogVisible">
      <el-form :model="goodsOrder">
        <el-form-item label-width="100px" label="商品Id">
          <el-input disabled v-model="goodsOrder.order_id" placeholder=""></el-input>
        </el-form-item>
        <el-form-item label-width="100px" label="商品名称">
          <el-input v-model="goodsOrder.name" placeholder=""></el-input>
        </el-form-item>
        <el-form-item label-width="100px" label="商品价格">
          <el-input v-model="goodsOrder.price" placeholder=""></el-input>
        </el-form-item>
        
        <el-form-item label-width="100px"  label="商品大小">
            <el-input v-model="goodsOrder.unit" placeholder=""></el-input>
        </el-form-item>
        <el-form-item label-width="100px" label="商品数量">
            <el-input v-model="goodsOrder.specs" placeholder=""></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="" @click="addAndUpdate">确定</el-button>
            <el-button type="" @click="dialogVisible=false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import debounce from "lodash/debounce";
export default {
  data() {
    return {
      dialogVisible: false,
      title: "",
      tableData: [],
      total: 0,
      body: {
        name: "",
        pageIndex: 1,
        pageSize: 3,
      },
      goodsOrder: {},
    };
  },
  methods: {
    handleSizeChange(pageSize) {
      this.body.name = "";
      this.body.pageSize = pageSize;
      this.getinit();
    },
    handleCurrentChange(pageIndex) {
      this.body.name = "";
      this.body.pageIndex = pageIndex;
      this.getinit();
    },
    async handleEdit(orderId) {
      let result=await this.$API.dingdanggaunli.selectOneById(orderId);
      if(result.code==200){
        this.goodsOrder=result.data[0];
        this.title="修改";
        this.dialogVisible=true;
      }else{
        this.$message({
          type:"error",
          message:"系统正忙"
        })
      }
     
    },
    async handleDelete(orderId) {
      if (window.confirm("你确定删除吗")) {
        let result = await this.$API.dingdanggaunli.deleteById(orderId);
        if (result.code == 200) {
          this.$message({
            type: "success",
            message: "成功",
          });
          this.body.pageIndex =
            this.tableData.length <= 1
              ? this.body.pageIndex - 1
              : this.body.pageIndex;
          this.getinit();
        } else {
          this.$message({
            type: "error",
            message: "系统正忙",
          });
        }
      }
    },
    async getinit() {
      try {
        let result = await this.$API.dingdanggaunli.selectList({
          ...this.body,
        });
        let tatalResult = await this.$API.dingdanggaunli.selectCount({
          ...this.body,
        });
        this.tableData = result.data;
        this.total = tatalResult.data[0].total;
      } catch (error) {
        this.$message({
          type: "error",
          message: "系统正忙...",
        });
      }
    },
    addBtn(){
      this.goodsOrder={
        name:"",
        price:"",
        unit:"",
        specs:""
      }
      this.dialogVisible=true;
    },
    async addAndUpdate(){
      if(this.goodsOrder.order_id){
        try {
          let result=await this.$API.dingdanggaunli.updateById({...this.goodsOrder})
          this.dialogVisible=false;
          this.getinit();
        } catch (error) {
          console.log(error);
          this.$message({
            type:"error",
            message:"失败"
          })
        }
        
      }else{
        try {
           let result=await this.$API.dingdanggaunli.add({...this.goodsOrder});
          this.dialogVisible=false;
          this.getinit();
        } catch (error) {
          console.log(error);
          this.$message({
            type:"error",
            message:"失败"
          })
        }
      }
    },
    handlerInput: debounce(function () {
      this.body.pageIndex = 1;
      this.getinit();
    }, 200),
  },
  mounted() {
    this.getinit();
  },
};
</script>

<style lang="scss" scoped>
.page {
  padding: 20px;
  height: calc(100vh - 50px);
  .mes {
    height: calc(80%);
  }
}
.demo-table-expand {
  font-size: 0;
}
.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}
.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 50%;
}
</style>
