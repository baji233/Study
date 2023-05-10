package com.jiuyun.system.vo;

public class DeptInfoVO {
    private String deptId;
    private String deptName;
    private String loc;

    public DeptInfoVO(){
        super();
    };

    public DeptInfoVO(String deptId, String deptName, String loc) {
        super();
        this.deptId = deptId;
        this.deptName = deptName;
        this.loc = loc;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
