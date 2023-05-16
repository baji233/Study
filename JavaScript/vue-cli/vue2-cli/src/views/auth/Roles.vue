<template>
  <div>
    <!-- 面包屑导航区域 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>权限列表</el-breadcrumb-item>
      <el-breadcrumb-item>角色列表</el-breadcrumb-item>
    </el-breadcrumb>
    <!-- 卡片视图 -->
    <el-card>
      <el-row>
        <el-col>
          <el-button @click="addRoleDialog = true" type="primary">添加角色</el-button>
        </el-col>
      </el-row>
      <!-- 表格 -->
      <el-table :data="rolelist" border>
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
          <template slot-scope="scope">
            <el-button @click="showEditDialog(scope.row.id)" size="mini" type="primary" icon="el-icon-edit">编辑</el-button>
            <el-button @click="deleteRole(scope.row.id)" size="mini" type="danger" icon="el-icon-delete">删除</el-button>
            <el-button @click="showSetRights(scope.row)" size="mini" type="warning" icon="el-icon-setting">分配权限</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-dialog
      title="分配权限"
      :visible.sync="rightsDialong"
      width="30%"
      :before-close="handleClose">
      <!-- 放个树 -->
      <el-tree
        ref="treeRef"
        default-expand-all
        :data="rightList"
        show-checkbox
        node-key="id"
        :default-checked-keys="defKeys"
        :props="treetProps">
      </el-tree>
      <span slot="footer" class="dialog-footer">
        <el-button @click="handleClose">取 消</el-button>
        <el-button @click="setRights" type="primary">确 定</el-button>
      </span>
      </el-dialog>
      <el-dialog
      title="编辑角色"
      :visible.sync="editDialog"
      width="30%"
      :before-close="handleClose">
      角色名称: <el-input v-model="roleName" placeholder="请输入内容"></el-input>
      角色描述: <el-input v-model="roleDesc" placeholder="请输入内容"></el-input>
      <span slot="footer" class="dialog-footer">
        <el-button @click="handleClose">取 消</el-button>
        <el-button @click="editRole" type="primary">确 定</el-button>
      </span>
      </el-dialog>
      <el-dialog
      title="添加角色"
      :visible.sync="addRoleDialog"
      width="30%"
      :before-close="handleClose">
      角色名称: <el-input v-model="roleName" placeholder="请输入内容"></el-input>
      角色描述: <el-input v-model="roleDesc" placeholder="请输入内容"></el-input>
      <span slot="footer" class="dialog-footer">
        <el-button @click="handleClose">取 消</el-button>
        <el-button @click="addRole" type="primary">确 定</el-button>
      </span>
      </el-dialog>

    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      //所有角色列表数据
      rolelist: [],
      rightsDialong: false,
      editDialog: false,
      addRoleDialog: false,
      rightList: [], //树的数据
      treetProps: {
        //树的参数对应的变量
        label: 'authName',
        children: 'children'
      },
      //默认选中节点id数组
      defKeys: [],
      //点击的角色id
      roleId: '',
      //提交的编辑角色信息
      roleName: '',
      roleDesc: ''
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
    },
    //显示设置权限对话框
    async showSetRights( role ) {
      console.log( '角色: ', role );
      this.roleId = role.id
      this.rightsDialong = true
      //获取所有权限
      let ret = await this.http.get('rights/tree')
      console.log('所有权限: ', ret );
      this.rightList = ret.data
      this.getLeafKeys( role, this.defKeys )
      console.log( '三级节点: ', this.defKeys);
    },
    //对话框关闭前的事件
    handleClose() {
      this.rightsDialong = false
      this.editDialog = false
      this.addRoleDialog = false
      this.roleName = ''
      this.roleDesc = ''
      this.defKeys = []
    },
    //递归查找三级节点
    getLeafKeys( node, arr ) {
      if( !node.children ){
        //如果节点内没有子节点,就将此节点的id放入数组
        return arr.push( node.id )
      }
      //否则递归调用自己
      node.children.forEach( item => this.getLeafKeys( item, arr ) )
    },
    //为角色授权
    async setRights() {
      let a = this.$refs.treeRef.getCheckedKeys()
      let b = this.$refs.treeRef.getHalfCheckedKeys()
      let c = [...a, ...b] //合并数组
      let strId = c.join(',') //使用逗号分隔
      console.log('全选中: ', a); 
      console.log('半选中: ', b); 
      let path = `roles/${this.roleId}/rights`
      let ret = await this.http.post( path, { rids: strId })
      if( ret.meta.status !== 200 ) {
        return this.$message.error( ret.meta.msg )
      }
      this.$message.success( ret.meta.msg )
      this.getRoleList() //刷新
      this.rightsDialong = false
    },
    //删除角色
    async deleteRole( id ) {
      let ok = await this.$confirm('此操作将永久删除该角色, 是否继续?', '提示', {
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
      let ret = await this.http.delete('roles/'+ id)
      if( ret.meta.status == 200 ) {
        this.$message.success( ret.meta.msg )
        this.getRoleList(); //刷新
        return;
      }
      this.$message.success( ret.meta.msg ) 
    },
    //显示编辑角色对话框
    showEditDialog( id ) {
      this.editDialog = true
      this.roleId = id
    },
    //提交编辑角色
    async editRole() {
      let ret = await this.http.put('roles/'+ this.roleId, { roleName: this.roleName, roleDesc: this.roleDesc})
      if( ret.meta.status == 200 ) {
        this.$message.success( '编辑角色成功!' )
        this.getRoleList(); //刷新
        return;
      }
      this.$message.error( ret.meta.msg ) 
    },
    //添加新的角色
    async addRole() {
      let ret = await this.http.post('roles', {roleName: this.roleName, roleDesc: this.roleDesc})
      if( ret.meta.status == 201 ) {
        this.$message.success( '添加角色成功!' )
        this.getRoleList(); //刷新
        return;
      }
      this.$message.error( ret.meta.msg ) 

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