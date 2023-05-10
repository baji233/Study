package com.jiuyun.system.vo;

public class loginInfoVO {
    private String empName;
    private String pass;

    public loginInfoVO(){
        super();
    }

    public loginInfoVO(String empName, String pass) {
        super();
        this.empName = empName;
        this.pass = pass;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
