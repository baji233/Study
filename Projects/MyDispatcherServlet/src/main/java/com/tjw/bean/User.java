package com.tjw.bean;

public class User {
    private Integer id;
    private String nme;
    private Integer age;
    private String address;

    public User(Integer id, String nme, Integer age, String address) {
        this.id = id;
        this.nme = nme;
        this.age = age;
        this.address = address;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNme() {
        return nme;
    }

    public void setNme(String nme) {
        this.nme = nme;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nme='" + nme + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
