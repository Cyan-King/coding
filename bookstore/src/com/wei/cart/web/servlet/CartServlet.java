package com.wei.cart.web.servlet;

import cn.itcast.servlet.BaseServlet;
import com.wei.book.domain.Book;
import com.wei.book.service.BookService;
import com.wei.cart.domain.Cart;
import com.wei.cart.domain.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends BaseServlet {

    /**
     * 添加购物车
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 1. 得到车
         * 2. 得到条目（得到图书和数量）
         * 3. 把条目添加到车中
         */
        /*
         * 1. 得到车
         */
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        if (cart == null){
            request.setAttribute("msg", "请登录先登录，这样才能加入购物车！");
            return "f:/jsps/user/login.jsp";
        }
        /*
         * 表单传递的只有bid和数量
         * 2. 得到条目
         *   > 得到图书和数量
         *   > 先得到图书的bid，然后我们需要通过bid查询数据库得到Book
         *   > 数量表单中有
         */
        String bid = request.getParameter("bid");
        Book book = new BookService().load(bid);

        int count = Integer.parseInt(request.getParameter("count"));
        if (count<=0){
            request.setAttribute("msg", "购物车数量不能为小于0");
            return "f:/jsps/cart/list.jsp";
        }else {
            CartItem cartItem = new CartItem();
            cartItem.setBook(book);
            cartItem.setCount(count);

            /*
             * 3. 把条目添加到车中
             */
            cart.add(cartItem);
        }


        return "f:/jsps/cart/list.jsp";
    }

    /**
     * 清空购物车
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        cart.clear();

        return "f:/jsps/cart/list.jsp";
    }


    /**
     * 删除购物车
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        String bid = request.getParameter("bid");
        cart.delete(bid);

        return "f:/jsps/cart/list.jsp";
    }
}
