package com.lanqiao.javalearn.java2.test4.method_3.getconstructor;

import java.lang.reflect.Constructor;

/**
 * @project: 获取 String 类的所有构造方法信息
 * @author: mikudd3
 * @version: 1.0
 */
public class StringConstructors {
    /**
     * 获取所有String类中构造方法
     */
    public void getConstructorInfos() {

        // 程序代码
        try {
            //获取Class对象
            Class<?> c = Class.forName("java.lang.String");

            //获取构造器对象数组
            Constructor<?>[] con = c.getDeclaredConstructors();

            System.out.println("构造方法总数：" + con.length);

            //输出所有构造方法
            for (Constructor<?> constructor : con) {
                System.out.println("构造方法名: " + constructor.getName());

                //获取构造方法参数
                //获取参数数组
                Class<?>[] ptl = constructor.getParameterTypes();
                System.out.println("构造方法参数：");
                //输出构造方法参数
                if (ptl.length == 0) {
                    System.out.println("构造方法无参数");
                } else {
                    for (Class<?> p : ptl) {
                        System.out.print(p.getName() + " ");
                    }
                    System.out.println();
                }
                //输出异常信息
                //获取异常数组
                Class<?>[] etl = constructor.getExceptionTypes();
                //输出异常
                if (etl.length == 0) {
                    System.out.println("无抛出异常");
                } else {
                    for (Class<?> e : etl) {
                        System.out.print(e.getName() + " ");
                    }
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new StringConstructors().getConstructorInfos();
    }
}
