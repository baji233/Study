package com.jiuyun.dao;

import com.jiuyun.bean.Type;
import com.jiuyun.util.CommonUtil;

import java.util.List;

public class TypeDao {

    /**
     * 新增商品类型
     */
    public boolean typeAdd(String typeName) {
        String sql = "insert into t_type (type_name) values(?)";
        return CommonUtil.modify(sql,typeName);
    }

    /**
     * 删除商品类型
     */
    public boolean typeDelete(Integer typeId) {
        String sql="delete from t_type where type_id=?";
        return CommonUtil.modify(sql,typeId);
    }

    /**
     * 修改商品类型
     */
    public boolean typeUpdate(Type type) {
        String sql="update t_type set type_name=? where type_id=?";
        return CommonUtil.modify(sql,type.getTypeName(),type.getTypeId());
    }

    /**
     * 获取所有商品类型信息
     */
    public List<Type> selectAll() {
        String sql="select * from t_type";
        return CommonUtil.query(sql,Type.class,null);
    }

    /**
     * 根据ID获取商品类型信息
     */
    public List<Type> selectById(Integer typeId){
        String sql="select * from t_type where type_id=?";
        return CommonUtil.query(sql,Type.class,typeId);
    }
}
