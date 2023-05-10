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
          <el-button type="primary">添加用户</el-button>
        </el-col>
      </el-row>
      <!-- 表格显示用户信息 -->
      <el-table
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
      <el-button size="mini" type="primary" icon="el-icon-edit"></el-button>
      <el-button size="mini" type="danger" icon="el-icon-delete"></el-button>
      <el-button size="mini" type="warning" icon="el-icon-setting"></el-button>
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
    total: 0
  }
},
created() {
  this.getUserList()  //获取用户信息
},
methods: {
  async getUserList() {
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
    console.log('当前页码: ', pagenump );
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
  }
}
}
</script>

<style>

</style>