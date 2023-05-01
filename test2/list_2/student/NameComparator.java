package com.lanqiao.javalearn.java2.test2.list_2.student;

import java.util.Comparator;

/**
 * @project: 学生姓名比较器
 * @author: mikudd3
 * @version: 1.0
 */
class NameComparator implements Comparator {
    //实现 Comparator 接口的 compare() 方法
    public int compare(Object op1, Object op2) {
        Student eOp1 = (Student) op1;
        Student eOp2 = (Student) op2;
        //通过调用 String 类的 compareTo() 方法进行比较
        return eOp1.stuName.compareTo(eOp2.stuName);
    }
}
