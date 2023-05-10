package com.demo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DemoDom4j {
    private static final Logger log = LoggerFactory.getLogger(DemoDom4j.class);

    public static void main(String[] args){
        try {

            DemoDom4j.writeXmL();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取XML文件
     * @return
     * @throws DocumentException
     */
    private static void readXML() throws DocumentException {
        File file = new File("D:\\studentDatas.xml");
        if (file.exists()) {
            //创建SAX方式的字符流
            SAXReader saxReader = new SAXReader();
            //读取XML文件
            Document document = saxReader.read(file);
            //获取根元素
            Element root = document.getRootElement();
            log.info(root.getName());
            //获取学生所有元素
            List<Element> studentElement = root.elements();
            for (Element element : studentElement) {
                log.info(element.getName());
                //获取单个学生的信息
                List<Element> student = element.elements();
                for (Element stu : student) {
                    log.info(stu.getName() + ":" + stu.getTextTrim());
                }
            }
        }
    }

    /**
     * XML转List
     * @param xml
     * @return
     * @throws DocumentException
     */
    private static List<Student> changeXMLToList (File xml) throws DocumentException {
        List<Student> studentList = new ArrayList<Student>();
        //创建SAX方式的字符流
        SAXReader saxReader = new SAXReader();
        //读取XML文件
        Document document = saxReader.read(xml);
        //获取根元素
        Element root = document.getRootElement();
        List<Element> studentElement = root.elements();
        for (Element element : studentElement) {
            Student student = new Student();
            student.setStuId(Integer.valueOf(element.elementText("stuId")));
            student.setStuName(element.elementText("stuName"));
            student.setSex(element.elementText("sex"));
            student.setAge(Integer.valueOf(element.elementText("age")));
            student.setRemark(String.valueOf(element.element("remark")));
            studentList.add(student);
        }
        return studentList;
    }

    /**
     * 写出XML文件
     * @throws IOException
     */
    private static void writeXmL() throws IOException {
        //创建文档对象
        Document document=DocumentHelper.createDocument();
        //通过文档对象创建根节点对象
        Element root=document.addElement("Students");
        Element stuElement=root.addElement("Student");
        stuElement.addElement("stuId").setText("1");
        stuElement.addElement("stuName").setText("qwe");
        stuElement.addElement("sex").setText("男");
        stuElement.addElement("age").setText("13");
        stuElement.addElement("remark").setText("长沙");
        //排版
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("D://student.xml"),OutputFormat.createPrettyPrint());
        xmlWriter.write(document);
        xmlWriter.close();
    }

    /**
     * 将学生信息转化为XML文件
     * @param studentList
     * @param filePath
     */
    private static void changeDataToXML(List<Student> studentList,String filePath) throws IOException {
        Document document=DocumentHelper.createDocument();
        Element root=document.addElement("Students");
        Element stuElement=root.addElement("Student");
        for(Student student : studentList){
            stuElement.addElement("stuId").setText(String.valueOf(student.getStuId()));
            stuElement.addElement("stuName").setText(student.getStuName());
            stuElement.addElement("stuSex").setText(student.getSex());
            stuElement.addElement("stuAge").setText(String.valueOf(student.getAge()));
            stuElement.addElement("stuRemark").setText(student.getRemark());
            XMLWriter xmlWriter = new XMLWriter(new FileWriter("D://student.xml"),OutputFormat.createPrettyPrint());
            xmlWriter.write(document);
            xmlWriter.close();
        }
    }
}


















