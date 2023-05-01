package com.lanqiao.javalearn.java2.test4.newInstance_4;

/**
 * @project: 动态的创建对象
 * @author: mikudd3
 * @version: 1.0
 */

/**
 * 子类
 */
public class Sub extends Super {
    private int subPri = 11;
    int subDef = 12;
    protected double subPro = 13;
    public String subPub = "14";

    public Sub() {

    }

    public Sub(int pri, int def, double pro, String pub) {
        this.subPri = pri;
        this.subDef = def;
        this.subPro = pro;
        this.subPub = pub;
    }

    protected Sub(int pri, int def, double pro) {
        this(pri, def, pro, "14");
    }

    Sub(int pri, int def) throws Exception {
        this(pri, def, 13.0, "14");
    }

    private Sub(int pri) {
        this(pri, 12, 13.0, "14");
    }

    private void subPrivate() {
        System.out.println(subPri);
    }

    int subDefault() {
        return subDef;
    }

    protected double subProtected() throws ArithmeticException {
        return subPro;
    }

    public String subPublic() {
        return subPub;
    }
}

// 父类
class Super {
    private int supPri = 1;
    int supDef = 2;
    protected String supPro = "3";
    public double supPub = 4;

    public Super() {
    }

    public Super(int pri, int def, String pro, double pub) {
        this.supPri = pri;
        this.supDef = def;
        this.supPro = pro;
        this.supPub = pub;
    }

    protected Super(int pri, int pac, String pro) {
        this(pri, pac, pro, 4);
    }

    Super(int pri, int pac) throws Exception {
        this(pri, pac, "4", 3.0);
    }

    private Super(int pri) {
        this(pri, 2, "4", 3.0);
    }

    private void supPrivate() {
        System.out.println(supPri);
    }

    int supDefault() {
        return supDef;
    }

    protected String supProtected() {
        return supPro;
    }

    public double supPublic() throws ArithmeticException, NumberFormatException {
        return supPub;
    }
}
