package com.lanqiao.javalearn.java2.test4.newInstance_4;

import java.lang.reflect.Constructor;

/**
 * @project: 通过 Constructor类中的 newInstance() 方法创建对象
 * @author: mikudd3
 * @version: 1.0
 */
public class TestNewInstance2 {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("Sub");
            //返回一个指定参数列表(int,class,int,class) 的constructor独享
            Constructor<?> con = c.getDeclaredConstructor(int.class, int.class);
            //通过 Constructor 的 newInstance(Object[] args)方法创建对象，参数为对象列表
            //参数列表对基本数据类型支持自动装箱、拆箱，所以也可以写成 newInstance(21, 22)
            Sub sub = (Sub) con.newInstance(new Object[]{21, 22});
            System.out.println(sub.subDefault());
            //返回一个无参构造方法
            Constructor<?> con2 = c.getDeclaredConstructor();
            //通过Constructor的newInstance()方法创建无参对象
            Sub sub2 = (Sub) con2.newInstance();
            System.out.println(sub2.subProtected());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
