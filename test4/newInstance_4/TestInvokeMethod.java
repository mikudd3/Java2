package com.lanqiao.javalearn.java2.test4.newInstance_4;

import java.lang.reflect.Method;

/**
 * @project: 根据参数动态调用功能
 * @author: mikudd3
 * @version: 1.0
 */
public class TestInvokeMethod {
    // 求和方法
    public int add(int x, int y) {
        return x + y;
    }

    // 加一方法
    public int add(int x) {
        return x + 1;
    }

    // 求乘积方法
    public int multiply(int x, int y) {
        return x * y;
    }

    // 求平方方法
    public int multiply(int x) {
        return x * x;
    }

    public static void main(String args[]) {
        try {
            Class<?> c = TestInvokeMethod.class;
            Object obj = c.newInstance();
            //通过方法名、参数类型列表，获得Method对象
            Method m = c.getDeclaredMethod("multiply", int.class, int.class);
            //invoke(Object o,Object[] args)方法调用对象o对应方法
            System.out.println("调用方法：multiply，输入值为int型3和4，结果为："
                    + m.invoke(obj, 3, 4));
            Method m2 = c.getDeclaredMethod("add", int.class);
            System.out.println("调用方法：add，输入值为int型18，结果为："
                    + m2.invoke(obj, 18));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
