package com.lanqiao.javalearn.java2.test3.nio_4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @project: 文件通道的使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestChannel {
    /**
     * 通过文件通道写入数据
     *
     * @param filename
     * @throws IOException
     */
    public void writeChannel(String filename) throws IOException {
        //创建文件输出流对象
        FileOutputStream fos = new FileOutputStream(filename);

        //通过文件输出流对象获取文件通道对象
        FileChannel channel = fos.getChannel();

        String str = "明月几时有？把酒问青天。不知天上宫阙，今夕是何年。\n我欲乘风归去，又恐琼楼玉宇，高处不胜寒。起舞弄清影，何似在人间。\n转朱阁，低绮户，照无眠。不应有恨，何事长向别时圆？\n人有悲欢离合，月有阴晴圆缺，此事古难全。但愿人长久，千里共婵娟。";

        //生成字符串对应的字节缓存对象
        ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());

        //往文件通道写入字节缓存
        channel.write(buffer);

        //资源释放
        fos.close();
        channel.close();
    }

    /**
     * 通过文件通道读取文件
     *
     * @param filename
     * @throws IOException
     */
    public void readChannel(String filename) throws IOException {
        //创建文件输入流对象
        FileInputStream fis = new FileInputStream(filename);

        //通过文件输入流对象获取文件通道对象
        FileChannel channel = fis.getChannel();

        //获取文件通道中文件的大小
        int size = (int) channel.size();

        //根据文件大小创建新的字节缓存
        ByteBuffer buffer = ByteBuffer.allocateDirect(size);

        //把文件通道中的数据读到字节缓存
        channel.read(buffer);

        //把缓冲区切换到读模式，必须调用flip方法
        buffer.flip();

        //创建于文件大小相同长度的字符数组
        byte[] bytes = new byte[size];

        //把字节缓存中的数据读取到字节数据
        buffer.get(bytes);

        //把字节数组转换成字符串
        String content = new String(bytes);

        //打印输出字符串信息
        System.out.println(content);

        //资源释放
        fis.close();
        channel.close();
    }

    /**
     * 通过文件通道完成文件复制操作
     * @param srcfile
     * @param destfile
     * @return
     */
    public boolean copyFileChannel(String srcfile,String destfile) {
        boolean result = false;
        // 声明文件输入流
        FileInputStream input = null;
        // 声明输入文件通道
        FileChannel inputChannel = null;
        // 声明文件输出流
        FileOutputStream output = null;
        // 声明输出文件通道
        FileChannel outputChannel = null;

        try {
            // 创建文件输入流对象
            input = new FileInputStream(srcfile);
            // 获取输入文件通道对象
            inputChannel = input.getChannel();
            // 创建文件输出流对象
            output = new FileOutputStream(destfile);
            // 获取输出文件通道对象
            outputChannel = output.getChannel();

            // 根据读取文件的大小创建字节缓存对象
            ByteBuffer buffer = ByteBuffer.allocate((int)inputChannel.size());
            // 通过输入文件通道读取源文件，指定放入buffer字节缓存中
            inputChannel.read(buffer);
            // 将读取的数据存储到字节缓存中
            buffer.flip();
            // 将字节缓存中的数据写入输出文件通道指定目标文件中
            outputChannel.write(buffer);
            // 完成复制后返回 true，有任何异常发生都返回 false
            result = true;
        } catch (FileNotFoundException e) {
            // 找不到 srcfile 会捕获的异常
            e.printStackTrace();
        } catch (IOException e) {
            // 读取和写入数据的过程中出现的流异常
            e.printStackTrace();
        } finally {
            // 资源释放
            try {
                // 输出文件通道关闭
                if(outputChannel!= null) {
                    outputChannel.close();
                }
                // 输出流关闭
                if(output != null) {
                    output.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                // 输入文件通道关闭
                if(inputChannel != null) {
                    inputChannel.close();
                }
                // 输入流关闭
                if(input != null) {
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    public static void main(String[] args) {
        TestChannel tc = new TestChannel();

        try {
            tc.writeChannel("src/com/lanqiao/javalearn/java2/test3/nio_4/myfile.txt");
            tc.readChannel("src/com/lanqiao/javalearn/java2/test3/nio_4/myfile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
