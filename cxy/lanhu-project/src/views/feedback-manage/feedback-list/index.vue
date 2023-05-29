<template>
  <div style="padding: 30px;">
    <el-row :gutter="10">
      <el-col :span="10">
        <el-input v-model="w" placeholder="请输入反馈标题" @keyup.enter.native="search">
          <el-button slot="append" icon="el-icon-search"></el-button>
        </el-input>
      </el-col>
      <AddFeedbackList/>
      <el-col :span="24">
        <el-table border v-loading="listLoading" :data="tableData" 
          height="calc(100vh - 182px)" stripe>
          <el-table-column show-overflow-tooltip prop="title" label='标题' >
          </el-table-column>
          <el-table-column show-overflow-tooltip prop="content" label="内容">
          </el-table-column>
          <el-table-column label="操作" width="180" align="center">
            <template slot-scope="{ row }">
              <UpdateFeedbackList :suggest="row" :key="row.id"/>
              <el-button style="margin: 0 5px;" type="danger" size="mini"
                icon="el-icon-delete" @click="deleteFeedbackList(row.id)">删除</el-button>
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
import {select, count, delFeedbackList} from '@/dao/feedback-manage/feedback-list';
import AddFeedbackList from './Add.vue';
import UpdateFeedbackList from './Update.vue';

export default {
  name: 'FeedBackList',
  data() {
    return {
      w: '',
      tableData: [],
      listLoading: false,
      count: 0,
    }
  },
  methods: {
    // 组织查询 tableData 的路径
    sendReqestUrl({ ps, cp, w }) {
      const url = ['/feedback-list/list?'];
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
    deleteFeedbackList(id) {
      delFeedbackList(this, id);
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
  },
  computed: {
    // 分页空间用到的总对象
    getPage() {
      return {
        total: this.count,
        url: this.sendReqestUrl,
        pageSize: 'feedbackListPageSize',
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
    AddFeedbackList,
    UpdateFeedbackList
  },
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