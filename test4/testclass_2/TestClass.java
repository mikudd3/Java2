package com.lanqiao.javalearn.java2.test4.testclass_2;

import java.util.Date;

/**
 * @project: 获取 Class 类对象的 5 种方式
 * @author: mikudd3
 * @version: 1.0
 */

public class TestClass {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("第一种方法：Object.getClass()");

        //获取对象
        Class<?> c1 = Date.class;
        System.out.println(c1.getName());

        System.out.println("第二种方法：类名.Class");
        Class<?> c2 = boolean.class;
        System.out.println(c2.getName());

        try {
            System.out.println("第三种方法：Class.forName()");
            //由于包中有多个TestClass类，所以需要限定包名
            Class<?> c3 = Class.forName("com.lanqiao.javalearn.java2.test4.testclass_2.TestClass");
            System.out.println(c3.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("第四种方法：包装类的TYPE属性");
        Class<?> c4 = Double.TYPE;
        System.out.println(c4.getName());

        System.out.println("第五种方法：Class 对象.getSuperClass()");
        Class<?> c5 = String.class.getSuperclass();
        System.out.println(c5.getName());

    }
}
