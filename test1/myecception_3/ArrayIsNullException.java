package com.lanqiao.javalearn.java2.test1.myecception_3;

/**
 * @project: 自定义异常
 * @author: mikudd3
 * @version: 1.0
 */
class ArrayIsNullException extends Exception {

    /**
     * 无参构造器，传递默认异常信息
     */
    public ArrayIsNullException() {
        super("ArrayIsNullException : 数组长度为 0");
    }

    /**
     * 带异常信息的构造器
     *
     * @param message 异常信息
     */
    public ArrayIsNullException(String message) {
        super(message);
    }
}
