package com.lanqiao.javalearn.java2.test3.dom4j_6.person;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @project: 使用 Dom4j 将数据生成 XML 文档
 * @author: mikudd3
 * @version: 1.0
 */
public class TestDataToXml {
    public void createXmlFile(String filename) {
        // 创建工厂类对象
        DocumentFactory factory = new DocumentFactory();

        // 创建文档对象
        Document document = factory.createDocument();

        // 创建根元素
        Element root = factory.createElement("persons");
        // 将根元素放入到文档对象中
        document.add(root);

        // 获取 Person 数据信息
        List<Person> persons = Person.getPersons();
        for (Person p : persons) {
            //创建子元素
            Element person = factory.createElement("person");
            //将子元素放入到根元素中
            root.add(person);

            // 创建属性，并同时设置属性名和属性值
            Attribute attrid = factory.createAttribute(person, "id", p.getId());
            // 将属性对象放入子元素中
            person.add(attrid);

            //创建子元素对象
            //姓名
            Element personName = factory.createElement("name");
            person.add(personName);
            //创建文本对象
            Text name = factory.createText(p.getName());
            //将文本字符数据放入到子元素中
            personName.add(name);

            //性别
            Element personSex = factory.createElement("sex");
            person.add(personSex);
            Text sex = factory.createText(p.getSex());
            personSex.add(sex);

            //年龄
            Element personAge = factory.createElement("age");
            person.add(personAge);
            Text age = factory.createText(String.valueOf(p.getAge()));
            personAge.add(age);

        }
        // 设置写入xml文档样式
        OutputFormat format = OutputFormat.createPrettyPrint();
        // OutputFormat format = OutputFormat.createCompactFormat();

        //将文档写入到指定的xml文件中
        XMLWriter writer = null;
        try {
            writer = new XMLWriter(new FileWriter(filename), format);
            writer.write(document);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    // 关闭流
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new TestDataToXml().createXmlFile("src/com/lanqiao/javalearn/java2/test3/dom4j/person/persons.xml");
    }
}
