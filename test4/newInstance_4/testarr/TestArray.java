package com.lanqiao.javalearn.java2.test4.newInstance_4.testarr;

import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * @project: 一维动态数组的创建和使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            Class<?> c = Class.forName("java.lang.String");
            System.out.println("请输入班级人数：");
            int stuNum = input.nextInt();

            //创建字符串数组
            Object arr = Array.newInstance(c, stuNum);
            System.out.println("请输入需要给学号为？的学生输入姓名：");
            int stuNo = input.nextInt();
            System.out.println("请输入该学生的姓名：");
            String stuName = input.next();
            //给数组赋值
            Array.set(arr, (stuNo - 1), stuName);

            //获取元素值
            System.out.println("学号为：" + stuNo + "的学生姓名为：" + Array.get(arr, (stuNo - 1)));


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            input.close();
        }
    }
}
