package com.lanqiao.javalearn.java2.test2.iterator_4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 使用迭代器遍历集合数据
 */
public class TestIterator {
    public static void main(String[] args) {
        // 创建 HashSet 集合，用于存放车辆
        Set<Vehicle> vehSet = new HashSet<>();
        // 创建两个轿车对象、两个卡车对象，并加入 HashSet 集合中
        Vehicle c1 = new Car("战神", "长城");
        Vehicle c2 = new Car("跑得快", "红旗");
        Vehicle t1 = new Truck("大力士", "5吨");
        Vehicle t2 = new Truck("大力士二代", "10吨");
        vehSet.add(c1);
        vehSet.add(c2);
        vehSet.add(t1);
        vehSet.add(t2);
        // 使用迭代器循环输出
        Iterator<Vehicle> it = vehSet.iterator();
        System.out.println("*** 显示集合中元素信息 ***");
        while (it.hasNext()) {
            Vehicle vehicle = it.next();
            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                //调用 Car 类的特有方法 getBrand()
                System.out.println("该车是轿车，其品牌为：" + car.getBrand());
            } else {
                Truck truck = (Truck) vehicle;
                //调用 Truck 类的特有方法 getLoad()
                System.out.println("该车是卡车，其吨位为：" + truck.getLoad());
            }
            System.out.println("车辆名称：" + vehicle.getName());
            // 集合元素分隔显式
            System.out.println("--------------------------");
        }
    }
}
