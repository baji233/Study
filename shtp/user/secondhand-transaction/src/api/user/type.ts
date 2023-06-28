// 用户的请求对象数据
import type {responseData} from '@/api/type';

export interface loginForm {
  username: string,
  password: string
}

export interface loginResponseData extends responseData{
  data: userInfo
}

export interface userInfo {
  userId: number,
  avatar: 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
  username: string,
  password: string,
  desc: string,
  roles: Array<string>,
  buttons: Array<string>,
  routes: Array<string>,
  token: string,
}
