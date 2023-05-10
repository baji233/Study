package com.jiuyun.dao;

import com.jiuyun.bean.Product;
import com.jiuyun.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
     * 保存商品的方法
     * @param product
     * @return
     */
    public boolean save(Product product) {
        boolean flag = false;
        String sql = "insert into t_product (product_name,type_id,description,price,picture,remark) values(?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, product.getProductName());
            st.setInt(2, product.getTypeId());
            st.setString(3, product.getDescription());
            st.setDouble(4, product.getPrice());
            st.setString(5, product.getPicture());
            st.setString(6, product.getRemark());
            flag = st.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 删除商品的方法
     * @param productId
     * @return
     */
    public boolean delete(Integer productId) {
        boolean flag = false;
        String sql = "update t_product set state=0 where product_id=?";
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, productId);
            flag = st.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 修改商品的方法
     * @param product
     * @return
     */
    public boolean update(Product product) {
        boolean flag = false;
        String sql = "update t_product set product_name=?,type_id=?,description=?,price=?,picture=?,remark=? where product_id=?";
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, product.getProductName());
            st.setInt(2, product.getTypeId());
            st.setString(3, product.getDescription());
            st.setDouble(4, product.getPrice());
            st.setString(5, product.getPicture());
            st.setString(6, product.getRemark());
            st.setInt(7, product.getProductId());
            flag = st.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 根据ID获取商品信息的方法
     * @param productId
     * @return
     */
    public Product selectById(Integer productId) {
        Product product = null;
        String sql = "select * from t_product where product_id=" + productId;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setTypeId(rs.getInt(3));
                product.setDescription(rs.getString(4));
                product.setPrice(rs.getDouble(5));
                product.setPicture(rs.getString(6));
                product.setState(rs.getInt(7));
                product.setRemark(rs.getString(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, st, rs);
        }
        return product;
    }

    /**
     * 获取所有商品信息的方法
     * @return  商品信息集合
     */
    public List<Product> selectAll() {}
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
                product.setProductId(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setTypeId(rs.getInt(3));
                product.setDescription(rs.getString(4));
                product.setPrice(rs.getDouble(5));
                product.setPicture(rs.getString(6));
                product.setState(rs.getInt(7));
                product.setRemark(rs.getString(8));
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, st, rs);
        }
        return productList;
    }

    /**
     * 根据商品名称以及描述搜索
     * @param name
     * @return
     */
    public List<Product> searchByName(String name) {
        List<Product> productList = new ArrayList<>();
        String sql = "select * from t_product where product_name like '%" + name + "%' or description like '%" +  name + "%'";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setTypeId(rs.getInt(3));
                product.setDescription(rs.getString(4));
                product.setPrice(rs.getDouble(5));
                product.setPicture(rs.getString(6));
                product.setState(rs.getInt(7));
                product.setRemark(rs.getString(8));
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, st, rs);
        }
        return productList;
    }

    /**
     * 多条件获取商品信息
     * @param params    参数
     * @return          商品集合
     */
    public List<Product> searchByParams(Product params) {
        List<Product> productList = new ArrayList<>();
        String sql = getSql("select * from t_product where 1=1 ", params);
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setTypeId(rs.getInt(3));
                product.setDescription(rs.getString(4));
                product.setPrice(rs.getDouble(5));
                product.setPicture(rs.getString(6));
                product.setState(rs.getInt(7));
                product.setRemark(rs.getString(8));
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, st, rs);
        }
        return productList;
    }

    /**
     * 获取多条件查询的SQL语句
     * @param sql
     * @param product
     * @return
     */
    private String getSql(String sql, Product product) {
        if(product.getProductName() != null) {
            sql += " and product_name like '%" + product.getProductName() + "%'";
        }
        if(product.getDescription() != null) {
            sql += " and product_name like '%" + product.getDescription() + "%'";
        }
        if(product.getPrice() != null) {
            sql += " and price >" + product.getPrice();
        }
        if (product.getTypeId() != null) {
            sql += " and type_id=" + product.getTypeId();
        }
        return sql;
    }
}
