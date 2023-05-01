package com.lanqiao.javalearn.java2.test5.sharethread.share;

/**
 * @project: 通过对象锁解决多线程下的共享数据问题
 * @author: mikudd3
 * @version: 1.0
 */
public class TestShareData2 {
    //共享资源
    static int data = 0;

    //定义一个对象锁lock
    static final Object lock = new Object();

    public static void main(String[] args) {
        ShareThread1 st1 = new ShareThread1();
        ShareThread2 st2 = new ShareThread2();

        new Thread(st1).start();
        new Thread(st2).start();
    }

    private static class ShareThread1 implements Runnable {

        @Override
        public void run() {
            //获取对象锁
            synchronized (lock) {
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
    }

    private static class ShareThread2 implements Runnable {

        @Override
        public void run() {
            //获取对象锁
            synchronized (lock) {
                while (data < 100) {
                    data++;
                    System.out.println("SHareThread2执行完后data的值为：" + data);
                }
            }
        }
    }
}
