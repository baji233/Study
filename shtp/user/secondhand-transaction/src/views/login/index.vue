<template>
  <div class="login-container">
    <el-form ref="loginFormRef" :model="loginForm" :rules="loginRules" class="login-form" auto-complete="on"
      label-position="left" @keyup.enter="handleLogin">

      <div class="title-container">
        <h3 class="title">Login Form</h3>
      </div>

      <el-form-item prop="username">
        <span class="svg-container">
          <svg-icon icon-class="user" />
        </span>
        <el-input ref="username" v-model="loginForm.username" placeholder="Username" name="username" type="text"
          tabindex="1" auto-complete="on" />
      </el-form-item>

      <el-form-item prop="password">
        <span class="svg-container">
          <svg-icon icon-class="password" />
        </span>
        <el-input :key="passwordType" v-model="loginForm.password" :type="passwordType"
          placeholder="Password" name="password" tabindex="2" auto-complete="on" show-password />
      </el-form-item>

      <el-button :loading="loading" type="primary"
        @click.prevent="handleLogin">Login</el-button>

      <div class="tips">
        <span>username: admin</span>
        <span> password: any</span>
      </div>

    </el-form>
  </div>
</template>

<script lang="ts" setup>
import { watch, reactive, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import type {RouteLocationNormalizedLoaded} from 'vue-router';
import { adminUserStore } from '@/store';

const $route = useRoute();
const $router = useRouter();
const loading = ref(false);
const passwordType = ref('password');
const redirect = ref<string | undefined>(undefined);
const loginFormRef = ref();
const loginForm = reactive({
  username: 'admin',
  password: '111111'
});
const loginRules = reactive({
  username: [{
    required: true, trigger: 'blur',
    validator(_rule: any, value: string, callback: Function) {
      if (!validUsername(value)) {
        callback(new Error('Please enter the correct user name'))
      } else {
        callback()
      }
    }
  }],
  password: [{
    required: true, trigger: 'blur', validator(_rule: any, value: string, callback: Function) {
      if (value.length < 6) {
        callback(new Error('The password can not be less than 6 digits'))
      } else {
        callback()
      }
    }
  }]
});

watch(
  () => $route,
  (route: RouteLocationNormalizedLoaded) => redirect.value = route.query && route.query.redirect as string,
  { immediate: true }
);

function validUsername(str: string) {
  const valid_map = ['admin', 'editor']
  return valid_map.indexOf(str.trim()) >= 0
}

// 登录回调
function handleLogin() {
  loginFormRef.value.validate(async (valid: boolean) => {
    if (valid) {
      loading.value = true;
      try {
        await adminUserStore.login(loginForm);
        $router.push(redirect.value || '/');
      } finally {
        loading.value = false;
      }
    } else {
      console.log('error submit!!')
      return false
    }
  })
}
</script>

<script lang="ts">
export default {
  name: 'Login'
}
</script>

<style lang="scss">
/* 修复input 背景不协调 和光标变色 */
/* Detail see https://github.com/PanJiaChen/vue-element-admin/pull/927 */

$bg: #283443;
$light_gray: #fff;
$cursor: #fff;

@supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
  .login-container .el-input input {
    color: $cursor;
  }
}

/* reset element-ui css */
.login-container {
  .el-input {
    display: inline-block;
    height: 47px;
    width: 93%;
    
    .el-input__wrapper {
      width: 100%;
      background-color: transparent;
      box-shadow: none;

      .el-icon {
        font-size: 16px;
      }
    }

    input {
      background: transparent;
      border: 0px;
      // -webkit-appearance: none;
      border-radius: 0px;
      padding: 12px 5px 12px 15px;
      color: $light_gray;
      height: 47px;
      caret-color: $cursor;

      &:-webkit-autofill {
        box-shadow: 0 0 0px 1000px $bg inset !important;
        -webkit-text-fill-color: $cursor !important;
      }
    }
  }

  .el-button--primary {
    width:100%;
    margin-bottom:30px;
  }

  .el-form-item {
    border: 1px solid rgba(255, 255, 255, 0.1);
    background: rgba(0, 0, 0, 0.1);
    border-radius: 5px;
    color: #454545;
  }
}
</style>

<style lang="scss" scoped>
$bg: #2d3a4b;
$dark_gray: #889aa4;
$light_gray: #eee;

.login-container {
  min-height: 100%;
  width: 100%;
  background-color: $bg;
  overflow: hidden;

  .login-form {
    position: relative;
    width: 520px;
    max-width: 100%;
    padding: 160px 35px 0;
    margin: 0 auto;
    overflow: hidden;
  }

  .tips {
    font-size: 14px;
    color: #fff;
    margin-bottom: 10px;

    span {
      &:first-of-type {
        margin-right: 16px;
      }
    }
  }

  .svg-container {
    padding: 6px 5px 6px 15px;
    color: $dark_gray;
    vertical-align: middle;
    width: 30px;
    display: inline-block;
  }

  .title-container {
    position: relative;

    .title {
      font-size: 26px;
      color: $light_gray;
      margin: 0px auto 40px auto;
      text-align: center;
      font-weight: bold;
    }
  }

  .show-pwd {
    position: absolute;
    right: 10px;
    top: 7px;
    font-size: 16px;
    color: $dark_gray;
    cursor: pointer;
    user-select: none;
  }
}
</style>
