package com.lanqiao.javalearn.java2.test2.iterator_4;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @project: 迭代器输出treeset
 * @author: mikudd3
 * @version: 1.0
 */
public class DataShowIterator {
    public static void main(String[] args) {
        // 程序代码
        TreeSet ts = new TreeSet();

        //数据
        Integer[] array = new Integer[]{12, 45, 23, 86, 100, 78, 546, 1, 45, 99, 136, 23};

        //将数据加入集合
        for (Integer value : array) {
            ts.add(value);
        }

        // 使用迭代器循环输出
        Iterator<Integer> it = ts.iterator();

        while(it.hasNext()){
            Integer i = it.next();
            System.out.println(i);
        }
    }
}
