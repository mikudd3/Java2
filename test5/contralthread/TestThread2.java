package com.lanqiao.javalearn.java2.test5.contralthread;

import java.util.Scanner;

/**
 * @project: sleep() 方法的使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestThread2 {
    public static void main(String[] args) {

        //创建记数线程
        CountThread t = new CountThread();

        //开始线程
        t.start();

        Scanner input = new Scanner(System.in);

        System.out.println("如果想终止输出计数线程，请输入 s。");

        while (true) {
            String s = input.nextLine();
            if ("s".equalsIgnoreCase(s)) {
                t.stopIt();
                break;
            }
        }

        input.close();
    }
}
