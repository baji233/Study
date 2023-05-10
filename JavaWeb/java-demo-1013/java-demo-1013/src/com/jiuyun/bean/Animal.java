package com.jiuyun.bean;

/**
 * @author cj
 * @create 2022年10月13日 11:34:54
 */
public abstract class Animal {
    private String name;

    public Animal(){

    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void shout();


}
