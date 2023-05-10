package com.jiuyun.bean;

/**
 * @author cj
 * @create 2022年10月25日 16:09:49
 */
public class Student {
    private Integer stuId;
    private String stuName;
    private String sex;
    private Integer age;
    private String remark;

    public Student() {
    }

    public Student(Integer stuId, String stuName, String sex, Integer age, String remark) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.sex = sex;
        this.age = age;
        this.remark = remark;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", remark='" + remark + '\'' +
                '}';
    }
}
