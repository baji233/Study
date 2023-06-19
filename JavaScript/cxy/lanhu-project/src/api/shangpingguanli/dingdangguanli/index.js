import request from '../../xitongguanli/request';
export const selectList=(data)=>request({url:'/shangpingguanli/selectList',method:'post',data})
export const selectCount=(data)=>request({url:'/shangpingguanli/selectCount',method:'post',data})
export const deleteById=(id)=>request({url:`/shangpingguanli/delete/${id}`,method:'get'})
export const selectOneById=(id)=>request({url:`/shangpingguanli/selectOneById/${id}`,method:'get'})
export const updateById=(data)=>request({url:'/shangpingguanli/updateById',method:'post',data})
export const add=(data)=>request({url:'/shangpingguanli/add',method:'post',data})