package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.User;

public class UserDao {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public int register(User user) {
		try {
			con=UtilDao.getConnection();//打开链接
			ps=con.prepareStatement("insert into user (username,password,phone) values(?,?,?)");
			ps.setString(1,user.getUsername());
			ps.setString(2,user.getPassword());
			ps.setString(3,user.getPhone());
			return ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		
	}
	
	public User login(String  username,String paasword) {
		try {
			con=UtilDao.getConnection();//打开链接
			ps=con.prepareStatement("select * from user where username=? and password=?");
			ps.setString(1,username);
			ps.setString(2,paasword);
			rs=ps.executeQuery();
			if(rs.next()) {
				User user=new User();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAge(rs.getInt("age"));
				user.setPhone(rs.getString("phone"));
				user.setMyname(rs.getString("myname"));
				return user;
			}else {
				return null;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	

}
