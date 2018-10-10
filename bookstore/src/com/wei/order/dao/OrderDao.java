package com.wei.order.dao;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;
import com.wei.book.domain.Book;
import com.wei.order.domain.Order;
import com.wei.order.domain.OrderItem;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderDao {

    private QueryRunner qr = new TxQueryRunner();

    /**
     * 添加订单
     * @param order
     */
    public void addOrder(Order order){
        try{
            String sql = "insert into orders values(?,?,?,?,?,?)";
        //将util类的Data转换成为sql的data，Timestamp
            Timestamp timestamp = new Timestamp(order.getOrdertime().getTime());
        Object[] params = {order.getOid(), timestamp, order.getTotal(), order.getState(), order.getOwner().getUid(), order.getAddress()};
        qr.update(sql, params);}
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 添加订单条目---要进行批处理操作
     * @param orderItemList
     */
    public void addOrderItem(List<OrderItem> orderItemList){

        try{
            String sql = "insert into orderitem values(?,?,?,?,?)";
            /**
             * QueryRunner类的batch(sql, Object[][] params)方法
             * 其中params是一个多为数组
             */

            Object[][] params = new Object[orderItemList.size()][];

            for (int i = 0; i < orderItemList.size(); i++){
                OrderItem item = orderItemList.get(i);
                params[i] = new Object[]{item.getIid(), item.getCount(),
                        item.getSubtotal(), item.getOrder().getOid(),
                        item.getBook().getBid()};
            }

            qr.batch(sql, params);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    /**
     * 使用uid查询到所有的订单和订单条目
     * @param uid
     * @return
     */
    public List<Order> findByUid(String uid) {



        try {
            String sql = "SELECT * FROM orders where uid=?";
            List<Order> orderList = qr.query(sql, new BeanListHandler<Order>(Order.class), uid);

            //循环遍历所有的订单
            for (Order order : orderList){
                //得到将在每个订单的每一个条目
                loadOrderItems(order);
            }

            return orderList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 加载指定的订单和订单中的订单条目
     * @param order
     * @throws SQLException
     */
    private void loadOrderItems(Order order) throws SQLException {

        String sql = "SELECT * FROM orderitem i, book b WHERE i.bid=b.bid AND oid=?";

        List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler(), order.getOid());

        //是orderitem和book建立联系
        List<OrderItem> orderItemList = toOrderItemList(mapList);

        order.setOrderItemList(orderItemList);


    }

    /**
     * 把maplist每一个Map转换会成为两个对象并对进行关联
     * @param mapList
     * @return
     */
    private List<OrderItem> toOrderItemList(List<Map<String, Object>> mapList) {

        List<OrderItem> orderItemList = new ArrayList<OrderItem>();
        for (Map<String, Object> map: mapList) {
            OrderItem item = toOrderItem(map);
            orderItemList.add(item);
        }


        return orderItemList;

    }

    /**
     * 将map转换成为OrderItem对象
     * @param map
     * @return
     */
    private OrderItem toOrderItem(Map<String, Object> map) {
        OrderItem orderItem = CommonUtils.toBean(map, OrderItem.class);
        Book book = CommonUtils.toBean(map, Book.class);
        orderItem.setBook(book);


        return orderItem;
    }

    /**
     * 加载订单
     * @param oid
     * @return
     */
    public Order load(String oid) {
        try {
            String sql = "SELECT * FROM orders where oid=?";
            Order order = qr.query(sql, new BeanHandler<Order>(Order.class), (Object) oid);

            //为order加载每一个订单条目
                loadOrderItems(order);

            return order;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过oid得到订单状态
     * @param oid
     */
    public int getStateByOid(String oid){

        try {
            String sql = "select state from orders where oid=?";
            return (Integer) qr.query(sql, new ScalarHandler(), oid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateState(String oid, int state){

        try{
            String sql = "update orders set state=? where oid=?";
            qr.update(sql, state, oid);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
