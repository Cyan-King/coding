package com.wei.dao.impl;

import com.wei.dao.StudentDao;
import com.wei.domain.Student;

public class StudentDaoImpl2 implements StudentDao {

        @Override
        public void add(Student student) {
            System.out.println("Impl2.add()方法");
        }

        @Override
        public void update(Student student) {
            System.out.println("Impl2.update()方法");
        }

}
