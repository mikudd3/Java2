package com.lanqiao.javalearn.java2.test5.sharethread.sellticket;

/**
 * @project: 解决售票系统的数据共享问题 1
 * @author: mikudd3
 * @version: 1.0
 */
public class SellTicketsBlock {
    public static void main(String[] args) {
        new Thread(new SellThread2()).start();

    }
}

// 创建子线程类 SellThread
class SellThread2 implements Runnable {
    static int data = 100;  //车票数量

    @Override
    public void run() {
        //启动线程
        new Thread(new ShareThread1()).start();
        new Thread(new ShareThread2()).start();
        new Thread(new ShareThread3()).start();
        new Thread(new ShareThread4()).start();
    }

    //内部类，访问类中静态成员变量data
    private static class ShareThread1 implements Runnable {

        public void run() {
            synchronized (ShareThread1.class) {
                while (data > 0) {
                    System.out.println("售票窗口1 票号：" + data--);
                }
            }
        }
    }

    //内部类，访问类中静态成员变量data
    private static class ShareThread2 implements Runnable {
        public void run() {
            synchronized (ShareThread2.class) {
                while (data > 0) {
                    System.out.println("售票窗口2 票号：" + data--);
                }
            }
        }
    }

    //内部类，访问类中静态成员变量data
    private static class ShareThread3 implements Runnable {
        public void run() {
            synchronized (ShareThread3.class) {
                while (data > 0) {
                    System.out.println("售票窗口3 票号：" + data--);
                }
            }
        }
    }

    //内部类，访问类中静态成员变量data
    private static class ShareThread4 implements Runnable {
        public void run() {
            synchronized (ShareThread4.class) {
                while (data > 0) {
                    System.out.println("售票窗口4 票号：" + data--);
                }
            }
        }
    }
}