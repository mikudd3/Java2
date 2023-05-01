package com.lanqiao.javalearn.java2.test5.produce;

import java.util.ArrayList;
import java.util.List;


/**
 * @project: 实现生产者和消费者线程协作
 * @author: mikudd3
 * @version: 1.0
 */


public class TestProdCons {
    //定义一个存放热狗的集合，里面存放的是整数，代表热狗编号
    private static final List<Integer> hotDogs = new ArrayList<Integer>();

    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            new Producer(i).start();
        }
        for (int i = 1; i <= 5; i++) {
            new Consumer(i).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    //生产者线程，以热狗集合作为对象锁，所有对热狗集合的操作互斥
    private static class Producer extends Thread {
        int i = 1;
        int pid = -1;

        public Producer(int id) {
            this.pid = id;
        }

        public void run() {
            while (true) {
                try {
                    //模拟消耗的时间
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (hotDogs) {
                    if (hotDogs.size() < 10) {
                        //热狗编号，如300002代表编号为3的生产者生产的第2个热狗
                        hotDogs.add(pid * 10000 + i);
                        System.out.println("生产者" + pid + "生产热狗，编号为：" + pid * 10000 + i);
                        i++;
                        //唤醒hotDogs对象锁上所有调用wait()方法的线程
                        hotDogs.notifyAll();
                    } else {
                        try {
                            System.out.println("热狗数已到10个，等待消费！");
                            hotDogs.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    //消费者线程，以热狗集合作为对象锁，所有对热狗集合的操作互斥
    private static class Consumer extends Thread {
        int cid = -1;

        public Consumer(int id) {
            this.cid = id;
        }

        public void run() {
            while (true) {
                synchronized (hotDogs) {
                    try {
                        //模拟消耗的时间
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (hotDogs.size() > 0) {
                        System.out.println("消费者" + this.cid + "正在消费一个热狗，其编号为： " + hotDogs.remove(0));
                        hotDogs.notifyAll();
                    } else {
                        try {
                            System.out.println("已没有热狗，等待生产！");
                            hotDogs.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
