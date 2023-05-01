package com.lanqiao.javalearn.java2.test3.xml_5.sax.task;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * @project: SAX 解析 XML 数据信息
 * @author: mikudd3
 * @version: 1.0
 */
public class SaxParseXml extends DefaultHandler {
    private String tagName;

    /**
     * 采用 SAX 解析方式进行文档解析
     *
     * @param filename 文档路径和名称
     */
    public void parseFile(String filename) {

        // 程序代码
        try {
            //获取SAX 解析对象
            SAXParser parser = SAXParserFactory.newDefaultInstance().newSAXParser();
            //传递文件
            parser.parse(new File(filename), this);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }

    // 重写五个核心的方法

    /**
     * 开始解析xml文件 （只执行一次）
     *
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        System.out.println("books2文档开始解析");
    }

    /**
     * 解析xml文件 结束（只执行一次）
     *
     * @throws SAXException
     */
    @Override
    public void endDocument() throws SAXException {
        System.out.println("books2文档结束解析");
    }

    /**
     * 开始解析xml元素（执行多次）
     *
     * @param uri        The Namespace URI, or the empty string if the
     *                   element has no Namespace URI or if Namespace
     *                   processing is not being performed.
     * @param localName  The local name (without prefix), or the
     *                   empty string if Namespace processing is not being
     *                   performed.
     * @param qName      The qualified name (with prefix), or the
     *                   empty string if qualified names are not available.
     * @param attributes The attributes attached to the element.  If
     *                   there are no attributes, it shall be an empty
     *                   Attributes object.
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("book")) {
            int id = Integer.parseInt(attributes.getValue(0));
            //获取书籍id
            System.out.println("编号：" + id);
        }
        this.tagName = qName;
    }

    /**
     * 结束 解析xml元素（执行多次）
     *
     * @param uri       The Namespace URI, or the empty string if the
     *                  element has no Namespace URI or if Namespace
     *                  processing is not being performed.
     * @param localName The local name (without prefix), or the
     *                  empty string if Namespace processing is not being
     *                  performed.
     * @param qName     The qualified name (with prefix), or the
     *                  empty string if qualified names are not available.
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //解析完毕之后给tagName置null
        this.tagName = null;
    }

    /**
     * 在startElement、endElement 之间调用多次
     *
     * @param ch     The characters.
     * @param start  The start position in the character array.
     * @param length The number of characters to use from the
     *               character array.
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //如果tagName不为null
        if (this.tagName != null) {
            String data = new String(ch, start, length);
            //获取书名
            if (this.tagName.equals("bookname")) {
                System.out.println("书名：" + data);
            }
            //获取作者
            if (this.tagName.equals("bookauthor")) {
                System.out.println("作者：" + data);
            }
            //获取书籍价格
            if (this.tagName.equals("bookprice")) {
                System.out.println("价格：" + data);
            }

        }
    }

    public static void main(String[] args) {
        new SaxParseXml().parseFile("src/com/lanqiao/javalearn/java2/test3/sax/task/books2.xml");
    }
}
