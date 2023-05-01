package com.lanqiao.javalearn.java2.test5.test.t1;

/**
 * @project: MyTicket1测试
 * @author: mikudd3
 * @version: 1.0
 */
public class TestMyTicket1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 2; i++) {
            new MyTicket1(i).start();
        }
    }
}
