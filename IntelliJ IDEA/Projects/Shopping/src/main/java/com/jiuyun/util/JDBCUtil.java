package com.jiuyun.util;

import org.slf4j.Logger;

import java.sql.*;

public class JDBCUtil {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/shopping?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "88888888";

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(JDBCUtil.class);

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            printLog(e);
        }
    }

    /**
     * 获取连接对象
     * @return connection
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            printLog(e);
        }
        return connection;
    }

    /**
     * 释放查询操作的资源
     * @param connection
     * @param statement
     * @param resultSet
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(resultSet != null) {
                resultSet.close();
            }
            if(statement != null) {
                statement.close();
            }
            if(connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            printLog(e);
        }
    }

    /**
     * 打印日志
     * @param e
     */
    public static void printLog(Exception e) {
        log.error(e.getClass().getName() + ":" + e.getMessage());
        StackTraceElement[] stackTraceElements = e.getStackTrace();
        for (StackTraceElement ste : stackTraceElements) {
            log.error(ste.toString());
        }
    }
}























