package com.lanqiao.javalearn.java2.test8.junit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddOperationTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
        int x = 3;
        int y = 5;
        AddOperation addOperation = new AddOperation();
        int expResult = 8;
        int result = addOperation.add(x, y);
        assertEquals(expResult, result);
    }
}