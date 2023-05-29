<template>
  <div class="paging">
    <el-pagination
      :page-sizes="[5, 10, 15, 20, 30, 50]"
      :page-size="pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :current-page="cp"
      :total="page.total"
      
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange">
    </el-pagination>
  </div>
</template>
<!-- hide-on-single-page -->
<script>
export default {
  name: 'Paging',
  data(){
    return {
      pageSize: +sessionStorage.getItem(this.page.pageSize) || 5,
      cp: parseInt(this.$route.query.cp) || 1,
    }
  },
  methods: {
    // 当展示条数发生改变时调用
    handleSizeChange(ps){
      sessionStorage.setItem(this.page.pageSize, ps);
      this.pageSize = ps;
      this.handleData();
    },
    // 当当前页切换时调用
    handleCurrentChange(cp){
      this.cp = cp;
      this.handleData();
    },
    handleData(){
      const {cp, page, $route, $bus, $router} = this;
      const query = {cp};
      for (const item of Object.keys(page.params)) {
        query[item] = $route.query[item] || page.params[item];
      }
      // 路由发生跳转
      $router.push({
        name: $route.name,
        query
      });
      // 调用会员卡类型的全局事件
      $bus.$emit('callFunc', page.funcs);
    }
  },
  // 接收的 props 参数
  props: ['page'],
  watch: {
    // 监听路由地址是否改变，因为直接回车没有效果，需要直接监听
    // 这个仅限于路由类型是has的，如果是history，只要地址栏回车就会触发，无需此次监听
    $route(newVal){
      let cp = parseInt(newVal.query.cp)
      if (cp) {
        this.cp = cp;        
      }
      this.handleData();
    }
  }
}
</script>

<style scoped>
.paging {
  overflow-x: auto;
  padding: 10px 30px;
  box-sizing: border-box;
  width: 100%;
}

.el-pagination {
  text-align: center;
}
</style>