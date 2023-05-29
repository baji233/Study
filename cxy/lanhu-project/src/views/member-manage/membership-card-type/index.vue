<template>
  <div style="padding: 30px;">
    <el-row :gutter="20">
      <el-col :span="10" class="search">
        <el-input v-model="w" placeholder="请输入标题" @keyup.enter.native="search">
          <el-button @click.native="search" slot="append" icon="el-icon-search"></el-button>
        </el-input>
      </el-col>
      <AddMemberCard :getCardType="getCardType"/>
      <el-col :span="24">
        <el-table v-loading="listLoading"
          :data="tableData" height="calc(100vh - 182px)">
          <el-table-column prop="title" label="标题" width="120">
          </el-table-column>
          <el-table-column label="类型">
            <template slot-scope="{row}">
              <el-tag :type="type[row.card_type - 1][0]">
                {{ type[row.card_type - 1][1] }}
              </el-tag>
            </template>
          </el-table-column>
          <el-table-column prop="card_day" label="天数">
          </el-table-column>
          <el-table-column prop="price" label="价格(元)">
          </el-table-column>
          <el-table-column label="状态">
            <template slot-scope="{row}">
              <el-tag :type="getStatusTag(row.status)[0]">
                {{ getStatusTag(row.status)[1] }}
              </el-tag>
            </template>
          </el-table-column>
          <el-table-column label="操作" width="180">
            <template slot-scope="{ row }">
              <UpdateMemberCard :getCardType="getCardType" :member_card="row" :key="row.card_id"/>
              <el-button @click.native="deleteMemberCard(row.card_id)" 
                size="mini" type="danger" icon="el-icon-delete">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-col>
      <el-col :span="24">
        <Paging :page="getPage"/>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import {select, count, delMemberCard} from '@/dao/member-manage/member-card';
import AddMemberCard from './Add.vue';
import UpdateMemberCard from './Update.vue';

export default {
  name: 'MembershipCardType',
  data() {
    return {
      w: '',
      tableData: [],
      listLoading: false,
      count: 0,
      type: [
        ['primary', '天卡'],
        ['success', '周卡'],
        ['danger', '月卡'],
        ['warning', '年卡']
      ]
    }
  },
  methods: {
    sendReqestUrl({ps, cp, w}) {
      const url = ['/member-card/list?'];
      url.push(`ps=${ps || 5}&`);
      url.push(`w=${w || ''}&`);
      url.push(`cp=${parseInt(cp) || 1}`);
      return url.join('');
    },
    search(){
      event.preventDefault();
      this.$router.push({
        name: this.$route.name,
        query: {
          cp: 1,
          w: this.w,
        }
      });
      this.$bus.$emit('callFunc', [select, count]);
    },
    callFunc(funcArr){
      for (const func of funcArr) {
        func(this);
      }
    },
    deleteMemberCard(card_id) {
      delMemberCard(this, card_id);
    },
    getCardType(card_type){
      switch(card_type){
        case '天卡':
          return '1';
        case '周卡':
          return '2';
        case '月卡':
          return '3';
        case '年卡':
          return '4'; 
        case '1':
          return '天卡';
        case '2':
          return '周卡';
        case '3':
          return '月卡';
        case '4':
          return '年卡';
      }
    },
    getStatusTag(status){
      return status === '1' ? ['success', '启用'] : ['danger', '停用'];
    }
  },
  computed: {
    getPage(){
      return {
        total: this.count,
        url: this.sendReqestUrl,
        pageSize: 'memberCardPageSize',
        params: { w: this.w },
        funcs: [select]
      }
    }
  },
  mounted() {
    this.$bus.$on('callFunc', funcs => {
      this.callFunc(funcs);
    });
    this.$bus.$on('setCount', count => {
      if (typeof count === 'boolean') {
        this.count += count ? 1 : -1;
      } else {
        this.count = parseInt(count);
      }
    });
    this.callFunc([select, count]);
  },
  beforeDestroy() {
    this.$off();
  },
  components: {
    AddMemberCard,
    UpdateMemberCard
  }
}
</script>

<style scoped>
.el-table {
  width: 100%;
  border:1px solid #EBEEF5;
  margin-top: 10px;
}

.el-row {
  height: calc(100vh - 110px);
}

.el-table .el-button:last-of-type {
  margin-left: 10px;
}
</style>