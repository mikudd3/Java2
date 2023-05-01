package com.lanqiao.javalearn.java2.test3.dom4j_6;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @project: Dom4j 解析 XML 文档数据
 * @author: mikudd3
 * @version: 1.0
 */
public class TestDom4j {
    /**
     * 解析文件
     *
     * @param filename
     */
    public void parseFile(String filename) {
        //创建SAX解析对象
        SAXReader reader = new SAXReader();

        try {
            //获取文档对象
            Document doc = reader.read(filename);

            //获取根元素
            Element root = doc.getRootElement();

            //获取子元素
            Element cars = root.element("cars");
            Element trucks = root.element("trucks");

            //调用数据获取的方法
            this.getData(cars, "car");
            this.getData(trucks, "truck");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取子元素以及子元素文本数据
     *
     * @param element     子元素对象
     * @param elementName 子元素标记名
     */
    public void getData(Element element, String elementName) {
        //获取子元素的列表集合
        List<Element> elementList = element.elements(elementName);

        for (Element e : elementList) {
            //获取属性信息
            Attribute attid = e.attribute("id");

            if (attid != null) {
                System.out.println("编号：" + attid.getValue());
            }

            String supplier = e.attributeValue("supplier");

            if (supplier != null) {
                System.out.println("供应商编号：" + supplier);
            }

            //获取子元素文本数据
            Element name = e.element("name");

            System.out.println("名称：" + name.getText());
            System.out.println("油量：" + e.elementText("oil"));
            System.out.println("损耗：" + e.elementText("loss"));

            if ("car".equals(element)) {
                Element brand = e.element("brand");
                System.out.println("品牌：" + brand.getText());
            } else {
                System.out.println("载重：" + e.elementText("load"));
            }
            System.out.println("----------");
        }
    }

    public static void main(String[] args) {
        new TestDom4j().parseFile("src/com/lanqiao/javalearn/java2/test3/dom4j/vehicles.xml");
    }
}
