package com.demo;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyDemoTest {

    @Test
    public void add() {
        MyDemo myDemo=new MyDemo();
        assertTrue(myDemo.add(1,2) == 3);
    }
}