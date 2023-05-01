package com.lanqiao.javalearn.java2.test5.thread02;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public class ThreadData {
    // 创建子线程程序代码
    private static class MyThread1 extends Thread {
        public MyThread1() {
            super("线程1");
        }

        @Override
        public void run() {
            for (int i = 0; i < 30; i++) {
                System.out.println(this.getName() + "数据为：" + (i + 1));
            }
        }


    }

    private static class MyThread2 extends Thread {
        public MyThread2() {
            super("线程2");
        }

        @Override
        public void run() {
            for (int i = 0; i < 30; i++) {
                System.out.println(this.getName() + "数据为：" + (i + 1));
            }
        }


    }

    private static class MyThread3 extends Thread {
        public MyThread3() {
            super("线程3");
        }

        @Override
        public void run() {
            for (int i = 0; i < 30; i++) {
                System.out.println(this.getName() + "数据为：" + (i + 1));
            }
        }


    }

    public static void main(String[] args) throws InterruptedException {
        // 启动子线程程序代码
        Thread t1 = new MyThread1();
        Thread t2 = new MyThread2();
        Thread t3 = new MyThread3();

        //启动线程
        t1.start();
        t2.start();
        t3.start();

    }
}
