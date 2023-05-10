package com.jiuyun.bean;

/**
 * @author cj
 * @create 2022年10月13日 20:17:58
 */
public class Student {
    private String stuId;
    private String stuName;
    private String sex;
    private String age;

    public Student() {
    }

    public Student(String stuId, String stuName, String sex, String age) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.sex = sex;
        this.age = age;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId='" + stuId + '\'' +
                ", stuName='" + stuName + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
