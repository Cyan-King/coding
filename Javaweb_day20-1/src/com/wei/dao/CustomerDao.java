package com.wei.dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.wei.domain.Customer;
import com.wei.domain.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

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
     *
     * @param c
     */
    public void add(Customer c) {
        try {
            String sql = "insert into t_customer values(?,?,?,?,?,?,?)";
            Object[] params = {c.getCid(), c.getCname(), c.getGender(), c.getBirthday(), c.getCellphone(), c.getEmail(), c.getDescription()};
            qr.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询客户
     *
     * @param pc
     * @param ps
     * @return
     */
    public PageBean<Customer> findAll(int pc, int ps) {

        try {
            //创建PageBean对象
            PageBean<Customer> pb = new PageBean<Customer>();
            //设置pc和ps-----这样的话我们就可以修改pc和ps了---也就是说我们request域中可以得到这个了
            pb.setPc(pc);
            pb.setPs(ps);
            //获得tr的值
            String sql = "select count(*) from t_customer";
            Number num = (Number) qr.query(sql, new ScalarHandler());
            int tr = num.intValue();
            pb.setTr(tr);
            //获得beanList,也就是limt中的值
            sql = "select * from t_customer order by cname limit ?,?";
            List<Customer> beanList = qr.query(sql, new BeanListHandler<Customer>(Customer.class), (pc - 1) * ps, ps);
            pb.setBeanList(beanList);
            return pb;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 查询
     *
     * @param cid
     * @return
     */
    public Customer load(String cid) {

        try {
            String sql = "select * from t_customer where cid=?";
            return qr.query(sql, new BeanHandler<Customer>(Customer.class), cid);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 修改数据库
     *
     * @param c
     */
    public void edit(Customer c) {
        try {
            String sql = "update  t_customer set cname=?, gender=?, birthday=?, cellphone=?, email=?, description=? where cid=? ";
            Object[] params = {c.getCname(), c.getGender(), c.getBirthday(), c.getCellphone(), c.getEmail(), c.getDescription(), c.getCid()};
            qr.update(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 删除操作
     *
     * @param cid
     * @return
     */
    public int delete(String cid) {
        try {
            String sql = "DELETE FROM t_customer WHERE cid=?";
            return qr.update(sql, cid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 高级查询操作
     *
     * @param c
     * @param pc
     * @param ps
     * @return
     */
//    public List<Customer> query(Customer c, int pc, int ps) {
//
//        try{
//        StringBuilder sql = new StringBuilder("select * from t_customer where 1=1");
//        List<Object> list = new ArrayList<Object>();
//
//        String cname = c.getCname();
//        if (cname!=null && !cname.trim().isEmpty()){
//            sql.append(" and cname like ?");
//            //添加参数
//            list.add("%" + cname +"%");
//        }
//
//        String gender = c.getGender();
//        if (gender!=null && !gender.trim().isEmpty()){
//            sql.append(" and gender like ?");
//            list.add("%" + gender +"%");
//        }
//
//        String cellphone = c.getCellphone();
//        if (cellphone!=null && !cellphone.trim().isEmpty()){
//            sql.append(" and cellphone like ?");
//            list.add("%" + cellphone +"%");
//        }
//
//        String email = c.getEmail();
//        if (email!=null && !email.trim().isEmpty()){
//            sql.append(" and email like ?");
//            list.add("%" + email +"%");
//        }
//
//         return qr.query(sql.toString(), new BeanListHandler<Customer>(Customer.class), list.toArray());
//        } catch (SQLException e){
//            throw new RuntimeException(e);
//        }
//    }
    public PageBean<Customer> query(Customer c, int pc, int ps) {

        try {

            //创建PageBean对象
            PageBean<Customer> pb = new PageBean<Customer>();
            //设置pc和ps-----这样的话我们就可以修改pc和ps了---也就是说我们request域中可以得到这个了
            pb.setPc(pc);
            pb.setPs(ps);
            //将sql语句拆分
            StringBuilder sql = new StringBuilder("select * from t_customer");
            StringBuilder cntSql = new StringBuilder("select count(*) from t_customer");
            StringBuilder whereSql = new StringBuilder(" where 1=1");
            List<Object> list = new ArrayList<Object>();

            String cname = c.getCname();
            if (cname != null && !cname.trim().isEmpty()) {
                whereSql.append(" and cname like ?");
                //添加参数
                list.add("%" + cname + "%");
            }

            String gender = c.getGender();
            if(gender != null && !gender.trim().isEmpty()) {
                whereSql.append(" and gender like ?");
                list.add("%"+gender+"%");
            }

            String cellphone = c.getCellphone();
            if (cellphone != null && !cellphone.trim().isEmpty()) {
                whereSql.append(" and cellphone like ?");
                list.add("%" + cellphone + "%");
            }

            String email = c.getEmail();
            if (email != null && !email.trim().isEmpty()) {
                whereSql.append(" and email like ?");
                list.add("%" + email + "%");
            }

            Number num = (Number) qr.query(cntSql.append(whereSql).toString(), (ResultSetHandler<Object>) new ScalarHandler(), list.toArray());
            int tr = num.intValue();
            //设置tr的值
            pb.setTr(tr);
            //设置beanList的值

            // 我们查询beanList这一步，还需要给出limit子句
            StringBuilder limitSql = new StringBuilder(" limit ?,?");
            list.add((pc-1)*ps);
            list.add(ps);
//            select count(*) from t_customer where 1=1  and gender like ? where 1=1  Parameters: [%?%]

            List<Customer> beanList = qr.query(sql.append(whereSql).append(limitSql).toString(), new BeanListHandler<Customer>(Customer.class), list.toArray());
            pb.setBeanList(beanList);

            System.out.println(sql.toString());
            return pb;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
