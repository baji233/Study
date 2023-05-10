package com.jiuyun.bean;

/**
 * @author cj
 * @create 2022年11月01日 15:56:54
 */
public class SingletonClass {
    //声明一个静态的本类的成员属性
    private static SingletonClass singletonClass;

    //私有化构造方法
    private SingletonClass() {
    }

    public static SingletonClass getInstance() {
        if(singletonClass == null) {
            singletonClass = new SingletonClass();
        }
        return singletonClass;
    }
}
