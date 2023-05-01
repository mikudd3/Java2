package com.lanqiao.javalearn.java2.test5.test.t4;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public class TestMyRedEnvelope {
    public static void main(String[] args) {
        Thread t1 = new MyRedEnvelope();
        Thread t2 = new MyRedEnvelope();
        Thread t3 = new MyRedEnvelope();
        Thread t4 = new MyRedEnvelope();
        Thread t5 = new MyRedEnvelope();

        t1.setName("镇长");
        t2.setName("理科不行");
        t3.setName("mikudd3");
        t4.setName("小林");
        t5.setName("小李");

        t3.start();
        t4.start();
        t5.start();
        t1.start();
        t2.start();


    }
}
