package com.lanqiao.javalearn.java2.test5.org;

/**
 * @project: 线程的插队运行
 * @author: mikudd3
 * @version: 1.0
 */
public class JoinThread {

    public static void main(String[] args) throws Exception {
        //创建线程
        Thread t = new Thread(new EmergencyThread());
        t.start();  //开启线程
        for (int i = 0; i < 5; i++) {

            if (i < 6) {
                t.join();   //调用 join() 方法
            }
            System.out.println("正常情况：" + i + "号车出发");
            Thread.sleep(500);  //线程休眠 500 毫秒
        }
    }
}
