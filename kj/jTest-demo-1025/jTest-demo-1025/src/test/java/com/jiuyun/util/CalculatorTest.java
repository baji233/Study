package com.jiuyun.util;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * @author cj
 * @create 2022年10月25日 14:20:33
 */
public class CalculatorTest {
    private static final Logger log = LoggerFactory.getLogger(CalculatorTest.class);
    private Calculator calculator;

    @BeforeClass
    public static void beforeClass() {
        log.info("this is CalculatorTest.beforeClass() method!");
    }

    @AfterClass
    public static void afterClass() {
        log.info("this is CalculatorTest.afterClass() method!");
    }

    @Before
    public void before() {
        calculator = new Calculator();
        log.info("this is CalculatorTest.before() method!");
    }

    @After
    public void after() {
        log.info("this is CalculatorTest.after() method!");
    }

    @Test
    public void add() {
        log.info("this is CalculatorTest.add() method!");
        assertTrue(calculator.add(1,2) == 3);;
    }

    @Test(timeout = 3000)
    public void sub() {
        log.info("this is CalculatorTest.sub() method!");
        assertTrue(calculator.sub(2, 1) == 1);
    }

    @Test
    public void multiply() {
        log.info("this is CalculatorTest.multiply() method!");
        assertTrue(calculator.multiply(2, 1) == 2);
    }

    @Ignore
    @Test(expected = ArithmeticException.class)
    public void div() {
        log.info("this is CalculatorTest.div() method!");
        assertTrue(calculator.div(2, 0) == 2);
    }
}