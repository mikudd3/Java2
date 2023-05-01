package com.lanqiao.javalearn.java2.test5.test.t6;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public class MyLottery extends Thread {
    ArrayList<Integer> list;

    public MyLottery(ArrayList<Integer> list) {
        this.list = list;
    }

    //线程一
    static ArrayList<Integer> list1 = new ArrayList<>();
    //线程二
    static ArrayList<Integer> list2 = new ArrayList<>();

    @Override
    public void run() {
        while (true) {
            synchronized (MyLottery.class) {
                if (list.size() == 0) {
                    if ("抽奖箱1".equals(getName())) {
                        System.out.println("抽奖箱1" + list1);
                    } else {
                        System.out.println("抽奖箱2" + list2);
                    }
                    break;
                } else {
                    //继续抽奖
                    Collections.shuffle(list);
                    int prize = list.remove(0);
                    if ("抽奖箱1".equals(getName())) {
                        list1.add(prize);
                    } else {
                        list2.add(prize);
                    }
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
