package com.lanqiao.javalearn.java2.test5.sharethread.sellticket;

/**
 * @project: 多线程下的售票系统
 * @author: mikudd3
 * @version: 1.0
 */
public class SellTicketsData {
    public static void main(String[] args) {
        new Thread(new SellThread()).start();

    }
}

// 创建子线程类 SellThread
class SellThread implements Runnable {
    static int data = 100;  //车票数量

    @Override
    public void run() {
        //创建线程
        ShareThread1 st1 = new ShareThread1();
        ShareThread2 st2 = new ShareThread2();
        ShareThread3 st3 = new ShareThread3();
        ShareThread4 st4 = new ShareThread4();
        //启动线程
        new Thread(st1).start();
        new Thread(st2).start();
        new Thread(st3).start();
        new Thread(st4).start();
    }

    //内部类，访问类中静态成员变量data
    private static class ShareThread1 implements Runnable {

        public void run() {
            while (data > 0) {
                try {
                    Thread.sleep(1000);
                    System.out.println("售票窗口1 票号：" + data--);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //内部类，访问类中静态成员变量data
    private static class ShareThread2 implements Runnable {
        public void run() {
            while (data > 0) {
                try {
                    Thread.sleep(1000);
                    System.out.println("售票窗口2 票号：" + data--);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //内部类，访问类中静态成员变量data
    private static class ShareThread3 implements Runnable {
        public void run() {
            while (data > 0) {
                try {
                    Thread.sleep(1000);
                    System.out.println("售票窗口3 票号：" + data--);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //内部类，访问类中静态成员变量data
    private static class ShareThread4 implements Runnable {
        public void run() {
            while (data > 0) {
                try {
                    Thread.sleep(1000);
                    System.out.println("售票窗口4 票号：" + data--);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

