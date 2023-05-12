<template>
  <div>
    <!-- 面包屑 -->
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item><a href="/">用户管理</a></el-breadcrumb-item>
      <el-breadcrumb-item>用户列表</el-breadcrumb-item>
    </el-breadcrumb>

    <!-- 卡片视图 -->
    <el-card>
      <el-row :gutter="20">
        <el-col :span="16">
          <el-input placeholder="请输入内容">
          <el-button slot="append" icon="el-icon-search"></el-button>
          </el-input>
        </el-col>
        <el-col :span="4">
          <el-button @click="addDialong = true" type="primary">添加用户</el-button>
        </el-col>
      </el-row>
      <!-- 表格显示用户信息 -->
      <el-table
      border
      :data="userList"
      style="width: 100%">
      <el-table-column
        type="index"
        label="#">
      </el-table-column>
      <el-table-column
        prop="username"
        label="姓名">
      </el-table-column>
      <el-table-column
        prop="email"
        label="邮箱">
      </el-table-column>
      <el-table-column
        prop="mobile"
        label="电话">
      </el-table-column>
      <el-table-column
        prop="role_name"
        label="角色">
      </el-table-column>
      <el-table-column
        label="状态">
        <template slot-scope="scope">
          <el-switch @change="userState(scope.row)" v-model="scope.row.mg_state"></el-switch>
        </template>
      </el-table-column>      
      <el-table-column
      label="操作" width="180px">
      <template slot-scope="scope">
      <el-button @click="showEditDialong( scope.row )" size="mini" type="primary" icon="el-icon-edit"></el-button>
      <el-button @click="deleteByUser( scope.row )" size="mini" type="danger" icon="el-icon-delete"></el-button>
      <el-button @click="showRoleDialong(scope.row)" size="mini" type="warning" icon="el-icon-setting"></el-button>
      </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="queryInfo.pagenum"
      :page-sizes="[2, 5, 10, 20]"
      :page-size="queryInfo.pagesize"
      layout="total, sizes, prev, pager, next, jumper"
      :total=total>
    </el-pagination>
    </el-card>

    <el-dialog
    title="添加用户"
    :visible.sync="addDialong"
    width="30%"
    :before-close="handleClose">
      <el-form :model="addForm" ref="addFormRef" label-width="70px">
        <el-form-item label="用户名" prop="username">
          <el-input v-model="addForm.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="addForm.password"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="addForm.email"></el-input>
        </el-form-item>
        <el-form-item label="手机" prop="mobile">
          <el-input v-model="addForm.mobile"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="addDialong = false">取 消</el-button>
        <el-button type="primary" @click="addUser">确 定</el-button>
      </span>
    </el-dialog>

    <el-dialog
    title="分配角色"
    :visible.sync="roleDialong"
    width="30%"
    :before-close="handleClose">
    <!-- 放个div -->
    <div>
      <p>当前用户: {{ userInfo.username }}</p>
      <p>当前角色: {{ userInfo.role_name }}</p>
      <p>角色列表: <el-select v-model="roleId" placeholder="请选择">
    <el-option
      v-for="item in roles"
      :key="item.id"
      :label="item.roleName"
      :value="item.id">
    </el-option>
  </el-select></p>
    </div>
    <span slot="footer" class="dialog-footer">
      <el-button @click="roleDialong = false">取 消</el-button>
      <el-button @click="setUserRole" type="primary">确 定</el-button>
    </span>
    </el-dialog>

    <el-dialog
    title="编辑用户"
    :visible.sync="editDialong"
    width="30%"
    :before-close="handleClose">
    <p>当前用户ID : {{ userInfo.id }}</p>
    <p>邮箱: <el-input v-model="userInfo.email" autocomplete="off"></el-input></p>
    <p>电话: <el-input v-model="userInfo.mobile" autocomplete="off"></el-input></p>
    <span slot="footer" class="dialog-footer">
      <el-button @click="editDialong = false">取 消</el-button>
      <el-button @click="editUserInfo" type="primary">确 定</el-button>
    </span>
    </el-dialog>

  </div>
