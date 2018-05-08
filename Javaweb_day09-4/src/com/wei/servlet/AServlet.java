package com.wei.servlet;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 演示获取类路径下的资源
 * @author cxf
 *
 */
public class AServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClassLoader cl = this.getClass().getClassLoader();

        InputStream input = cl.getResourceAsStream("a.txt");

        String s = IOUtils.toString(input);
        System.out.println(s);
    }

}
