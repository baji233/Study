<template>
  <div style="padding: 30px;">
    <el-row :gutter="10">
      <el-col :span="24">
        <el-table v-loading="listLoading" :data="tableData" height="calc(100vh - 182px)">
          <el-table-column align="center" show-overflow-tooltip 
            prop="member.username" label="会员卡号" width="120" />
          <el-table-column align="center" show-overflow-tooltip 
            prop="member.name" label="会员姓名" />
          <el-table-column align="center" show-overflow-tooltip 
            prop="money" label="充值金额" width="120" />
          <el-table-column align="center" show-overflow-tooltip 
            prop="create_time" label="充值时间"/>
          <el-table-column align="center" show-overflow-tooltip 
            prop="create_user" label="操作人" width="120" />
        </el-table>
      </el-col>
      <el-col :span="24">
        <Paging :page="getPage" />
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { select, count } from '@/dao/member-manage/my-recharge';
export default {
  name: 'MyRecharge',
  data() {
    return {
      tableData: [],
      listLoading: false,
      count: 0,
    }
  },
  methods: {
    sendReqestUrl({ ps, cp }) {
      const url = ['/my-recharge/list?'];
      url.push(`ps=${ps || 5}&`);
      url.push(`cp=${parseInt(cp) || 1}`);
      return url.join('');
    },
    callFunc(funcArr) {
      for (const func of funcArr) {
        func(this);
      }
    },
  },
  mounted() {
    this.$bus.$on('callFunc', funcs => {
      this.callFunc(funcs);
    });
    this.callFunc([select, count]);
  },
  beforeDestroy() {
    this.$off();
  },
  computed: {
    getPage() {
      return {
        total: this.count,
        url: this.sendReqestUrl,
        pageSize: 'myRechargePageSize',
        params: {},
        funcs: [select, count]
      }
    }
  }
}
</script>

<style scoped>
.el-table {
  width: 100%;
  border: 1px solid #EBEEF5;
  margin-top: 10px;
}

.el-row {
  height: calc(100vh - 110px);
}

.el-table .el-button:last-of-type {
  margin-left: 10px;
}
</style>