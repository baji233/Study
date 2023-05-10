package com.jiuyun.system.model;

import com.jiuyun.system.util.Util;
import com.jiuyun.system.vo.Test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ����empInfo��
 */
public class Test02 {
    Connection connection=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;
    String sql;
    Test01 test01 =new Test01();
    Scanner scanner=new Scanner(System.in);
    ArrayList<Test01> arrayList=new ArrayList<>();
    //��ѯ
    public ArrayList<Test01> queryEmpInfo(String empName, String sql){//�����Ҫ���Դ���һ��������ʾ��ѯ����,��Ȼ�Ϳ���̨��ʾ���
        try {
            connection= Util.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,empName);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                int id=resultSet.getInt("��Ա���");
                String name=resultSet.getString("����");
                int pay=resultSet.getInt("����");
                String department=resultSet.getString("����");
                String job=resultSet.getString("����");
                System.out.println("��Ա���:"+id+"����:"+name+"����:"+pay+"����:"+department+"����:"+job);
                Test01 test01 =new Test01(id,name,pay,department,job);
                arrayList.add(test01);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            Util.free(connection,preparedStatement,resultSet);
        }
        return arrayList;
    }
    //���
    public void addEmpInfo(){//��Ա��Ż��Զ���һ
        System.out.println("<----��������Ҫ��ӵĹ�Ա��Ϣ---->\n");
        System.out.println("����:");
        test01.setName(scanner.next());
        System.out.println("����:");
        test01.setName(scanner.next());
        System.out.println("����:");
        test01.setName(scanner.next());
        System.out.println("����:");
        test01.setName(scanner.next());
        System.out.println("������ӹ�Ա...");
        try {
            sql="insert into empinfo (����,����,����,����) values (?,?,?,?)";
            String name= test01.getName();
            int pay= test01.getPay();
            String department= test01.getDepartment();
            String job= test01.getJob();
            connection= Util.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,pay);
            preparedStatement.setString(3,department);
            preparedStatement.setString(4,job);
            int row=preparedStatement.executeUpdate();
            if(row>0){
                System.out.println("�ɹ�!");
            }else if(row==0){
                System.out.println("ʧ��!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Util.free(connection,preparedStatement,null);
        }
    }
    //ɾ��
    public void deleteEmpInfo(){
        System.out.println("<----��������Ҫɾ���Ĺ�Ա����---->\n");
        Scanner scanner=new Scanner(System.in);
        test01.setName(scanner.next());
        System.out.println("����ɾ����Ա��Ϣ...");
        try {
            sql="delete empinfo where ����=?";
            String name= test01.getName();
            connection= Util.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            int row=preparedStatement.executeUpdate();
            if(row>0){
                System.out.println("�ɹ�!");
            }else if(row==0){
                System.out.println("ʧ��!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Util.free(connection,preparedStatement,null);
        }
    }
    //����
    public void updateEmpInfo() throws SQLException {//ʹ������
        sql="update empinfo set ?=? where ����=?";
        String name,str1,str2;
        int pay;
        System.out.println("<----��������Ҫ�޸���Ϣ�Ĺ�Ա����---->\n");
        name=scanner.next();
        System.out.println("<----������Ҫ�޸ĵ��ֶ�(����,����,����,����)---->\n");
        str1=scanner.next();
        if("����".equals(str1)||"����".equals(str1)||"����".equals(str1)){
            System.out.println("<----����ĳ�ɶ?---->");
            str2=scanner.next();
            System.out.println("<----�޸���...---->");
            try {
                connection= Util.getConnection();
                connection.setAutoCommit(false);
                preparedStatement=connection.prepareStatement(sql);
                preparedStatement.setString(1,str1);
                preparedStatement.setString(2,str2);
                preparedStatement.setString(3,name);
                int row=preparedStatement.executeUpdate();
                connection.commit();
                if(row>0){
                    System.out.println("�ɹ�!");
                }else if(row==0){
                    System.out.println("ʧ��");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                connection.rollback();
                System.out.println("ʧ��");
                throw new RuntimeException(e);
            } finally {
                Util.free(connection,preparedStatement,null);
            }
        }else if("����".equals(str1)){
            System.out.println("<----����Ķ���?---->");
            pay=scanner.nextInt();
            System.out.println("<----�޸���...---->");
            try {
                connection = Util.getConnection();
                connection.setAutoCommit(false);
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, str1);
                preparedStatement.setInt(2, pay);
                preparedStatement.setString(3, name);
                int row = preparedStatement.executeUpdate();
                connection.commit();
                if (row > 0) {
                    System.out.println("�ɹ�!");
                } else if (row == 0) {
                    System.out.println("ʧ��");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                connection.rollback();
                System.out.println("ʧ��");
                throw new RuntimeException(e);
            } finally {
                Util.free(connection,preparedStatement,null);
            }
        }else{
            System.out.println("�밴�չ�����������!!!");
        }
    }
    public static void main(String[] args){
    }
}























