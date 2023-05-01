package com.lanqiao.javalearn.java2.test7.challenge;

/**
 * @project: 车类型
 * @author: mikudd3
 * @version: 1.0
 */
public class Car {
    private String name;
    private int size;

    public Car(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public Car() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
