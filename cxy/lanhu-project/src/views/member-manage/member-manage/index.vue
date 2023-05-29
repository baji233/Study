<template>
  <div style="padding: 30px;">
    <el-row :gutter="10">
      <el-col :span="5">
        <el-input v-model="n" placeholder="请输入姓名" @keyup.enter.native="search" />
      </el-col>
      <el-col :span="5">
        <el-input v-model="p" placeholder="请输入电话" @keyup.enter.native="search" />
      </el-col>
      <el-col :span="5">
        <el-input v-model="m" placeholder="请输入会员卡号" @keyup.enter.native="search" />
      </el-col>
      <el-col :span="3" style="margin-right: 10px;">
        <el-button @click.native="resetSearch()" icon="el-icon-close" type="danger">重置</el-button>
      </el-col>
      <AddMember />
      <el-col :span="24">
        <el-table v-loading="listLoading" :data="tableData" height="calc(100vh - 182px)">
          <el-table-column align="center" show-overflow-tooltip prop="username" label="会员卡号" width="120">
          </el-table-column>
          <el-table-column align="center" show-overflow-tooltip prop="name" label="姓名">
          </el-table-column>
          <el-table-column align="center" show-overflow-tooltip prop="card_type" label="会员类型">
          </el-table-column>
          <el-table-column align="center" show-overflow-tooltip prop="price" label="会员价格">
          </el-table-column>
          <el-table-column align="center" show-overflow-tooltip prop="money" label="充值金额">
          </el-table-column>
          <el-table-column align="center" show-overflow-tooltip prop="end_time" label="到期时间" width="100">
          </el-table-column>
          <el-table-column align="center" show-overflow-tooltip label="性别">
            <template slot-scope="{row}">
              <el-tag :type="+row.sex ? 'danger' : 'success'">
                {{ +row.sex ? '女' : '男' }}
              </el-tag>
            </template>
          </el-table-column>
          <el-table-column align="center" show-overflow-tooltip prop="age" label="年龄">
          </el-table-column>
          <el-table-column align="center" show-overflow-tooltip prop="birthday" label="生日">
          </el-table-column>
          <el-table-column align="center" show-overflow-tooltip prop="join_time" label="加入时间">
          </el-table-column>
          <el-table-column align="center" show-overflow-tooltip prop="height" label="身高">
          </el-table-column>
          <el-table-column align="center" show-overflow-tooltip prop="weight" label="体重">
          </el-table-column>
          <el-table-column align="center" show-overflow-tooltip prop="waist" label="腰围">
          </el-table-column>
          <el-table-column align="center" show-overflow-tooltip prop="status" label="状态">
            <template slot-scope="{row}">
              <el-tag :type="+row.status ? 'success' : 'danger'">
                {{ +row.status ? '启用' : '停用' }}
              </el-tag>
            </template>
          </el-table-column>
          <el-table-column align="center" label="操作" width="200">
            <template slot-scope="{ row }">
              <DoMembershipCard :member="row" :getMemberCardAll="getMemberCardAll"/>
              <el-dropdown size="medium">
                <el-button type="primary" size="small">
                  更多<i class="el-icon-arrow-down el-icon--right"></i>
                </el-button>
                <el-dropdown-menu slot="dropdown">
                  <!-- 充值 -->
                  <MemberRecharge :member="row"/>
                  <!-- 编辑 -->
                  <UpdateMemberManage :member="row" :key="row.member_id"/>
                  <el-dropdown-item icon="el-icon-delete"
                    @click.native="deleteMember(row)">删除</el-dropdown-item>
                  <el-dropdown-item icon="el-icon-edit-outline" @click.native="resetPassword(row)">重置密码
                  </el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
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
import { selectAll } from '@/dao/member-manage/member-card';
import { select, count, delMember, update } from '@/dao/member-manage/member-manage';
import AddMember from './Add.vue';
import DoMembershipCard from './DoCard.vue';
import MemberRecharge from './Recharge.vue';
import UpdateMemberManage from './Update.vue';
import { Message, MessageBox } from 'element-ui';

