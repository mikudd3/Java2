package com.lanqiao.javalearn.java2.test7.myannotation.org;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @project: 使用反射机制处理自定义注解
 * @author: mikudd3
 * @version: 1.0
 */
public class MyMessageProcessor {
    public static void main(String[] args) {
        try {
            // 加载 AnnotationTest.class类
            Class<?> clazz = MyMessageProcessor.class.getClassLoader().loadClass("com.lanqiao.javalearn.java2.test7.myannotation.org.AnnotationTest");
            // 获取属性
            Field[] fields = clazz.getDeclaredFields();
            //遍历属性
            for (Field field : fields) {
                MyMessage myMessage = field.getAnnotation(MyMessage.class);
                System.out.println("name:" + myMessage.name() + ",num:" + myMessage.num() + ",desc:" + myMessage.desc());
            }

            // 获取类中的方法
            Method[] methods = clazz.getMethods();
            // 遍历方法
            for (Method method : methods) {
                // 判断方法是否带有MyMessage注解
                if (method.isAnnotationPresent(MyMessage.class)) {
                    // 获取所有注解 method.getDeclaredAnnotations();
                    // 获取MyMessage注解
                    MyMessage myMessage = method.getAnnotation(MyMessage.class);
                    System.out.println("name:" + myMessage.name() + ",num:" + myMessage.num() + ",desc:" + myMessage.desc());
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
