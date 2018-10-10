package com.wei.book.service;

import com.wei.book.dao.BookDao;
import com.wei.book.domain.Book;

import java.util.List;

public class BookService {
    private BookDao bookDao = new BookDao();

    /**
     * 添加图书
     * @param book
     */
    public void add(Book book){
        bookDao.add(book);
    }

    //查询图书
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    //查询图书分类
    public List<Book> findByCategory(String cid) {
        return bookDao.findByCategory(cid);
    }

    //加载所有图书
    public Book load(String bid) {
        return bookDao.findByid(bid);
    }


    /**
     * 删除图书
     * @param bid
     */
    public void del(String bid){
        bookDao.del(bid);
    }

    public void edit(Book book) {
        bookDao.edit(book);
    }
}
