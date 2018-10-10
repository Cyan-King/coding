package com.wei.book.dao;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;
import com.wei.book.domain.Book;
import com.wei.category.domain.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class BookDao {
    QueryRunner qr = new TxQueryRunner();

    /**
     * 查询所有图书
     * @return
     */
    public List<Book> findAll() {

        try {

                String sql = "SELECT * FROM book where del=false";
                return qr.query(sql, new BeanListHandler<Book>(Book.class));

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 按分类查询
     * @param cid
     * @return
     */
    public List<Book> findByCategory(String cid) {
        try {

            String sql = "SELECT * FROM book where cid=? and del=false";
            return qr.query(sql, new BeanListHandler<Book>(Book.class), cid);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 加载方法
     * @param bid
     * @return
     */
    public Book findByid(String bid) {
        try {

            /**
             * 我们需要保存category中的信息
             */
            String sql = "SELECT * FROM book where bid=?";
            Map<String, Object> map = qr.query(sql, new MapHandler(), bid);

            /**
             * 使用map映射两个对象，在建立联系
             */
            Category category = CommonUtils.toBean(map, Category.class);
            Book book = CommonUtils.toBean(map, Book.class);
            book.setCategory(category);
            return book;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询图书本数
     * @param cid
     * @return
     */
    public int getCountByCid(String cid) {

        try {

            String sql = "SELECT count(*) FROM book where cid=?";
            Number number = (Number) qr.query(sql, new ScalarHandler(), cid);

            return number.intValue();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 添加图书
     * @param book
     */
    public void add(Book book) {
        try {

            String sql = "insert into book value(?,?,?,?,?,?,?)";
            Object[] params = {book.getBid(), book.getBname(), book.getPrice(), book.getAuthor(), book.getImage(), book.getCategory().getCid(), book.isDel()};
            qr.update(sql, params);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除图书
     * @param bid
     */
    public void del(String bid){
        try{
            String sql = "update book set del=true where bid=?";
            qr.update(sql, bid);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void edit(Book book) {
        try {

            String sql = "update book set bname=?, price=?,author=?, image=?, cid=? where bid=?";
            Object[] params = {book.getBname(), book.getPrice(),
                    book.getAuthor(), book.getImage(),
                    book.getCategory().getCid(), book.getBid()};
            qr.update(sql, params);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
