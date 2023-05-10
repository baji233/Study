package com.jiuyun.system.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 负责对数据库资源的管理
 * @author boboli
 *
 */
public class DBUtil {
	public static final String URL="jdbc:mysql://localhost:3306/world";
	public static final String DRIVER_CLASS="com.mysql.cj.jdbc.Driver";
	
	//获取数据库连接
	public static Connection getConnection()
	{
		Connection conn=null;
		try {
			Class.forName(DRIVER_CLASS);
			conn=DriverManager.getConnection(URL,"root","test");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void releaseDBResource(Connection con,Statement stmt,ResultSet rs)
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
