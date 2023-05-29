import request from '../../xitongguanli/request';
export const getInit=(data)=>request({url:`/my-system/userSelectList`,method:'post',data})
export const deleteUser=(userid)=>request({url:`/my-system/deleteUser/${userid}`,method:'get'})
export const getSelectOneById=(userid)=>request({url:`/my-system/selectOneById/${userid}`,method:'get'})
export const updateUserById=(data)=>request({url:`/my-system/updateUserById`,method:'post',data})
export const selectCount=(data)=>request({url:'/my-system/selectCount',method:'post',data})
export const insertUser=(data)=>request({url:'/my-system/insertUser',method:'post',data})
export const updatePasswordById=(password,id)=>request({url:`/my-system/updatePasswordById/${password}/${id}`,method:"get"})