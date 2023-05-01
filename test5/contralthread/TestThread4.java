package com.lanqiao.javalearn.java2.test5.contralthread;

/**
 * @project: join() 方法的使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestThread4 {
    public static void main(String[] args) {
        SThread st = new SThread();
        QThread qt = new QThread(st);
        st.start();
        qt.start();
    }
}

class QThread extends Thread {

    int i = 0;
    Thread t = null;

    //构造方法，传入一个线程对象
    public QThread(Thread t) {
        super("QThread线程");
        this.t = t;
    }

    public void run() {
        try {
            while (i < 100) {

                //当i=5时，调用SThread线程对象的join()方法，等线程t执行完毕再执行本线程
                if (i != 5) {
                    Thread.sleep(500);
                    System.out.println("QThread正在每隔0.5秒输出数字：" + i++);
                } else {
                    t.join();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SThread extends Thread {
    int i = 0;
    //从0输出到99

    public void run() {
        try {
            while (i < 100) {
                Thread.sleep(1000);
                System.out.println("Thread正在每隔1秒输出数字：" + i++);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

