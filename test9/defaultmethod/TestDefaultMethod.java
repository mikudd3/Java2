package com.lanqiao.javalearn.java2.test9.defaultmethod;

/**
 * @project: 访问接口中的默认方法
 * @author: mikudd3
 * @version: 1.0
 */
public class TestDefaultMethod {
    public static void main(String[] args) {
        new DefaultMethodClass().method1();
        System.out.println(new DefaultMethodClass2().defaultMethod());
    }
}

//定义接口
interface DefaultInterface {
    //默认方法，需要有方法体
    default String defaultMethod() {
        return "hello default method";
    }
}

//接口实现类
class DefaultMethodClass implements DefaultInterface {
    public void method1() {

        //实现类可以继承并使用接口中的默认方法
        String str = new DefaultMethodClass().defaultMethod();
        System.out.println(str);
    }
}

// 实现类重写接口中的默认方法
class DefaultMethodClass2 implements DefaultInterface {
    @Override
    public String defaultMethod() {
        return "override method";
    }
}
