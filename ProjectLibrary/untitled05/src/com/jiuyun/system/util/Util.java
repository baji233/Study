package com.jiuyun.system.util;

import java.sql.*;

/**
 * ������
 */
public class Util {
    public static final String URL = "jdbc:mysql://localhost:3306/emp_database";
    public static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    //����
    public static Connection getConnection() {
        Connection connection;
        try {
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(URL, "root", "88888888");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    //�ͷ�
    public static void free(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){//PreparedStatement��ִ��Ԥ�����SQL���,��ȫ
        try{
            if(resultSet!=null){
                resultSet.close();
            }
            if(preparedStatement!=null){
                preparedStatement.close();
            }
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}



