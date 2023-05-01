package com.lanqiao.javalearn.java2.test7.challenge;

import java.lang.reflect.Field;

/**
 * @project: 通过注解配置类参数
 * @author: mikudd3
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) {

        CarIns ann = new CarIns();
        Car c = new Car();
        // 补充代码
        try {
            Class<?> clazz = Main.class.getClassLoader().loadClass("com.lanqiao.javalearn.java2.test7.challenge.CarIns");
            // 获取属性
            Field[] fields = clazz.getDeclaredFields();
            //遍历属性
            for (Field field : fields) {
                MyTag myTag = field.getAnnotation(MyTag.class);
                c.setName(myTag.name());
                c.setSize(myTag.size());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        ann.setCar(c);
        System.out.println(ann.getCar());
    }
}
