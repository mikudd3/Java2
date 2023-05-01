package com.lanqiao.javalearn.java2.test2.list_2.student;

import java.util.Comparator;

/**
 * @project: 学生学号比较器
 * @author: mikudd3
 * @version: 1.0
 */
class NumComparator implements Comparator {
    //实现 Comparator 接口的 compare() 方法
    public int compare(Object op1, Object op2) {
        Student eOp1 = (Student) op1;
        Student eOp2 = (Student) op2;
        return eOp1.stuNum - eOp2.stuNum;
    }
}
