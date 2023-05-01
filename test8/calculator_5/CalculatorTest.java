package com.lanqiao.javalearn.java2.test8.calculator_5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calc;

    @BeforeEach
    void setUp() throws Exception {
        // 计算器类对象创建
        calc = new Calculator();
        System.out.println("测试前初始值置零！");
        calc.clear();
    }

    @AfterEach
    void tearDown() throws Exception {
        System.out.println("测试后......");
        calc = null;
    }

    @Test
    void testAdd() {
        calc.add(2);
        calc.add(3);
        assertEquals(5, calc.getResult());
    }

    @Test
    void testSubtract() {
        calc.add(10);
        calc.subtract(2);
        assertEquals(8, calc.getResult());
    }

    @Test
    void testDivide() {
        calc.add(8);
        calc.divide(2);
        assert calc.getResult() == 5;
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide(0));
    }

    @Disabled("not Ready Yet A Multiply")
    @Test
    void multiply() {
        calc.add(10);
        calc.multiply(10);
        assertEquals(100, calc.getResult());
    }

    // @A
    void testSquare() {

    }
}