package com.lanqiao.javalearn.java2.test1.testexception_1;

import java.util.Scanner;

/**
 * @project: 异常出现体验
 * @author: mikudd3
 * @version: 1.0
 */
public class TestException {
    public void method1() {
        /**
         * 会出现 ArrayIndexOutOfBoundsException 异常
         * 数组越界异常
         */
        String[] names = {"小凳子", "小椅子", "小桌子"};
        //数组个数为3，最后一个数字的下标为2
        //下标3已经超过了2，会出现数组下标越界异常
        for (int i = 0; i < 4; i++) {
            System.out.println(names[i]);
        }
        System.out.println("over");
    }

    public void method2() {
        //苹果数
        int appleNUm = 0;
        //学生数
        int stuNum = 0;
        System.out.println("**_现在给孩子们分苹果_**");
        Scanner input = new Scanner(System.in);
        System.out.print("请输入桌子上有几个苹果：");
        appleNUm = input.nextInt();

        //如果输入孩子数为 0，则要求用户再次输入
        while (stuNum == 0) {
            System.out.print("请输入班上有几个孩子（孩子数不能为 0）：");
            stuNum = input.nextInt();
        }
//        System.out.print("请输入班上有几个孩子：");
//        stuNum = input.nextInt();

        System.out.println("班上每个孩子分得多少苹果：" + appleNUm / stuNum);
        System.out.println("孩子们非常开心！");
    }

    public static void main(String[] args) {
        var te = new TestException();
        //te.method1();
        te.method2();
    }
}
