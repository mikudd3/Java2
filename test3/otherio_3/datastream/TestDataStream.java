package com.lanqiao.javalearn.java2.test3.otherio_3.datastream;

import java.io.*;

/**
 * @project: 数据流的使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestDataStream {
    static final String dataFile = "src/com/lanqiao/javalearn/java2/test3/charstream";//数据存储文件

    //标识类型：1代表桥车、2代表卡车
    static final int[] types = {1, 1, 2, 2,};
    static final String[] names = {"战神", "跑得快", "大力士", "大力士二代"};

    static final int[] oils = {20, 40, 20, 30};
    static final int[] losss = {0, 20, 0, 30};
    static final String[] others = {"长城", "红旗", "5吨", "10吨"};

    static DataOutputStream out = null;
    static DataInputStream in = null;

    public static void main(String[] args) {

        try {
            //输出数据流，向dataFile输出数据
            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)));

            for (int i = 0; i < types.length; i++) {
                out.writeInt(types[i]);
                //使用UTF-8编码一个字符串写入基础输出流
                out.writeUTF(names[i]);
                out.writeInt(oils[i]);
                out.writeInt(losss[i]);
                out.writeUTF(others[i]);
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

        try {
            int type, oil, loss;
            String name, other;

            //输出数据流，从dataFile读出数据
            in = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile)));
            while (true) {
                type = in.readInt();
                name = in.readUTF();
                oil = in.readInt();
                loss = in.readInt();
                other = in.readUTF();

                if (type == 1) {
                    System.out.println("显示车辆信息：\n车型：轿车 车辆名称为：" + name +
                            " 品牌是：" + other + " 油量是：" + oil + " 车损度为：" + loss);
                } else {
                    System.out.println("显示车辆信息：\n车型：卡车 车辆名称为：" + name +
                            " 吨位是：" + other + " 油量是：" + oil + " 车损度为：" + loss);
                }
            }
        } catch (IOException e) {
            //EOFException作为读取结束的标志
            System.err.println("数据读取结束");
        } finally {
            try {
                if(in != null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
