package com.lanqiao.javalearn.java2.test9.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @project: Stream 流的基本使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestStream {
    public static void main(String[] args) {
        // 使用集合接口Collection中的方法生成流
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("ab");
        list.add("abc");
        list.add("hello");
        list.add("stream");
        // stream()会以单线程的方式，将集合中的数据转为Stream类型
        Stream<String> stream1 = list.stream();
        // 使用filter()和limit()方法进行转换流操作
        Stream<String> stream;
        //先使用filter()方法筛选出stream1中字符串长度大于2的元素
        stream = stream1.filter((x) -> x.length() > 2)
                // 然后再通过limit()方法从结果元素中只保留两个元素
                .limit(2);
        // 使用forEach()遍历并输出 stream 中的元素
        stream.forEach(System.out::println);

        // parallelStream()会以多线程的并发方式，将集合中的数据转为Stream类型
        Stream<String> stream2 = list.parallelStream();

        //使用map方法进行转换流操作
        stream = stream2.map(str -> str.toUpperCase());
        //统计stream2中的元素个数
        long count = stream.count();
        System.out.println("stream 中的元素个数是：" + count);

        // 使用数组类Arrays中的方法生成流
        String[] arr = new String[]{"hello", "stream"};
        Stream<String> stream3 = Arrays.stream(arr);
        stream = stream3.map(str -> str.toUpperCase());
        //终止流
        //reduce()方法可以聚合流中的所有元素，也就是将Stream中的所有元素依次按表达式计算，最终得出一个值
        String reduce = stream.reduce("", (a, b) -> a + b);
        System.out.println("reduce：" + reduce);

        // 使用Stream接口中的方法生成流
        Stream<String> stream4 = Stream.of(arr);
        // 使用forEach()遍历并输出 stream4 中的元素
        stream4.forEach(x -> System.out.print(x + "\t"));
    }
}