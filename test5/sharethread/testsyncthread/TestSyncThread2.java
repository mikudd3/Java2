package com.lanqiao.javalearn.java2.test5.sharethread.testsyncthread;

/**
 * @project: 启动多个线程，不希望每个线程交替执行。
 * 使用当前对象进行上锁
 * @author: mikudd3
 * @version: 1.0
 */

/**
 * 启动多个线程，不希望每个线程交替执行。
 */
public class TestSyncThread2 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new SyncThread2(i)).start();
        }
    }
}

// 创建线程类
class SyncThread2 implements Runnable {
    private int tid;

    public SyncThread2(int id) {
        this.tid = id;
    }

    public void run() {
        // 使用 this 作为竞争对象，代码可以变得非常简洁。
        synchronized (SyncThread2.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println("线程ID名为: " + this.tid + "正在输出：" + i);
            }
        }
        //要保证锁的唯一，而this代表的是当前的对象，创建5个的话就代表有5个this，锁不唯一
        //而SyncThread2表示类对象，只有一个是唯一的锁


//        synchronized(this) {
//            for (int i = 0; i < 10; i++) {
//                System.out.println("线程ID名为: " + this.tid + "正在输出：" + i);
//            }
//        }


    }
}
