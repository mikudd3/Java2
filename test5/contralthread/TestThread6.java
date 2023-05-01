package com.lanqiao.javalearn.java2.test5.contralthread;

/**
 * @project: 守护线程的基本使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestThread6 {
    public static void main(String[] args) {
        DaemonThread t = new DaemonThread();

        t.start();

        System.out.println("让一切都结束吧");
    }

    //私有静态内部类
    private static class DaemonThread extends Thread {

        //在无参构造方法中设置本线程为守护线程
        public DaemonThread() {
            setDaemon(true);
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("我是后台线程");
            }
        }
    }
}
