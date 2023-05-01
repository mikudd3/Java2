package com.lanqiao.javalearn.java2.test9.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;


/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */

public class LambdaTest {
    public static void main(String[] args) {
        //实例化一个对象并调用 A() 方法
        new LambdaTest().test();
    }

    public void test() {
        List<String> languages = Arrays.asList("Java", "Python", "C++", "JavaScript", "TypeScript");

        //调用Filter()方法 打印输出统计信息
        System.out.print("J 开头的语言有：");
        filter(languages, (str) -> str.startsWith("J"));

        System.out.print("t 结束的语言有：");
        filter(languages, (str) -> str.endsWith("t"));

        System.out.print("所有语言：");
        filter(languages, str -> true);

        System.out.print("名字长度大于 4 的语言：");
        filter(languages, str -> str.length() > 4);
    }

    public void filter(List<String> names, Predicate<String> predicate) {
        //遍历字符串，调用 Predicate接口的test()方法判断符合条件的语言并打印
        names.forEach(str -> {
            if (predicate.test(str)) {
                System.out.print(str + " ");
            }
        });
        System.out.println();
    }
}
