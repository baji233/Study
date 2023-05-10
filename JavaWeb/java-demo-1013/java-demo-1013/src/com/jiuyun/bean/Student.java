package com.jiuyun.bean;

/**
 * @author cj
 * @create 2022年10月13日 11:14:07
 */
public class Student {
    private int stuId;
    private String stuName;
    private String sex;
    public static int count;

    public Student() {
        count++;
    }

    public Student(int stuId, String stuName, String sex) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.sex = sex;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
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

    public boolean equals(Object o) {
        if(o instanceof Student) {
            Student stu = (Student) o;
            if((stu.getStuId() == this.stuId) && (stu.getStuName().equals(this.stuName)) && (stu.getSex().equals(this.sex))) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
