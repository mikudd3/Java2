package com.lanqiao.javalearn.java2.test4.method_3.fieldchallenge;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @project: 获取任意类的属性和方法
 * @author: mikudd3
 * @version: 1.0
 */
public class MethodAndField {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个类全名：");
        String name = input.next();


        try {
            //创建Class对象
            Class<?> c = Class.forName(name);

            //获取方法
            Method[] mlist = c.getDeclaredMethods();

            //遍历方法数组
            for (Method method : mlist) {
                System.out.println("方法：" + method.getName());
            }

            //获取父类方法
            Method[] m = c.getMethods();
            for (Method method : m) {
                System.out.println("方法：" + method.getName());
            }

            //获取属性数组
            Field[] flist = c.getDeclaredFields();

            //遍历属性数组
            for (Field field : flist) {
                System.out.println("属性：" + field.getName());
            }


        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            input.close();
        }
    }
}
