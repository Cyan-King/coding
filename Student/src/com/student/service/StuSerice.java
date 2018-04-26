package com.student.service;

import com.student.bean.Dom4jUtils;
import com.student.bean.Student;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.XMLWriter;

import java.util.List;

public class StuSerice {

    private static Student student;

    //添加学生信息
    public static void addStu(Student student){
        StuSerice.student = student;

        //获取docuement
        Document docuement = Dom4jUtils.getDocuement("src/Student.xml");
        //得到根节点
        Element rootElement = docuement.getRootElement();
        //在根节点上创建stu
        Element stu = rootElement.addElement("stu");
        //在stu上依次添加id, name, age
        Element id = stu.addElement("id");
        Element name = stu.addElement("name");
        Element age = stu.addElement("age");
        //在id, name, age上面依次添加值
        id.setText(student.getId());
        name.setText(student.getName());
        age.setText(student.getAge());

        //执行回写操作
        Dom4jUtils.xmlWriters("src/Student.xml", docuement);
    }

    //获取id进行删除操作
    public static void DelStu(String id){
        //获取docuement
        Document docuement = Dom4jUtils.getDocuement("src/Student.xml");
        //获取所有的id值
        List<Node> list = docuement.selectNodes("//id");
        //id值进行遍历
        for (Node node:list) {
            //得到id的值
            String idv = node.getText();
            //判断id的值和传递的id值是否相同,进行下列代码
            if (idv.equals(id)){
                //得到id的父节点stu
                Element stu = node.getParent();
                //使用stu的父节点来删除stu节点
                Element parent = stu.getParent();
                //使用父节点删除stu节点
                parent.remove(stu);
            }
        }
        //进行回写操作
        Dom4jUtils.xmlWriters("src/Student.xml", docuement);
    }

    //获取id执行查询操作
    public static void IntStu(String id){
        Document docuement = Dom4jUtils.getDocuement("src/Student.xml");
        //获取所有的id值
        List<Node> list = docuement.selectNodes("//id");
        Student student = new Student();
        //遍历list集合
        for (Node node:list) {
            String idv = node.getText();
            if (idv.equals(id)){
                //获取id的父节点，在获取name的值和age的值
                Element stu = node.getParent();
                String name = stu.element("name").getText();
                String age = stu.element("age").getText();
                System.out.println("Student{" +
                        "id='" + id + '\'' +
                        ", name='" + name + '\'' +
                        ", age='" + age + '\'' +
                        '}');
            }
        }

    }

    public static void MolStu(String id, Student student){
        //获取document
        Document docuement = Dom4jUtils.getDocuement("src/Student.xml");
        //获取id的节点
        List<Node> list = docuement.selectNodes("//id");
        //遍历id节点
        for (Node node:list) {
            //得到id的值
            String idv = node.getText();
            if (idv.equals(id)){
                //获取stu节点
                Element stu = node.getParent();
                //获取id， name， age标签
                Element id1 = stu.element("id");
                Element name1 = stu.element("name");
                Element age1 = stu.element("age");
                //使用setText()方法进修修改
                id1.setText(student.getId());
                name1.setText(student.getName());
                age1.setText(student.getAge());
            }
        }
        //执行回写操作
        Dom4jUtils.xmlWriters("src/Student.xml", docuement);
    }
}
