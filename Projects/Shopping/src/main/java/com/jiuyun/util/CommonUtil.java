package com.jiuyun.util;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.jiuyun.util.DBUtil.printLog;

public class CommonUtil {

    /**
     * 通用的增删改操作数据表
     * @param sql
     * @param paramValues
     * @return 是否操作成功
     */
    public static boolean modify(String sql,Object...paramValues){
        boolean isSuccess=false;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection= DBUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            int index=1;
            if(paramValues!=null){
                for(Object param:paramValues){
                    preparedStatement.setObject(index++,param);
                }
            }
            int row=preparedStatement.executeUpdate();
            if(row>0){
                isSuccess=true;
            }
        }catch(Exception e){
            printLog(e);
        }finally{
            DBUtil.close(connection,preparedStatement,null);
        }
        return isSuccess;
    }

    /**
     * 通用的查询操作数据表
     * @param sql
     * @param voClass
     * @param paramValues
     * @return 查询结果集
     */
    public static List query (String sql, Class voClass, Object...paramValues){
        List result=new ArrayList();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
            //1.先获取properties配置文件名,然后读取表中数据
            String className=voClass.getName();//com.jiuyun.bean.Order
            int lastIndex=className.lastIndexOf(".");
            String pNAME=className.substring(lastIndex+1);
            String pName=pNAME.toLowerCase();
            Properties properties=loadProperties(pName);
            //2.开始查询读者信息表
            connection= DBUtil.getConnection();
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
                    String cName=metaData.getColumnName(i);//字段名
                    String lowerCName=cName.toLowerCase();
                    String fieldName=(String)properties.get(lowerCName);
                    Object columnValue=resultSet.getObject(cName);
                    Field field=voClass.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    field.set(vo,columnValue);
                }
                result.add(vo);
            }
        }catch(Exception e){
            printLog(e);
        }finally{
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return result;
    }

    /**
     * 读取指定配置文件名xxx.properties的表中数据
     * @param pName 配置文件名
     * @return CollectionRecordVO.properties引用
     */
    private static Properties loadProperties(String pName){
        Properties properties=null;
        try{
            String path=CommonUtil.class.getClassLoader().getResource(pName+".properties").getPath();
            File file=new File(path);
            FileInputStream fileInputStream=new FileInputStream(file);
            properties=new Properties();
            properties.load(fileInputStream);
        }catch(Exception e){
            printLog(e);        }
        return properties;
    }

    /**
     * 截取URL字符串
     * @param req
     * @return
     */
    public static String getSubURL(HttpServletRequest req){
        String path= req.getRequestURI();
        String subURL = path.substring(path.lastIndexOf("/") + 1);
        return subURL;
    }

}
