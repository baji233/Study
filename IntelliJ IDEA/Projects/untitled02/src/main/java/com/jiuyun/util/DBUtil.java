package com.jiuyun.util;

import java.sql.*;

public class DBUtil {
    private static final String DRIVER_NAME="com.mysql.cj.jdbc.DriVer";
    private static final String URL="jdbc:mysql://127.0.0.1:3306/javaweb?useUnicode=true;characterEncoding=utf8;allowMultiQueries=true;useSSL=false;serverTimezone = GMT;zeroDateTimeBehavior=convertToNull";
    private static final String USER_NAME="root";
    private static final String PASSWORD="88888888";

    static {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 连接数据库
     * @return 连接对象
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return connection;
    }

    /**
     * 释放资源
     * @param conn
     * @param st
     * @param rs
     */
    public static void closeAll(Connection conn, Statement st, ResultSet rs) {
        try {
            if(rs != null) {
                rs.close();
            }
            if(st != null) {
                st.close();
            }
            if(conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
















