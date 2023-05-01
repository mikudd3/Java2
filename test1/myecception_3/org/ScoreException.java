package com.lanqiao.javalearn.java2.test1.myecception_3.org;

/**
 * @project: 成绩异常类
 * @author: mikudd3
 * @version: 1.0
 */
public class ScoreException extends Exception {
    public ScoreException() {
        System.out.println("ScoreException : 成绩不合理");
    }

    public ScoreException(String message) {
        super(message);
    }
}
