package com.lanqiao.javalearn.java2.test8.calculator_4one;

import org.junit.Test;

import static org.junit.Assert.*;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest {
    Calculator calc;

    @Before
    public void setUp() throws Exception {
        // 创建 Calculator 对象
        calc = new Calculator();
        System.out.println("测试前初始值置零！");
        calc.clear();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("测试后...");
        calc = null;
    }

    // 测试加法计算
    @Test
    public void testAdd() {
        calc.add(2);
        calc.add(3);
        int result = calc.getResult();
        assertEquals(5, result);
    }

    // 测试减法计算
    @Test
    public void testSubtract() {
        calc.add(10);
        calc.subtract(2);
        int result = calc.getResult();
        assertEquals(8, result);
    }

    // 忽略测试乘法计算
    @Ignore("not Ready Yet A Multiply")
    @Test
    public void testMultiply() {
        calc.add(10);
        calc.multiply(10);
        int result = calc.getResult();
        assertEquals(100, result);
    }

    // 测试除法计算
    @Test
    public void testDivide() {
        calc.add(8);
        calc.divide(2);
        assert calc.getResult() == 5;
    }

    // 测试除法计算，抛出 ArithmeticException 异常
    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calc.add(8);
        calc.divide(0);
    }

    // 不测试平方计算
    //@A
    public void testSquare() {

    }
}