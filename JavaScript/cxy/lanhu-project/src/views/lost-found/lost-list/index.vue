<template>
  <div style="padding: 30px;">
    <el-row :gutter="10">
      <el-col :span="10">
        <el-input v-model="w" placeholder="请输入失物名称" @keyup.enter.native="search">
          <el-button slot="append" icon="el-icon-search"></el-button>
        </el-input>
      </el-col>
      <AddLostList/>
      <el-col :span="24">
        <el-table border v-loading="listLoading" :data="tableData" 
          height="calc(100vh - 182px)" stripe>
          <el-table-column show-overflow-tooltip prop="lost_name" label='物品名称' >
          </el-table-column>
          <el-table-column show-overflow-tooltip prop="found_person" label="拾取人">
          </el-table-column>
          <el-table-column show-overflow-tooltip prop="found_addres" label="拾取地址">
          </el-table-column>
          <el-table-column show-overflow-tooltip prop="found_time" label="拾取时间" width="100">
          </el-table-column>
          <el-table-column show-overflow-tooltip prop="found_phone" label="拾取人电话" width="140">
          </el-table-column>
          <el-table-column show-overflow-tooltip prop="lost_person" label='认领人' >
          </el-table-column>
          <el-table-column show-overflow-tooltip prop="status" label="认领状态">
            <template slot-scope="{row}">
              <el-tag :type="+row.status ? 'success' : 'danger'">
                {{ +row.status ? '已认领' : '未认领' }}
              </el-tag>
            </template>
          </el-table-column>
          <el-table-column label="操作" width="260" align="center">
            <template slot-scope="{ row }">
              <UpdateLostList :lost="row"/>
              <el-button style="margin: 0 5px;" type="danger" size="mini"
                icon="el-icon-delete" @click="deleteLostList(row.lost_id)">删除</el-button>
              <ClaimLost :lost="row"/>
              </template>
          </el-table-column>
        </el-table>
      </el-col>
      <el-col :span="24">
        <Paging :page="getPage" />
      </el-col>
    </el-row>
  </div>
</template>

<script>
import {select, count, delLostList, update} from '@/dao/lost-found/lost-list';
import AddLostList from './Add.vue';
import UpdateLostList from './Update.vue';
import ClaimLost from './Claim.vue';

export default {
  name: 'LostList',
  data() {
    return {
      w: '',
      tableData: [],
      listLoading: false,
      count: 0,
      claimMap: new Map()
    }
  },
  methods: {
    // 组织查询 tableData 的路径
    sendReqestUrl({ ps, cp, w }) {
      const url = ['/lost-list/list?'];
      url.push(`ps=${ps || 5}&`);
      url.push(`w=${w || ''}&`);
      url.push(`cp=${parseInt(cp) || 1}`);
      return url.join('');
    },
    // 需要被调用的函数
    callFunc(funcArr) {
      for (const func of funcArr) {
        func(this);
      }
    },
    // 删除某个失物信息
    deleteLostList(lost_id) {
      delLostList(this, lost_id);
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
    handleBeforeunload(callback){
      const data = [];
      for (const item of this.claimMap) {
        data.push(item[1]);
      }
      if(data.length) {
        update(this, data, () => { 
        this.claimMap.clear();
          callback && callback();
        });
      } else {
        callback && callback();
      }
    }
  },
  computed: {
    // 分页空间用到的总对象
    getPage() {
      return {
        total: this.count,
        url: this.sendReqestUrl,
        pageSize: 'lostListPageSize',
        params: { w: this.w },
        funcs: [select]
      }
    }
  },
  mounted() {
    window.addEventListener('beforeunload', this.handleBeforeunload);
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
    this.$bus.$on('claim', item => {
      this.claimMap.set(item.lost_id, item);
    });
    this.$bus.$on('setRow', (item1, item2) => {
      for (const key of Object.keys(item2)) {
        item1[key] = item2[key];
      }
    });
    this.callFunc([select, count]);
  },
  beforeDestroy() {
    this.handleBeforeunload();
    window.removeEventListener('beforeunload', this.handleBeforeunload);
    this.$off();
  },
  components: {
    AddLostList,
    UpdateLostList,
    ClaimLost
  },
  watch: {
    $route(){
      this.handleBeforeunload();
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

</style>