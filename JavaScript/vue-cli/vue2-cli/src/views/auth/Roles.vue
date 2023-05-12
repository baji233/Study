<template>
  <div>
    <!-- 面包蟹导航区域 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>权限列表</el-breadcrumb-item>
      <el-breadcrumb-item>角色列表</el-breadcrumb-item>
    </el-breadcrumb>
    <!-- 卡片视图 -->
    <el-card>
      <el-row>
        <el-col>
          <el-button type="primary">添加角色</el-button>
        </el-col>
      </el-row>
      <!-- 表格 -->
      <el-table :data="rolelist">
        <!-- 展开行 -->
        <el-table-column type="expand">
          <template slot-scope="scope">
            <el-row :class="['bdbottom','vcenter', i1 == 0? 'bdtop':'']" v-for="item01,i1 in scope.row.children" :key="item01.id">
              <!-- 显示一级权限标签 -->
              <el-col :span="5">
                <el-tag @close="removeRightById(scope.row, item01.id)" closable>{{ item01.authName }}</el-tag>
              </el-col>
              <!-- 显示二三级权限标签 -->
              <el-col :span="19">
                <el-row :class="[i2 == 0? '':'bdtop','vcenter']" v-for="item02,i2 in item01.children" :key="item02.id">
                 <el-col :span="6">
                  <!-- 二级 -->
                  <el-tag @close="removeRightById(scope.row, item02.id)" closable type="success">{{ item02.authName }}</el-tag>
                 </el-col>
                 <el-col :span="18">
                  <!-- 三级 -->
                  <el-tag @close="removeRightById(scope.row, item03.id)" closable type="warning" v-for="item03 in item02.children" :key="item03.id">{{ item03.authName }}</el-tag>
                </el-col>
                </el-row>
              </el-col>
            </el-row>
          </template>
        </el-table-column>

        <el-table-column label="#" type="index"></el-table-column>
        <el-table-column label="角色名称" prop="roleName"></el-table-column>
        <el-table-column label="角色描述" prop="roleDesc"></el-table-column>
        <el-table-column label="角色操作" width="300px">
          <el-button size="mini" type="primary" icon="el-icon-edit">编辑</el-button>
          <el-button size="mini" type="danger" icon="el-icon-delete">删除</el-button>
          <el-button size="mini" type="warning" icon="el-icon-setting">分配权限</el-button>
        </el-table-column>

      </el-table>
    </el-card>

  </div>
</template>

<script>
export default {
  data() {
    return {
      //所有角色列表数据
      rolelist: [],
    }
  },
  //生命周期之创建后
  created() {
    this.getRoleList()
  },
  methods: {
    //获取角色列表
    async getRoleList() {
      let ret = await this.http.get('roles')
      console.log('角色列表: ', ret);
      this.rolelist = ret.data
    },
    //通过角色id删除的指定权限
    async removeRightById( role, rightId ) {
      let ok = await this.$confirm( '此操作将永久删除该角色权限, 是否继续?', '提示', {
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
      console.log('角色id: ', role.id,',权限id: ', rightId);
      let path = `roles/${ role.id }/rights/${ rightId }`
      let ret = await this.http.delete( path )
      if( ret.meta.status == 200 ) {
        //页面更新
        role.children = ret.data
        this.$message.success( ret.meta.msg )
        return;
      } 
      this.$message.success( ret.meta.msg )
    }
  }
}
</script>

<style lang="less" scoped>
.el-tag {
  margin: 7px;
}

.bdtop {
  border-top: 1px solid #eee;
}

.bdbottom {
  border-bottom: 1px solid #eee;
}

.vcenter {
  display: flex;
  align-items: center;
}

</style>