package com.wei.servlet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;

public class AServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Context context = new InitialContext();

            /**
             * java:comp/evn/jdbc/dataSource这个路径是指定路径
             */
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/dataSource");

            Connection con = dataSource.getConnection();

            System.out.println(con);
            con.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
