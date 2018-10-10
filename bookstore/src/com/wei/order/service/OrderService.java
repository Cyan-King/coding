package com.wei.order.service;

import cn.itcast.jdbc.JdbcUtils;
import com.wei.order.dao.OrderDao;
import com.wei.order.domain.Order;

import java.sql.SQLException;
import java.util.List;

public class OrderService {

    private OrderDao orderDao = new OrderDao();


    public void zhiFu(String oid){
        int state = orderDao.getStateByOid(oid);

        if (state == 1){
            orderDao.updateState(oid, 2);
        }
    }

    /**
     * 添加订单
     * 处理事务
     * @param order
     */
    public void add(Order order){
        try {
            //开启事务
            JdbcUtils.beginTransaction();

            orderDao.addOrder(order);//插入订单
            orderDao.addOrderItem(order.getOrderItemList());//插入订单条目

            //提交事务
            JdbcUtils.commitTransaction();
        } catch (SQLException e) {


            //回滚事务
            try {
                JdbcUtils.rollbackTransaction();
            } catch (SQLException e1) {
            }

            throw new RuntimeException(e);
        }
    }

    /**
     * 我的订单
     * @param uid
     * @return
     */
    public List<Order> myOrder(String uid) {

        return orderDao.findByUid(uid);
    }

    /**
     * 加载订单
     * @param oid
     * @return
     */
    public Order load(String oid) {

        return orderDao.load(oid);
    }

    public void cofirm(String oid) throws OrderException {

        //得到oid的值
        int state = orderDao.getStateByOid(oid);

        //判断订单状态是否为3
        if (state != 3) throw new OrderException("订单确认失败！");

        //如果订单状态是3的话我们就修改订单状态
        orderDao.updateState(oid, 4);


    }
}
