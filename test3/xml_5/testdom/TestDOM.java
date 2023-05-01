package com.lanqiao.javalearn.java2.test3.xml_5.testdom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * 采用 DOM 方式解析 XML 数据
 */
public class TestDOM {
    /**
     * 文件解析
     *
     * @param filename 文件名
     */
    public void parseFile(String filename) {
        try {
            //创建解析器工厂
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //通过解析器工厂获得DOM解析器
            DocumentBuilder db = dbf.newDocumentBuilder();
            //解析指定XML文档，得到DOM节点树
            Document doc = db.parse(filename);
            //得到根节点
            NodeList vehicles = doc.getChildNodes();
            System.out.println(" `租车系统` 中共有" + vehicles.getLength() + "种类型的车！");
            //得到所有<truck>节点列表信息
            NodeList truckList = doc.getElementsByTagName("truck");
            System.out.println(" `租车系统` 中共有" + truckList.getLength() + "辆卡车！");
            //遍历所有卡车
            for (int i = 0; i < truckList.getLength(); i++) {
                //获取索引为i的卡车
                Node truck = truckList.item(i);
                //获取卡车属性值并显示
                Element element = (Element) truck;
                String idValue = element.getAttribute("id");
                //以下通过属性名获得属性节点，再通过getNodeValue()获得属性值
                //Node attr = element.getAttributeNode("id");
                //String idValue = attr.getNodeValue();
                System.out.println("id为" + idValue + "的卡车信息为：");
                //获取索引为i的卡车详细信息并输出
                for (Node node = truck.getFirstChild(); node != null; node = node.getNextSibling()) {
                    //根据节点类型进行判断，显示元素节点信息，如 <oil>20</oil>
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        //元素节点的节点名为标签名，如oil
                        String name = node.getNodeName();
                        //元素节点<oil>20</oil>下第一个子节点为文本节点20，得到节点值20
                        String value = node.getFirstChild().getNodeValue();
                        System.out.println("  " + name + "：" + value + "；");
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TestDOM().parseFile("src/com/lanqiao/javalearn/java2/test3/testdom/vehicles.xml");
    }
}