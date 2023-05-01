package com.lanqiao.javalearn.java2.test1.exceptiontest_5;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @project: 模拟报名系统
 * @author: mikudd3
 * @version: 1.0
 */

public class Registration {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("请输入您的姓名(不小于 1 个字符且不超过 20 个字符)：");
        String name = inputName();
        System.out.println("请输入您的年龄(18~35)：");
        int age = inputAge();
        System.out.println("请选择您的性别：1. 男    2. 女");
        String gender = setGender();
        System.out.println("您的报名信息为： 姓名：" + name + "；年龄：" + age + "；性别：" + gender);
    }

    /**
     * 输入姓名的方法
     */
    public static String inputName() {
        // 补充代码
        String name;

        //如果姓名长度小于1或者大于20，则姓名不合法
        while (true) {
            name = input.next();
            try {
                if (name.length() > 1 && name.length() < 20) {
                    break;
                } else {
                    throw new NameException("输入的姓名不合法，合法姓名长度应该大于1并且小于20，请重新输入：");
                }
            } catch (NameException e) {
                System.out.println(e.getMessage());
            }
        }
        return name;
    }

    /**
     * 输入年龄的方法
     */
    public static int inputAge() {
        // 补充代码
        String age;
        while (true) {
            try {
                age = input.next();
                if (!age.matches("-?\\d+(\\.\\d+)?")) {
                    throw new AgeException("输入的年龄不合法，请输入数字！");
                } else {
                    if (Integer.parseInt(age) > 17 & Integer.parseInt(age) < 35) {
                        break;
                    } else {
                        throw new AgeException("输入的年龄不合法，合法年龄应该在18~35范围内，请重新输入：");
                    }
                }

            } catch (AgeException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(age);
    }

    /**
     * 选择性别的方法
     */
    public static String setGender() {
        // 补充代码
        String gender;
        while (true) {
            gender = input.next();
            try {
                if ("1".equals(gender) || "2".equals(gender)) {
                    break;
                } else {
                    throw new SexException("输入的性别不合法，合法性别应该输入1或2，请重新输入：");
                }
            } catch (SexException e) {
                System.out.println(e.getMessage());
            }
        }
        return "1".equals(gender) ? "男" : "女";
    }

    // 内部异常类
    //姓名异常类
    private static class NameException extends Exception {
        //无参构造
        public NameException() {
            System.out.println("输入的姓名不合法，合法姓名不小于 1 个字符且不超过 20 个字符");
        }

        public NameException(String message) {
            super(message);
        }
    }

    //年龄异常类
    private static class AgeException extends Exception {
        public AgeException() {
            System.out.println("输入的年龄不合法，合法年龄应该在18~35范围内");
        }

        public AgeException(String message) {
            super(message);
        }
    }

    //性别异常类
    private static class SexException extends Exception {
        public SexException() {
            System.out.println("输入的性别不合法，合法性别应该输入1或2");
        }

        public SexException(String message) {
            super(message);
        }
    }
}
