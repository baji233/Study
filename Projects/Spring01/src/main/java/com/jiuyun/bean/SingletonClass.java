package com.jiuyun.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 单例模式:
 */
public class SingletonClass {
    private static final Logger log = LoggerFactory.getLogger(SingletonClass.class);
    //声明一个私有静态的自己的对象
    private static SingletonClass singletonClass;

    private SingletonClass() {
    }

    /**
     * 饿汉式：调用时创建对象
     * @return
     */
    public static SingletonClass getInstance() {
        if(singletonClass == null){
            singletonClass = new SingletonClass();
        }
        return singletonClass;
    }

    public void test(){
        log.info("SingletonClass.test()");
    }

}
