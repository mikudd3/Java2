package com.lanqiao.javalearn.java2.test5.thread01;

/**
 * @project: 实现Runnable接口创建线程类
 * @author: mikudd3
 * @version: 1.0
 */
class MyThread2 implements Runnable {
    String name = "我的线程2";

    @Override
    public void run() {
        //通过循环判断，输出20次
        for (int i = 0; i < 20; i++) {
            System.out.println(this.name + "运行第" + (i + 1) + "次");
        }
    }
}
