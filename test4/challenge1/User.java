package com.lanqiao.javalearn.java2.test4.challenge1;

/**
 * @project: 用户类
 * @author: mikudd3
 * @version: 1.0
 */
public class User {
    private int ID = 10001;
    int age = 22;
    protected String username = "张三";
    public String password = "123456";

    private void userPrivate() {
    }

    int getAge() {
        return age;
    }

    protected String userProtected() {
        return username;
    }

    public String userPublic() {
        return password;
    }
}
