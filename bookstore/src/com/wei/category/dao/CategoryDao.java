package com.wei.category.dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.wei.category.domain.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDao {

    QueryRunner qr = new TxQueryRunner();

    /**
     * 查询所有分类
     * @return
     */
    public List<Category> findAll() {

        try {
            String sql = "SELECT * FROM category";
            return qr.query(sql, new BeanListHandler<Category>(Category.class));
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 添加分类
     * @param category
     */
    public void add(Category category) {
        try {
            String sql = "insert into category values(?,?)";
            qr.update(sql, category.getCid(), category.getCname());
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除分类
     * @param cid
     */
    public void delete(String cid) {
        try {
            String sql = "DELETE FROM category where cid=?";
            qr.update(sql, cid);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 加载类
     * @param cid
     * @return
     */
    public Category load(String cid) {
        try {
            String sql = "select * from category where cid=?";
            return qr.query(sql, new BeanHandler<Category>(Category.class), cid);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 修改类
     * @param category
     */
    public void edit(Category category) {
        try {
            String sql = "update category set cname=? where cid=?";
            qr.update(sql, category.getCname(), category.getCid());
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
