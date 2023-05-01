package com.lanqiao.javalearn.java2.test7.myannotation;


import java.lang.annotation.Annotation;

/**
 * @project: 通过反射机制获取注解数据
 * @author: mikudd3
 * @version: 1.0
 */
public class TestAnnotation7 {
    @MyAnnotation(value = "Java")
    @Deprecated
    public void getObjectInfo() throws NoSuchMethodException, SecurityException, ClassNotFoundException {
        // 利用反射机制获取注解
        Annotation[] arr = Class.forName("com.lanqiao.javalearn.java2.test7.myannotation.TestAnnotation7").getMethod("getObjectInfo").getAnnotations();
        // 遍历每个注解对象
        for (Annotation an : arr) {
            // 如果注解是 MyAnnotation 类型
            if (an instanceof MyAnnotation) {
                System.out.println("MyAnnotation 注解：" + an);
                System.out.println("MyAnnotation 注解的 name 属性值：" + ((MyAnnotation) an).name());
                System.out.println("MyAnnotation 注解的 age 属性值：" + ((MyAnnotation) an).age());
            } else {
                System.out.println("非 MyAnnotation 注解：" + an);
            }
        }
    }

    public static void main(String[] args) {
        try {
            new TestAnnotation7().getObjectInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
