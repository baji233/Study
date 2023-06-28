/// <reference types="vite/client" />

// 让 ts 理解 vue 文件
declare module '*.vue' {
  import { ComponentOptions } from 'vue'
  const componentOptions: ComponentOptions
  export default componentOptions
}

// 断言 element-plus 的中文库
declare module 'element-plus/dist/locale/zh-cn.mjs';
declare module 'element-plus';

declare module 'nprogress';
declare module 'path-browserify';
declare module 'js-cookie';