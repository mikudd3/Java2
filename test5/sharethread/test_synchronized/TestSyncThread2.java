package com.lanqiao.javalearn.java2.test5.sharethread.test_synchronized;

/**
 * @project: 采用同步方法实现线程同步
 * @author: mikudd3
 * @version: 1.0
 */
public class TestSyncThread2 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new SyncThread2(i)).start();
        }
    }
}

class SyncThread2 implements Runnable {
    private int tid;

    public SyncThread2(int id) {
        this.tid = id;
    }

    @Override
    public void run() {
        doTask(this.tid);
    }

    //通过类的静态方法实现互斥访问
    private static synchronized void doTask(int tid) {

        for (int i = 0; i < 10; i++) {
            System.out.println("线程ID名为：" + tid + "正在输出：" + i);
        }
    }
}
