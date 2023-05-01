package com.lanqiao.javalearn.java2.test2.list_2.student;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @project: LinkedList 与 Comparator 结合使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestLinkedList {
    public static void main(String[] args) {
        //用 LinkedList 存储学生对象
        LinkedList stuLL = new LinkedList();
        stuLL.add(new Student("王云", 1));
        stuLL.add(new Student("南天华", 3));
        stuLL.add(new Student("刘静涛", 2));
        //使用sort方法，按姓名比较器进行排序
        Collections.sort(stuLL, new NameComparator());
        System.out.println("*** 按学生姓名顺序输出学生信息 ***");
        for (Object object : stuLL) {
            System.out.println(object);
        }
        //使用sort方法，按学号比较器进行排序
        stuLL.sort(new NumComparator());
        System.out.println("*** 按学生学号顺序输出学生信息 ***");
        for (Object object : stuLL) {
            System.out.println(object);
        }
    }
}
