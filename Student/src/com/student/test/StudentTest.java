package com.student.test;

import com.student.bean.Student;
import com.student.service.StuSerice;

public class StudentTest {

    public static void main(String[] args){
//        testAdd();
//        testDel();
        testSelect();
    }

    private static  void  testSelect(){
        StuSerice.MolStu("103");
    }

    private static void testAdd() {
        Student student = new Student();
        student.setId("103");
        student.setName("孙三");
        student.setAge("21");
        StuSerice.addStu(student);
    }

    private  static void testDel(){
        StuSerice.DelStu("102");
    }
}
