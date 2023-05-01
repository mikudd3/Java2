package com.lanqiao.javalearn.java2.test2.list_2.car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @project: ArrayList 类的基本使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestArrayList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 创建 ArrayList 集合，用于存放车辆
        List vehal = new ArrayList();

        Vehicle c1 = new Car("战神", "长城");
        Vehicle c2 = new Car("跑得快", "红旗");

        Vehicle t1 = new Truck("大力士", "5吨");
        Vehicle t2 = new Truck("大力士二代", "10吨");

        // 将 c1 添加到 vehAL 集合的末尾
        vehal.add(c1);
        vehal.add(c2);
        vehal.add(t1);
        vehal.add(t2);

        System.out.println("*** 显示全部车辆 ***");
        // 用于显示序号
        int num = 1;
        // 增强for循环遍历
        for (Object obj : vehal) {
            if (obj instanceof Car) {
                Car car = (Car) obj;
                System.out.println(num + "该车是轿车，其车名为：" + car.getName());
            } else {
                Truck truck = (Truck) obj;
                System.out.println(num + " 该车是卡车，其车名为：" + truck.getName());

            }
            num++;
        }
        System.out.print("请输入要显示车名的车辆编号：");
        String name = ((Vehicle) vehal.get(input.nextInt() - 1)).getName();
        System.out.println("车辆名称为：" + name);
    }
}

