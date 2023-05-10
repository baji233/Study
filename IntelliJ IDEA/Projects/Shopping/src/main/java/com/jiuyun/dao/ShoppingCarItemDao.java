package com.jiuyun.dao;

import com.jiuyun.bean.ShoppingCarItem;
import com.jiuyun.util.CommonDaoUtil;

import java.util.List;

public class ShoppingCarItemDao {
    /**
     * 添加新的购物车项
     */
    public boolean save(ShoppingCarItem shoppingCarItem){
        String sql="insert into t_shoppingcaritem (user_id,product_id,count) values (?,?,?)";
        Integer userId=shoppingCarItem.getUser_id();
        Integer productId= shoppingCarItem.getProduct_id();
        Integer count=shoppingCarItem.getCount();
        return CommonDaoUtil.modify(sql,userId,productId,count);
    }

    /**
     * 根据用户id和购物车id删除购物项
     */
    public boolean deleteCarItem(ShoppingCarItem shoppingCarItem){
        String sql="delete t_shoppingcaritem where user_id=? and product_id=?";
        return CommonDaoUtil.modify(sql,shoppingCarItem.getUser_id(),shoppingCarItem.getProduct_id());
    }

    /**
     * 根据用户id清空购物车
     */
    public boolean deleteCar(Integer userId){
        String sql="delete from t_shoppingcaritem where user_id=?";
        return CommonDaoUtil.modify(sql,userId);
    }

    /**
     * 根据用户id和商品id修改购物车商品数量
     */
    public boolean update(ShoppingCarItem shoppingCarItem){
        String sql="update t_shoppingcaritem set count=? where user_id=? and product_id=?";
        return CommonDaoUtil.modify(sql,shoppingCarItem.getCount(),shoppingCarItem.getUser_id(),shoppingCarItem.getProduct_id());
    }

    /**
     * 根据当前用户id获取所有购物车项
     */
    public List<ShoppingCarItem> selectAllById(Integer userId){
        String sql="select * from t_shoppingcaritem where user_id=?";
        return CommonDaoUtil.query(sql, ShoppingCarItem.class,userId);
    }
}
