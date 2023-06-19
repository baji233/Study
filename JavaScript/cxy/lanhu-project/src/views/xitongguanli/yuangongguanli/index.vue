<template>
  <div style="padding: 30px;">
    <el-row :gutter="10">
      <el-col :span="6">
        <el-input @keyup.native.enter="selectUserList" placeholder="请输入姓名" v-model="bady.name"></el-input>
      </el-col>
      <el-col :span="6">
        <el-input @keyup.native.enter="selectUserList" placeholder="请输入电话" v-model="bady.phone"></el-input>
      </el-col>
      <el-col :span="10">
        <el-button icon="el-icon-zoom-in" @click="selectUserList">搜索</el-button>
        <el-button type="danger" icon="el-icon-close" @click="empty" >重置</el-button>
        <el-button type="primary" icon="el-icon-plus" @click="addUser" >新增</el-button>
      </el-col>
      <el-col :span="24">
        <el-table :data="tableData" border v-loading="listLoading" height="calc(100vh - 182px)">
          <el-table-column show-overflow-tooltip prop="nick_name" label="姓名"> </el-table-column>
          <el-table-column show-overflow-tooltip prop="username" label="登录账户"> </el-table-column>
          <el-table-column prop="sex" label="性别">
            <template slot-scope="{ row }">
              <el-tag v-if="row.sex == 1" type="success">男</el-tag>
              <el-tag v-if="row.sex == 0" type="danger">女</el-tag>
            </template>
          </el-table-column>
          <el-table-column show-overflow-tooltip prop="phone" label="电话"> </el-table-column>
          <el-table-column show-overflow-tooltip prop="email" label="邮箱"> </el-table-column>
          <el-table-column prop="user_type" label="类型">
            <template slot-scope="{ row }">
              <el-tag v-if="row.user_type == 1" type="success">学员</el-tag>
              <el-tag v-if="row.user_type == 2" type="danger">教练</el-tag>
            </template>
          </el-table-column>
          <el-table-column prop="salary" label="薪水"> </el-table-column>
          <el-table-column prop="status" label="状态">
            <template slot-scope="{ row }">
              <el-tag v-if="row.status == 1" type="success">启用</el-tag>
              <el-tag v-if="row.status == 0" type="danger">禁用</el-tag>
            </template>
          </el-table-column>
          <el-table-column label="操作" width="300">
            <template slot-scope="{ row }">
              <el-button size="mini" type="primary" icon="el-icon-edit-outline"
                @click="getSelectOneById(row.user_id)">编辑</el-button>
              <el-button size="mini" type="danger" icon="el-icon-delete-solid"
                @click="deleteUser(row.user_id)">删除</el-button>
              <el-button size="mini" type="warning" icon="el-icon-edit-outline"
                @click="updateGetId(row.user_id)">重置密码</el-button>
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
    </el-row>
    <el-dialog title="提示" :visible.sync="dialogVisible">
      <el-form :model="getSelectOne">
        <el-form-item label-width="100px" label="员工姓名">
          <el-input v-model="getSelectOne.username"></el-input>
        </el-form-item>
        <el-form-item label-width="100px" label="员工账号">
          <el-input v-model="getSelectOne.nick_name"></el-input>
        </el-form-item>
        <el-form-item label-width="100px" label="员工密码">
          <el-input type="password" v-model="getSelectOne.password"
            :disabled="getSelectOne.user_id == undefined ? false : true"></el-input>
        </el-form-item>
        <el-form-item label-width="100px" label="员工性别">
          <el-select v-model="getSelectOne.sex">
            <el-option label="男" value="1"></el-option>
            <el-option label="女" value="0"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label-width="100px" label="员工电话">
          <el-input v-model="getSelectOne.phone"></el-input>
        </el-form-item>
        <el-form-item label-width="100px" label="员工邮箱">
          <el-input v-model="getSelectOne.email"></el-input>
        </el-form-item>
        <el-form-item label-width="100px" label="员工类型">
          <el-select v-model="getSelectOne.user_type">
            <el-option label="学员" value="1"></el-option>
            <el-option label="教练" value="2"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label-width="100px" label="员工薪水">
          <el-input type="number" v-model.number="getSelectOne.salary"></el-input>
        </el-form-item>
        <el-form-item label-width="100px" label="员工状态">
          <el-select v-model="getSelectOne.status">
            <el-option label="启用" value="1"></el-option>
            <el-option label="禁用" value="0"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="updateUserById">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog title="修改密码" :visible.sync="xiugaimima">
      <el-form>
        <el-form-item label-width="100px" label="新密码">
          <el-input type="password" v-model="newPassword" placeholder="请输入新密码"></el-input>
        </el-form-item>
        <el-form-item label-width="100px" label="确定密码">
          <el-input type="password" v-model="confirmPassword" placeholder="请输入确定密码"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="xiugaimima = false">取 消</el-button>
        <el-button type="primary" @click="updatePassword">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>


