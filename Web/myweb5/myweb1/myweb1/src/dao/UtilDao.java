package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilDao {
	static{
		//通过静态块加载驱动
		//最先加载，只会加载一次
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gd1","root","88888888");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static void close(Connection con,PreparedStatement ps,ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(con!=null) {
				con.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
