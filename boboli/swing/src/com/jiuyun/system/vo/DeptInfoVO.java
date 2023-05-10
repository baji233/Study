package com.jiuyun.system.vo;

public class DeptInfoVO {
    private String deptNo;
    private String deptName;
    private String location;
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public DeptInfoVO(String deptNo, String deptName, String location) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.location = location;
	}
    
	public DeptInfoVO()
	{
		
	}
    
}
