package com.lanqiao.javalearn.java2.test1.testthrows_2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @project: 主动抛出异常继续解决分苹果问题
 * @author: mikudd3
 * @version: 1.0
 */
public class DivideApplesThrow {
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
            if (0 == appleNum) {
                throw new RuntimeException("苹果数量不能为零，否则孩子们要失望了");
            }
            System.out.print("请输入班上有几个孩子：");
            stuNum = input.nextInt();
            System.out.println("班上每个孩子分得多少苹果：" + appleNum / stuNum);
            return "孩子们非常开心！";
        } catch (InputMismatchException e) {
            System.out.println("苹果数量和孩子人数必须为整数值");
        } catch (ArithmeticException e) {
            System.out.println("孩子人数不能为零");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            input.close();
            System.out.println("Scanner 对象进行释放");
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new DivideApplesThrow().divide());
    }
}
