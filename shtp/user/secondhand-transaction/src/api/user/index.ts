import request from '@/utils/request'
import type { loginForm, loginResponseData } from './type'
import type { responseData } from '@/api/type'

// 枚举请求路径
enum ADMIN_User_URL {
  LOGIN = '/user/login',
  INFO = '/user/info',
}

export function login(data: loginForm) {
  return request<any, responseData>({
    url: ADMIN_User_URL.LOGIN,
    method: 'post',
    data
  })
}

export function getUserInfo(token: string) {
  return request<any, loginResponseData>({
    url: ADMIN_User_URL.INFO,
    method: 'get',
    params: { token }
  })
}

