package com.lanqiao.javalearn.java2.test7.challenge;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public class CarIns {
    @MyTag(name = "Audi", size = 10)
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
