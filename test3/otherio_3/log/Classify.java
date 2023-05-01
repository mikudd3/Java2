package com.lanqiao.javalearn.java2.test3.otherio_3.log;

import java.io.*;
import java.util.ArrayList;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public class Classify {
    static BufferedReader in = null;
    static BufferedWriter out = null;
    //路径
    static String mainPathname = "src/com/lanqiao/javalearn/java2/test3/otherio_3/log/log.txt";
    //分类文件
    static String infoPathname = "src/com/lanqiao/javalearn/java2/test3/otherio_3/log/Info.txt";
    static String errorPathname = "src/com/lanqiao/javalearn/java2/test3/otherio_3/log/Error.txt";
    //集合
    static ArrayList<String> info = new ArrayList<>();
    static ArrayList<String> error = new ArrayList<>();
    static ArrayList<String> all = new ArrayList<>();

    /**
     * 提取文件内容
     */
    public static void readFile() {
        try {
            in = new BufferedReader(new FileReader(mainPathname));
            String s;
            while ((s = in.readLine()) != null) {
                all.add(s);
            }
//            System.out.println(all);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 对数据进行分组
     */
    public static void classifyFile() {
        for (String s : all) {
            if (s.contains("INFO")) {
                info.add(s.substring(0, 18) + s.substring(23));
            } else if (s.contains("ERROR")) {
                error.add(s.substring(0, 18) + s.substring(24));
            }
        }
        //System.out.println(info);
        //System.out.println(error);
    }

    /**
     * 将内容写入文件
     *
     * @param list
     * @param pathname
     */
    public static void writeFile(ArrayList<String> list, String pathname) {
        try {
            out = new BufferedWriter(new FileWriter(pathname));
            for (String s : list) {
                out.write(s);
                out.newLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        readFile();
        classifyFile();
        writeFile(info, infoPathname);
        writeFile(error, errorPathname);

    }
}
