<template>

  <el-container>
    <!-- 头部 -->
    <el-header>
      <div>
        <img width="50" src="../assets/logo.png"/>
        <span>后台管理系统</span>
      </div>
      <el-button size="small" type="warning" @click="exit">退出</el-button>
    </el-header>
    <!-- 左右部分 -->
    <el-container>
      <el-aside width="200px">
        <!-- 导航菜单 -->
          <el-menu router background-color="#333744" text-color="#fff" active-text-colir="#ffd04b">
            <!-- 一级菜单 -->
            <el-submenu :index="item.id + ''" v-for="item in menulist" :key="item.id">
            <template slot="title">
            <i :class="icons[item.id]"></i>
            <span>{{ item.authName }}</span>
            </template>
            <!-- 二级菜单 -->
            <el-menu-item :index='mi.path' v-for="mi in item.children" :key="mi.id">
              <template slot="title">
                <i class="el-icon-menu"></i>
                <span>{{ mi.authName }}</span>
              </template>
            </el-menu-item>
            </el-submenu>

          </el-menu>
        </el-aside>
      <el-main>
        <!-- 子路由占位符 -->
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>

</template>

<script>
export default {
  data() {
    return {      
      menulist: [],
      icons: {
        '125': 'iconfont icon-user',
        '103': 'iconfont icon-33702mima',
        '101': 'iconfont icon-shangpin',
        '102': 'iconfont icon-danju',
        '145': 'iconfont icon-baobiao'
      }
    }
  },
  created() {
    this.getMenuList()
  },
  methods: {
    exit() {
      console.log('退出登录');
      sessionStorage.clear()
      this.$router.push('/login')
    },
    async getMenuList() {
      //获取菜单列表
      let ret = await this.http.get('menus')
      console.log('菜单列表: ', ret);
      this.menulist = ret.data
    }

  }
}
</script>

<style lang="less" scoped>
.homepage {
  height: 100%;
}

.el-header {
  background: #373d41;
  display: flex;
  justify-content: space-between;
  color: #fff;
  > div {
    display: flex;
    align-items: center;
    span {
      margin-left: 15px;
    }
  }
}

.el-aside {
  background-color: #333744;
  .el-menu {
    border-right: none;
  }
}

.el-main {
  background-color: #eaedfe;
}

.iconfont {
  margin-right: 10px;
}
</style>