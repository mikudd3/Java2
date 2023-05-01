package com.lanqiao.javalearn.java2.test4.testclass_2.person;

/**
 * @project: 获取不同类的 Class 对象
 * @author: mikudd3
 * @version: 1.0
 */
public class UseClass{
    public static void main(String[] args) throws ClassNotFoundException{

        // 程序代码
        //Student
        Class<?> c1 = new Student().getClass();
        System.out.println("当前类：" + c1.getName());
        System.out.println("父类：" + c1.getSuperclass().getName());

        //Teacher
        Class<?> c2 = Teacher.class;
        System.out.println("当前类：" + c2.getName());
        System.out.println("父类：" + c2.getSuperclass().getName());


        //Person
        Class<?> c3 = Class.forName("com.lanqiao.javalearn.java2.test4.testclass_2.person.Person");
        System.out.println("当前类：" + c3.getName());
        System.out.println("父类：" + c3.getSuperclass().getName());
    }
}
