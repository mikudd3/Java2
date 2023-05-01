package com.lanqiao.javalearn.java2.test5.test.t3;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public class TestMyNum {
    public static void main(String[] args) {
        //创建参数对象
        MyNum mr = new MyNum();

        //创建线程对象
        Thread t1 = new Thread(mr, "线程A");
        Thread t2 = new Thread(mr, "线程B");

        //启动线程
        t1.start();
        t2.start();
    }
}
