package com.lanqiao.javalearn.java2.test4.newInstance_4.testarr;

import java.lang.reflect.Array;

/**
 * @project: 动态创建多维数组
 * @author: mikudd3
 * @version: 1.0
 */
public class TestArray2 {
    public static void main(String args[]) {
        try {
            Class<?> c = Integer.TYPE;
            //创建一个8×10二维整型数组
            int[] dim = {8, 10};
            Object arr = Array.newInstance(c, dim);
            //arr4为一维数组
            Object arr4 = Array.get(arr, 4);
            //给arr[4][6]赋值为20
            Array.set(arr4, 6, 20);
            //获取arr[4][6]的值
            System.out.println("arr[4][6]的值为：" + Array.get(arr4, 6));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
