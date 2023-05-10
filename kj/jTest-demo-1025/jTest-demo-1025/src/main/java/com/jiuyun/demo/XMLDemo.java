package com.jiuyun.demo;

import com.jiuyun.bean.Student;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cj
 * @create 2022年10月25日 15:57:42
 */
public class XMLDemo {
    private static final Logger log = LoggerFactory.getLogger(XMLDemo.class);

    public static void main(String[] args) throws Exception {
//        readXML();
//        log.info("XML中的数据：" + changeXmlToList(new File("d://studentDatas.xml")));

        writeXML();
    }

    private static void writeXML() throws ParserConfigurationException, IOException {
        //创建文档对象
        Document document = DocumentHelper.createDocument();
        //通过文档对象创建根节点对象
        Element root = document.addElement("students");
        Element stuElement = root.addElement("student");
        stuElement.addElement("stuId").setText("1");
        stuElement.addElement("stuName").setText("jack");
        stuElement.addElement("sex").setText("男");
        stuElement.addElement("age").setText("18");
        stuElement.addElement("remark").setText("株洲");
        //排版
        XMLWriter xmlWriter =
                new XMLWriter(
                        new FileWriter("d://stu.xml"),OutputFormat.createPrettyPrint());
        xmlWriter.write(document);
        xmlWriter.close();
    }

    public static void changeDataToXML(List<Student> studentList, String filePath) {

    }

    private static void readXML() throws Exception {
        File file = new File("d:\\studentDatas.xml");
        if(file.exists()) {
            //创建SAX方式的字符流
            SAXReader saxReader = new SAXReader();
            //读取XML文件
            Document document = saxReader.read(file);
            //获取根节点
            Element root = document.getRootElement();
            log.info(root.getName());
            List<Element> studentElements = root.elements();
            for (Element element : studentElements) {
                log.info(element.getName());
                List<Element> student = element.elements();
                for (Element stu : student) {
                    log.info(stu.getName() + ":" + stu.getTextTrim());
                }
            }
        } else {
            log.info("文件不存在！");
        }
    }

    public static List<Student> changeXmlToList(File xml) throws DocumentException {
        List<Student> studentList = new ArrayList<Student>();
        //创建SAX方式的字符流
        SAXReader saxReader = new SAXReader();
        //读取XML文件
        Document document = saxReader.read(xml);
        //获取根节点
        Element root = document.getRootElement();
        List<Element> studentElements = root.elements();
        for (Element element : studentElements) {
            Student student = new Student();
            student.setStuId(Integer.parseInt(element.elementText("stuId")));
            student.setStuName(element.elementText("stuName"));
            student.setSex(element.elementText("sex"));
            student.setAge(Integer.parseInt(element.elementText("age")));
            student.setRemark(element.elementText("remark"));
            studentList.add(student);
        }
        return studentList;
    }
}





















