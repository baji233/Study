package com.jiuyun.util;

/**
 * @author cj
 * @create 2022年10月25日 14:19:24
 */
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        return a / b;
    }
}
