package com.lanqiao.javalearn.java2.test5.contralthread;

/**
 * @project: 计数功能线程
 * @author: mikudd3
 * @version: 1.0
 */
class CountThread extends Thread {

    private int i = 0;

    public CountThread() {
        super("计数线程");
    }

    //通过设置i= 100，让线程终止
    public void stopIt() {
        i = 100;
    }

    public void run() {
        try {
            while (i < 100) {
                System.out.println(this.getName() + "记数：" + (i + 1));
                i++;
                //每隔2秒
                sleep(2000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
