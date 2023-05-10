package com.jiuyun.dao;

import com.jiuyun.bean.ShoppingCarItem;
import com.jiuyun.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cj
 * @create 2022年10月15日 19:19:22
 */
public class ShoppingCarItemDAO {
    /**
     * 保存购物车的方法
     * @param shoppingCarItem
     * @return
     */
    public boolean save(ShoppingCarItem shoppingCarItem) {
        boolean flag = false;
        String sql = "insert into t_shoppingcar_item (user_id,product_id,count) values(?,?,?)";
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, shoppingCarItem.getUserId());
            st.setInt(2, shoppingCarItem.getProductId());
            st.setInt(3, shoppingCarItem.getCount());
            flag = st.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 删除购物项的方法
     * @param userId
     * @return
     */
    public boolean delete(Integer userId, Integer productId) {
        boolean flag = false;
        String sql = "delete from t_shoppingcar_item where user_id=? and product_id=?";
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, userId);
            st.setInt(2, productId);
            flag = st.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 根据用户清空购物车的方法
     * @param userId
     * @return
     */
    public boolean clearShoppingCar(Integer userId) {
        boolean flag = false;
        String sql = "delete from t_shoppingcar_item where user_id=?";
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, userId);
            flag = st.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 修改购物车的方法
     * @param shoppingCarItem
     * @return
     */
    public boolean update(ShoppingCarItem shoppingCarItem) {
        boolean flag = false;
        String sql = "update t_shoppingcar_item set count=? where user_id=? and product_id=?";
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, shoppingCarItem.getCount());
            st.setInt(2, shoppingCarItem.getUserId());
            st.setInt(3, shoppingCarItem.getProductId());
            flag = st.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 获取当前用户所有购物车项信息的方法
     * @return  购物车信息集合
     */
    public List<ShoppingCarItem> selectAllByUserId(Integer userId) {
        List<ShoppingCarItem> shoppingCarItemList = new ArrayList<>();
        String sql = "select * from t_shoppingcar_item where user_id=" + userId;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                ShoppingCarItem shoppingCarItem = new ShoppingCarItem();
                shoppingCarItem.setUserId(userId);
                shoppingCarItem.setProductId(rs.getInt(2));
                shoppingCarItem.setCount(rs.getInt(3));
                shoppingCarItemList.add(shoppingCarItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, st, rs);
        }
        return shoppingCarItemList;
    }


}
