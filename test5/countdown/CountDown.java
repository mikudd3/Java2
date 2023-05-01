package com.lanqiao.javalearn.java2.test5.countdown;

import java.util.Scanner;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public class CountDown implements Runnable {

    // 程序代码
    public void go() {
        CountDown c = new CountDown();
        Thread t = new Thread(c);
        t.start();
    }

    @Override
    public void run() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入倒计时秒数：");
        int m = input.nextInt();
        try {
            while (m > 0) {
                System.out.println(m--);
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new CountDown().go();
    }
}
