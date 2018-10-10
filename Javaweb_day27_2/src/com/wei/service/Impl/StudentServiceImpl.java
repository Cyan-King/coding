package com.wei.service.Impl;

import com.wei.dao.StudentDao;
import com.wei.domain.Student;
import com.wei.service.StudentService;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao = null;

    //谁调用谁就需要调用service谁就需要调用本方法，提供dao
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void login() {

    }
}
