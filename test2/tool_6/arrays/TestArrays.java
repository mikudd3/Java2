package com.lanqiao.javalearn.java2.test2.tool_6.arrays;

import java.util.Arrays;

/**
 * @project: Arrays 工具类的使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestArrays {
    public static void output(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = new int[5];

        //填充数据
        Arrays.fill(array, 8);
        System.out.println("填充数组Arrays.fill(array,8)：");

        output(array);

        //将数组索引为1到4的元素赋值为6
        Arrays.fill(array, 1, 4, 6);
        System.out.println("将数组索引为1到4的元素赋值为6 Arrays.fill(array, 1, 4, 6)：");

        output(array);

        int[] array1 = {12, 9, 21, 43, 15, 6, 19, 77, 18};
        //对数组索引为3到7的元素进行排序
        System.out.println("排序前，数组的序列为：");
        output(array1);
        Arrays.sort(array1, 3, 7);
        System.out.println("对数组索引为3到7的元素进行排序：Arrays.sort(array1,3,7)：");
        output(array1);
        //对数组进行自然排序
        Arrays.sort(array1);
        System.out.println("对数组进行自然排序 Arrays.sort(array1)：");
        output(array1);

        //比较数组元素是否相等
        int[] array2 = array1.clone();
        System.out.println("数组克隆后是否相等：Arrays.equals(array1, array2):"
                + Arrays.equals(array1, array2));

        //二维数组拷贝
        int[][] array3 = {{1, 2, 3}, {4, 5, 6}};
        int[][] array4 = new int[2][3];
        for (int i = 0; i < array3.length; i++) {
            array4[i] = array3[i].clone();
        }
        System.out.println(Arrays.deepToString(array4));

        //使用二分查找法查找元素下标（数组必须是排好序的）
        System.out.println("77在数组中的索引：Arrays.binarySearch(array1, 77)："
                + Arrays.binarySearch(array1, 77));

    }
}
