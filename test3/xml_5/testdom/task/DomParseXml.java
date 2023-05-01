package com.lanqiao.javalearn.java2.test3.xml_5.testdom.task;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @project: DOM 解析 XML 数据信息
 * @author: mikudd3
 * @version: 1.0
 */
public class DomParseXml {
    /**
     * 采用 DOM 解析方式进行文档解析
     *
     * @param filename 文档路径和名称
     */
    public void parseFile(String filename) {

        // 程序代码
        try {
            //创建解析器工厂
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //获取dom解析器
            DocumentBuilder db = dbf.newDocumentBuilder();
            //解析xml文档
            Document doc = db.parse(filename);
            //得到根节点
            NodeList books = doc.getChildNodes();

            //获取书的数量
            //int length = books.getLength();   //获取xml文档里面的类型，由于xml文档里面只有书，所以为1
            //System.out.println("该xml文档里面有" + length + "本书");

            //获取书本集合
            NodeList bookList = doc.getElementsByTagName("book");
            //获取书本数量
            int length = bookList.getLength();
            //System.out.println("该xml文档里面有" + length + "本书");

            //提取书的信息
            for (int i = 0; i < length; i++) {
                //获取书本
                Element book = (Element) bookList.item(i);
                System.out.println("编号：" + book.getAttribute("id"));

                //书名
                NodeList bookType = doc.getElementsByTagName("bookname");
                System.out.println("书名：" + bookType.item(0).getFirstChild().getNodeValue());
                //作者
                bookType = doc.getElementsByTagName("bookauthor");
                System.out.println("作者：" + bookType.item(0).getFirstChild().getNodeValue());
                //价格
                bookType = doc.getElementsByTagName("bookprice");
                System.out.println("价格：" + bookType.item(0).getFirstChild().getNodeValue());

                System.out.println();
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        new DomParseXml().parseFile("src/com/lanqiao/javalearn/java2/test3/testdom/task/books1.xml");
    }
}
