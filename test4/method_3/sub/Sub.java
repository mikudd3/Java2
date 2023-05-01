package com.lanqiao.javalearn.java2.test4.method_3.sub;

/**
 * @project: 子类
 * @author: mikudd3
 * @version: 1.0
 */
public class Sub {
    //私有的属性
    private int subPri = 11;
    //默认的属性
    int subDef = 12;

    //被保护的属性
    protected double subPro = 13;
    //公共的属性
    public String subPub = "14";

    //私有的方法
    private void subPrivate() {
        System.out.println(subPri);
    }

    //默认的方法
    int subDefault() {
        return subDef;
    }

    // 被保护的方法
    protected double subProtected() throws ArithmeticException {
        return subPro;
    }

    //公共的方法
    public String subPublic() {
        return subPub;
    }

}

//父类
class Super {
    //私有的属性
    private int supPri = 1;
    //默认的属性
    int supDef = 2;
    //被保护的属性
    protected String supPro = "3";
    //公共的属性
    public double supPub = 4;

    //私有的方法
    private void supPrivate() {
        System.out.println(supPri);
    }

    //不加访问修饰符的方法
    int supDefault() {
        return supDef;
    }

    //被保护的方法
    protected String supProtected() {
        return supPro;
    }

    //公共的方法
    public double supPub() throws ArithmeticException, NumberFormatException {
        return supPub;
    }
}

