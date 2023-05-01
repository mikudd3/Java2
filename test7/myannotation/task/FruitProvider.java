package com.lanqiao.javalearn.java2.test7.myannotation.task;

import java.lang.annotation.*;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    int id() default -1;//供应商编号

    String name() default "";//供应商名称

    String address() default "";//供应商地址
}


