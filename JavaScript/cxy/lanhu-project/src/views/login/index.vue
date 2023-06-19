<template>
  <div class="logincontainer">
    <el-form :model="loginModel" class="loginform" ref="loginRef" :rules="rules" size="default">
      <el-form-item>
        <div class="logintitle">系统登录</div>
      </el-form-item>
      <el-form-item prop="username">
        <el-input size="large" id="username" v-model="loginModel.username" placeholder="请输入账户"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input type="password" id="password" size="large" v-model="loginModel.password" placeholder="请输入密码"></el-input>
      </el-form-item>
      <el-form-item prop="code">
        <el-row :gutter="20">
          <el-col :span="16" :offset="0">
            <el-input size="large" id="code" v-model="loginModel.code" placeholder="请输入验证码"></el-input>
          </el-col>
          <el-col :span="8" :offset="0">
            <img :src="codeImg" @click="getImage" alt=""/>
          </el-col>
        </el-row>
      </el-form-item>
      <el-form-item label="用户类型" prop="userType">
        <el-radio-group v-model="loginModel.userType" id="userType">
          <el-radio :label="1">会员</el-radio>
          <el-radio :label="2">员工</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item>
        <el-row style="width: 100%">
          <el-col :span="12" :offset="0" style="padding-right: 10px; padding-left: 0px">
            <el-button size="large" style="width: 100%" type="primary" @click="onSubmit">登录</el-button>
          </el-col>
          <el-col :span="12" :offset="0" style="padding-right: 0px; padding-left: 10px">
            <el-button @click="reset" size="large" style="width: 100%" type="danger" plain>重置</el-button>
          </el-col>
        </el-row>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { Message } from 'element-ui';

export default {
  data() {
    return {
      loginModel: {
        username: 'admin',
        password: '123456',
        code: '',
        userType: ''
      },
      //验证码图片            
      codeImg: '',

      //登录表单验证规则
      rules: {
        username: [
          {
            required: true,
            trigger: "blur",
            message: "请填写账户",
          },
        ],
        password: [
          {
            required: true,
            trigger: "blur",
            message: "请填写密码",
          },
        ],
        code: [
          {
            required: true,
            trigger: "blur",
            message: "请填写验证码",
          },
        ],
        userType: [
          {
            required: true,
            trigger: "blur",
            message: "请选择用户类型",
          },
        ],
      }
    }
  },
  mounted() {
    this.getImage()
  },
  methods: {
    //获取验证码图片
    async getImage() {
      this.loginModel.code = ''
      let res = await this.http.get('/code')
      if (res) {
        this.codeImg = `http://localhost:5000/code?t=${new Date().getTime()}`;
      }
    },
    //重置按钮
    reset() {
      this.$refs.loginRef.resetFields()
      this.loginModel.username = ''
      this.loginModel.password = ''
    },
    //登录按钮
    onSubmit() {
      this.$refs.loginRef.validate((valid) => {
        if (valid) {
          this.http.post('/login', this.loginModel).then(result => {
            //保存用户信息到本地存储
            localStorage.setItem('username', this.loginModel.username)
            localStorage.setItem('userType', this.loginModel.userType)
            //跳转到首页
            this.$router.push({ path: "/" });
          }).catch(err => {
            this.reset();
            Message({
              type: 'error',
              showClose: true,
              message: '登录失败，请稍后重试'
            });
          });
        }
      });
    },
  },
};
</script>

<style scoped lang="scss">
.logincontainer {
  background-color: #fff;
  height: 100%;
  background-image: url("../../assets/bg.jpg");
  background-size: 100% 100%;
  display: flex;
  justify-content: center;
  align-items: center;

  .loginform {
    border-radius: 10px;
    background-color: #fff;
    height: 400px;
    width: 500px;
    padding: 20px 35px;

    .logintitle {
      width: 100%;
      font-size: 24px;
      font-weight: 600;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .image {
      height: 40px;
      width: 100%;
      display: flex;
      justify-content: center;
      align-items: center;
      cursor: pointer;
    }
  }
}
</style>