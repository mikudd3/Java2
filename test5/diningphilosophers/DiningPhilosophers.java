package com.lanqiao.javalearn.java2.test5.diningphilosophers;

/**
 * @project: 哲学家进餐
 * @author: mikudd3
 * @version: 1.0
 */
public class DiningPhilosophers implements Runnable {
    private int tid;
    private Object lock;
    private boolean[] fork;

    public DiningPhilosophers(int i, Object lock, boolean[] fork) {
        this.tid = i;
        this.lock = lock;
        this.fork = fork;
    }

    @Override
    public void run() {
        eating();
        thinking();
    }

    private void eating() {
        synchronized (lock) {
            while (!fork[tid] && !fork[(tid + 1) % 5]) {
                System.out.println(tid + "号哲学家拿起了左边的筷子");
                fork[tid] = true;
                System.out.println(tid + "号哲学家拿起了右边的筷子");
                fork[(tid + 1) % 5] = true;
                System.out.println(tid + "号哲学家正在吃饭");
            }
        }

    }

    private void thinking() {
        synchronized (lock) {
            while (fork[tid] && fork[(tid) % 5]) {
                System.out.println(tid + "号哲学家放下了左边的筷子");
                fork[tid] = false;
                System.out.println(tid + "号哲学家放下了右边的筷子");
                fork[(tid + 1) % 5] = false;
                System.out.println(tid + "号哲学家正在思考");
            }
        }
    }
}
/*
public class DiningPhilosophers extends Thread {

    private boolean[] fork;

    private Object lock;

    private int philosopher = -1;

    public DiningPhilosophers(int philosopher, Object lock, boolean[] fork){
        this.philosopher = philosopher;
        this.lock = lock;
        this.fork = fork;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (fork[philosopher] || fork[(philosopher + 1) % 5]) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            pickLeftFork(philosopher);
            pickRightFork(philosopher);
            System.out.println(philosopher + " 号哲学家开始吃饭");
            lock.notifyAll();
            putLeftFork(philosopher);
            putRightFork(philosopher);
            System.out.println(philosopher + " 号哲学家陷入沉思");
        }
    }

    public void pickLeftFork(int philosopher) {
        fork[philosopher] = true;
        System.out.println(philosopher + " 号哲学家拿起了左边的叉子");
    }

    public void pickRightFork(int philosopher) {
        fork[(philosopher + 1) % 5] = true;
        System.out.println(philosopher + " 号哲学家拿起了右边的叉子");
    }

    public void putLeftFork(int philosopher) {
        fork[philosopher] = false;
        System.out.println(philosopher + " 号哲学家放下了左边的叉子");
    }

    public void putRightFork(int philosopher) {
        fork[(philosopher + 1) % 5] = false;
        System.out.println(philosopher + " 号哲学家放下了右边的叉子");
    }
}*/
