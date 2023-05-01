package com.lanqiao.javalearn.java2.test5.threadgroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: 获取 JVM 中已经存在的线程组
 * @author: mikudd3
 * @version: 1.0
 */

public class TestJVMThreadGroup {
    //获得根线程组
    private static ThreadGroup getRootThreadGroup() {
        //获得当前线程组
        ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();
        while (true) {
            //如果getParent()返回值非空，则不是根线程组
            if (rootGroup.getParent() != null) {
                //获得空线程
                rootGroup = rootGroup.getParent();

            } else {
                //如果到达根线程组，则退出循环
                break;
            }
        }
        //返回根线程组
        return rootGroup;
    }

    //获得规定线程组中所有线程
    public static List<String> getThreads(ThreadGroup group) {
        //创建保持线程名的列表
        List<String> threadList = new ArrayList<>();

        //根据活动线程数创建线程数组
        Thread[] threads = new Thread[group.activeCount()];

        //复制线程到线程数组
        int count = group.enumerate(threads, false);

        //遍历线程数组将线程名及其所在组保持到列表中
        for (int i = 0; i < count; i++) {
            threadList.add(group.getName() + "线程组：" + threads[i].getName());


        }
        return threadList;
    }


    //获得线程数组中子线程组
    public static List<String> getThreadGroups(ThreadGroup group) {
        //获得规定线程组中线程名
        List<String> threadList = getThreads(group);
        //创建线程组数组
        ThreadGroup[] groups = new ThreadGroup[group.activeCount()];

        //复制子线程组到线程组数组
        int count = group.enumerate(groups, false);

        //遍历所有子线程组
        for (int i = 0; i < count; i++) {
            //利用getThreads()方法获得线程名列表
            threadList.addAll(getThreads(groups[i]));
        }

        //返回所有线程名
        return threadList;
    }

    public static void main(String[] args) {
        for (String s : getThreadGroups(getRootThreadGroup())) {

            //遍历输出列表中的字符串
            System.out.println(s);

        }
    }
}
