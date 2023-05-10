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
	 * ͨ�õ���ɾ�Ĺ���
	 * sql--Ҫִ�е���ɾ�ĵ�sql���
	 * 
	 * paramValues--sql��Ҫע��Ĳ���ֵ
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
				//ѭ�����ò���ֵ
				for(Object tmp:paramValues)
				{
					pstmt.setObject(index++, tmp);
				}
			}
			int row=pstmt.executeUpdate();
			if(row>0)
			{
				isSuccess=true;
				System.out.println("���³ɹ�");
			}else{
				System.out.println("ִ��ʧ��");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.releaseDBResource(conn, pstmt, null);
		}
		
		return isSuccess;
	}
	
	/**
	 * ����: ��ѯ��sql���,��¼��װ��vo����,����List
	 * 
	 * ����ѯ������ļ�¼��װ��vo�����������
	 * ����:�ֶ�����vo��������(�ֶ�����Сд����������ͬ)
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
			//��ò�ѯ�������Ԫ����(�������ֶ���ص���Ϣ)
			ResultSetMetaData rsmd=rs.getMetaData();
			//��ý����������
			int cols=rsmd.getColumnCount();
			//��ȡ�ֶε�����
			//String cname=rsmd.getColumnName(1);
			while(rs.next())
			{
				//����vo����
				Object vo=voClass.newInstance();
				for(int i=1;i<=cols;i++)
				{
					//����ֶ���
					String cname=rsmd.getColumnName(i);
					//ת����Сд
					String lowerCname=cname.toLowerCase();
					System.out.println(lowerCname+"---");
					//�����ֶ�����ȡvo�����������
					String fieldName=(String)props.get(lowerCname);
					//��ȡ�ֶε�ֵ
					Object columnValue=rs.getString(cname);
					//����vo�����setXxx����Ϊ���Ը�ֵ
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
	//��ȡuserinfo.properties
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
