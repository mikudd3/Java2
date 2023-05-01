package com.lanqiao.javalearn.java2.test5.org;

/**
 * @project: 线程的插队运行
 * @author: mikudd3
 * @version: 1.0
 */
//线程插队
public class ExampleM10 {
    public static void main(String[] args) throws Exception{
        //创建线程
        Thread t = new Thread(new EmergencyThread1(),"线程一");
        t.start();  //开启线程
        for (int i=1;i<6;i++){

            if (i<6){
                t.join();   //调用 join() 方法
            }
            System.out.println(Thread.currentThread().getName()+"输入："+i);
            Thread.sleep(500);  //线程休眠 500 毫秒
        }
    }
}
class EmergencyThread1 implements Runnable {
    public void run() {
        for (int i = 1;i<6;i++) {
            System.out.println(Thread.currentThread().getName()+"输入："+i);
            try {
                Thread.sleep(500);  //线程休眠 500 毫秒
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
