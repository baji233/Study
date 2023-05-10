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
 * 操作empInfo表
 */
public class Test02 {
    Connection connection=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;
    String sql;
    Test01 test01 =new Test01();
    Scanner scanner=new Scanner(System.in);
    ArrayList<Test01> arrayList=new ArrayList<>();
    //查询
    public ArrayList<Test01> queryEmpInfo(String empName, String sql){//如果需要可以创建一个窗口显示查询内容,不然就控制台显示结果
        try {
            connection= Util.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,empName);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                int id=resultSet.getInt("雇员编号");
                String name=resultSet.getString("姓名");
                int pay=resultSet.getInt("工资");
                String department=resultSet.getString("部门");
                String job=resultSet.getString("工作");
                System.out.println("雇员编号:"+id+"姓名:"+name+"工资:"+pay+"部门:"+department+"工作:"+job);
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
    //添加
    public void addEmpInfo(){//雇员编号会自动加一
        System.out.println("<----请输入需要添加的雇员信息---->\n");
        System.out.println("姓名:");
        test01.setName(scanner.next());
        System.out.println("工资:");
        test01.setName(scanner.next());
        System.out.println("部门:");
        test01.setName(scanner.next());
        System.out.println("工作:");
        test01.setName(scanner.next());
        System.out.println("正在添加雇员...");
        try {
            sql="insert into empinfo (姓名,工资,部门,工作) values (?,?,?,?)";
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
                System.out.println("成功!");
            }else if(row==0){
                System.out.println("失败!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Util.free(connection,preparedStatement,null);
        }
    }
    //删除
    public void deleteEmpInfo(){
        System.out.println("<----请输入需要删除的雇员姓名---->\n");
        Scanner scanner=new Scanner(System.in);
        test01.setName(scanner.next());
        System.out.println("正在删除雇员信息...");
        try {
            sql="delete empinfo where 姓名=?";
            String name= test01.getName();
            connection= Util.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            int row=preparedStatement.executeUpdate();
            if(row>0){
                System.out.println("成功!");
            }else if(row==0){
                System.out.println("失败!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Util.free(connection,preparedStatement,null);
        }
    }
    //更新
    public void updateEmpInfo() throws SQLException {//使用事务
        sql="update empinfo set ?=? where 姓名=?";
        String name,str1,str2;
        int pay;
        System.out.println("<----请输入需要修改信息的雇员姓名---->\n");
        name=scanner.next();
        System.out.println("<----输入需要修改的字段(姓名,工资,部门,工作)---->\n");
        str1=scanner.next();
        if("姓名".equals(str1)||"部门".equals(str1)||"工作".equals(str1)){
            System.out.println("<----你想改成啥?---->");
            str2=scanner.next();
            System.out.println("<----修改中...---->");
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
                    System.out.println("成功!");
                }else if(row==0){
                    System.out.println("失败");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                connection.rollback();
                System.out.println("失败");
                throw new RuntimeException(e);
            } finally {
                Util.free(connection,preparedStatement,null);
            }
        }else if("工资".equals(str1)){
            System.out.println("<----你想改多少?---->");
            pay=scanner.nextInt();
            System.out.println("<----修改中...---->");
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
                    System.out.println("成功!");
                } else if (row == 0) {
                    System.out.println("失败");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                connection.rollback();
                System.out.println("失败");
                throw new RuntimeException(e);
            } finally {
                Util.free(connection,preparedStatement,null);
            }
        }else{
            System.out.println("请按照规则重新输入!!!");
        }
    }
    public static void main(String[] args){
    }
}























