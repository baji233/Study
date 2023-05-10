package com.jiuyun.system.util;


import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CommonDao {
    /**
     * 通用的增删改
     * @param sql --sql语句
     * @param params --插入语句的参数
     */
    public static boolean updateTable(String sql, Object... params){
        Connection conn=null;
        PreparedStatement stmt=null;
        boolean isSuccess=false;
        try{
            conn= DBUtil.getConnection();
            stmt=conn.prepareStatement(sql);
            //设置参数
            //索引从1开始
            if(params!=null){
                int index=1;
                for(Object tmp:params){
                    stmt.setObject(index++,tmp);
                }
            }
            int result = stmt.executeUpdate();
            if(result>0){
                System.out.println("执行成功");
                isSuccess=true;
            }else{
                System.out.println("执行失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.releaseDBResource(conn,stmt,null);
        }
        return isSuccess;
    }

    /**
     * 通用查询
     * @param sql--sql
     * @param voClass--Class对象 Value Object
     * @param params--参数
     */
    public static List queryTable(String sql, Class voClass,String fileName, Object...params){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet resultSet=null;
        List item=new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            //设置参数
            if (params != null) {
                int index = 1;
                for (Object tmp : params) {
                    stmt.setObject(index++, tmp);
                }
            }
            resultSet=stmt.executeQuery();
            //获得(字段信息)元数据
            ResultSetMetaData data = resultSet.getMetaData();
            int count = data.getColumnCount();
            while (resultSet.next()){
//                已被弃用，可以使用getConstructor方法，并生成对象
                Object vo=voClass.newInstance();
                for(int i=1;i<=count;i++){
                    //数据库的字段名
                    String columnName = data.getColumnName(i);
                    String lowerName = columnName.toLowerCase();
                    Properties pro = getPro(fileName);
                    String fieldName = (String) pro.get(lowerName);

                    //获得值
                    Object columnValue = resultSet.getString(columnName);

//                    暴力反射
//                    生成Field对象，通过field对象的set方法为vo设置值
                    Field field = voClass.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    field.set(vo, columnValue);
                }
                item.add(vo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.releaseDBResource(conn,stmt,resultSet);
        }
        return item;
    }


    /**
     * 加载资源库
     * 只需修改资源文件，无需修改源代码
     * @return
     */
    private static   Properties getPro(String fileName){
        Properties properties=null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            properties=new Properties();
            properties.load(fis);
        }catch (Exception e){
            e.printStackTrace();
        }
        return properties;
    }
}
