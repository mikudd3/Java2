package com.lanqiao.javalearn.java2.test7.myannotation.task;

import java.lang.reflect.Field;

/**
 * @project: 小蓝写了一个水果店的收银系统，
 * 在做生意的时候他常常需要描述一种水果的信息，请你帮他编写几个注解用来对水果类的属性进行描述。
 * @author: mikudd3
 * @version: 1.0
 */
public class FruitInfoUtil {
    public static void main(String[] args) {
        String strFruitName = "水果名称:";
        String strFruitColor = "水果颜色:";
        String strFruitProvider = "生产供应商:";
        try {
            // 加载 AnnotationTest.class类
            Class<?> clazz = FruitInfoUtil.class.getClassLoader().loadClass("com.lanqiao.javalearn.java2.test7.myannotation.task.Apple");
            // 获取属性
            //通过反射获取属性信息
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                //判断字段属性
                if (field.isAnnotationPresent(FruitName.class)) {//FruitName的注解是否在field上 如果在true 不在返回false
                    //获取某一个方法上的某个注解，要是没有该注解则返回null，有的话就返回该注解的类型
                    FruitName annotaion = field.getAnnotation(FruitName.class);
                    System.out.println(strFruitName + annotaion.value());
                } else if (field.isAnnotationPresent(FruitColor.class)) {
                    FruitColor annotation = field.getAnnotation(FruitColor.class);
                    System.out.println(strFruitColor + annotation.fruitColor());
                } else if (field.isAnnotationPresent(FruitProvider.class)) {
                    FruitProvider annotation = field.getAnnotation(FruitProvider.class);
                    System.out.println(strFruitProvider + "供应商编号：" + annotation.id()
                            + "\t供应商名称：" + annotation.name() + "\t供应商地址：" + annotation.address());

                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
