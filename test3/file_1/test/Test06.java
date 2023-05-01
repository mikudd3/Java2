package com.lanqiao.javalearn.java2.test3.file_1.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 统计一个文件夹中每种文件的个数并打印。（考虑子文件夹）
 */
public class Test06 {
    public static void main(String[] args) throws IOException {

        File file = new File("E:\\Java\\Lanqiao");
        HashMap<String, Integer> hm = getCount(file);
        System.out.println(hm);
    }

    /**
     * 统计一个文件夹中每种文件的个数
     *
     * @param src
     * @return
     */
    public static HashMap<String, Integer> getCount(File src) {
        //1.定义集合用来统计
        HashMap<String, Integer> hm = new HashMap<>();
        //2.进入src文件夹
        File[] files = src.listFiles();
        //3.遍历数组
        for (File file : files) {
            //4.判断，如果是文件，统计
            if (file.isFile()) {
                //a.txt
                String name = file.getName();
                String[] arr = name.split("\\.");
                if (arr.length >= 2) {
                    String endName = arr[arr.length - 1];
                    if (hm.containsKey(endName)) {
                        //存在
                        int count = hm.get(endName);
                        count++;
                        hm.put(endName, count);
                    } else {
                        //不存在
                        hm.put(endName, 1);
                    }
                }
            } else {
                //5.判断，如果是文件夹，递归
                //sonMap里面是子文件中每一种文件的个数
                HashMap<String, Integer> sonMap = getCount(file);
                //hm:  txt=1  jpg=2  doc=3
                //sonMap: txt=3 jpg=1
                //遍历sonMap把里面的值累加到hm当中
                Set<Map.Entry<String, Integer>> entries = sonMap.entrySet();
                for (Map.Entry<String, Integer> entry : entries) {
                    String key = entry.getKey();
                    int value = entry.getValue();
                    if (hm.containsKey(key)) {
                        //存在
                        int count = hm.get(key);
                        count = count + value;
                        hm.put(key, count);
                    } else {
                        //不存在
                        hm.put(key, value);
                    }
                }
            }
        }
        return hm;
    }
}
