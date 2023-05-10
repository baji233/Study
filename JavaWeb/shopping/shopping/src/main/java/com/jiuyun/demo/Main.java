package com.jiuyun.demo;

/**
 * @author cj
 * @create 2022年10月18日 15:01:10
 */
public class Main {
    public static void main(String[] args) {
        String path = Main.class.getClassLoader().getResource("log4j.properties").getPath();
        System.out.println(path);
    }
}
