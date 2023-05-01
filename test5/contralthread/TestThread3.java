package com.lanqiao.javalearn.java2.test5.contralthread;

/**
 * @project: interrupt() 方法的使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestThread3 {
    public static void main(String[] args) {
        CountThread2 t = new CountThread2();
        t.start();
        try {
            Thread.sleep(6000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //中断线程的阻塞状态
        t.interrupt();
    }
}
