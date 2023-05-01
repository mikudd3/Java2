package com.lanqiao.javalearn.java2.test5.org;

/**
 * @project: 线程的插队运行
 * @author: mikudd3
 * @version: 1.0
 */
public class EmergencyThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("紧急情况：" + i + "号车出发");
            try {
                Thread.sleep(500);  //线程休眠 500 毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
