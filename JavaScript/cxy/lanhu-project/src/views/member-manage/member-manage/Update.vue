<template>
  <div>
    <el-dropdown-item @click.native="openDialog" icon="el-icon-edit-outline">编辑</el-dropdown-item>
    <el-dialog title="编辑" :visible.sync="dialogVisible" append-to-body class="member-manage">
      <el-form label-position="top" :model="form" :rules="rules" size="small" ref="form"
        @keyup.native.enter="submitForm('form')">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" id="name"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-switch v-model="form.sex" id="sex" inactive-text="男" active-text="女">
          </el-switch>
        </el-form-item>
        <el-form-item label="电话" prop="phone">
          <el-input v-model="form.phone" id="phome" maxlength="11" show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="年龄" prop="age">
          <el-input :value="computedAge" readonly id="age"></el-input>
        </el-form-item>
        <el-form-item label="生日" prop="birthday">
          <el-date-picker type="date" id="birthday" placeholder="选择生日" v-model="form.birthday" />
        </el-form-item>
        <el-form-item label="到期时间" prop="end_time">
          <el-date-picker type="date" id="end_time" placeholder="选择到期时间" v-model="form.end_time" />
        </el-form-item>
        <el-form-item label="身高(cm)" prop="height">
          <el-input v-model="form.height" id="height"></el-input>
        </el-form-item>
        <el-form-item label="体重" prop="weight">
          <el-input v-model="form.weight" id="weight"></el-input>
        </el-form-item>
        <el-form-item label="腰围" prop="waist">
          <el-input v-model="form.waist" id="waist"></el-input>
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-switch v-model="form.status" id="status" inactive-text="停用" active-text="启用">
          </el-switch>
        </el-form-item>
        <el-form-item label="会员卡号" prop="username">
          <el-input v-model="form.username" id="username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input type="password" id="password" v-model="form.password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button size="small" type="primary" @click="submitForm('form')">确定</el-button>
          <el-button size="small" type="danger" @click="resetForm('form')">重置</el-button>
        </el-form-item>
        
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import memberManageVerification from '@/verification/member-manage/member-manage';
import { update } from '@/dao/member-manage/member-manage';
import { Message } from 'element-ui';

export default {
  name: 'UpdateMemberManage',
  data() {
    return {
      form: {
        name: '',
        sex: false,
        phone: '',
        age: null,
        birthday: '',
        end_time: '',
        height: null,
        weight: null,
        waist: null,
        status: false,
        username: '',
        password: ''
      },
      initForm: {},
      rules: memberManageVerification,
      dialogVisible: false
    }
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          if (this.has_the_source_data_been_modified()) {
            this.form.sex = +this.form.sex;
            this.form.status = +this.form.status;
            this.form.birthday = this.form.birthday;
            this.form.end_time = this.form.end_time;
            update(this, [this.form]);
          } else {
            Message({
              type: 'warning',
              message: '您未修改源数据，请修改数据后重试',
              showClose: true
            });
          }
        }
      });
    },
    has_the_source_data_been_modified() {
      for (const key of Object.keys(this.initForm)) {
        if (this.initForm[key] !== this.form[key]) {
          return true;
        }
      }
      return false;
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    openDialog(){
      setTimeout(() => {
        const {status, sex} = this.member;
        this.initForm.status = status === '1';
        this.initForm.sex = sex === '1';
        this.initForm = Object.assign(this.member, this.initForm);
        this.form = { ...this.initForm };
      }, 0);
      this.dialogVisible = true;
      this.$nextTick(() => {
        this.$refs.form.clearValidate();
      });
    },
  },
  props: ['member'],
  computed: {
    computedAge(){
      const year = new Date().getFullYear();
      this.form.age = (year - (new Date(this.form.birthday).getFullYear() || year)) || null;
      return this.form.age;
    }
  }
}
</script>