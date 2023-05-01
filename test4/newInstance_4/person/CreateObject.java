package com.lanqiao.javalearn.java2.test4.newInstance_4.person;

import java.lang.reflect.Constructor;

/**
 * @project: 反射创建 Person 对象
 * @author: mikudd3
 * @version: 1.0
 */
public class CreateObject {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("com.lanqiao.javalearn.java2.test4.newInstance_4.person.Person");
            //利用newInstance创建对象
            Constructor<?> con = c.getDeclaredConstructor(int.class,String.class);

            //创建对象
            Person p = (Person) con.newInstance(new Object[]{1,"小蓝"});
//            p.setId(1);
//            p.setName("小蓝");

            System.out.println(p);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
