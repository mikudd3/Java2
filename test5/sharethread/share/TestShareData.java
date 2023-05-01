package com.lanqiao.javalearn.java2.test5.sharethread.share;

/**
 * @project: 多线程数据共享
 * @author: mikudd3
 * @version: 1.0
 */
public class TestShareData {
    static int data = 0;

    public static void main(String[] args) {
        ShareThread1 st1 = new ShareThread1();
        ShareThread2 st2 = new ShareThread2();
        new Thread(st1).start();
        new Thread(st2).start();
    }

    //内部类，访问类中静态成员变量data
    static class ShareThread1 implements Runnable {
        public void run() {
            while (data < 10) {
                try {
                    Thread.sleep(1000);
                    System.out.println("这个小于10的数据是：" + data++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //内部类，访问类中静态成员变量data
    static class ShareThread2 implements Runnable {
        public void run() {
            while (data < 100) {
                data++;
            }
        }
    }
}