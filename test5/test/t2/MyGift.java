package com.lanqiao.javalearn.java2.test5.test.t2;

/**
 * @project: 送100份礼品，当礼品小于10时不在送出
 * @author: mikudd3
 * @version: 1.0
 */
public class MyGift extends Thread {
    //礼品
    static int gift = 100;

    public MyGift() {

    }

    public MyGift(int i) {
        super("第" + i + "个人");
    }

    @Override
    public void run() {
        while (gift > 10) {
            synchronized (MyGift.class) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //礼物还剩下10个不在送出
                System.out.println(getName() + "在赠送礼物，还剩下" + gift-- + "个礼物!!!");
            }
        }
        System.out.println("礼物还剩下" + gift + "不再赠送");
    }
}
