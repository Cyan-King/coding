package com.wei.web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import com.wei.domain.Customer;
import com.wei.domain.PageBean;
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
import java.io.UnsupportedEncodingException;
import java.util.List;


/**
 * web层
 */
public class CustomerServlet extends BaseServlet {
    private CustomerService customerService = new CustomerService();

    /**
     * 添加用户
     *
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
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /**
         * 获取页面船体的pc，在这里我们使用了判定pc的方法，自己写的
         */
        int pc = getPc(request);
        //自定义ps
        int ps = 10;
        //service层的
//        PageBean<Customer> pb = customerService.findAll(pc, ps);
        PageBean<Customer> pb = customerService.findAll(pc, ps);

        //将url保存到request域中
        pb.setUrl(getUrl(request));


        //保存到request域中
        request.setAttribute("pb", pb);

        return "f:/list.jsp";

    }

    private int getPc(HttpServletRequest request) {

        //获得页面传递的pc
        String values = request.getParameter("pc");

        if (values == null || values.trim().isEmpty()) {
            return 1;
        }

        return Integer.parseInt(values);

    }

    /**
     * 加载用户到界面
     *
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
        Customer cstm = customerService.load(cid);

        //保存到request中
        request.setAttribute("cstm", cstm);

        //将数据返回给edit.jsp
        return "f:/edit.jsp";
    }

    /**
     * 修改用户资料
     *
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

    /**
     * 删除操作
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
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

//    /**
//     * 高级查询
//     *
//     * @param request
//     * @param response
//
//     * @return
//             * @throws ServletException
//     * @throws IOException
//     */
//    public String query(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        //封装Customer对象
//        Customer criteria = CommonUtils.toBean(request.getParameterMap(), Customer.class);
//
//        //service操作
//        List<Customer> cstmList = customerService.query(criteria);
//
//        //保存到reuest域中
//        request.setAttribute("cstmList", cstmList);
//
//        return "/list.jsp";
//    }

    /**
     * 多条件组合查询
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String query(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /**
         * 获取Customer
         */
        Customer customer = CommonUtils.toBean(request.getParameterMap(), Customer.class);

        /**
         * 解决get的编码问题
         */
//        customer = encoding(customer);

        int pc = getPc(request);
        int ps = 10;

        PageBean<Customer> pb = customerService.query(customer, pc, ps);

        request.setAttribute("pb", pb);

        //将url保存到request域中
        pb.setUrl(getUrl(request));

        return "f:/list.jsp";
    }

    /**
     * 处理四样
     *
     * @param criteria
     * @return
     * @throws UnsupportedEncodingException
     */
//    private Customer encoding(Customer criteria) throws UnsupportedEncodingException {
//        String cname = criteria.getCname();
//        String gender = criteria.getGender();
//        String cellphone = criteria.getCellphone();
//        String email = criteria.getEmail();
//
//        if (cname != null && !cname.trim().isEmpty()) {
//            cname = new String(cname.getBytes("ISO-8859-1"), "utf-8");
//            criteria.setCname(cname);
//        }
//
//        if (gender != null && !gender.trim().isEmpty()) {
//            gender = new String(gender.getBytes("ISO-8859-1"), "utf-8");
//            criteria.setGender(gender);
//        }
//
//        if (cellphone != null && !cellphone.trim().isEmpty()) {
//            cellphone = new String(cellphone.getBytes("ISO-8859-1"), "utf-8");
//            criteria.setCellphone(cellphone);
//        }
//
//        if (email != null && !email.trim().isEmpty()) {
//            email = new String(email.getBytes("ISO-8859-1"), "utf-8");
//            criteria.setEmail(email);
//        }
//        return criteria;
//    }

    /**
     * 获取url
     *
     * @param request
     * @return
     */
    private String getUrl(HttpServletRequest request) {
        String contextPath = request.getContextPath();//获取项目名
        String servletPath = request.getServletPath();//获取servletPath，即/CustomerServlet
        String queryString = request.getQueryString();//获取问号之后的参数部份

        //  判断参数部份中是否包含pc这个参数，如果包含，需要截取下去，不要这一部份。
        if (queryString.contains("&pc=")) {
            int index = queryString.lastIndexOf("&pc=");
            queryString = queryString.substring(0, index);
        }

        return contextPath + servletPath + "?" + queryString;
    }

}
