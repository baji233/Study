package com.jiuyun.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author cj
 * @create 2022年10月25日 15:12:58
 */
public class MyDemoTest {

    @Test
    public void add() {
        assertTrue(new MyDemo().add(1, 1) == 2);
    }
}