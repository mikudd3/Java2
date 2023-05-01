package com.lanqiao.javalearn.java2.test3.xml_5.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * @project: 采用 SAX 方式解析 XML 数据
 * @author: mikudd3
 * @version: 1.0
 */
public class TestSAX extends DefaultHandler {
    private String tagName;

    // 开始解析xml文件 （只执行一次）
    @Override
    public void startDocument() throws SAXException {
        System.out.println("SAX解析开始...");
    }

    // 解析xml文件 结束（只执行一次）
    @Override
    public void endDocument() throws SAXException {
        System.out.println("SAX解析结束...");
    }

    // 开始解析xml元素（执行多次）
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("car")) {
            int id = Integer.parseInt(attributes.getValue(0));
            System.out.println(id);
        }
        if (qName.equals("truck")) {
            int id = Integer.parseInt(attributes.getValue(0));
            System.out.println(id);
        }
        this.tagName = qName;
    }

    // 结束 解析xml元素（执行多次）
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("car")) {
            System.out.println("一个car标签解析完毕");
        }
        if (qName.equals("truck")) {
            System.out.println("一个truck标签解析完毕");
        }
        this.tagName = null;
    }

    // 在startElement、endElement 之间调用多次
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (this.tagName != null) {
            String data = new String(ch, start, length);// ch[] -> String
            if (this.tagName.equals("name")) {
                System.out.print(data + "\t");
            }
            if (this.tagName.equals("oil")) {
                System.out.print(Integer.parseInt(data) + "\t");
            }

            if (this.tagName.equals("loss")) {
                System.out.print(Integer.parseInt(data) + "\t");
            }

            if (this.tagName.equals("brand")) {
                System.out.println(data);
            }

            if (this.tagName.equals("load")) {
                System.out.println(data);
            }
        }
    }

    /**
     * SAX 解析
     *
     * @param filename 解析文件
     */
    public void paresFile(String filename) {
        try {
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            parser.parse(new File(filename), this);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new TestSAX().paresFile("src/com/lanqiao/javalearn/java2/test3/sax/vehicles.xml");
    }
}