package com.lanqiao.javalearn.java2.test2.generic_3.car;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: 泛型的基本使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestGeneric {
    public static void main(String[] args) {
        //使用泛型保证集合里的数据元素都是 Vehicle 类及其子类
        List<Vehicle> vehAL = new ArrayList<>();

        Vehicle c1 = new Car("战神", "红旗");
        Vehicle c2 = new Car("跑得快", "红旗");
        Vehicle t1 = new Truck("大力士", "5吨");
        Vehicle t2 = new Truck("大力士二代", "10吨");

        vehAL.add(c1);
        vehAL.add(c2);
        vehAL.add(t1);
        //在集合索引为 1 处添加 t2
        vehAL.add(1, t2);

        //vehAL.add("大力士三代");            //编译错误，添加的是 Vehicle 类，而不是字符串
        System.out.println("*** 显示全部车辆 ***");
        //使用增强 for 循环遍历时，获取的已经是 Vehicle 对象
        for (Vehicle obj : vehAL) {
            // Vehicle中定义 oil 的默认值是 20
            System.out.println(obj.getName() + "," + obj.getOil());
        }
    }
}
