import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
import axios from 'axios'
//导入全局样式
import './assets/css/global.css'
//导入字体图标
import './assets/fonts/iconfont.css'

// 将axios挂载到vue原型上
Vue.prototype.http = axios

//基准根路径
axios.defaults.baseURL = 'http://127.0.0.1:8888/api/private/v1/'

//响应拦截器,简化返回值
axios.interceptors.response.use(( ret ) => {
  return ret.data
},( err ) => {
  console.log(err);
})

//请求拦截器, 在请求头中添加Authorization内放入token
axios.interceptors.request.use( (config) => {
  // console.log('请求拦截器');
  const tk = sessionStorage.getItem('token')
  // console.log('获取token');
  config.headers.Authorization = tk
  // console.log('添加Authorization');
  return config
})

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
