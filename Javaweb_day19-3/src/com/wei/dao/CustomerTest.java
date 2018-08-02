package com.wei.dao;

import cn.itcast.commons.CommonUtils;
import com.wei.domain.Customer;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void fun1(){
        CustomerDao customerDao = new CustomerDao();

        for (int i = 1; i <= 300; i++){
            Customer c = new Customer();
            c.setCid(CommonUtils.uuid());
            c.setCname("cstm_" + i);
            c.setBirthday("2017-1-1");
            c.setGender(i%2==0?"男":"女");
            c.setCellphone("152" + i + "123");
            c.setEmail("cstm_" + i + "@163.com");
            c.setDescription("我是客户");

            customerDao.add(c);

        }

    }
}
