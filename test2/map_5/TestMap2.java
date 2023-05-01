package com.lanqiao.javalearn.java2.test2.map_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @project: 采用 Map.Entry 方式遍历 Map 数据
 * @author: mikudd3
 * @version: 1.0
 */
public class TestMap2 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");

        //获取 Map 的全部 entry 对象
        Set<Map.Entry<String, String>> entries = map.entrySet();

        //遍历 entry 集合
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getKey();
            System.out.println(key + "," + value);
        }
    }
}
