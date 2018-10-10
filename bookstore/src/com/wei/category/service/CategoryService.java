package com.wei.category.service;

import com.wei.book.dao.BookDao;
import com.wei.category.dao.CategoryDao;
import com.wei.category.domain.Category;
import com.wei.category.web.servlet.admin.CategoryExcetion;

import java.util.List;

public class CategoryService {

    private CategoryDao categoryDao = new CategoryDao();
    BookDao bookDao = new BookDao();

    //查询所有分类
    public List<Category> findAll() {

        return categoryDao.findAll();
    }

    /**
     * 添加分类
     * @param category
     */
    public void add(Category category) {

        categoryDao.add(category);
    }

    /**
     * 删除分类
     * @param cid
     * @throws CategoryExcetion
     */
    public void delete(String cid) throws CategoryExcetion {
        int count = bookDao.getCountByCid(cid);

        if (count > 0) throw new  CategoryExcetion("该图书分类下面还有图书不能删除");

        categoryDao.delete(cid);


    }

    /**
     * 加载类
     * @param cid
     * @return
     */
    public Category load(String cid) {
        return categoryDao.load(cid);
    }

    /**
     * 修改类
     * @param category
     */
    public void edit(Category category) {
        categoryDao.edit(category);
    }
}
