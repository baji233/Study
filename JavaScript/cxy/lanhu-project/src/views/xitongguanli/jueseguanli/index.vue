<template>
  <div style="padding: 30px;">
    <el-row :gutter="10">
      <el-col :span="6">
        <el-input @keyup.enter.native="selectByList" v-model="bady.role_name" class="sousuoInput" placeholder="请输入角色名称"></el-input>
      </el-col>
      <el-col :span="10">
        <el-button icon="el-icon-zoom-in" @click="selectByList">搜索</el-button>
        <el-button type="danger" icon="el-icon-close" @click="empty">重置</el-button>
        <el-button type="primary" icon="el-icon-plus" @click="addBtn">新增</el-button>
      </el-col>
      <el-col class="table" :span="24">
        <el-table :data="jueSeList" border v-loading="listLoading" height="calc(100vh - 182px)">
          <el-table-column show-overflow-tooltip label="角色名称" prop="role_name"></el-table-column>
          <el-table-column show-overflow-tooltip label="角色描述" prop="remark"></el-table-column>
          <el-table-column label="操作" width="300">
            <template slot-scope="{row}">
              <el-button size="mini" type="primary" @click="selectOneById(row.role_id)"
                icon="el-icon-edit-outline">编辑</el-button>
              <el-button size="mini" type="success" icon="el-icon-edit-outline">分配权限</el-button>
              <el-button size="mini" type="danger" @click="deleteJueSe(row.role_id)" icon="el-icon-delete">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-col>
      <el-col :span="24">
        <el-pagination style="text-align: center" @size-change="handleSizeChange" @current-change="handleCurrentChange"
          :current-page.sync="bady.pageIndex" :page-size="3" :page-sizes="[3, 5, 7, 10]"
          layout="total, sizes, prev, pager, next, jumper" :total="total">
        </el-pagination>
      </el-col>
      <el-dialog :title="title" :visible.sync="dialogVisible">
        <el-form :model="addBody">
          <el-form-item label-width="100px" label="角色名称">
            <el-input v-model="addBody.role_name" placeholder="请输入角色名称"></el-input>
          </el-form-item>
          <el-form-item label-width="100px" label="角色描述">
            <el-input v-model="addBody.remark" placeholder="请输入角色描述"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="createAndUpdate">确 定</el-button>
        </div>
      </el-dialog>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "jueseguanli",
  data() {
    return {
      bady: {
        role_name: "",
        PageSize: 3,
        pageIndex: 1,
      },
      jueSeList: [],
      total: 0,
      dialogVisible: false,
      addBody: {
        role_name: "",
        remark: "",
      },
      title: "",
      listLoading: false
    };
  },
  methods: {
    async getInit() {
      this.listLoading = true;
      try {
        let result = await this.$API.role.slectList({ ...this.bady });
        let resultTotal = await this.$API.role.selectCount({ ...this.bady });
        this.jueSeList = result;
        this.total = resultTotal[0].total;
      } catch (error) {
        console.log(error);
      }
      this.listLoading = false;
    },
    handleSizeChange(pageSize) {
      this.bady.role_name = "";
      this.bady.PageSize = pageSize;
      this.getInit();
    },
    handleCurrentChange(pageIndex) {
      this.bady.role_name = "";
      this.bady.pageIndex = pageIndex;
      this.getInit();
    },
    selectByList() {
      this.bady.pageIndex = 1;
      this.getInit();
    },
    empty() {
      this.bady.role_name = "";
    },
    addBtn() {
      this.addBody = {
        role_name: "",
        remark: "",
      }
      this.title = "添加";
      this.dialogVisible = true;
    },
    async deleteJueSe(roleId) {
      if (window.confirm('你确定删除吗')) {
        let result = await this.$API.role.deleteJueSe(roleId);
        if (result.code == 200) {
          this.$message({
            type: "success",
            message: "删除成功"
          })
          this.bady.pageIndex = this.jueSeList.length <= 1 ? (this.bady.pageIndex - 1) : this.bady.pageIndex;
          this.getInit();
        } else {
          this.$message({
            type: "error",
            message: "系统正忙...."
          })
        }
      }

    },
    async createAndUpdate() {
      const time = this.$moment().format('yyyy-MM-DD HH:mm:ss');
      if (this.addBody.role_id) {
        this.addBody.update_time = time;
        this.addBody.create_time = this.$moment(this.addBody.create_time).format('yyyy-MM-DD HH:mm:ss')
        let result = await this.$API.role.updateJueSe({ ...this.addBody });
        if (result.code == 200) {
          this.$message({
            type: 'success',
            message: '修改成功'
          });
          this.dialogVisible = false;
          this.getInit();
        }
      } else {
        this.addBody.create_time = time;
        let result = await this.$API.role.insertJueSe({ ...this.addBody });
        if (result.code == 200) {
          this.$message({
            type: 'success',
            message: '增加成功'
          });
          this.dialogVisible = false;
          this.getInit();
        }
      }
    },
    async selectOneById(roleId) {
      this.title = "修改"
      let result = await this.$API.role.selectOneById(roleId);
      if (result.code == 200) {
        this.addBody = result.data[0];
        this.dialogVisible = true;
      } else {
        this.$message({
          type: "error",
          message: "系统正忙"
        })
      }
    }
  },
  mounted() {
    this.getInit();
  },
};
</script>

<style scoped lang="scss">
.table {
  margin: 10px 0;
}
</style>

