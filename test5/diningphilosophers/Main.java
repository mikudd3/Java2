package com.lanqiao.javalearn.java2.test5.diningphilosophers;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) {

        Object lock = new Object();
        boolean[] fork = new boolean[5];
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new DiningPhilosophers(i, lock, fork));
        }
        for (int i = 0; i < 5; i++) {
            threads[i].start();
        }
    }
}
