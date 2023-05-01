package com.lanqiao.javalearn.java2.test2.iterator_4;


/**
 * @project: 轿车类
 * @author: mikudd3
 * @version: 1.0
 */
public class Car extends Vehicle {
    //品牌
    private String brand = "红旗";

    //构造方法，指定车名和品牌
    public Car(String name, String brand) {
        super(name, 20);
        this.brand = brand;
    }

    //获取品牌
    public String getBrand() {
        return brand;
    }
}