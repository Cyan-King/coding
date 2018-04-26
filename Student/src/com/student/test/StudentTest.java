package com.student.test;

import com.student.bean.Student;
import com.student.service.StuSerice;

public class StudentTest {

    public static void main(String[] args) {
        testAdd();
//        testDel();
//        testSelect();
//        testMol();
    }

    private static void testMol() {

        Student student = new Student();
        student.setId("101");
        student.setName("赵一");
        student.setAge("19");
        StuSerice.MolStu("104", student);
    }

    private static void testSelect() {
        StuSerice.IntStu("103");
    }

    private static void testAdd() {
        Student student = new Student();
        student.setId("102");
        student.setName("钱二");
        student.setAge("20");
        StuSerice.addStu(student);
    }

    private static void testDel() {
        StuSerice.DelStu("102");
    }
}