export default {
  name: 'MemberManage',
  data() {
    return {
      n: '',
      p: '',
      m: '',
      tableData: [],
      listLoading: false,
      count: 0,
      passwordMap: new Map(),
      doCardMap: new Map(),
      rechargeMap: new Map(),
      getMemberCardAll: []
    }
  },
  methods: {
    // 组织查询 tableData 的路径
    sendReqestUrl({ ps, cp, n, p, m }) {
      const url = ['/member-manage/list?'];
      url.push(`ps=${ps || 5}&`);
      url.push(`n=${n || ''}&`);
      url.push(`p=${p || ''}&`);
      url.push(`m=${m || ''}&`);
      url.push(`cp=${parseInt(cp) || 1}`);
      return url.join('');
    },
    // 查询文本框
    search() {
      event.preventDefault();
      this.$router.push({
        name: this.$route.name,
        query: {
          cp: 1,
          n: this.n,
          p: this.p,
          m: this.m
        }
      });
      this.$bus.$emit('callFunc', [select, count]);
    },
    // 需要被调用的函数
    callFunc(funcArr) {
      for (const func of funcArr) {
        func(this);
      }
    },
    // 删除某个会员
    deleteMember(member) {
      delMember(this, member);
    },
    // 重置密码，但不是立马重置，是等待组件销毁后 或 页面被刷新时调用
    resetPassword(member) {
      // resetMemberPassword(this, member);
      const six = '666666';
      if (member.password !== six) {
        MessageBox.confirm
          (`是否将 ${member.name} 的密码重置为[${six}]`, '警告', { type: 'warning' })
          .then(result => {
            this.passwordMap.set(member.member_id, {
              member_id: member.member_id,
              password: six
            });
            Message({
              type: 'success',
              showClose: true,
              message: `成功将${member.name}的密码重置为 ${six}`
            });
            member.password = six;
          }).catch(err => { console.log(err); });
      } else {
        Message({
          showClose: true,
          message: `${member.name}的密码已经重置为 ${six} 或 已经是 ${six}`
        });
      }
    },
    // 重置查询文本框
    resetSearch() {
      if (this.n || this.p || this.m) {
        this.n = '';
        this.m = '';
        this.p = '';
        this.$router.push({
          name: this.$route.name,
          query: {
            n: '',
            p: '',
            m: ''
          }
        });
        this.callFunc([select, count]);
      }
    },
    handleBeforeunload(callback){
      const data = [];
      /* if (e) {
        e.preventDefault();
        e.returnValue = '';
      } */
      this.pushValue(this.passwordMap, data);
      this.pushValue(this.doCardMap, data);
      this.pushValue(this.rechargeMap, data);
      if (data.length) {
        update(this, data, () => { callback && callback(); });
      } else {
        callback && callback();
      }
    },
    pushValue(map, arr){
      for (const item of map) {
        arr.push(item[1]);
      }
      map.clear();
    }
  },
  computed: {
    // 分页空间用到的总对象
    getPage() {
      return {
        total: this.count,
        url: this.sendReqestUrl,
        pageSize: 'memberManagePageSize',
        params: { n: this.n, p: this.p, m: this.m },
        funcs: [select]
      }
    }
  },
  mounted() {
    // 组件销毁之前调用重置密码
    window.addEventListener('beforeunload', this.handleBeforeunload);
    // 开启全局事件，可能其他组件也会要调用这个组件的方法
    this.$bus.$on('callFunc', funcs => {
      this.callFunc(funcs);
    });
    // 设置这个组件的 count，在分页组件中需要更新
    this.$bus.$on('setCount', count => {
      if (typeof count === 'boolean') {
        this.count += count ? 1 : -1;
      } else {
        this.count = parseInt(count);
      }
    });
    // 其他子组件修改后，不立马更新数据，将数据传递到该组件后修改
    this.$bus.$on('setRow', (item1, item2) => {
      for (const key in item2) {
        item1[key] = item2[key];
      }
    });
    // 办卡时调用的操作
    this.$bus.$on('doCard', item => {
      this.doCardMap.set(item.member_id, item);
    });
    // 充值时的操作
    this.$bus.$on('recharge', item => {
      this.rechargeMap.set(item.member_id, item);
    });
    selectAll(this, result => {
      // 开启全局总线，有组件想获取到这个会员卡的所有信息
      this.getMemberCardAll = result;
    });
    // 一开始查询总条数和源数据
    this.callFunc([select, count]);
  },
  beforeDestroy() {
    this.handleBeforeunload();
    window.removeEventListener('beforeunload', this.handleBeforeunload);
    this.$off();
  },
  components: {
    AddMember,
    DoMembershipCard,
    MemberRecharge,
    UpdateMemberManage
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

.el-table .el-button:last-of-type {
  margin-left: 10px;
}
</style>