package com.jiuyun.system.util;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class CommonDao {

	/**
	 * 通用的增删改功能
	 * sql--要执行的增删改的sql语句
	 * 
	 * paramValues--sql中要注入的参数值
	 */
	public static boolean operModify(String sql,Object...paramValues)
	{
		boolean isSuccess=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			int index=1;
			if(paramValues!=null)
			{
				//循环设置参数值
				for(Object tmp:paramValues)
				{
					pstmt.setObject(index++, tmp);
				}
			}
			int row=pstmt.executeUpdate();
			if(row>0)
			{
				isSuccess=true;
				System.out.println("更新成功");
			}else{
				System.out.println("执行失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.releaseDBResource(conn, pstmt, null);
		}
		
		return isSuccess;
	}
	
	/**
	 * 参数: 查询的sql语句,记录封装的vo对象,返回List
	 * 
	 * 将查询结果集的记录封装到vo对象的属性中
	 * 规则:字段名与vo的属性名(字段名的小写与属性名相同)
	 */
	public static List queryInfo(String querySQL,Class voClass,Object ...paramValues)
	{
		List items=new ArrayList();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String className=voClass.getName();
			int dotIdx=className.lastIndexOf('.');
			String name=className.substring(dotIdx+1);
			Properties props=loadProps(name+".properties");
			conn=DBUtil.getConnection();
			pstmt=conn.prepareStatement(querySQL);
			if(paramValues!=null)
			{
				int paramIndex=1;
				for(Object p:paramValues)
				{
					pstmt.setObject(paramIndex++, p);
				}
			}
			rs=pstmt.executeQuery();
			//获得查询结果集的元数据(包含了字段相关的信息)
			ResultSetMetaData rsmd=rs.getMetaData();
			//获得结果集的列数
			int cols=rsmd.getColumnCount();
			//获取字段的名字
			//String cname=rsmd.getColumnName(1);
			while(rs.next())
			{
				//创建vo对象
				Object vo=voClass.newInstance();
				for(int i=1;i<=cols;i++)
				{
					//获得字段名
					String cname=rsmd.getColumnName(i);
					//转换成小写
					String lowerCname=cname.toLowerCase();
					System.out.println(lowerCname+"---");
					//根据字段名获取vo对象的属性名
					String fieldName=(String)props.get(lowerCname);
					//获取字段的值
					Object columnValue=rs.getString(cname);
					//调用vo对象的setXxx方法为属性赋值
					System.out.println(fieldName);
					Field field=voClass.getDeclaredField(fieldName);
					field.setAccessible(true);
					field.set(vo, columnValue);
				}
				items.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.releaseDBResource(conn, pstmt, rs);
		}
		return items;
	}
	/*
	public static Properties props=null;
	static{
		props=loadProps();
	}*/
	//读取userinfo.properties
	public static Properties loadProps(String fname)
	{
		Properties props=null;
		try {
			FileInputStream fis=new FileInputStream(fname);
			
			props=new Properties();
			props.load(fis);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return props;
	}
	
	
	public static void main(String[] args) {
		//loadProps();
	}
	
}
