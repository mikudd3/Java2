package com.lanqiao.javalearn.java2.test1.triangleexception_4;

import java.util.Scanner;

/**
 * @project: 三角形测试类
 * @author: mikudd3
 * @version: 1.0
 */
public class Test {
    //判断是否可以构成三角形
    public void isTriangle(int a, int b, int c) throws TriangleException {
        if (a + b > c && a + c > b && b + c > a) {
            System.out.println("三角形的边长分别为：a=" + a + "b=" + b + "c=" + c);
        } else {
            throw new TriangleException("不能构成三角形");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        int a = input.nextInt();
        System.out.println("请输入第二个数字：");
        int b = input.nextInt();
        System.out.println("请输入第三个数字：");
        int c = input.nextInt();
        Test t = new Test();
        try {
            t.isTriangle(a, b, c);

        } catch (TriangleException e) {
            System.out.println(e.getMessage());
        } finally {
            input.close();
        }
    }
}
