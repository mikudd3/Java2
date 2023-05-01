package com.lanqiao.javalearn.java2.test9.defaultmethod;

/**
 * @project: 实现多接口默认方法同名的情况下，接口默认方法的使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestDefaultMethod2 {
    public static void main(String[] args) {
        System.out.println(new DefaultMethodClass3().defaultMethod());
        System.out.println(new DefaultMethodClass4().defaultMethod());
    }
}
// 定义的接口 DefaultInterface2 中的默认方法名和 DefaultInterface 接口中是一样的
interface DefaultInterface2{
    default String defaultMethod() {
        return "hello default method 2";
    }
}

// 实现类 DefaultMethodClass3 实现了两个接口
class DefaultMethodClass3 implements DefaultInterface, DefaultInterface2 {
    @Override
    public String defaultMethod() {
        //指定使用的是 DefaultInterface 接口中的 defaultMethod() 方法
        return DefaultInterface.super.defaultMethod();
    }
}

// 实现类 DefaultMethodClass4 实现了两个接口
class DefaultMethodClass4 implements DefaultInterface, DefaultInterface2{
    @Override
    public String defaultMethod() {
        //指定使用的是 DefaultInterface 接口中的 defaultMethod() 方法
        return DefaultInterface2.super.defaultMethod();
    }
}