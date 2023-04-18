package itheima.java2.d02_list.mycollection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @project: 增强for遍历数组
 * @author: mikudd3
 * @version: 1.0
 */
public class MyCollection2 {
    public static void main(String[] args) {
        //创建集合
        Collection<String> coll = new ArrayList<>();
        //添加数据
        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");
        coll.add("ddd");

        //增强for遍历数组
        for (String str : coll) {
            //4.next方法的两件事情：获取元素并移动指针
            System.out.println(str);
        }
    }
}
