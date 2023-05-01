package com.lanqiao.javalearn.java2.test2.set_1.treeset;

import java.util.Random;
import java.util.TreeSet;

/**
 * @project: 使用 TreeSet 生成数组
 * @author: mikudd3
 * @version: 1.0
 */
public class RandomSortArray {
    public static void main(String[] args) {

        //创建TreeSet对象
        TreeSet set = new TreeSet();

        //创建Random对象
        Random r = new Random();

        int count = 0;
        while (count < 10) {
            //提取0-99的随机数加入到集合中
            boolean succeed = set.add(r.nextInt(100));

            if (succeed) {
                count++;
            }
        }
        int size = set.size();

        //创建整型数组
        Integer[] array = new Integer[size];

        //将集合元素转换为数组
        set.toArray(array);

        System.out.println("生成不重复随机数组内容如下：");
        for (int value : array) {
            System.out.println(value + " ");
        }

    }
}
