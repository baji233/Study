package com.jiuyun.system.vo;
//图书信息VO对象
public class ReaderInfoVO {
    String readerId;
    String Name;
    String borrowNum;
    String isBorrow;
    String sex;
    String age;
    String birth;
    String reTypeId;
    String registerDate;
    String expireTime;
    String idCard;
    String phone;
    String e_mail;
    String workLocation;
    String department;
    String lossState;//挂失状态
    String operator;

    public ReaderInfoVO(){

    }

    public ReaderInfoVO(String readerId, String name, String borrowNum, String isBorrow, String sex, String age, String birth, String readerType, String registerDate, String expireTime, String idCard, String phone, String e_mail, String workLocation, String department, String lossState, String operator) {
        this.readerId = readerId;
        Name = name;
        this.borrowNum = borrowNum;
        this.isBorrow = isBorrow;
        this.sex = sex;
        this.age = age;
        this.birth = birth;
        this.reTypeId = readerType;
        this.registerDate = registerDate;
        this.expireTime = expireTime;
        this.idCard = idCard;
        this.phone = phone;
        this.e_mail = e_mail;
        this.workLocation = workLocation;
        this.department = department;
        this.lossState = lossState;
        this.operator = operator;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBorrowNum() {
        return borrowNum;
    }

    public void setBorrowNum(String borrowNum) {
        this.borrowNum = borrowNum;
    }

    public String getIsBorrow() {
        return isBorrow;
    }

    public void setIsBorrow(String isBorrow) {
        this.isBorrow = isBorrow;
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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getReTypeId() {
        return reTypeId;
    }

    public void setReTypeId(String reTypeId) {
        this.reTypeId = reTypeId;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLossState() {
        return lossState;
    }

    public void setLossState(String lossState) {
        this.lossState = lossState;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
