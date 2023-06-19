<template>
  <el-col :span="4">
    <el-button type="primary" icon="el-icon-plus" @click="openDialog">新增</el-button>
    <el-dialog title="新增" :visible.sync="dialogVisible" class="member-manage">
      <el-form label-position="top" :model="form" :rules="rules" size="small"
        ref="form" @keyup.native.enter="submitForm('form')">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" id="name"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-switch id="sex"
            v-model="form.sex"
            inactive-text="男"
            active-text="女">
          </el-switch>
        </el-form-item>
        <el-form-item label="电话" prop="phone">
          <el-input v-model="form.phone" maxlength="11" show-word-limit id="phone"></el-input>
        </el-form-item>
        <el-form-item label="年龄" prop="age">
          <el-input :value="computedAge()" readonly id="age"></el-input>
        </el-form-item>
        <el-form-item label="生日" prop="birthday">
          <el-date-picker type="date" placeholder="选择生日" id="birthday" v-model="form.birthday" />
        </el-form-item>
        <el-form-item label="到期时间" prop="end_time">
          <el-date-picker type="date" placeholder="选择到期时间" id="end_time" v-model="form.end_time" />
        </el-form-item>
        <el-form-item label="身高(cm)" prop="height">
          <el-input v-model="form.height" id="height"></el-input>
        </el-form-item>
        <el-form-item label="体重" prop="weight">
          <el-input id="weight" v-model="form.weight"></el-input>
        </el-form-item>
        <el-form-item label="腰围" prop="waist">
          <el-input id="waist" v-model="form.waist"></el-input>
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-switch
            id="status"
            v-model="form.status"
            inactive-text="停用"
            active-text="启用">
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
  </el-col>
</template>

<script>
import memberManageVerification from '@/verification/member-manage/member-manage';
import {add} from '@/dao/member-manage/member-manage';

export default {
  name: 'AddMemberManage',
  data() {
    return {
      dialogVisible: false,
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
      rules: memberManageVerification,
    }
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.form.sex = +this.form.sex;
          this.form.status = +this.form.status;
          this.form.join_time = this.$moment().format('yyyy-MM-DD');
          this.form.birthday = this.form.birthday;
          this.form.end_time = this.form.end_tim;
          add(this, this.form);
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    computedAge(){
      const year = new Date().getFullYear();
      this.form.age = +(year - (new Date(this.form.birthday).getFullYear() || year)) || null;
      return this.form.age;
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