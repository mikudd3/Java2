package com.lanqiao.javalearn.java2.test2.set_1.hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * @project: HashSet 类的使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestSet {
    public static void main(String[] args) {
        //创建一个HashSet对象，存放学生信息
        Set nameSet = new HashSet();

        nameSet.add("王云");
        nameSet.add("刘静涛");
        nameSet.add("南天华");
        nameSet.add("雷静");
        nameSet.add("王云");//增加已有的数据元素

        System.out.println("再次添加王云是否成功：" + nameSet.add("王云"));

        System.out.println("显示集合内容：" + nameSet);

        System.out.println("集合中是否包含南天华" + nameSet.contains("南天华"));

        System.out.println("从集合中删除南天华");
        nameSet.remove("南天华");

        System.out.println("集合中是否包含南天华" + nameSet.contains("南天华"));

        System.out.println("集合中的元素个数为：" + nameSet.size());
    }
}
