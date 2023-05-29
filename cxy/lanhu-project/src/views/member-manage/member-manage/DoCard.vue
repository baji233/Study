<template>
  <div class="do-card">
    <el-button type="success" icon="el-icon-edit-outline" size="small" @click="openDialog">办卡</el-button>
    <el-dialog :title="`为[${member.name}]办理会员卡`" :visible.sync="dialogVisible">
      <el-row>
        <el-col :span="24">请选择会员卡类型</el-col>
        <el-col :span="24">
          <el-select value-key="card_id" v-model="member_card" placeholder="请选择">
            <el-option v-for="item in options" :key="item.card_id" :value="item" :label="item.title">
              <span style="float: left">{{ item.title }}</span>
              <span style="float: right; color: #8492a6; font-size: 13px">
                {{ item.price }}￥
              </span>
            </el-option>
          </el-select>
        </el-col>
        <el-col :span="24">
          <el-button type="danger" size="mini" @click="dialogVisible = false">取消</el-button>
          <el-button type="primary" size="mini" @click="doCard">确定</el-button>
        </el-col>
      </el-row>
    </el-dialog>
  </div>
</template>

<script>
import { Message } from 'element-ui';

export default {
  name: 'DoMembershipCard',
  props: ['member', 'getMemberCardAll'],
  data() {
    return {
      dialogVisible: false,
      options: [],
      member_card: null,
    }
  },
  methods: {
    openDialog() {
      this.options = this.getMemberCardAll;
      this.dialogVisible = true;
    },
    doCard() {
      if (this.member_card !== null) {
        const { price, title } = this.member_card;
        this.$bus.$emit('doCard', {
          member_id: this.member.member_id,
          price,
          card_type: title
        });
        Message({
          type: 'success',
          showClose: true,
          message: '办卡成功!'
        });
        this.dialogVisible = false;
        this.$bus.$emit('setRow', this.member, {
          card_type: title,
          price
        });
        this.member_card = null;
      } else {
        Message({
          type: 'error',
          message: '请选择会员卡类型',
          showClose: true
        });
      }
    },
  },
}
</script>