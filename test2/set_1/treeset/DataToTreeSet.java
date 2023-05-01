package com.lanqiao.javalearn.java2.test2.set_1.treeset;

import java.util.TreeSet;

/**
 * @project: 使用 TreeSet 存储数据信息
 * @author: mikudd3
 * @version: 1.0
 */
public class DataToTreeSet {
    public static void main(String[] args) {

        // 程序代码
        TreeSet ts = new TreeSet();

        //数据
        Integer[] array = new Integer[]{12, 45, 23, 86, 100, 78, 546, 1, 45, 99, 136, 23};

        //将数据加入集合
        for (Integer value : array) {
            ts.add(value);
        }

        System.out.println(ts);

    }
}
