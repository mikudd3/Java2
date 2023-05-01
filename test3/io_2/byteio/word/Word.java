package com.lanqiao.javalearn.java2.test3.io_2.byteio.word;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @project: 单词归类
 * @author: mikudd3
 * @version: 1.0
 */
public class Word {
    static FileInputStream in = null;      //输入流
    static FileOutputStream out = null;    //输出流
    //相对路径
    static String pathname = "src\\com\\lanqiao\\javalearn\\java2\\test3\\word\\";    //路径
    //要创建的文件
    static String verbPathName = "verb.txt";
    static String adjectivePathName = "adjective.txt";
    static String nounPathName = "noun.txt";

    //创建集合存储对应数据
    static List<String> verb = new ArrayList<>();
    static List<String> adjective = new ArrayList<>();
    static List<String> noun = new ArrayList<>();

    /**
     * 将文件中的内容转为字符数组输出
     *
     * @return
     */
    public static String[] readFile() {
        String[] str = new String[0];
        try {
            File f = new File(pathname + "word.txt");
            //构造输入流
            in = new FileInputStream(f);
            byte[] bytes = new byte[1024];
            //获取文件字节
            int len = in.read(bytes);
            //使用相应字节创建String字符串
            String s = new String(bytes, 0, len);
            //将读取的字符分割为字符数组
            str = s.split(",");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return str;
    }

    /**
     * 对单词进行分组
     *
     * @param str
     */
    public static void makeList(String[] str) {
        //对文件进行分组
        for (String s2 : str) {
            if (s2.startsWith("verb:")) {
                //提取“verb:”后面字符串
                verb.add(s2.substring(5));
            } else if (s2.startsWith("adjective:")) {
                //提取“adjective:”后面字符串
                adjective.add(s2.substring(10));
            } else if (s2.startsWith("noun:")) {
                //提取“noun:”后面字符串
                noun.add(s2.substring(5));
            }
        }
    }

    public static void makefile(String newPathName, List<String> list) {
        try {
            File f = new File(newPathName);
            out = new FileOutputStream(f);
            for (String s : list) {
                //将字符串转为对应字节输入文件
                out.write(s.getBytes());
                //输入空格分开字符串
                out.write("  ".getBytes());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        //将文件中的内容转为字符数组输出
        String[] str = readFile();
        //对单词进行分组
        makeList(str);
        //创建文件
        makefile(pathname + verbPathName, verb);
        makefile(pathname + adjectivePathName, adjective);
        makefile(pathname + nounPathName, noun);

    }
}
