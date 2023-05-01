package com.lanqiao.javalearn.java2.test5.test.t1;

/**
 * @project: 卖电影票
 * @author: mikudd3
 * @version: 1.0
 */
public class MyTicket1 extends Thread {
    //共享资源，电影票
    static int ticket = 1;

    public MyTicket1() {

    }

    public MyTicket1(int i) {
        super("窗口" + i);
    }

    @Override
    public void run() {
        //卖1000张电影票
        while (ticket < 1000) {
            synchronized (MyTicket1.class) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //卖电影票
                System.out.println(getName() + "正在卖第" + ticket++ + "张电影票");
            }
        }
    }
}
