package com.lanqiao.javalearn.java2.test1.triangleexception_4;

/**
 * @project: 三角形异常类
 * @author: mikudd3
 * @version: 1.0
 */
public class TriangleException extends Exception {
    public TriangleException() {
        System.out.println("TriangleException : 不能构成三角形");
    }

    public TriangleException(String message) {
        super(message);
    }
}
