package com.lanqiao.javalearn.java2.test3.io_2.chario.filter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @project: 文件内容过滤
 * @author: mikudd3
 * @version: 1.0
 */
public class Filter {
    static FileReader in = null;
    static FileWriter out = null;
    static String inPathname = "src\\com\\lanqiao\\javalearn\\java2\\test3\\filter\\test.txt";    //路径
    static String outPathname = "src\\com\\lanqiao\\javalearn\\java2\\test3\\filter\\出师表.txt";    //路径
    static File f1 = new File(inPathname);
    static File f2 = new File(outPathname);

    /**
     * 从文件读取内容
     *
     * @return
     */
    public static char[] readFile() {
        char[] newChars = new char[16];
        char[] chars = new char[24];
        try {
            in = new FileReader(f1);
            in.read(chars);
            int i = 0;
            for (char c : chars) {
                if (c >= 'a' && c < 'z') {
                    continue;
                }
                newChars[i++] = c;
            }
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
        return newChars;
    }

    /**
     * 将过滤后的内容写入文件
     *
     * @param chars
     */
    public static void writerFIle(char[] chars) {
        try {
            out = new FileWriter(f2);
            for (char c : chars) {
                out.write(c);
                out.flush();
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
        char[] chars = readFile();
        writerFIle(chars);
    }
}
