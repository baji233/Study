package com.jiuyun.dao;

import com.jiuyun.bean.Type;
import com.jiuyun.util.CommonDaoUtil;

import java.util.List;

public class TypeDao {
    /**
     * 添加商品类型
     */
    public boolean save(Type type){
        String sql="insert into t_type (type_name) values ?";
        return CommonDaoUtil.modify(sql,type.getType_name());
    }

    /**
     * 删除商品类型
     */
    public boolean delete(Integer typeId){
        String sql="delete from t_type where type_id=?";
        return CommonDaoUtil.modify(sql,typeId);
    }

    /**
     * 修改商品类型名称
     */
    public boolean update(Type type){
        String sql="update t_type set type_name=? where type_id=?";
        return CommonDaoUtil.modify(sql,type.getType_id());
    }

    /**
     * 获取所有商品类型
     */
    public List<Type> selectAll(){
        String sql="select * from t_type";
        List<Type> allTypeList=CommonDaoUtil.query(sql, Type.class,null);
        return allTypeList;
    }

    /**
     * 根据类型ID查询商品类型信息
     */
    public List<Type> selectById(Integer type_id){
        String sql="select * from t_type where type_id=?";
        List<Type> byIdList=CommonDaoUtil.query(sql, Type.class,type_id);
        return byIdList;
    }

}
