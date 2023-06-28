import axios from "axios";
import type {InternalAxiosRequestConfig, AxiosResponse} from 'axios';
import { ElNotification } from "element-plus";
import { getToken } from "./auth";

const service = axios.create({
  baseURL: import.meta.env.BASE_URL,
  timeout: 5000
});

// 请求拦截器
service.interceptors.request.use((config: InternalAxiosRequestConfig) => {
  const headerToken = getToken();
  if (headerToken) {
    config.headers.TOKEN = headerToken;
  }
  return config;
}, (err: any) => Promise.reject(err));

// 响应拦截器
service.interceptors.response.use((response: AxiosResponse) => {
  const res = response.data;
  if (res.code !== 200 && res.code !== 20000) {
    console.log(res);
    ElNotification({
      showClose: true,
      message: res.message,
      type: "error",
      duration: 2000
    });
    return Promise.reject(res);
  }
  return res;
}, ({response}: any) => {
   // 这里用来处理http常见错误，进行全局提示
   let message = response.message || `连接出错!`;
   // 这里错误消息可以使用全局弹框展示出来
   // 比如element plus 可以使用 ElMessage
   ElNotification({
     showClose: true,
     message: `${message}，请检查网络或联系管理员！`,
     type: "error",
   });
   // 这里是AxiosError类型，所以一般我们只reject我们需要的响应即可
   return Promise.reject(response)
});

export default service;