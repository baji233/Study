package com.jiuyun.dao;

import com.jiuyun.bean.Type;
import com.jiuyun.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cj
 * @create 2022年10月15日 19:37:01
 */
public class TypeDAO {
    /**
     * 保存商品类型的方法
     * @param type
     * @return
     */
    public boolean save(Type type) {
        boolean flag = false;
        String sql = "insert into t_type (type_name) values(?)";
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, type.getTypeName());
            flag = st.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 删除商品类型的方法
     * @param typeId
     * @return
     */
    public boolean delete(Integer typeId) {
        boolean flag = false;
        String sql = "delete from t_type where type_id=?";
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, typeId);
            flag = st.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 修改商品类型的方法
     * @param type
     * @return
     */
    public boolean update(Type type) {
        boolean flag = false;
        String sql = "update t_type set type_name=? where type_id=?";
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, type.getTypeName());
            st.setInt(2, type.getTypeId());
            flag = st.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 获取所有商品类型信息的方法
     * @return  商品类型信息集合
     */
    public List<Type> selectAll() {
        List<Type> typeList = new ArrayList<>();
        String sql = "select * from t_type";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                Type type = new Type();
                type.setTypeId(rs.getInt(1));
                type.setTypeName(rs.getString(2));
                typeList.add(type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, st, rs);
        }
        return typeList;
    }

    /**
     * 根据ID获取商品类型信息的方法
     * @param typeId
     * @return
     */
    public Type selectById(Integer typeId) {
        Type type = null;
        String sql = "select * from t_type where type_id=" + typeId;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                type = new Type();
                type.setTypeId(rs.getInt(1));
                type.setTypeName(rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, st, rs);
        }
        return type;
    }
}
