package com.lanqiao.javalearn.java2.test1.myecception_3.org;

import java.util.Scanner;

/**
 * @project: 测试类
 * @author: mikudd3
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            Student s1 = new Student();
            Student s2 = new Student();
            System.out.println("请输入第一个学生姓名：");
            s1.setName(input.next());
            System.out.println("请输入第一个学生成绩：");
            s1.setScore(input.nextDouble());
            System.out.println("请输入第二个学生姓名：");
            s2.setName(input.next());
            System.out.println("请输入第一个学生成绩：");
            s2.setScore(input.nextDouble());
        } catch (ScoreException e) {
            System.out.println(e.getMessage());
        }
    }
}
