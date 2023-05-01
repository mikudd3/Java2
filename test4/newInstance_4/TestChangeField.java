package com.lanqiao.javalearn.java2.test4.newInstance_4;

import java.lang.reflect.Field;

/**
 * @project: 使用 Field 类修改类中私有属性值
 * @author: mikudd3
 * @version: 1.0
 */
public class TestChangeField {
    public static void main(String args[]) {
        try {
            Class<?> c = Class.forName("com.lanqiao.javalearn.java2.test4.newInstance_4.Sub");
            Sub sub = (Sub) c.newInstance();
            //通过属性名获得Field对象
            Field f = c.getDeclaredField("subPri");//subPri为私有属性
            //取消属性的访问权限控制，即使private属性也可以进行访问
            f.setAccessible(true);
            //调用get(Object o)方法取得对象o对应属性值
            System.out.println("取消访问权限控制后访问subPri，其值为：" + f.get(sub));
            //调用set(Object o,Object v)方法设置对象o对应属性值
            f.set(sub, 20);
            System.out.println("f.set(sup, 20)后访问subPri，其值为：" + f.get(sub));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
