package com.jiuyun.system.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {
    public static final String URL="jdbc:mysql://localhost:3306/jjj";

    public static Connection getConnection()
    {
        Connection conn=null;
        try {

            conn= DriverManager.getConnection(URL,"root","88888888");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void releaseDBResource(Connection con, Statement stmt, ResultSet rs)
    {
        try {
            if(rs!=null)
            {
                rs.close();
            }
            if(stmt!=null)
            {
                stmt.close();
            }
            if(con!=null)
            {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
