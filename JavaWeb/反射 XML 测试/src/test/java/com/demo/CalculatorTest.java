package com.demo;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class CalculatorTest {

    static Calculator calculator=null;

    //添加log4j日志
    private static final Logger log =LoggerFactory.getLogger(CalculatorTest.class);
    @BeforeClass
    public static void beforeClass() throws Exception {
        //在类加载时调用..
        calculator=new Calculator();
        log.info("beforeClass()\n");
    }

    @Test
    public void add() {
        after();
        assertTrue(calculator.add(1,2) == 3);
        before();
    }

    @Test (timeout = 3000) //将超时2000毫秒（性能测试）
    public void sub() throws InterruptedException {
        assertTrue(calculator.sub(4,1) == 3);
    }

    @Ignore //忽略测试这个mul方法
    @Test
    public void mul() {
        assertTrue(calculator.mul(1,2) == 3);
    }

    @Test (expected = ArithmeticException.class) //已知的异常
    public void div() throws Exception {
        afterClass();
        assertTrue(calculator.div(1,0) == 3);
        beforeClass();
    }


    @AfterClass
    public static void afterClass() throws Exception {
        log.info("afterClass()\n");
    }

    @Before
    public void before(){
        log.info("before()\n");
    }

    @After
    public void after(){
        //在方法结束时调用..
        log.info("after()\n");
    }
}













