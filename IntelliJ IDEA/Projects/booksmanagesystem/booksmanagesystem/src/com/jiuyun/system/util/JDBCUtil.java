package com.jiuyun.system.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 数据库工具类
 */
public class JDBCUtil {
    public static final String URL="jdbc:mysql://localhost:3306/jjj";//数据库路径
    public static final String DRIVER_CLASS="com.mysql.cj.jdbc.Driver";

    /**
     * 获取连接对象
     * @return:连接对象
     */
    public static Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName(DRIVER_CLASS);
            connection=DriverManager.getConnection(URL,"root","88888888");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 释放资源
     * @param connection
     * @param preparedStatement
     * @param resultSet
     */
    public static void free(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        try{
            if(resultSet!=null){
                resultSet.close();
            }if(preparedStatement!=null){
                preparedStatement.close();
            }if(connection!=null){
                connection.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
















