package jdbc_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * jdbc�������ݿ�
 * @author boboli
 *
 */
public class DBConnection {
	
	/**
	 * ʵ����ɾ��
	 * 1��������ݿ�����
	 * 2��ִ��sql���Statement
	 * 3���ر�����,�ͷ���Դ
	 */
	public static void test02()
	{
		//���Ӷ���
		Connection conn=null;
		//ִ��sql���Statement
		Statement stmt=null;
		try {
			conn=test01();
			String sql="insert into userinfo values('tt01','test',20,'2010-8-8')";
			stmt=conn.createStatement();
			//ִ��sql(insert,delete,update)
			int row=stmt.executeUpdate(sql);
			if(row>0)
			{
				System.out.println("sql ִ�гɹ�");
			}else{
				System.out.println("ʧ��");
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
	//ִ�в�ѯ
	public static void test03()
	{
		Connection conn=null;
		Statement stmt=null;
		//��ѯ����� 
		ResultSet rs=null;
		try {
			conn=test01();
			String sql="select * from userinfo";
			stmt=conn.createStatement();
			//��ѯ
			rs=stmt.executeQuery(sql);
			//ָ�����ƣ��������true,���ʾ��ǰָ�������Ч�ġ�
			while(rs.next())
			{
				//��ȡ��ǰ��¼���ֶε�ֵ
				String uid=rs.getString("userid");//ͨ���ֶ���
				String uname=rs.getString(2);//�ֶε�����,������1��ʼ
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
			//������������
			Class.forName("com.mysql.cj.jdbc.Driver");
			//������ݿ�����(��¼)
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
