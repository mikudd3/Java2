package com.lanqiao.javalearn.java2.test2.set_1.car;

import java.util.HashSet;
import java.util.Set;

/**
 * @project: 测试类
 * @author: mikudd3
 * @version: 1.0
 */
public class TestVehicle {
    public static void main(String[] args) {
        Set set = new HashSet();

        System.out.println(set.add(new Vehicle("a", 70)));
        System.out.println(set.add(new Vehicle("b", 80)));
        System.out.println(set.add(new Vehicle("a", 70)));

    }
}