<script>
export default {
  name: "yuangongguanli",
  data() {
    return {
      bady: {
        name: "",
        phone: "",
        pageIndex: 1,
        pageSize: 3,
      },
      total: 0,
      tableData: [],
      dialogVisible: false,
      getSelectOne: {},
      xiugaimima: false,
      confirmPassword: "",
      newPassword: "",
      updateUserId: "",
      listLoading: false
    };
  },
  methods: {
    async getInit() {
      this.listLoading = true;
      try {
        let result = await this.$API.system.getInit({ ...this.bady });
        let total = await this.$API.system.selectCount({ ...this.bady });
        this.tableData = result;
        this.total = total[0].total;
      } catch (error) {
        console.log(error);
        this.$message({
          type: "error",
          message: "系统正忙",
        });
      }
      this.listLoading = false;
    },
    selectUserList() {
      this.bady.pageIndex = 1;
      this.getInit({ ...this.bady });
    },
    async deleteUser(id) {
      if (window.confirm("确定删除吗")) {
        try {
          let result = await this.$API.system.deleteUser(id);
          this.bady.pageIndex = this.tableData.length <= 1 ? (this.bady.pageIndex - 1) : this.bady.pageIndex;
          this.getInit();
        } catch (error) {
          console.log(error);
          this.$message({
            type: "error",
            message: "系统正忙",
          });
        }
      }
    },
    async getSelectOneById(id) {
      let result = await this.$API.system.getSelectOneById(id);
      if (result.code == 200) {
        this.getSelectOne = result.data[0];
        this.dialogVisible = true;
      } else {
        this.$message({
          type: "error",
          message: "系统正忙.....",
        });
      }
    },
    async updateUserById() {
      const time = this.$moment().format('yyyy-MM-DD');
      if (this.getSelectOne.user_id) {
        this.getSelectOne.create_time = this.$moment(this.getSelectOne.create_time).format('yyyy-MM-DD');
        this.getSelectOne.update_time = time;
        let result = await this.$API.system.updateUserById({ ...this.getSelectOne });
        if (result.code == 200) {
          this.$message({
            type: "success",
            message: "修改成功",
          });
          this.getInit();
          this.dialogVisible = false;
        } else {
          this.$message({
            type: "error",
            message: "系统正忙",
          });
        }
      } else {
        if (this.getSelectOne.nick_name == "") {
          this.$message({
            type: "error",
            message: "用户账号不能为空",
          });
          return;
        }
        if (this.getSelectOne.username == "") {
          this.$message({
            type: "error",
            message: "用户姓名不能为空",
          });
          return;
        }
        if (this.getSelectOne.password == "") {
          this.$message({
            type: "error",
            message: "用户密码不能为空",
          });
          return;
        }
        if (this.getSelectOne.sex == "") {
          this.$message({
            type: "error",
            message: "用户性别不能为空",
          });
          return;
        }
        if (this.getSelectOne.phone == "") {
          this.$message({
            type: "error",
            message: "用户电话不能为空",
          });
          return;
        }
        if (this.getSelectOne.user_type == "") {
          this.$message({
            type: "error",
            message: "用户类型不能为空",
          });
          return;
        }
        if (this.getSelectOne.salary == "") {
          this.$message({
            type: "error",
            message: "用户薪水不能为空",
          });
          return;
        }
        if (this.getSelectOne.status == "") {
          this.$message({
            type: "error",
            message: "用户状态不能为空",
          });
          return;
        }
        try {
          this.getSelectOne.create_time = time;
          let result = await this.$API.system.insertUser({ ...this.getSelectOne });
          this.getInit();
          this.$message({
            type: "success",
            message: "添加成功",
          });
          this.getSelectOne = {
            username: "",
            password: "",
            phone: "",
            email: "",
            sex: "",
            salary: "",
            user_type: "",
            status: "",
            nick_name: "",
          };
          this.dialogVisible = false;
        } catch (error) {
          console.log(error)
          this.$message({
            type: "error",
            message: "系统正忙",
          });
        }
      }
    },
    handleSizeChange(pageSize) {
      this.bady.name = "";
      this.bady.phone = "";
      this.bady.pageSize = pageSize;
      this.getInit();
    },
    handleCurrentChange(pageIndex) {
      this.bady.name = "";
      this.bady.phone = "";
      this.bady.pageIndex = pageIndex;
      this.getInit();
    },
    addUser() {
      this.getSelectOne = {
        username: "",
        password: "",
        phone: "",
        email: "",
        sex: "",
        salary: "",
        user_type: "",
        status: "",
        nick_name: "",
      };
      this.dialogVisible = true;
    },
    async updatePassword() {
      if (this.newPassword == "") {
        this.$message({
          type: "error",
          message: "新密码不能等于空"
        })
        return;
      }
      if (this.confirmPassword == "") {
        this.$message({
          type: "error",
          message: "确定密码不能为空"
        })
        return;
      }
      if (this.newPassword != this.confirmPassword) {
        this.$message({
          type: "error",
          message: "新密码不等于确定密码"
        })
        return;
      }
      let result = await this.$API.system.updatePasswordById(this.newPassword, this.updateUserId);
      if (result.code == 200) {
        this.$message({
          type: "success",
          message: "修改成功"
        })
        this.getInit();
        this.xiugaimima = false;
      } else {
        this.$message({
          type: "error",
          message: "修改失败"
        })
      }
    },
    updateGetId(id) {
      this.updateUserId = id;
      this.xiugaimima = true;
    },
    empty() {
      this.bady.phone = "";
      this.bady.name = "";
    }
  },
  mounted() {
    this.getInit();
  },
};
</script>

<style scoped lang="scss">
.el-col:nth-last-child(2) {
  margin: 10px 0;
}

</style>
