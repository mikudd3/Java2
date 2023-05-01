package com.lanqiao.javalearn.java2.test9.methodref;

import java.util.ArrayList;

/**
 * @project: 使用不同的方法引用方式
 * @author: mikudd3
 * @version: 1.0
 */

@FunctionalInterface
interface MyInterface1 {
    boolean method(String str);
}

@FunctionalInterface
interface MyInterface2 {
    boolean method(String str1, String str2);
}

class School {
}

@FunctionalInterface
interface MyInterface3 {
    School method();
}

@FunctionalInterface
interface MyInterface4 {
    String[] method(Integer length);
}

/**
 * 使用不同的方法引用方式
 */
public class TestMethodRef2 {
    // 引用某个对象的实例方法
    void methodRef() {
        ArrayList<String> list = new ArrayList<>();
        // 对象名 :: 非静态方法
        MyInterface1 mi = list::add;
        System.out.println("对象名 :: 非静态方法：");
        mi.method("Tony");
        mi.method("CoCo");
        // forEach() 方法中还可以更加简化
        list.forEach(System.out::println);
    }

    /// 引用类中的实例方法
    void methodRef2() {
        // 类名 :: 非静态方法
        MyInterface2 mi = String::equals;
        System.out.println("类名 :: 非静态方法：");
        System.out.println(mi.method("hello", "hello"));
        System.out.println(mi.method("hello", "hi"));
    }

    // 引用构造方法
    void methodRef3() {
        // 类名 :: new
        MyInterface3 mi = School::new;
        System.out.println("类名 :: new：");
        School s = mi.method();
        System.out.println(s);
    }

    // 引用数组
    void methodRef4() {
        // 元素类型[] :: new
        MyInterface4 mi = String[]::new;
        System.out.println("元素类型[] :: new：");
        String[] strs = mi.method(6);
        System.out.println("String 数组长度为：" + strs.length);
    }

    public static void main(String[] args) {
        TestMethodRef2 tmr = new TestMethodRef2();
        tmr.methodRef();
        tmr.methodRef2();
        tmr.methodRef3();
        tmr.methodRef4();
    }


}