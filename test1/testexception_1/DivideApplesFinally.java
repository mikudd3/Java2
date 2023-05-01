package com.lanqiao.javalearn.java2.test1.testexception_1;

import java.util.Scanner;

/**
 * @project: 采用 finally 释放 Scanner 资源
 * @author: mikudd3
 * @version: 1.0
 */
public class DivideApplesFinally {
    //苹果数
    int appleNum = 0;
    //学生数
    int stuNum = 0;

    public String divide() {
        System.out.println("**_现在给孩子们分苹果_**");
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("请输入桌子上有几个苹果：");
            appleNum = input.nextInt();
            System.out.print("请输入班上有几个孩子：");
            stuNum = input.nextInt();
            System.out.println("班上每个孩子分得多少苹果：" + appleNum / stuNum);
            return "孩子们非常开心！";
        } catch (RuntimeException e) {
            return "请输入正确的苹果数量和孩子人数";
        } finally {
            System.out.println("Scanner 对象进行释放");
            input.close();
        }
    }

    public static void main(String[] args) {
        System.out.println(new DivideApplesFinally().divide());
    }
}
