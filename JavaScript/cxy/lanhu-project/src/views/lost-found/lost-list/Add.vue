<template>
  <el-col :span="4">
    <el-button type="primary" icon="el-icon-plus" @click="openDialog">新增</el-button>
    <el-dialog title="新增" :visible.sync="dialogVisible">
      <el-form :model="form" :rules="rules" 
        ref="form" label-width="80px" @keyup.native.enter="submitForm('form')">
        <el-form-item label="物品名称" prop="lost_name">
          <el-input v-model="form.lost_name" id="lost_name"></el-input>
        </el-form-item>
        <el-form-item label="拾取时间" prop="found_time">
          <el-date-picker style="width: 100%;" type="date" placeholder="选择拾取时间" v-model="form.found_time" id="found_time"/>
        </el-form-item>
        <el-form-item label="拾取地址" prop="found_addres">
          <el-input v-model="form.found_addres" id="found_addres"></el-input>
        </el-form-item>
        <el-form-item label="拾取人" prop="found_person">
          <el-input v-model="form.found_person" id="found_person"></el-input>
        </el-form-item>
        <el-form-item label="联系电话" prop="found_phone">
          <el-input v-model="form.found_phone" id="found_phone" maxlength="11" show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-switch id="status"
            v-model="form.status"
            inactive-text="未认领"
            active-text="已认领">
          </el-switch>
        </el-form-item>
        <el-form-item>
          <el-button size="small" type="primary" @click="submitForm('form')">确定</el-button>
          <el-button size="small" type="danger" @click="resetForm('form')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </el-col>
</template>

<script>
import lostListVerification from '@/verification/lost-found/lost-list';
import {add} from '@/dao/lost-found/lost-list';

export default {
  name: 'AddLostList',
  data() {
    return {
      dialogVisible: false,
      form: {
        lost_name: '',
        found_time: '',
        found_addres: '',
        found_person: '',
        found_phone: null,
        status: false
      },
      rules: lostListVerification,
    }
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.form.status = +this.form.status;
          this.form.found_time = this.$moment(this.form.found_time).format('yyyy-MM-DD');
          add(this, this.form);
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    openDialog(){
      this.dialogVisible = true;
      this.$nextTick(() => {
        this.$refs['form'].clearValidate();
      });
    }
  },
}
</script>
