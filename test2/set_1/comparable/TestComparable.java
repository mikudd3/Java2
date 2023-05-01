package com.lanqiao.javalearn.java2.test2.set_1.comparable;

import java.util.Set;
import java.util.TreeSet;

/**
 * @project: 测试类
 * @author: mikudd3
 * @version: 1.0
 */
public class TestComparable {
    public static void main(String[] args) {
        //用有序的TreeSet 存储学生对象
        Set stuTs = new TreeSet();

        stuTs.add(new Student("王云", 1));
        stuTs.add(new Student("南天华", 3));
        stuTs.add(new Student("刘静涛", 2));
        stuTs.add(new Student("张平", 3));

        for (Object stu : stuTs) {
            System.out.println(stu);
        }
    }
}
