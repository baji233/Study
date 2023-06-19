import Vue from 'vue'

import 'normalize.css/normalize.css' // A modern alternative to CSS resets
import API from '@/api/xitongguanli';

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
// import locale from 'element-ui/lib/locale/lang/en' // lang i18n

import '@/styles/index.scss' // global css

import App from './App'
import store from './store'
import router from './router'
import Paging from './components/Paging';

import '@/icons' // icon
import '@/permission' // permission control
import moment from 'moment';

import axios from 'axios';

Vue.prototype.http = axios

// 支持跨域携带 cookie
axios.defaults.withCredentials = true
axios.defaults.baseURL = 'http://127.0.0.1:5000';

axios.defaults.timeout = 5000; //请求超时时间

/**
 * 如果您不想使用mock服务器
 * 您想将MockJs用于mock-api
 * yo您可以执行: mockXHR()
 *
 * 目前MockJ将用于生产环境,
 * 请在联机前将其删除！
 */
if (process.env.NODE_ENV === 'production') {
  const { mockXHR } = require('../mock')
  mockXHR()
}

// set ElementUI lang to EN
// Vue.use(ElementUI, { locale })
// 如果想要中文版 element-ui，按如下方式声明
Vue.use(ElementUI);
Vue.component(Paging.name, Paging);

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App),
  beforeCreate() {
    // 开启全局事件总线
    Vue.prototype.$bus = this;
    // 将请求作为全局对象引入
    Vue.prototype.$axios = axios;
    // 日期格式化
    Vue.prototype.$moment = moment;
    Vue.prototype.$API = API;
  }
})
