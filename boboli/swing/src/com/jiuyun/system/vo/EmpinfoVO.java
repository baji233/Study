package com.jiuyun.system.vo;

public class EmpinfoVO {

	private String empNo;
	private String ename;
	private String salary;
	private String job;
	private String birthday;
	private String dname;
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
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
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public EmpinfoVO(String empNo, String ename, String salary, String job, String birthday, String dname) {
		super();
		this.empNo = empNo;
		this.ename = ename;
		this.salary = salary;
		this.job = job;
		this.birthday = birthday;
		this.dname = dname;
	}
	public EmpinfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
