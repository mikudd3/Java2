package com.lanqiao.javalearn.java2.test2.list_2.car;

/**
 * @project: 卡车类
 * @author: mikudd3
 * @version: 1.0
 */
public class Truck extends Vehicle {
    // 吨位
    private String load = "10吨";

    //构造方法，指定车名和品牌
    public Truck(String name, String load) {
        super(name, 20);
        this.load = load;
    }

    //获取吨位
    public String getLoad() {
        return load;
    }
}
