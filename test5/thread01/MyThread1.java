package com.lanqiao.javalearn.java2.test5.thread01;

/**
 * @project: 继承自 Thread 类创建线程类
 * @author: mikudd3
 * @version: 1.0
 */
class MyThread1 extends Thread{
    //无参构造方法，调用父类构造方法设置线程名称
    public MyThread1(){
        super("我的线程1");
    }
    @Override
    public void run() {
        //通过循环判断，输出20次
        for(int i = 0;i < 20;i ++){
            System.out.println(this.getName() + "运行第" + (i + 1) + "次");
        }
    }
}
