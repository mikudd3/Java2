package com.lanqiao.javalearn.java2.test2.map_5;

import java.util.*;

/**
 * @project: 统计字符出现次数
 * @author: mikudd3
 * @version: 1.0
 */
public class Statistics {
    public Map statis(String s) {
        //去除字符串的非字母部分
        s = s.replaceAll("[^a-zA-Z]", "");
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            //取key
            String key = String.valueOf(s.charAt(i));
            if (m.containsKey(key)) {
                m.put(key, m.get(key) + 1);
            } else {
                m.put(key, 1);
            }

        }
        return m;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String s = input.next();
        //调用方法
        Map<String, Integer> m = new Statistics().statis(s);
        //遍历
        //获取键集合
        Set<String> keys = m.keySet();
        //获取迭代器
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            Integer value = m.get(key);
            System.out.println(key + "=" + value);
        }

    }
}
