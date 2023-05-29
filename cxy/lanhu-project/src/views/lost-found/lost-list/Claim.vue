<template>
  <div class="do-card">
    <el-button type="success" icon="el-icon-edit-outline" size="mini" @click="openDialog">认领</el-button>
    <el-dialog :title="`认领`" :visible.sync="dialogVisible">
      <el-row>
        <el-col :span="24"><b>失物招领</b></el-col>
        <el-col :span="24">
          <el-input autofocus v-model="lost_person" placeholder="请填写您的名字" @keyup.native.enter="claim"></el-input>
        </el-col>
        <el-col :span="24">
          <el-button type="danger" size="mini" @click="dialogVisible = false">取消</el-button>
          <el-button type="primary" size="mini" @click="claim">确定</el-button>
        </el-col>
      </el-row>
    </el-dialog>
  </div>
</template>

<script>
import { Message } from 'element-ui';

export default {
  name: 'ClaimLost',
  props: ['lost'],
  data() {
    return {
      dialogVisible: false,
      lost_person: '',
    }
  },
  methods: {
    claim(){
      if (/^.{1,36}$/.test(this.lost_person)) {
        this.$bus.$emit('claim', {
          lost_id: this.lost.lost_id,
          lost_person: this.lost_person,
          status: '1'
        });
        this.$bus.$emit('setRow', this.lost, {
          lost_person: this.lost_person,
          status: '1'
        });
        Message({
          type: 'success',
          showClose: true,
          message: '认领成功'
        });
        this.dialogVisible = false;
      } else {
        Message({
          type: 'warning',
          showClose: true,
          message: "请将您的名字控制在 1 到 36 之间"
        });
      }
    },
    openDialog(){
      if (this.lost.status === '1') {
        Message({
          type: 'warning',
          showClose: true,
          message: '该失物已被认领'
        });
      } else {
        this.dialogVisible = true;
      }
    }
  },
}
</script>