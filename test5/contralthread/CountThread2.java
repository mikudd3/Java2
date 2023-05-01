package com.lanqiao.javalearn.java2.test5.contralthread;

/**
 * @project: 计数功能线程
 * @author: mikudd3
 * @version: 1.0
 */
class CountThread2 extends Thread {
    private int i = 0;

    public CountThread2() {
        super("计数线程");
    }

    public void run() {
        while (i < 10) {
            try {

                System.out.println(this.getName() + "记数：" + (i + 1));
                i++;

                sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("程序捕获了InterruptedException 异常！");
            }
            System.out.println("计数线程运行1次!");
        }
    }
}
