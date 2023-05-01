package com.lanqiao.javalearn.java2.test2.tool_6.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @project: Collections的使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestCollections {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("w");
        list.add("o");
        list.add("r");
        list.add("l");
        list.add("d");

        System.out.println("排序前：                " + list);
        System.out.println("该集合中的最大值  " + Collections.max(list));
        System.out.println("该集合中的最小值  " + Collections.min(list));
        //排序
        Collections.sort(list);
        System.out.println("排序后：                " + list);
        //使用二分查找，查找前须保证被查找集合是自然有序排列的
        System.out.println("r在集合中的索引为： " + Collections.binarySearch(list, "r"));
        //随机排序
        Collections.shuffle(list);
        System.out.println("再shuffle排序后：       " + list);
        //反转
        Collections.reverse(list);
        System.out.println("再reverse排序后：       " + list);
        //交换
        Collections.swap(list, 1, 4);
        System.out.println("索引为1、4的元素交换后：" + list);
        //替换
        Collections.replaceAll(list, "w", "d");
        System.out.println("把w都换成d后的结果：    " + list);
        //填充
        Collections.fill(list, "s");
        System.out.println("全部填充为s后的结果：   " + list);
    }
}
