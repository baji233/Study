package com.jiuyun.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class getConnection {
    public static Connection myConnection(){
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database01", "root", "88888888");
            if (connection != null) {
                System.out.println("连接成功");
            } else {
                System.out.println("连接失败");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void main(String[] args){
        myConnection();
    }
}
