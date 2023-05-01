package com.lanqiao.javalearn.java2.test5.contralthread;

/**
 * @project: 守护线程的应用
 * @author: mikudd3
 * @version: 1.0
 */

public class TestDaemonThread {
    public static void main(String[] args) {
        Thread useThread = new Thread(new Worker());
        Thread daemonThread = new Thread(new Timer());

        //设置守护线程
        daemonThread.setDaemon(true);

        //启动用户和守护线程
        useThread.start();

        daemonThread.start();

        System.out.println("Worker 是否为守护线程：" + useThread.isDaemon());
        System.out.println("Timer 是否为守护线程：" + daemonThread.isDaemon());

    }
}

class Worker implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("《Java变成词典》第" + i + "次更新");
        }
    }
}


class Timer implements Runnable {
    @Override
    public void run() {
        long currentTime = System.currentTimeMillis();
        long processTime = 0;

        while (true) {
            if ((System.currentTimeMillis() - currentTime) > processTime) {
                processTime = System.currentTimeMillis() - currentTime;

                System.out.println("程序运行时间：" + processTime);
            }
        }
    }


}

