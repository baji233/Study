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
     * ͨ�õ���ɾ�Ĺ���
     * sql--Ҫִ�е���ɾ�ĵ�sql���
     * paramValues--sql��Ҫע��Ĳ���ֵ
     */

    public static boolean operMoper(String sql,Object...paramValues){
        boolean isSuccess=false;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection=Util.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            int index=1;//�ӵ�һ��������ʼ
            if(paramValues!=null){
                for(Object tmp:paramValues){
                    preparedStatement.setObject(index++,tmp);//����������ָ��������ֵ
                }
            }
            int row=preparedStatement.executeUpdate();
            if(row>0){
                isSuccess=true;
                System.out.println("���³ɹ�!");
            }else{
                System.out.println("����ʧ��!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            Util.free(connection,preparedStatement,null);
        }
        return isSuccess;
    }

    /**
     * ����: ?�Ĳ�ѯ��sql���,��¼��װ��vo����,paramValuesΪSQL�����ֵ
     *
     * ����ѯ������ļ�¼��װ��vo�����������
     *
     * ����:�ֶ�����vo��������(�ֶ�����Сд����������ͬ)
     */
    public static @NotNull List queryInfo(String sql, Class voClass, Object...paramValues){
        List items=new ArrayList();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            //��String��ʽ���ش�Class�����ʾ��ʵ�������(com.jiuyun.system.vo.EmpInfoVO)
            String className=voClass.getName();
            //����"."���һ�γ��ֵ�����������
            int lastIndex=className.lastIndexOf(".");
            //������Ϊ���ַ��������ַ������ַ���(lastIndex+1:���ַ�����.��ʼ��ǰ�����쵽���ַ�����ĩβ,������.����)����Сд����������ļ���,�޺�׺
            String propertiesNAME=className.substring(lastIndex+1);
            String propertiesName=propertiesNAME.toLowerCase();
            //����loadProperties������ȡ���ݿ����Ϣ
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
            ResultSetMetaData resultSetMetaData=resultSet.getMetaData(); //��ò�ѯ�������Ԫ����(�е����������ͺ�����)
            //��ȡ�����������
            int cols=resultSetMetaData.getColumnCount();
            while(resultSet.next()){
                //ͨ��������ƻ�ȡVO���ʵ��
                Object vo=voClass.newInstance();
                for(int i=1;i<=cols;i++){
                    //��ȡ�ֶ����ֲ�ת��ΪСд
                    String nAME=resultSetMetaData.getColumnName(i);
                    String name=nAME.toLowerCase();//ת����Сд����Ϊ�����ļ�empInfo.properties����Ҫ
                    System.out.println(name+"--");//�ֶ���
                    //�����ֶ�����ȡvo�����������
                    String fieldName=(String)properties.get(name);
                    //��ȡ�ֶ�ֵ
                    Object values=resultSet.getString(nAME);
                    //����vo�����setXxx����Ϊ���Ը�ֵ
                    System.out.println(fieldName+"--");//������
                    Field field=voClass.getDeclaredField(fieldName);//��Class�����ʾ�����ӿڵ�ָ�������ֶε�Field����
                    field.setAccessible(true);//���������ʹ��ʱӦ��ֹ Java ���Է��ʼ��
                    field.set(vo,values);//��vo�����ϵĴ�Field�����ʾ���ֶ�����Ϊָ������ֵ

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

    //��ȡ���������ָ�������ļ�xxx.properties�е�����,���������xml�ļ�������(��Ϊxml�ļ��ڳ���ʼ��ʱ����ѳ�ʼ����).��properties�ļ�������Ҫʱ����
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
    //properties�����ļ�ͨ����̬���������ʼ������
    public static Properties properties=null;
    static{
        properties=loadProperties();
    }

    //��ȡ�����ļ�empInfo.properties�е�����
    public static Properties loadProperties(){
        Properties properties=null;
        try {
            FileInputStream fileInputStream=new FileInputStream("empInfo.properties");//�����ļ�empInfo.propertiesͨ���ֽ���������������
            properties=new Properties();
            properties.load(fileInputStream);//���ֽ��������ж�ȡ�����б�����Ԫ�ضԣ�
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
 */

}


























