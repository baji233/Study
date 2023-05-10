package com.jiuyun.system.vo;

import com.jiuyun.system.view.MainFrame;

/**
 * 获取值
 */
public class Test01 {
//封装表中属性
    private int id;
    private String name;
    private int pay;
    private String department;//部门
    private String job;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Test01(){};
    public Test01(int id, String name, int pay, String department, String job) {
        super();
        this.id = id;
        this.name = name;
        this.pay = pay;
        this.department = department;
        this.job = job;
    }

    //获取txtName或txtJob里的文本信息
    MainFrame mainFrame=new MainFrame();
    String empName,empJob="";
    public String getEmpName(){
        empName=mainFrame.txtName.getText();
        return empName;
    }
    public String getEmpJob(){
        empJob=mainFrame.txtJob.getText();
        return empJob;
    }

    public static void main(String[] args){

    }

}
