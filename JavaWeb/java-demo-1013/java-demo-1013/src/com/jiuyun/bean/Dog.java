package com.jiuyun.bean;

/**
 * @author cj
 * @create 2022年10月13日 13:37:25
 */
public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void shout() {
        System.out.println(getName() + "正在叫：汪汪汪");
    }
}
