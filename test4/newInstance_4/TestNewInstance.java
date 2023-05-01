package com.lanqiao.javalearn.java2.test4.newInstance_4;

/**
 * @project: 通过 newInstance() 方法创建新对象
 * @author: mikudd3
 * @version: 1.0
 */
public class TestNewInstance {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("com.lanqiao.javalearn.java2.test4.newInstance_4.Sub");
            //通过Class类的newInstance()方法创建对象
            Sub sub = (Sub) c.newInstance();
            System.out.println(sub.subPublic());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
