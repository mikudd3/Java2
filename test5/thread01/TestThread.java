package com.lanqiao.javalearn.java2.test5.thread01;

/**
 * @project: 创建子线程类和启动子线程
 * @author: mikudd3
 * @version: 1.0
 */
public class TestThread {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new MyThread1();
        MyThread2 mt2 = new MyThread2();
        Thread t2 = new Thread(mt2);
        //启动子线程
        t1.start();
        t2.start();
    }
}
