package com.wei.service;

import com.wei.dao.CustomerDao;
import com.wei.domain.Customer;
import com.wei.domain.PageBean;

import java.util.List;

/**
 * service层业务层
 */
public class CustomerService {

    CustomerDao customerDao = new CustomerDao();

    /**
     * 添加用户
     *
     * @param c
     */
    public void add(Customer c) {
        customerDao.add(c);
    }

    //查询用户
    public PageBean<Customer> findAll(int pc, int ps) {
        return customerDao.findAll(pc, ps);
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

    public PageBean<Customer> query(Customer customer, int pc, int ps) {

        return customerDao.query(customer, pc, ps);
    }
}
