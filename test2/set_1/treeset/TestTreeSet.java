package com.lanqiao.javalearn.java2.test2.set_1.treeset;

import java.util.Set;
import java.util.TreeSet;

/**
 * @project: TreeSet的使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestTreeSet {
    public static void main(String[] args) {
        Set ts = new TreeSet();

        ts.add("王云");
        ts.add("刘静涛");
        ts.add("南天华");

        System.out.println(ts);
    }
}
