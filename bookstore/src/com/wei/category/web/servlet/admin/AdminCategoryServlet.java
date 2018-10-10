package com.wei.category.web.servlet.admin;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import com.wei.category.domain.Category;
import com.wei.category.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminCategoryServlet")
public class AdminCategoryServlet extends BaseServlet {
    private CategoryService categoryService = new CategoryService();

    /**
     * 修改类
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     * @throws CategoryExcetion
     */
    public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CategoryExcetion {

        //封装category类
        Category category = CommonUtils.toBean(request.getParameterMap(), Category.class);

        categoryService.edit(category);

        return findAll(request, response);

    }

    /**
     * 加载类
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     * @throws CategoryExcetion
     */
    public String editPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CategoryExcetion {

        //得到cid
        String cid = request.getParameter("cid");

        //保存到request域中，通过service方法进行加载
        request.setAttribute("category",  categoryService.load(cid));


        return "f:/adminjsps/admin/category/mod.jsp";

    }

    /**
     * 删除分类
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CategoryExcetion {

        /**
         * 获取cid参数
         * 使用service#delete
         *      如果有一场抛出异常，保存异常信息发送msg.jsp
         *  返回findAll()
         */
        String cid = request.getParameter("cid");

       try{
           categoryService.delete(cid);
           return findAll(request, response);
       }catch (CategoryExcetion e){
           request.setAttribute("msg", e.getMessage());
           return "f:/adminjsps/msg.jsp";
       }

    }

    /**
     * 添加分类
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 封装category类
         * 补全cid
         * 调用service中的add方法
         * 调用findAll方法
         */

        Category category = CommonUtils.toBean(request.getParameterMap(), Category.class);
        category.setCid(CommonUtils.uuid());
        categoryService.add(category);

        return findAll(request, response);

    }

    /**
     * 查询分类
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * 调用service#List<Category>,保存到request域中
         * 转发到/adminjsps/admin/category/list.jsp
         */

        request.setAttribute("categoryList", categoryService.findAll());

        return "f:/adminjsps/admin/category/list.jsp";
    }
}
