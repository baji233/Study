<template>
  <span>
    <el-button size="mini" type="primary" icon="el-icon-edit" @click="openDialog">编辑</el-button>
    <el-dialog title="编辑" :visible.sync="dialogVisible">
      <el-form :model="form" :rules="rules" ref="form" label-width="80px" @keyup.native.enter="submitForm('form')">
        <el-form-item label="类型" prop="card_type">
          <el-radio-group v-model="form.card_type" id='card_type' size="small">
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
          <el-input type="number" v-model.number="form.card_day" id="card_day"></el-input>
        </el-form-item>
        <el-form-item label="价格" prop="price">
          <el-input v-model="form.price" id="price"></el-input>
        </el-form-item>
        <el-form-item label="类型" prop="status">
          <el-switch v-model="form.status" id="status" inactive-text="停用" active-text="启用">
          </el-switch>
        </el-form-item>
        <el-form-item>
          <el-button size="small" type="primary" @click="submitForm('form')">确定</el-button>
          <el-button size="small" type="danger" @click="resetForm('form')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </span>
</template>

<script>
import memberCardVerification from '@/verification/member-manage/member-card';
import { Message } from 'element-ui';
import { update } from '@/dao/member-manage/member-card';

export default {
  name: 'UpdateMemberCard',
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
      initForm: {},
      rules: memberCardVerification,
    }
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          if (this.has_the_source_data_been_modified()) {
            this.form.card_type = this.getCardType(this.form.card_type);
            this.form.status = +this.form.status;
            update(this, this.form);
          } else {
            Message({
              type: 'warning',
              message: '您未修改任何数据，请修改后重试',
              showClose: true
            });
          }
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    openDialog() {
      setTimeout(() => {
        this.initForm = { ...this.member_card};
        const {status, card_type} = this.initForm;
        this.initForm.status = status === '1';
        this.initForm.card_type = this.getCardType(card_type);
        this.form = { ...this.initForm };
      }, 0);
      this.dialogVisible = true;
      this.$nextTick(() => {
        this.$refs['form'].clearValidate();
      });
    },
    // 返回false，源数据未修改
    has_the_source_data_been_modified() {
      for (const key of Object.keys(this.initForm)) {
        if (this.initForm[key] !== this.form[key]) {
          return true;
        }
      }
      return false;
    }
  },
  props: ['member_card', 'getCardType'],
}
</script>
