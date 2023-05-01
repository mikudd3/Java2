package com.lanqiao.javalearn.java2.test6.crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @project: 实现爬虫获取海量数据
 * @author: mikudd3
 * @version: 1.0
 */
public class TestCrawler {
    /**
     * 获取蓝桥云课首页的html源码
     *
     * @return
     */

    public static String getResource() {
        BufferedReader reader = null;
        //创建字符串缓存区，存储爬取的数据
        StringBuffer html = new StringBuffer();
        try {
            //创建URL对象
            URL url = new URL("https://www.lanqiao.cn/");
            // 通过URL对象获取URLconnection对象
            URLConnection urlConnection = url.openConnection();
            //建立链接
            urlConnection.connect();
            //通过IO流提取数据信息
            reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                html.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //返回字符串
        return html.toString();
    }

    /**
     * 从蓝桥云课首页的源码中解析特定的数据
     *
     * @param html
     * @return
     */
    public static String parseResource(String html) {
       /* (.+?) :表示匹配一次符合条件的值，即从蓝桥网首页的源码中，寻找以下内容：
            <meta data-n-head="ssr" data-hid="description" name="description" content=*/
        Pattern pattern = Pattern.compile("meta data-n-head=\"ssr\" data-hid=\"description\" name=\"description\" content=\"(.+?)\"");
        //从蓝桥云课首页的源码中，提取符合pattern约束的字符串
        Matcher matcher = pattern.matcher(html);
        String result = null;
        if (matcher.find()) {
            //提取出全部符合条件的值，即提取出<meta>标签中的content属性值
            result = matcher.group(0);
            result = result.substring(result.indexOf("content=") + "content=".length());
        }
        return result;
    }

    public static void main(String[] args) {
        String html = getResource();
//        System.out.println("蓝桥云课首页的源码如下所示：\n" + html);
        String result = parseResource(html);
        System.out.println(result == null ? "爬取失败" : "description 的 content 值是：" + result);
    }
}
