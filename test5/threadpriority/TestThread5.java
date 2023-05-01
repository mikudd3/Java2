package com.lanqiao.javalearn.java2.test5.threadpriority;

/**
 * @project: 线程优先级的使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestThread5 {
    public static void main(String[] args) {
        QThread2 qt = new QThread2();
        SThread2 st = new SThread2();

        //设置优先级
        qt.setPriority(Thread.MIN_PRIORITY);

        st.setPriority(Thread.MIN_PRIORITY);

        //启动线程
        qt.start();
        st.start();

        //获取线程的优先级别
        System.out.println("QThread2 线程优先级为：" + qt.getPriority());
        System.out.println("SThread2 线程优先级为：" + st.getPriority());

        // 获取qt线程是否在活动状态
        System.out.println("QThread2 线程是否在活动状态：" + qt.isAlive());
        // 获取st线程是否在活动状态
        System.out.println("SThread2 线程是否在活动状态：" + st.isAlive());
    }
}

class QThread2 extends Thread {
    int i = 0;

    @Override
    public void run() {
        while (i < 30) {
            System.out.println("QThread2 正在输出数字：" + i++);

        }
    }
}

class SThread2 extends Thread {
    int i = 0;

    @Override
    public void run() {
        while (i < 30) {
            System.out.println("SThread2 正在输出数字：" + i++);
        }
    }
}
