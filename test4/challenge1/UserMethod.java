package com.lanqiao.javalearn.java2.test4.challenge1;

import java.lang.reflect.Method;

/**
 * @project: 获取指定类的方法信息
 * @author: mikudd3
 * @version: 1.0
 */

public class UserMethod {
    public static void main(String args[]) {
        try {
            Class<?> c = Class.forName("com.lanqiao.javalearn.java2.test4.challenge1.User");
            //调用getDeclaredMethods()返回Method对象数组，存放该类所有方法（不含继承的）
            Method[] mlist = c.getDeclaredMethods();
            System.out.println("User类getDeclaredMethods()得到的方法如下：");
            //遍历所有方法，打印方法的名称、所在类以及返回值类型信息
            for (int i = 0; i < mlist.length; i++) {
                Method m = mlist[i];
                System.out.println("===============================");
                System.out.println("方法" + (i + 1) + "名称为：" + m.getName());//得到方法名
                System.out.println("该方法所在的类：" + m.getDeclaringClass());
                System.out.println("返回值类型为：" + m.getReturnType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
