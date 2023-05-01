package com.lanqiao.javalearn.java2.test8.junit5;

import org.junit.jupiter.api.Assertions;


class AddOperationTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void add() {
        int x = 3;
        int y = 5;
        AddOperation addOperation = new AddOperation();
        int expResult = 8;
        int result = addOperation.add(x, y);
        Assertions.assertEquals(expResult, result);
    }
}