package com.jiuyun.system.util;

import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CommonDao {
    /**
     * 通用的增删改功能
     * sql--要执行的增删改的sql语句
     * paramValues--sql中要注入的参数值
     */

    public static boolean operMoper(String sql,Object...paramValues){
        boolean isSuccess=false;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection=Util.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            int index=1;//从第一个参数开始
            if(paramValues!=null){
                for(Object tmp:paramValues){
                    preparedStatement.setObject(index++,tmp);//给对象设置指定参数的值
                }
            }
            int row=preparedStatement.executeUpdate();
            if(row>0){
                isSuccess=true;
                System.out.println("更新成功!");
            }else{
                System.out.println("更新失败!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            Util.free(connection,preparedStatement,null);
        }
        return isSuccess;
    }

    /**
     * 参数: ?的查询的sql语句,记录封装的vo对象,paramValues为SQL语句中值
     *
     * 将查询结果集的记录封装到vo对象的属性中
     *
     * 规则:字段名与vo的属性名(字段名的小写与属性名相同)
     */
    public static @NotNull List queryInfo(String sql, Class voClass, Object...paramValues){
        List items=new ArrayList();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            //以String形式返回此Class对象表示的实体的名称(com.jiuyun.system.vo.EmpInfoVO)
            String className=voClass.getName();
            //返回"."最后一次出现的索引的索引
            int lastIndex=className.lastIndexOf(".");
            //返回作为此字符串的子字符串的字符串(lastIndex+1:子字符串以.开始向前并延伸到该字符串的末尾,不包括.在内)将其小写后就是配置文件名,无后缀
            String propertiesNAME=className.substring(lastIndex+1);
            String propertiesName=propertiesNAME.toLowerCase();
            //调用loadProperties方法读取数据库的信息
            Properties properties=loadProperties(propertiesName+".properties");

            connection=Util.getConnection();
            preparedStatement=  connection.prepareStatement(sql);
            if(paramValues!=null){
                int paramIndex=1;
                for(Object tmp:paramValues){
                    preparedStatement.setObject(paramIndex++,tmp);
                }
            }
            resultSet=preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData=resultSet.getMetaData(); //获得查询结果集的元数据(列的数量、类型和属性)
            //获取结果集的列数
            int cols=resultSetMetaData.getColumnCount();
            while(resultSet.next()){
                //通过反射机制获取VO类的实例
                Object vo=voClass.newInstance();
                for(int i=1;i<=cols;i++){
                    //获取字段名字并转换为小写
                    String nAME=resultSetMetaData.getColumnName(i);
                    String name=nAME.toLowerCase();//转化成小写是因为配置文件empInfo.properties中需要
                    System.out.println(name+"--");//字段名
                    //根据字段名获取vo对象的属性名
                    String fieldName=(String)properties.get(name);
                    //获取字段值
                    Object values=resultSet.getString(nAME);
                    //调用vo对象的setXxx方法为属性赋值
                    System.out.println(fieldName+"--");//属性名
                    Field field=voClass.getDeclaredField(fieldName);//此Class对象表示的类或接口的指定声明字段的Field对象
                    field.setAccessible(true);//反射对象在使用时应禁止 Java 语言访问检查
                    field.set(vo,values);//将vo参数上的此Field对象表示的字段设置为指定的新值

                }
                items.add(vo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally{
            Util.free(connection,preparedStatement,resultSet);
        }
        return items;
    }

    //读取传入参数中指定配置文件xxx.properties中的数据,但不建议对xml文件这样做(因为xml文件在程序开始的时候就已初始化了).而properties文件是在需要时传入
    public static Properties loadProperties(String propertiesName){
        Properties properties=null;
        try {
            FileInputStream fileInputStream=new FileInputStream(propertiesName);
            properties=new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }


/**
    //properties配置文件通过静态代码块来初始化数据
    public static Properties properties=null;
    static{
        properties=loadProperties();
    }

    //读取配置文件empInfo.properties中的数据
    public static Properties loadProperties(){
        Properties properties=null;
        try {
            FileInputStream fileInputStream=new FileInputStream("empInfo.properties");//配置文件empInfo.properties通过字节输入流来到这里
            properties=new Properties();
            properties.load(fileInputStream);//从字节输入流中读取属性列表（键和元素对）
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
 */

}


























