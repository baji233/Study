package com.jiuyun.system.vo;

public class ReaderInfoVO1 {
	private String readerId;
	private String readerName;
	private String sex;
	private String age;
	private String birthday;
	public String getReaderId() {
		return readerId;
	}
	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}
	public String getReaderName() {
		return readerName;
	}
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "ReaderInfo [readerId=" + readerId + ", readerName=" + readerName + ", sex=" + sex + ", age=" + age
				+ ", birthday=" + birthday + "]";
	}
	public ReaderInfoVO1(String readerId, String readerName, String sex, String age, String birthday) {
		super();
		this.readerId = readerId;
		this.readerName = readerName;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
	}
	public ReaderInfoVO1() {
		super();
	}
	
	
}
