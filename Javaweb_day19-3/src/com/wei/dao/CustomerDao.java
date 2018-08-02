package com.wei.dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.wei.domain.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Dao层数据层
 */
public class CustomerDao {

    QueryRunner qr = new TxQueryRunner();

    /**
     * 添加用户
     * @param c
     */
    public void add(Customer c){
        try{
        String sql = "insert into t_customer values(?,?,?,?,?,?,?)";
        Object[] params = {c.getCid(), c.getCname(), c.getGender(), c.getBirthday(), c.getCellphone(), c.getEmail(), c.getDescription()};
        qr.update(sql, params);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询客户
     * @return
     */
    public List<Customer> findAll(){

        try {
            String sql = "select * from t_customer";
            List<Customer> query = qr.query(sql, new BeanListHandler<Customer>(Customer.class));
            return query;
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    public Customer load(String cid) {

        try{
        String sql = "select * from t_customer where cid=?";
        return qr.query(sql, new BeanHandler<Customer>(Customer.class), cid);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void edit(Customer c) {
        try{
        String sql = "update  t_customer set cname=?, gender=?, birthday=?, cellphone=?, email=?, description=? where cid=? ";
        Object[] params = {c.getCname(), c.getGender(), c.getBirthday(), c.getCellphone(), c.getEmail(), c.getDescription(),c.getCid()};
        qr.update(sql, params);
    } catch (Exception e){
        throw new RuntimeException(e);
    }
    }


    public int delete(String cid) {
        try {
            String sql = "DELETE FROM t_customer WHERE cid=?";
            return qr.update(sql, cid);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Customer> query(Customer c) {

        try{
        StringBuilder sql = new StringBuilder("select * from t_customer where 1=1");
        List<Object> list = new ArrayList<Object>();

        String cname = c.getCname();
        if (cname!=null && !cname.trim().isEmpty()){
            sql.append(" and cname like ?");
            //添加参数
            list.add("%" + cname +"%");
        }

        String gender = c.getGender();
        if (gender!=null && !gender.trim().isEmpty()){
            sql.append(" and gender like ?");
            list.add("%" + gender +"%");
        }

        String cellphone = c.getCellphone();
        if (cellphone!=null && !cellphone.trim().isEmpty()){
            sql.append(" and cellphone like ?");
            list.add("%" + cellphone +"%");
        }

        String email = c.getEmail();
        if (email!=null && !email.trim().isEmpty()){
            sql.append(" and email like ?");
            list.add("%" + email +"%");
        }

         return qr.query(sql.toString(), new BeanListHandler<Customer>(Customer.class), list.toArray());
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