</template>

<script>
export default {
data() {
  return {
    userList: [],
    //查询用户信息所需要的参数
    queryInfo: {
      query: '',
      pagenum: 1,
      pagesize: 5
    },
    total: 0,
    addDialong: false,
    editDialong: false,
    roleDialong: false,
    addForm: {
      username: '',
      password: '',
      email: '',
      mobile: ''
    },
    userInfo: [],
    roles: [],
    roleId : ''
  }
},
created() {
  this.getUserList()  
},
methods: {
  async getUserList() {
    //获取用户信息
    let ret = await this.http.get('users', { params: this.queryInfo })
    console.log('用户信息菜单', ret);
    this.userList = ret.data.users
    this.total = ret.data.total
  },
  handleSizeChange( size ) {
    //页面大小改变
    console.log('每页', size,'条数据');
    this.queryInfo.pagesize = size
    this.getUserList()
  },
  handleCurrentChange( pagenum ) {
    //当前页面被改变
    console.log('当前页码: ', pagenum );
    this.queryInfo.pagenum = pagenum
    this.getUserList()
  },
  async userState( user ) {
    //用户状态改变时
    console.log( user );
    let path = `users/${user.id}/state/${user.mg_state}`
    let ret = await this.http.put( path )
    console.log('用户状态: ', ret.data.mg_state );
    if( ret.meta.status != 200) {
      user.mg_state = !user.mg_state
      return this.$message.error(ret.meta.msg)
    }
    this.$message.success(ret.meta.msg)
  },
  handleClose() {
    //点击对话框右上角关闭时触发
    this.addDialong = false
    this.editDialong = false
    this.roleDialong = false
  },
  async addUser() {
    //新增用户
    let ret = await this.http.post('users', this.addForm)
    console.log( ret );
    this.addDialong = false
    if( ret.meta.status == 201 ) {
      this.$refs.addFormRef.resetFields() //清空表单数据
      this.$message.success( ret.meta.msg )
      this.getUserList(); //刷新表单
      return;
    }
    this.$message.success( ret.meta.msg )
  },
  showEditDialong( u ) {
    //显示编辑用户对话框
    this.editDialong = true
    console.log('编辑用户信息: ', u );
    this.userInfo.id = u.id
  },
  async editUserInfo() {
    //编辑用户
    console.log('用户id: ', this.userInfo.id);
    let path = `users/${this.userInfo.id}`
    let ret = await this.http.put( path, {email:this.userInfo.email, mobile:this.userInfo.email})
    console.log('编辑用户结果: ', ret);
    if( ret.meta.status == 200 ) {
      this.$message.success( ret.meta.msg )
      this.getUserList(); //刷新表单
      this.userInfo.email = ''
      this.userInfo.mobile = ''//手动清空输入框
      return;
    }
    this.$message.success( ret.meta.msg )

  },
  async deleteByUser(u) {
    //删除用户
    let ok = await this.$confirm('此操作将永久删除该用户, 是否继续?', '提示', {
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
    console.log( u.id );
    let ret = await this.http.delete('users/'+u.id)
    if( ret.meta.status == 200 ) {
      this.$message.success( ret.meta.msg )
      this.getUserList(); //刷新表单
      return;
    }
    this.$message.success( ret.meta.msg ) 
  },
  async showRoleDialong( u ) {
    //显示分配角色对话框
    this.roleDialong = true
    console.log('当前用户信息: ', u);
    this.userInfo = u
    let ret = await this.http.get('roles')
    console.log('角色列表: ', ret);
    this.roles = ret.data
  },
  async setUserRole() {
    //分配用户的角色
    let path = `users/${this.userInfo.id}/role`
    let ret = await this.http.put(path, {rid:this.roleId})
    console.log( '分配角色结果: ', ret );
    if( ret.meta.status == 200 ) {
      this.$message.success( ret.meta.msg )
      this.getUserList(); //刷新表单
      return;
    } 
    this.$message.success( ret.meta.msg )
  }

}
}
</script>

<style>

</style>