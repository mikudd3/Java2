package com.lanqiao.javalearn.java2.test5.sharethread.testsyncthread;

/**
 * @project: 启动多个线程，不希望每个线程交替执行。
 * 使用object对象进行上锁
 * @author: mikudd3
 * @version: 1.0
 */
public class TestSyncThread {
    public static void main(String[] args) {
        Object obj = new Object();
        for (int i = 0; i < 5; i++) {
            new Thread(new SyncThread(i,obj)).start();
        }
    }
}

//创建线程类
class SyncThread implements Runnable {
    private int tid;
    private Object lock;
    public SyncThread(int id,Object obj) {
        this.tid = id;
        this.lock = obj;
    }

    @Override
    public void run() {
        //未加锁
//        for (int i = 0; i < 10; i++) {
//            System.out.println("线程ID名为：" + this.tid + "正在输出：" + i);
//        }

        //加锁后
        synchronized (lock) {
            for (int i = 0; i < 10; i++) {
                System.out.println("线程ID名为：" + this.tid + "正在输出：" + i);
            }
        }
    }
}
