package com.lanqiao.javalearn.java2.test2.set_1.hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * @project: 向hashset中添加数据
 * @author: mikudd3
 * @version: 1.0
 */
public class DataToHashSet {
    public static void main(String[] args) {

        // 程序代码
        //创建集合
        Set s = new HashSet();

        //添加数据
//        s.add(12);
//        s.add(45);
//        s.add(23);
//        s.add(86);
//        s.add(100);
//        s.add(78);
//        s.add(546);
//        s.add(1);
//        s.add(45);
//        s.add(99);
//        s.add(136);
//        s.add(23);

        int[] arr = new int[]{12, 45, 23, 86, 100, 78, 546, 1, 45, 99, 136, 23};
        for (int num : arr) {
            s.add(num);
        }
        System.out.println(s);
    }
}
