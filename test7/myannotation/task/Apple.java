package com.lanqiao.javalearn.java2.test7.myannotation.task;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public class Apple {
    @FruitName("Apple")
    private String appleName;//苹果名称
    @FruitColor(fruitColor = "RED")
    private String appleColor;//苹果颜色
    @FruitProvider(id = 1, name = "陕西红富士集团", address = "陕西省西安市未央区红富士大厦")
    private String appleProvider;//生产厂商

    public Apple(String appleName, String appleColor, String appleProvider) {
        this.appleName = appleName;
        this.appleColor = appleColor;
        this.appleProvider = appleProvider;
    }

    public Apple() {

    }

    public String getAppleName() {
        return appleName;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "appleName='" + appleName + '\'' +
                ", appleColor='" + appleColor + '\'' +
                ", appleProvider='" + appleProvider + '\'' +
                '}';
    }
}

