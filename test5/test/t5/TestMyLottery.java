package com.lanqiao.javalearn.java2.test5.test.t5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @project: 有一个抽奖池, 该抽奖池中存放了奖励的金额, 该抽奖池中的奖项为 {10,5,20,50,100,200,500,800,2,80,300,700};
 * 创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”
 * 随机从抽奖池中获取奖项元素并打印在控制台上,格式如下:
 * 每次抽出一个奖项就打印一个(随机)
 * 抽奖箱1 又产生了一个 10 元大奖
 * 抽奖箱1 又产生了一个 100 元大奖
 * 抽奖箱1 又产生了一个 200 元大奖
 * 抽奖箱1 又产生了一个 800 元大奖
 * 抽奖箱2 又产生了一个 700 元大奖
 * .....
 * @author: mikudd3
 * @version: 1.0
 */
public class TestMyLottery {
    public static void main(String[] args) {
        //创建奖池
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700);

        //创建线程
        Thread t1 = new MyLottery(list);
        Thread t2 = new MyLottery(list);

        //设置名字
        t1.setName("抽奖箱1");
        t2.setName("抽奖箱2");

        //启动线程
        t1.start();
        t2.start();
    }
}
