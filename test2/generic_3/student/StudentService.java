package com.lanqiao.javalearn.java2.test2.generic_3.student;

import java.util.HashSet;

/**
 * @project: 录入学生信息
 * @author: mikudd3
 * @version: 1.0
 */
public class StudentService {
    // 录入学生信息
    public boolean addStudent(HashSet<Student> hs) {
        hs.add(new Student("张三", "一年级"));
        hs.add(new Student("张三", "一年级"));
        hs.add(new Student("李四", "二年级"));
        hs.add(new Student("小桃子", "三年级"));


        return true;
    }

    // 显示学生信息
    public void showStudent(HashSet<Student> hs) {
        for (Student s : hs) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {

        StudentService ss = new StudentService();
        HashSet<Student> hs = new HashSet<>();
        if (ss.addStudent(hs)) {
            System.out.println("录入学生信息成功");
        } else {
            System.out.println("录入学生信息失败");
        }
        ss.showStudent(hs);
    }
}
