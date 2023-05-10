package com.jiuyun.system.model;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.jiuyun.system.util.DBUtil;


public class CommonDao {

    public static boolean operModify(String sql,Object...paramValues) {
        boolean isSuccess=false;
        Connection conn=null;
        PreparedStatement pstmt=null;
        try {
            conn=DBUtil.getConnection();
            pstmt=conn.prepareStatement(sql);
            int index=1;

            if (paramValues!=null) {
                for (Object tmpObject : paramValues) {
                    pstmt.setObject(index++, tmpObject);
                }
                System.out.println(pstmt);
               
            }
            int row=pstmt.executeUpdate();

            if (row>0) {
                System.out.println("成功");
                isSuccess=true;
            }else {
                System.out.println("失败");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            DBUtil.releaseDBResource(conn, pstmt, null);
        }
        return isSuccess;
    }


    public static List queryInfo(String querySQL,Class voClass,String fielName, Object...paramValues) {
        List items=new ArrayList();
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        props=loadProps(fielName);
        try {
            conn=DBUtil.getConnection();
            pstmt=conn.prepareStatement(querySQL);

            if(paramValues!=null) {
                int paramIndex=1;

                for (Object p : paramValues) {

                    pstmt.setObject(paramIndex++, p);
                }
                System.out.println(pstmt);
            }
            //System.out.println(pstmt);
            rs=pstmt.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            //System.out.println(rsmd);
            int cols = rsmd.getColumnCount();
            //System.out.println(cols);
            //String cName = rsmd.getColumnName(1);
            while (rs.next()) {
                Object vo=voClass.newInstance();
                for (int i = 1; i <=cols; i++) {
                    String cName=rsmd.getColumnName(i);
                    String lowerCname=cName.toLowerCase();
                    //System.out.println(lowerCname);
                    //System.out.println(props.getProperty(lowerCname));
                    String fieldName=props.getProperty(lowerCname);
                    Object columnValue=rs.getString(cName);
                    Field field=voClass.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    field.set(vo, columnValue);
                }
                //System.out.println(	);
                items.add(vo);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.releaseDBResource(conn, pstmt, rs);
        }
        return items;
    }

    public static Properties props=null;
    
    

    //��ȡuserinfo.properties
    public static Properties loadProps(String fielName) {
        Properties props=null;
        try {
            FileInputStream fis=new FileInputStream(fielName);
            props=new Properties();
            props.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return props;
    }

    public static void main(String[] args) {

    }

}
