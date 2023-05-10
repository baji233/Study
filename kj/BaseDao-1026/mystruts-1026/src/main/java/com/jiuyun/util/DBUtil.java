package com.jiuyun.util;

import java.sql.*;

/**
 * @author cj
 * @create 2022年10月26日 18:40:01
 */
public class DBUtil {
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true;characterEncoding=utf8;allowMultiQueries=true;useSSL=false;serverTimezone = GMT;zeroDateTimeBehavior=convertToNull";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    static {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return conn;
    }

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
