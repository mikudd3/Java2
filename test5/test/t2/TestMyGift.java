package com.lanqiao.javalearn.java2.test5.test.t2;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public class TestMyGift {

    public static void main(String[] args) {
        for (int i = 1; i <= 2; i++) {
            new MyGift(i).start();
        }
    }
}
