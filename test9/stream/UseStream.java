package com.lanqiao.javalearn.java2.test9.stream;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class UseStream {
    public static void main(String[] args) {
        // 提供集合数据
        List<Integer> numbers = Arrays.asList(-1, -3, 0, 7, 9, -1);

        // 程序代码
        //使用 forEach 方法进行遍历输出，提示打印输出的字符串为 “集合数据转换为流对象”。
        System.out.println("集合数据转换为流对象");
        Stream<Integer> stream1 = numbers.stream();
        stream1.forEach(System.out::println);

        //需要输出元素值大于零的元素个数，提示打印输出的字符串为 “集合数据过滤后的数据个数为”。
        System.out.print("集合数据过滤后的数据个数为");
        Stream<Integer> stream2 = numbers.stream().filter((num) -> num > 0);
        System.out.println(stream2.count());

        //需要将元素进行绝对值计算后输出结果，提示打印输出的字符串为 “集合数据进行绝对值运算生成新的流对象”。
        System.out.println("集合数据进行绝对值运算生成新的流对象");
        Stream<Integer> stream3 = numbers.stream().map(Math::abs);
        stream3.forEach(System.out::println);

        //需要限制输出的元素为 2 个，提示打印输出的字符串为 “集合数据转换为流对象进行限流操作”。
        System.out.println("集合数据转换为流对象进行限流操作");
        Stream<Integer> stream4 = numbers.stream().limit(2);
        stream4.forEach(System.out::println);

        /*List li = new ArrayList();
        li.add(1);
        li.add(3);
        li.add(2);
        li.add(4);
        li.add(5);
        Stream<Integer> stream = li.stream();
        System.out.println(stream.reduce(0,(a,b)->a-b));*/
    }
}
