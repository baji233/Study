package com.jiuyun.dao;

import com.jiuyun.bean.Product;
import com.jiuyun.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cj
 * @create 2022年10月14日 18:43:58
 */
public class ProductDAO {
    /**
     * 获取所有商品信息的方法
     * @return  商品信息集合
     */
    public List<Product> selectAll() {
        List<Product> productList = new ArrayList<>();
        String sql = "select * from t_product";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setType(rs.getString(3));
                product.setPrice(rs.getDouble(4));
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, st, rs);
        }
        return productList;
    }

    public Product selectById(Integer id) {
        Product product = null;
        String sql = "select * from t_product where id=" + id;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setType(rs.getString(3));
                product.setPrice(rs.getDouble(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, st, rs);
        }
        return product;
    }

}
