package com.lanqiao.javalearn.java2.test7.annotation;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */

import java.lang.annotation.Documented;

@Documented
@interface MyAnnotation4 {
    String name() default "小桃子";

    int age() default 18;
}

@MyAnnotation4
public class TestAnnotation4 {

}
