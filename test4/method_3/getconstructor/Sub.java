package com.lanqiao.javalearn.java2.test4.method_3.getconstructor;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public class Sub extends Super {
    // 属性省略书写
    private int subPri = 11;
    //默认的属性
    int subDef = 12;

    //被保护的属性
    protected double subPro = 13;
    //公共的属性
    public String subPub = "14";

    // 无参构造方法
    public Sub() {

    }

    // 公共的带全参的构造方法
    public Sub(int pri, int def, double pro, String pub) {
        this.subPri = pri;
        this.subDef = def;
        this.subPro = pro;
        this.subPub = pub;
    }

    // 被保护的带参的构造方法
    protected Sub(int pri, int def, double pro) {
        this(pri, def, pro, "14");
    }

    // 默认的带参的构造方法
    Sub(int pri, int def) throws Exception {
        this(pri, def, 13.0, "14");
    }

    // 私有的带参的构造方法
    private Sub(int pri) {
        this(pri, 12, 13.0, "14");
    }
    // 普通方法省略书写
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

// 父类
class Super {
    // 属性省略书写
    private int supPri = 1;
    //默认的属性
    int supDef = 2;
    //被保护的属性
    protected String supPro = "3";
    //公共的属性
    public double supPub = 4;

    // 无参构造方法
    public Super() {
    }

    // 公共的带全参的构造方法
    public Super(int pri, int def, String pro, double pub) {
        this.supPri = pri;
        this.supDef = def;
        this.supPro = pro;
        this.supPub = pub;
    }

    // 被保护的带参的构造方法
    protected Super(int pri, int pac, String pro) {
        this(pri, pac, pro, 4);
    }

    // 默认的带参的构造方法
    Super(int pri, int pac) throws Exception {
        this(pri, pac, "4", 3.0);
    }

    // 私有的带参的构造方法
    private Super(int pri) {
        this(pri, 2, "4", 3.0);
    }

    // 普通方法省略书写
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
