package com.jiuyun.dao;

import com.jiuyun.bean.User;
import com.jiuyun.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cj
 * @create 2022年10月15日 18:36:36
 */
public class UserDAO {
    /**
     * 保存用户的方法
     * @param user
     * @return
     */
    public boolean save(User user) {
        boolean flag = false;
        String sql = "insert into t_user (user_name, password, remark) values(?,?,?)";
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, user.getUserName());
            st.setString(2, user.getPassword());
            st.setString(3, user.getRemark());
            flag = st.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 删除用户的方法
     * @param userId
     * @return
     */
    public boolean delete(Integer userId) {
        boolean flag = false;
        String sql = "delete from t_user where user_id=?";
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
     * 修改用户的方法
     * @param user
     * @return
     */
    public boolean update(User user) {
        boolean flag = false;
        String sql = "update t_user set user_name=?,password=?,remark=? where user_id=?";
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, user.getUserName());
            st.setString(2, user.getPassword());
            st.setString(3, user.getRemark());
            st.setInt(4, user.getUserId());
            flag = st.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 获取所有用户信息的方法
     * @return  用户信息集合
     */
    public List<User> selectAll() {
        List<User> userList = new ArrayList<>();
        String sql = "select * from t_user";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setRemark(rs.getString(4));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, st, rs);
        }
        return userList;
    }

    /**
     * 根据ID获取用户信息的方法
     * @param userId
     * @return
     */
    public User selectById(Integer userId) {
        User user = null;
        String sql = "select * from t_user where user_id=" + userId;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                user = new User();
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setRemark(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, st, rs);
        }
        return user;
    }

    /**
     * 登录的方法
     * @param userName
     * @param password
     * @return
     */
    public User login(String userName, String password) {
        User user = null;
        String sql = "select * from t_user where user_name='" + userName + "' and password='" + password + "'";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            while(rs.next()) {
                user = new User();
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setRemark(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, st, rs);
        }
        return user;
    }

    /**
     * 检查该用户名是否可用
     * @param userName
     * @return
     */
    public User checkUserName(String userName) {
        User user = null;
        String sql = "select * from t_user where user_name='" + userName + "'";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            while(rs.next()) {
                user = new User();
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setRemark(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, st, rs);
        }
        return user;
    }
}
