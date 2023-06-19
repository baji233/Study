import request from '../request';
export const slectList=(data)=>request({url:"/my-role/slectList",method:'post',data})
export const selectCount=(data)=>request({url:"/my-role/selectCount",method:"post",data})
export const deleteJueSe=(roleId)=>request({url:`/my-role/deleteJueSe/${roleId}`,method:'get'})
export const insertJueSe=(data)=>request({url:'/my-role/insertJueSe',method:'post',data});
export const selectOneById=(roleId)=>request({url:`/my-role/selectOneById/${roleId}`,method:'get'})
export const updateJueSe=(data)=>request({url:`/my-role/updateJueSe`,method:'post',data})