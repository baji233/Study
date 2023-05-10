package com.jiuyun.dao;

import com.jiuyun.bean.ShoppingCarItem;
import com.jiuyun.util.CommonUtil;

import java.util.List;

public class ShoppingCarItemDao {
    /**
     * 向购物车添加商品
     */
    public boolean shoppingCarItemAdd(ShoppingCarItem shoppingCarItem) {
        String sql = "insert into t_shoppingcaritem (user_id,product_id,count) values(?,?,?)";
        return CommonUtil.modify(sql,shoppingCarItem.getUserId(),shoppingCarItem.getProductId(),shoppingCarItem.getCount());

    }

    /**
     * 删除购物项
     */
    public boolean shoppingCarItemDelete(Integer userId, Integer productId) {
        String sql="delete from t_shoppingcaritem where user_id=? and product_id=?";
        return CommonUtil.modify(sql,userId,productId);
    }


    /**
     * 根据用户id清空购物车
     */
    public boolean clearShoppingCar(Integer userId) {
        String sql = "delete from t_shoppingcaritem where user_id=?";
        return CommonUtil.modify(sql,userId);
    }

     /**
     * 修改购物车项
     */
    public boolean shoppingCarItemUpdate(ShoppingCarItem shoppingCarItem) {
        String sql = "update t_shoppingcaritem set count=? where user_id=? and product_id=?";
        return  CommonUtil.modify(sql,shoppingCarItem.getCount(),shoppingCarItem.getUserId(),shoppingCarItem.getProductId());
    }

    /**
     * 获取当前用户所有购物车项信息
     */
    public List<ShoppingCarItem> selectAllByUserId(Integer userId) {
        String sql = "select * from t_shoppingcaritem where user_id=?";
        return CommonUtil.query(sql,ShoppingCarItem.class,userId);
    }
}
