package itheima.java2.d02_list.mycollection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @project: lambda表达式遍历数组
 * @author: mikudd3
 * @version: 1.0
 */
public class MyCollection3 {
    public static void main(String[] args) {
        //创建集合
        Collection<String> coll = new ArrayList<>();
        //添加数据
        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");
        coll.add("ddd");

        //lambda表达式遍历数组
        coll.forEach(s -> System.out.println(s));

    }
}
