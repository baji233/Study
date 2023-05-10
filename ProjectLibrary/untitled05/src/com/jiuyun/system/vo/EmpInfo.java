package com.jiuyun.system.vo;

public class EmpInfo {
    private String empId;
    private String empName;
    private String pay;
    private String job;
    private String birthday;
    private String deptId;

    public EmpInfo(){
        super();
    }

    public EmpInfo(String empId, String empName, String pay, String job, String birthday, String deptId) {
        super();
        this.empId = empId;
        this.empName = empName;
        this.pay = pay;
        this.job = job;
        this.birthday = birthday;
        this.deptId = deptId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
}
