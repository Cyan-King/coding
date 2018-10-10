package com.wei.web.sevlet;

import com.wei.dao.Dao;
import com.wei.domain.Provnice;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProvniceServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");


        /**
         * 1.通过Dao到得到所有的省
         * 2.把List<Provnice>转换成为json
         * 3.发送给客户端
         */

        Dao dao = new Dao();
        List<Provnice> pro = dao.findByProvnice();

        String json = JSONArray.fromObject(pro).toString();
        System.out.println(json);

        response.getWriter().print(json);


    }
}
