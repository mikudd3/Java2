package com.lanqiao.javalearn.java2.test2.generic_3.car;

/**
 * @project: 车类
 * @author: mikudd3
 * @version: 1.0
 */
public class Vehicle {
    private String name;    //车名
    private int oil;        //车油

    public Vehicle() {
    }

    public Vehicle(String name, int oil) {
        this.name = name;
        this.oil = oil;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOil() {
        return oil;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    @Override
    public boolean equals(Object obj) {
        // 如果 obj 参数为 null 时，无须比较，直接返回 false 即可。
        if (obj == null) {
            return false;
        }
        //如果当前对象和obj的内存地址相同，则二者必须指向同一个对象，因此返回true即可
        if (this == obj) {
            return true;
        }

        //如果当前对象和obj参数对象的类型不一致，也无须比较，直接返回false即可
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        //如果当前对象和Obj的所有属性，这里值name和oil都相同，也认为二者的比较结果为true
        if (obj instanceof Vehicle) {
            Vehicle vehicle = (Vehicle) obj;
            //用传入的Obj，和当前对象this比较
            if (this.name.equals(vehicle.getName()) && this.oil == vehicle.getOil()) {
                return true;
            }

        }
        return false;
    }

    // 用对象的所有属性值作为 hashcode 的计算因子
    @Override
    public int hashCode() {
        int result = 0;
        result = result * 31 + name.hashCode();
        result = result * 31 + oil;

        return result;
    }
}
