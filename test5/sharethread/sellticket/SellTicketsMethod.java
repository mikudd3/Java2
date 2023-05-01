package com.lanqiao.javalearn.java2.test5.sharethread.sellticket;


/**
 * @project: 解决售票系统的数据共享问题 2
 * @author: mikudd3
 * @version: 1.0
 */
public class SellTicketsMethod {
    public static void main(String[] args) {
        new Thread(new SellThread3()).start();
    }
}

class SellThread3 implements Runnable {
    private static int data = 100;

    @Override
    public void run() {
        sell();
    }

    // 程序代码
    private static synchronized void sell() {
        new Thread(new ShareThread1()).start();
        new Thread(new ShareThread2()).start();
        new Thread(new ShareThread3()).start();
        new Thread(new ShareThread4()).start();
    }

    //内部类，访问类中静态成员变量data
    private static class ShareThread1 implements Runnable {

        public void run() {
            while (data > 0) {
                System.out.println("售票窗口1 票号：" + data--);
            }
        }
    }

    //内部类，访问类中静态成员变量data
    private static class ShareThread2 implements Runnable {
        public void run() {
            while (data > 0) {
                System.out.println("售票窗口2 票号：" + data--);
            }
        }
    }

    //内部类，访问类中静态成员变量data
    private static class ShareThread3 implements Runnable {
        public void run() {
            while (data > 0) {
                System.out.println("售票窗口3 票号：" + data--);
            }
        }
    }

    //内部类，访问类中静态成员变量data
    private static class ShareThread4 implements Runnable {
        public void run() {
            while (data > 0) {
                System.out.println("售票窗口4 票号：" + data--);
            }
        }
    }

}
