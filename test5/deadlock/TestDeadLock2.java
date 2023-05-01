package com.lanqiao.javalearn.java2.test5.deadlock;

/**
 * @project: 巧妙的解决死锁现象
 * @author: mikudd3
 * @version: 1.0
 */
public class TestDeadLock2 implements Runnable {
    // 使用 flag 变量作为进入不同块的标志
    private boolean flag;
    private static final Object o1 = new Object();
    private static final Object o2 = new Object();

    @Override
    public void run() {
        // 获得当前线程的名字
        String threadName = Thread.currentThread().getName();
        // 输出当前线程的 flag 变量值
        System.out.println(threadName + ": flag = " + flag);
        if (flag) {
            // 为 o1 加锁
            synchronized (o1) {
                try {
                    // 线程休眠 1 秒钟
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 显示进入 o1 块
                System.out.println(threadName + "进入同步块o1准备进入 o2");
                // 为o2加锁
                synchronized (o2) {
                    // 显示进入o2块
                    System.out.println(threadName + "已经进入同步块o2");
                }
            }
        }

        if (!flag) {
            synchronized (o2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 显示进入 o2 块
                System.out.println(threadName + "进入同步块o2准备进入o1");
                // 显示进入 o1 块
                System.out.println(threadName + "已经进入同步块o1");
                //下面代码会造成死锁
//                synchronized (o1) {
//                    // 显示进入 o1 块
//                    System.out.println(threadName + "已经进入同步块o1");
//                }
            }
        }
    }

    public static void main(String[] args) {
        // 创建 TestDeadLock 对象 d1
        TestDeadLock2 d1 = new TestDeadLock2();
        // 创建 TestDeadLock 对象 d2
        TestDeadLock2 d2 = new TestDeadLock2();
        // 将 d1 的 flag 设置为 true
        d1.flag = true;
        // 将 d2 的 flag 设置为 false
        d2.flag = false;
        // 在新线程中运行 d1 的 run() 方法
        new Thread(d1).start();
        // 在新线程中运行 d2 的 run() 方法
        new Thread(d2).start();
    }
}
