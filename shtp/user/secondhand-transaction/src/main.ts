import { createApp } from 'vue';
import App from './App.vue';
const app = createApp(App);
// 引入 element-plus 及其样式
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';
// 配置 element-plus 中文, 让 ts 忽略类型监测(下面一行就能做到)
import zhCn from 'element-plus/dist/locale/zh-cn.mjs';
// 引入模板的全局样式
import './styles/index.scss';
// 注册路由
import router from './router';
// 注册仓库
import store from './store';

// 判断的环境变量
// vite 会向外暴露一个 import.meta.env
// webpack 会向外暴露一个 process.env

// svg 插件需要的代码，修改了配置文件一定要重启项目，一定要！！！！！！！
import 'virtual:svg-icons-register';

// 加载全局组件
import { registerComponent } from './utils';
app.use(registerComponent);

// 在组件挂载之前加载插件
app.use(ElementPlus, {
  locale: zhCn
});
// 加载路由
app.use(router);
app.use(store);

app.mount('#app');