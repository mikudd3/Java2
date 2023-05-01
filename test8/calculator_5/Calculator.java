package com.lanqiao.javalearn.java2.test8.calculator_5;

/**
 * @project: 计算器类
 * @author: mikudd3
 * @version: 1.0
 */
public class Calculator {
    //存储运算结果的静态变量
    private static int result;

    //加法
    public void add(int n) {
        result = result + n;
    }

    //减法，有错误，应该是“result = result - n”
    public void subtract(int n) {
        result = result - 1;
    }

    //乘法，此方法尚未实现
    public void multiply(int n) {
    }

    //除法
    public void divide(int n) {
        result = result / n;
    }

    //平方
    public void square(int n) {
        result = n * n;
    }

    //清除结果
    public void clear() {
        result = 0;
    }

    //获取运算结果
    public int getResult() {
        return result;
    }
}
