package com.wei.order.domain;

import com.wei.user.domain.User;

import java.util.Date;
import java.util.List;

/**
 * 订单类
 */
public class Order {

    private String oid;//订单id
    private Date ordertime;//订单时间
    private double total;//合计
    private int state;//四种状态：1. 未下单    2.已付款未发货    3.已发货但未确认收货 4.确认收货
    private User owner;//订单持有者
    private String address;//地址
    private List<OrderItem> orderItemList;

    @Override
    public String toString() {
        return "Order{" +
                "oid='" + oid + '\'' +
                ", ordertime=" + ordertime +
                ", total=" + total +
                ", state=" + state +
                ", owner=" + owner +
                ", address='" + address + '\'' +
                ", orderItemList=" + orderItemList +
                '}';
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
