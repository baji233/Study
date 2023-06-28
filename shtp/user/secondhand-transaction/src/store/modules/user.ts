import { login, getUserInfo } from '@/api/user'
import { getToken, setToken, removeToken } from '@/utils/auth'
import { resetRouter } from '@/router'
import { defineStore } from 'pinia'
import type { loginForm, userInfo } from '@/api/user/type'

const getDefaultState = () => {
  return {
    token: getToken(),
    user: {} as userInfo
  }
}

const useAdminUserStore = defineStore('adminUserStore', {
  state(){
    return getDefaultState();
  },
  actions: {
    // 登录
    async login(userInfo: loginForm) {
      const { username, password } = userInfo
      try {
        const {data} = await login({ username: username.trim(), password: password });
        this.token = data;
        setToken(data);
      } catch (error) {}
    },
    // 获取用户信息
    async getUserInfo() {
      try {
        const { code, message, data } = await getUserInfo(this.token);
        if (code !== 200 && code !== 20000) {
          return Promise.reject(message);
        }
        this.user = data;
      } catch (error) {}
    },
    // 退出登录
    logout() {
      resetRouter();
      this.resetToken();
    },
    // 重置 token
    resetToken() {
      removeToken();
      Object.assign(this.$state, getDefaultState());
    }
  }
});

export default useAdminUserStore;
