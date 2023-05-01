package com.lanqiao.javalearn.java2.test2.tool_6.student;


import java.util.*;

/**
 * @project: 班级成绩排序
 * @author: mikudd3
 * @version: 1.0
 */
public class Results {
    static List<Student> data = new ArrayList<>();

    static Random r = new Random();

    /**
     * 生成数据
     */
    public static void initData() {
        //创建学生信息
        int id = 180201;

        for (int i = 1; i <= 40; i++) {
            String name = "同学" + i;
            int score = 50 + r.nextInt(50);
            data.add(new Student(id, name, score));
            id++;
        }
    }

    /**
     * 排序
     */
    public static void adjust() {
        data.sort((o1, o2) -> (o2.getScore() == o1.getScore()) ? (o2.getId() - o1.getId()) : (o2.getScore() - o1.getScore()));
    }

    /**
     * 输出
     */
    public static void print() {
        Iterator<Student> it = data.iterator();

        while (it.hasNext()) {
            Student s = it.next();
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        initData();
        adjust();
        print();

    }


}
