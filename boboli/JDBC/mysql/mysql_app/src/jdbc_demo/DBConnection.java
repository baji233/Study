package jdbc_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * jdbc连接数据库
 * @author boboli
 *
 */
public class DBConnection {
	
	/**
	 * 实现增删改
	 * 1、获得数据库连接
	 * 2、执行sql语句Statement
	 * 3、关闭连接,释放资源
	 */
	public static void test02()
	{
		//连接对象
		Connection conn=null;
		//执行sql语句Statement
		Statement stmt=null;
		try {
			conn=test01();
			String sql="insert into userinfo values('tt01','test',20,'2010-8-8')";
			stmt=conn.createStatement();
			//执行sql(insert,delete,update)
			int row=stmt.executeUpdate(sql);
			if(row>0)
			{
				System.out.println("sql 执行成功");
			}else{
				System.out.println("失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			stmt.close();
			conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	//执行查询
	public static void test03()
	{
		Connection conn=null;
		Statement stmt=null;
		//查询结果集 
		ResultSet rs=null;
		try {
			conn=test01();
			String sql="select * from userinfo";
			stmt=conn.createStatement();
			//查询
			rs=stmt.executeQuery(sql);
			//指针下移，如果返回true,则表示当前指向的是有效的。
			while(rs.next())
			{
				//获取当前记录的字段的值
				String uid=rs.getString("userid");//通过字段名
				String uname=rs.getString(2);//字段的索引,索引从1开始
				int age=rs.getInt("age");
				String birth=rs.getString("birthday");
				System.out.println(uid+" "+uname+" "+age+" "+birth);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public static Connection test01()
	{
		Connection conn=null;
		try {
			//加载驱动程序
			Class.forName("com.mysql.cj.jdbc.Driver");
			//获得数据库连接(登录)
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "test");
			if(conn!=null)
			{
				System.out.println(conn);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return conn;
		}
		
	}
	public static void main(String[] args) {
		test03();
	}
}
