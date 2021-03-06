package com.wei.cart.domain;


import com.wei.book.domain.Book;

import java.math.BigDecimal;


/**
 * 条目类
 */
public class CartItem {

    private Book book;//商品
    private int count;//商品数量


    //小计方法
    public double getSubtotal(){

        BigDecimal d1 = new BigDecimal(book.getPrice() + "");
        BigDecimal d2 = new BigDecimal(count + "");

        //数量乘以加个
        return d1.multiply(d2).doubleValue();
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
