package test;

import cn.itcast.beanfactory.BeanFactory;
import com.wei.dao.StudentDao;
import com.wei.domain.Student;
import com.wei.service.StudentService;
import org.junit.Test;

public class Demo1 {

    @Test
    public void fun1(){
        /**
         * 1.创建Bean工厂时，需要给工厂指定配置文件
         * 2.从工厂中获取bean对象
         */
        BeanFactory bf = new BeanFactory("beans.xml");
        Student stu1 = (Student) bf.getBean("stu1");
        System.out.printf(String.valueOf(stu1));
    }

    @Test
    public void fun2(){
        BeanFactory bf = new BeanFactory("beans.xml");
        Student stu1 = (Student) bf.getBean("stu1");
        Student stu2 = (Student) bf.getBean("stu2");
//        System.out.printf(String.valueOf(stu1 == stu2));
//        System.out.printf(String.valueOf(stu1.getTeacher()));
        System.out.printf(String.valueOf(stu1.getTeacher() == stu2.getTeacher()));
    }

    @Test
    public void fun3(){

        BeanFactory bf = new BeanFactory("beans.xml");
//        StudentImpl stu1 = (StudentImpl) bf.getBean("stuDao1");
//        StudentImpl2 stu2 = (StudentImpl2) bf.getBean("stuDao2");
        StudentDao stu1 = (StudentDao) bf.getBean("stuDao1");
        StudentDao stu2 = (StudentDao) bf.getBean("stuDao2");
        stu1.add(null);
        stu1.update(null);

        stu2.add(null);
        stu2.update(null);
    }

    @Test
    public void fun4(){
        BeanFactory bf = new BeanFactory("beans.xml");
        StudentService stuService = (StudentService)bf.getBean("stuService");

        stuService.login();
    }
}
