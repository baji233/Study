<template>
  <el-col :span="4">
    <el-button type="primary" icon="el-icon-plus" @click="openDialog">新增</el-button>
    <el-dialog title="新增" :visible.sync="dialogVisible">
      <el-form :model="form" :rules="rules" 
        ref="form" label-width="80px" @keyup.native.enter="submitForm('form')">
        <el-form-item label="类型" prop="card_type">
          <el-radio-group v-model="form.card_type" id="card_type" size="small">
            <el-radio-button label="天卡"></el-radio-button>
            <el-radio-button label="周卡"></el-radio-button>
            <el-radio-button label="月卡"></el-radio-button>
            <el-radio-button label="年卡"></el-radio-button>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="标题" prop="title">
          <el-input v-model="form.title" id="title"></el-input>
        </el-form-item>
        <el-form-item label="天数" prop="card_day">
          <el-input type="number" id="card_day" v-model.number="form.card_day"></el-input>
        </el-form-item>
        <el-form-item label="价格" prop="price">
          <el-input v-model="form.price" id="price"></el-input>
        </el-form-item>
        <el-form-item label="类型" prop="status">
          <el-switch
            id="status"
            v-model="form.status"
            inactive-text="停用"
            active-text="启用">
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
import memberCardVerification from '@/verification/member-manage/member-card';
// import {MessageBox} from 'element-ui';
import {add} from '@/dao/member-manage/member-card';

export default {
  name: 'AddMemberCard',
  data() {
    return {
      dialogVisible: false,
      form: {
        card_type: '',
        title: '',
        card_day: 0,
        price: '',
        status: false
      },
      rules: memberCardVerification,
    }
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.form.card_type = this.getCardType(this.form.card_type);
          this.form.status = +this.form.status;
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
  props: ['getCardType']
}
</script>
