package com.lanqiao.javalearn.java2.test4.reflect_1;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @project: 反射机制的基本使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestReflect {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //输入类全名
        System.out.println("请输入一个Java类全名：");
        String cName = input.next();
        //调用方法
        showMethod(cName);
        //资源释放
        input.close();

    }

    /**
     * 显式类中所有方法
     */
    public static void showMethod(String name) {
        try {
            Class<?> c = Class.forName(name);
            //获取方法，并返回方法数组
            Method m[] = c.getDeclaredMethods();
            //输出
            System.out.println("该Java类的方法有：");

            for (int i = 0; i < m.length; i++) {
                System.out.println(m[i].toString());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

