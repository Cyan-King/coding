package com.wei.web.sevlet;

import com.wei.dao.Dao;
import com.wei.domain.City;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        /**
         * 1. 获取pid的参数
         * 2. 使用这个省pid查询数据库
         * 3. 转发成为json，发送给客户端
         */

        //获得pid参数
        int pid = Integer.parseInt(request.getParameter("pid"));

        Dao dao = new Dao();
        List<City> city = dao.findByCity(pid);

        //转换成为json
        String json = JSONArray.fromObject(city).toString();

        //发送给客户端
        response.getWriter().print(json);


    }
}
