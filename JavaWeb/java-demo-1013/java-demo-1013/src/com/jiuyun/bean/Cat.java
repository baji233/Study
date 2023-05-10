package com.jiuyun.bean;

/**
 * @author cj
 * @create 2022年10月13日 11:35:18
 */
public class Cat extends Animal {

    public Cat() {

    }

    public Cat(String name) {
        super(name);
    }

    public void shout() {
        System.out.println(getName() + "正在叫：喵喵喵！");
    }
}
