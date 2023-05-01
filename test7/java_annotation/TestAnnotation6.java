package com.lanqiao.javalearn.java2.test7.java_annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: 内建注解的使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestAnnotation6 {
    @SuppressWarnings(value = "unchecked")
    public static void main(String[] args) {
        List names = new ArrayList();
        names.add("Tom");
        names.add("Rose");
    }
}
