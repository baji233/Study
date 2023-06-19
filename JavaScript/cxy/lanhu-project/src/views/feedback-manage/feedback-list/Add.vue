<template>
  <el-col :span="4">
    <el-button type="primary" icon="el-icon-plus" @click="dialogVisible = true">新增</el-button>
    <el-dialog title="新增" :visible.sync="dialogVisible">
      <el-form :model="form" :rules="rules" ref="form" label-width="80px" >
        <el-form-item label="标题" prop="title">
          <el-input v-model="form.title" id="title"></el-input>
        </el-form-item>
        <el-form-item label="内容" prop="content">
          <el-input type='textarea' v-model="form.content" 
            resize="none" :rows="10" id="content"></el-input>
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
import feedbackListVerification from '@/verification/feedback-manage/feedback-list';
import {add} from '@/dao/feedback-manage/feedback-list';

export default {
  name: 'AddFeedbackList',
  data() {
    return {
      dialogVisible: false,
      form: {
        title: '',
        content: '',
      },
      rules: feedbackListVerification,
    }
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          add(this, this.form);
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
}
</script>
