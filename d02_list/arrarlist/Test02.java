package itheima.java2.d02_list.arrarlist;

import java.util.ArrayList;

/**
 * @project: 集合的遍历方式
 * 需求:定义一个集合，添加字符串，并进行遍历遍历格式参照:[元素1,元素2,元素3]。
 * @author: mikudd3
 * @version: 1.0
 */
public class Test02 {
    public static void main(String[] args) {
        //创建集合
        ArrayList<String> arr = new ArrayList<>();

        //添加元素
        arr.add("aaaa");
        arr.add("aaaa");
        arr.add("aaaa");
        arr.add("aaaa");

        //遍历
        System.out.println(arr);
    }
}
