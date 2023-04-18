package itheima.java2.d02_list.arrarlist;

import java.util.ArrayList;

/**
 * @project: 添加数字并遍历
 * 需求:定义一个集合，添加数字，并进行遍历。遍历格式参照:[元素1，元素2,元素3]。
 * @author: mikudd3
 * @version: 1.0
 */
public class Test03 {
    public static void main(String[] args) {
        //创建集合
        ArrayList<Integer> arr = new ArrayList<>();

        //添加元素
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);

        //遍历
        System.out.println(arr);
    }
}
