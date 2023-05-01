package com.lanqiao.javalearn.java2.test7.myannotation.org;

/**
 * @project: 自定义注解
 * @author: mikudd3
 * @version: 1.0
 */

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MyMessage {

    String name() default "lanqiao";

    int num() default 0;

    String desc();

}
