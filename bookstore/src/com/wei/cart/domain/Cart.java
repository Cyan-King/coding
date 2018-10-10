package com.wei.cart.domain;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车模块
 */
public class Cart {


    Map<String, CartItem> map = new LinkedHashMap<String, CartItem>();

    /**
     * 总计方法
     * @return
     */
    public double getTotal(){

        BigDecimal total = new BigDecimal("0");
        for (CartItem cartItem:map.values()) {
            BigDecimal subtotal = new BigDecimal("" + cartItem.getSubtotal());
            total = total.add(subtotal);
        }

        return total.doubleValue();

    }

    /**
     * 添加条目
     * @param cartItem
     */
    public void add(CartItem cartItem) {
        if(map.containsKey(cartItem.getBook().getBid())) {//判断原来车中是否存在该条目
            CartItem _cartItem = map.get(cartItem.getBook().getBid());//返回原条目
            _cartItem.setCount(_cartItem.getCount() + cartItem.getCount());//设置老条目的数量为，其自己数量+新条目的数量
            map.put(cartItem.getBook().getBid(), _cartItem);
        } else {
            map.put(cartItem.getBook().getBid(), cartItem);
        }
    }

    /**
     * 清空条目
     */
    public void clear(){

        map.clear();

    }

    /**
     * 删除条目
     * @param bid
     */
    public void delete(String bid){

        map.remove(bid);
    }


    public Collection<CartItem> getCartItems() {
        return map.values();
    }




}
