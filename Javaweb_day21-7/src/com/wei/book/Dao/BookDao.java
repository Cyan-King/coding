package com.wei.book.Dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.wei.book.domain.Book;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDao {

    QueryRunner qr = new TxQueryRunner();

    /**
     * 查询所有
     *
     * @return
     */
    public List<Book> findAll() {


        try {
            String sql = "SELECT * FROM t_book";
            return qr.query(sql, new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> findByCategory(int category) {
        try {
            String sql = "SELECT * FROM t_book where category=?";

            return qr.query(sql, new BeanListHandler<Book>(Book.class), category);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
