package com.wei.web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import com.wei.domain.Customer;
import com.wei.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;


/**
 * web层
 */
public class CustomerServlet extends BaseServlet {
    private CustomerService customerService = new CustomerService();

    /**
     * 添加用户
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
         * 1. 封装表单数据到Customer对象
         * 2. 补全：cid，使用uuid---uuid是一个自动生成id的方法
         * 3. 使用service方法完成添加工作--- customerService.add(c);
         * 4. 向request域中保存成功信息
         * 5. 转发到msg.jsp
         */
        Customer c = CommonUtils.toBean(request.getParameterMap(), Customer.class);
        c.setCid(CommonUtils.uuid());
        customerService.add(c);
        request.setAttribute("msg", "恭喜，添加客户成功！");
        return "f:/msg.jsp";
    }

    /**
     * 查询用户
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /**
         * 1.调用service中的所有用户
         * 2.保存到request
         * 3.转发到list.jsp
         */
       request.setAttribute("cstmList", customerService.findAll());
       return "f:/list.jsp";

    }

    /**
     * 加载用户到界面
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String preEidt(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //从request中得到cid
        String cid = request.getParameter("cid");

        //通过cid查询Customer对象
         Customer cstm =  customerService.load(cid);

         //保存到request中
         request.setAttribute("cstm", cstm);

         //将数据返回给edit.jsp
        return "f:/edit.jsp";
    }

    /**
     * 修改用户资料
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //封装Customer对象
        Customer c = CommonUtils.toBean(request.getParameterMap(), Customer.class);

        //通过service中的edit()方法进行编辑
        customerService.edit(c);

        request.setAttribute("msg", "恭喜，修改客户成功！");

        return "f:/msg.jsp";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //从request中得到cid
        String cid = request.getParameter("cid");

        //通过cid查询Customer对象
        customerService.delete(cid);

        //保存到request中
        request.setAttribute("msg", "恭喜，删除客户成功！");

        //将数据返回给edit.jsp
        return "f:/msg.jsp";
    }

    /**
     * 高级查询
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String query(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //封装Customer对象
        Customer criteria = CommonUtils.toBean(request.getParameterMap(), Customer.class);

        List<Customer> cstmList = customerService.query(criteria);

        request.setAttribute("cstmList", cstmList);

        return "/list.jsp";
    }

    /*public String query(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        *//*
         * 1. 封装表单数据到Customer对象中，它只有四个属性（cname、gender、cellphone、email）
         *   它就是一个条件
         * 2. 使用Customer调用service方法，得到List<Customer>
         * 3. 保存到request域中
         * 4. 转发到list.jsp
         *//*
        Customer criteria = CommonUtils.toBean(request.getParameterMap(), Customer.class);
        List<Customer> cstmList = customerService.query(criteria);
        request.setAttribute("cstmList", cstmList);
        return "/list.jsp";
    }*/



}
