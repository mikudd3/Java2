package com.lanqiao.javalearn.java2.test8.junit3;

import junit.framework.TestCase;

public class AddOperationTest extends TestCase {

    // 声明实例变量
    AddOperation operation;
    public void setUp() throws Exception{
        // 创建 AddOperator 对象
        operation = new AddOperation();
    }
    public void tearDown() throws Exception{
        // 资源释放
        operation = null;
    }
    // 测试 AddOperation 类的 add()方法
    public void testAdd(){
        // 输入值
        int x = 3;
        int y = 5;
        // 预期结果
        int expResult = 8;
        // 获取实际结果
        int result = operation.add(x, y);
        //通过断言判断实际结果和预期结果的差异，前者为预期，后者为实际
        assertEquals(expResult,result);
    }
}