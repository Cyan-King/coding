package com.wei.service;

import com.wei.dao.CustomerDao;
import com.wei.domain.Customer;

import java.util.List;

/**
 * service层业务层
 */
public class CustomerService {

    CustomerDao customerDao = new CustomerDao();

    /**
     * 添加用户
     * @param c
     */
    public void add(Customer c){
        customerDao.add(c);
    }

    //查询用户
    public List<Customer> findAll(){
        return customerDao.findAll();
    }

    //加载客户到页面中
    public Customer load(String cid) {
        return customerDao.load(cid);
    }

    public void edit(Customer c) {
        customerDao.edit(c);
    }

    public void delete(String cid) {
        customerDao.delete(cid);
    }

    public List<Customer> query(Customer c) {
        return customerDao.query(c);
    }
}
