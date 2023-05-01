package com.lanqiao.javalearn.java2.test5.test.t5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @project: 抽奖箱抽奖
 * @author: mikudd3
 * @version: 1.0
 */
public class MyLottery extends Thread {
    ArrayList<Integer> list;

    public MyLottery(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        //1.循环
        //2.同步代码块
        //3.判断
        //4.判断

        while (true) {
            synchronized (MyLottery.class) {
                if (list.size() == 0) {
                    break;
                } else {
                    //继续抽奖
                    Collections.shuffle(list);
                    int prize = list.remove(0);
                    System.out.println(getName() + "又产生了一个" + prize + "元大奖");
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
