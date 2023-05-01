package com.lanqiao.javalearn.java2.test9.defaultmethod.task;

/**
 * @project: 使用不同接口中提供的默认方法
 * @author: mikudd3
 * @version: 1.0
 */
public class UseDefaultMethod {
    public static void main(String[] args) {

        // 程序代码
        ModuleServiceImpl ms = new ModuleServiceImpl();
        ms.method1();
        ms.method2();
        ms.method();
        ms.method3();
        ms.method();

    }
}

// 创建接口 IModuleAService 程序代码
interface IModuleAService {
    void method1();

    default void method2() {
        System.out.println("IModuleAService 中的 method2 默认方法");
    }

    default void method() {
        System.out.println("IModuleAService 中的 method 默认方法");
    }
}

// 创建接口 IModuleBService 程序代码
interface IModuleBService {
    void method3();

    default void method() {
        System.out.println("IModuleBService 中的 method 默认方法");
    }
}

// 创建实现类 ModuleServiceImpl 程序代码
class ModuleServiceImpl implements IModuleAService, IModuleBService {

    @Override
    public void method1() {
        System.out.println("模块 A 中的 method1 方法实现");
    }

    @Override
    public void method2() {
        IModuleAService.super.method2();
    }

    @Override
    public void method() {
        IModuleAService.super.method();
    }

    @Override
    public void method3() {
        System.out.println("模块 B 中的 method3 方法实现");
    }
}