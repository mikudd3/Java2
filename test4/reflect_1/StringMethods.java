package com.lanqiao.javalearn.java2.test4.reflect_1;

import java.lang.reflect.Method;

/**
 * @project: 列出 String 类提供使用的所有方法
 * @author: mikudd3
 * @version: 1.0
 */
public class StringMethods {
    /**
     * 获取所有String类中方法
     */
    public void getStringMethodInfos() {

        // 程序代码
        String cName = "java.lang.String";

        try {
            //创建
            Class<?> c = Class.forName(cName);

            //提取方法
            Method[] m = c.getDeclaredMethods();

            System.out.println("String类中一共有：" + m.length + "个方法");

            //遍历方法
            for (Method method : m) {
                System.out.println(method);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new StringMethods().getStringMethodInfos();
    }

}