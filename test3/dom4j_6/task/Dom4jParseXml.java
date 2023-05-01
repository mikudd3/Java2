package com.lanqiao.javalearn.java2.test3.dom4j_6.task;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @project: Dom4j 解析 XML 数据信息
 * @author: mikudd3
 * @version: 1.0
 */
public class Dom4jParseXml {
    /**
     * 采用 Dom4j 框架进行文档解析
     *
     * @param filename 文档路径和名称
     */
    public void parseFile(String filename) {

        //创建SAX解析对象
        SAXReader reader = new SAXReader();

        try {
            Document doc = reader.read(filename);

            //获取根元素
            Element books = doc.getRootElement();

            //调用数据获取的方法
            this.getData(books, "book");

        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取子元素以及子元素文本数据
     *
     * @param element
     * @param elementName
     */
    public void getData(Element element, String elementName) {
        //获取子元素的列表集合
        List<Element> elementList = element.elements(elementName);

        for (Element e : elementList) {
            //获取属性信息
            Attribute attId = e.attribute("id");

            //获取编号
            if (attId != null) {
                System.out.println("编号：" + attId.getValue());
            }

            //获取子元素文本数据
            //获取书名
            Element bookName = e.element("bookname");
            System.out.println("书名：" + bookName.getText());

            //获取书作者
            Element bookAuthor = e.element("bookauthor");
            System.out.println("作者：" + bookAuthor.getText());

            //获取书价格
            System.out.println("价格：" + e.elementText("bookprice"));
        }
    }

    public static void main(String[] args) {
        new Dom4jParseXml().parseFile("src/com/lanqiao/javalearn/java2/test3/dom4j/task/books2.xml");
    }
}
