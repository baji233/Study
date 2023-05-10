package com.jiuyun.system.util;

import javax.swing.*;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 常用工具类
 */
public class CommonDao2 {
    /**
     * 通用的增删改功能
     * @param sql sql修改语句
     * @param paramValues 参数值
     * @return 是否成功
     */
    public static boolean modify(String sql,Object...paramValues){
        boolean isSuccess=false;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=JDBCUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            int index=1;
            if(paramValues!=null){
                for(Object param:paramValues){
                    preparedStatement.setObject(index++,param);
                }
            }
            System.out.println(preparedStatement);
            int row=preparedStatement.executeUpdate();
            if(row>0){
                isSuccess=true;
                JOptionPane.showMessageDialog(null, "操作成功!", "普通提示框",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "操作失败！", "错误提示框",JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JDBCUtil.free(connection,preparedStatement,null);
        }
        return isSuccess;
    }

    /**
     * 通用的查询功能
     * @param sql sql查询语句
     * @param voClass CollectionRecordVO类反射对象
     * @param paramValues 参数值
     * @return 查询结果集
     */
    public static List query (String sql,Class voClass,Object...paramValues){
        List result=new ArrayList();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
            //1.先获取properties配置文件名,然后读取表中数据
            String className=voClass.getName();
            int lastIndex=className.lastIndexOf(".");
            String pNAME=className.substring(lastIndex+1);
            String pName=pNAME.toLowerCase();
            Properties properties=loadProperties(pName+".properties");
            //2.开始查询读者信息表
            connection=JDBCUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            if(paramValues!=null){
                int index=1;
                for(Object param:paramValues){
                    preparedStatement.setObject(index++,param);
                }
            }
            resultSet=preparedStatement.executeQuery();
            //3.获得查询结果集的元数据(列的数量、类型和属性)
            ResultSetMetaData metaData=resultSet.getMetaData();
            int cols=metaData.getColumnCount();
            while(resultSet.next()){
                Object vo=voClass.newInstance();
                for(int i=1;i<=cols;i++){
                    String cName=metaData.getColumnName(i);
                    String lowerCName=cName.toLowerCase();
                    String fieldName=(String)properties.get(lowerCName);
                    Object columnValue=resultSet.getString(cName);
                    Field field=voClass.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    field.set(vo,columnValue);
                }
                result.add(vo);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JDBCUtil.free(connection,preparedStatement,resultSet);
        }
        return result;
    }

    /**
     * 读取指定配置文件名xxx.properties的表中数据
     * @param pName 配置文件名
     * @return CollectionRecordVO.properties引用
     */
    public static Properties loadProperties(String pName){
        Properties properties=null;
        try{
            FileInputStream fileInputStream=new FileInputStream(pName);
            properties=new Properties();
            properties.load(fileInputStream);
        }catch(Exception e){
            e.printStackTrace();
        }
        return properties;
    }

}


























