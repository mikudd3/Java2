package itheima.java2.d02_list.arrarlist;

import java.util.ArrayList;

/**
 * @project: 存储字符串并遍历
 * 创建一个字符串集合，存储字符串元素，使用程序实现在控制台遍历该集合
 * @author: mikudd3
 * @version: 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("mikudd1");
        arr.add("mikudd2");
        arr.add("mikudd3");

        for (String s : arr) {
            System.out.print(s + " ");
        }
    }
}
