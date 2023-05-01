package com.lanqiao.javalearn.java2.test3.all_7.university;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @project: 模拟实现大学管理系统
 * @author: mikudd3
 * @version: 1.0
 */


public class Solve {

    public static void main(String[] args) {
        String pathname = "src/com/lanqiao/javalearn/java2/test3/university/University.xml";
        try {
            //创建解析器工厂
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //获取doc解析器
            DocumentBuilder db = dbf.newDocumentBuilder();
            //解析指定xml文档
            Document doc = db.parse(pathname);
            //获取根节点
            NodeList university = doc.getChildNodes();

            System.out.println("大学管理系统中共有" + university.getLength() + "种人员类型");
            System.out.println("分别为：");
            //获取孩子节点
            System.out.println("instructor");
            System.out.println("students");

            //得到所有students类型列表
            NodeList students = doc.getElementsByTagName("student");
            System.out.println("大学管理系统中共有" + students.getLength() + "名学生");

            //获取学生新
            for (int i = 0; i < students.getLength(); i++) {
                //学生
                Element student = (Element) students.item(i);

                //id
                System.out.println("id为" + student.getAttribute("id") + "的学生信息为：");

                //姓名
                NodeList studentType = doc.getElementsByTagName("name");
                System.out.println("name:" + studentType.item(0).getFirstChild().getNodeValue());

                studentType = doc.getElementsByTagName("department");
                System.out.println("department:" + studentType.item(0).getFirstChild().getNodeValue());

                studentType = doc.getElementsByTagName("grade");
                System.out.println("grade:" + studentType.item(0).getFirstChild().getNodeValue());


            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
