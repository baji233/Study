<template>
  <div>
    <el-dropdown-item @click.native="dialogVisible = true" icon="el-icon-chat-line-square">充值</el-dropdown-item>
    <el-dialog :title="`为[${member.name}]充值`" append-to-body :visible.sync="dialogVisible" >
      <el-row class="recharge">
        <el-col :span="24"><label>充值金额</label></el-col>
        <el-col :span="24">
          <el-input placeholder="请输入充值金额" v-model="money" label="充值金额"></el-input>
        </el-col>
        <el-col :span="24">
          <el-button type="danger" size="mini" @click="dialogVisible = false">取消</el-button>
          <el-button type="primary" size="mini" @click="recharge">确定</el-button>
        </el-col>
      </el-row>
    </el-dialog>
  </div>
</template>

<script>
import { Message } from 'element-ui';

export default {
  name: 'MemberRecharge',
  props: ['member'],
  data() {
    return {
      money: '',
      dialogVisible: false
    }
  },
  methods: {
    recharge() {
      this.money = parseInt(this.money);
      if (!/^\d+(.\d+)?$/.test(this.money)) {
        return Message({
          type: 'error',
          message: '请输入小数或整数',
          showClose: true
        });
      }
      if (`${this.member.money + this.money}`.length > 18) {
        return Message({
          type: 'error',
          showClose: true,
          message: '请控制金额增长'
        });
      }
      this.$bus.$emit('recharge', {
        member_id: this.member.member_id,
        money: this.money + this.member.money
      });
      Message({
        type: 'success',
        showClose: true,
        message: '充值成功!'
      });
      this.member.showRecharge = false;
      this.$bus.$emit('setRow', this.member, {
        money: this.member.money + this.money
      });
      this.dialogVisible = false;
      this.money = '';
    }
  }
}
</script>
