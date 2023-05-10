package com.jiuyun.util;

import java.sql.*;

/**
 * @author cj
 * @create 2022年10月14日 18:37:49
 */
public class DBUtil {
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/shopping?useUnicode=true;characterEncoding=utf8;allowMultiQueries=true;useSSL=false;serverTimezone = GMT;zeroDateTimeBehavior=convertToNull";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    //静态块加载驱动
    static {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接的方法
     * @return  数据库连接
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
     * 关闭资源的方法
     * @param conn  连接对象
     * @param st    语句对象
     * @param rs    结果集对象
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
