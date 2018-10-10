package com.wei.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "AServlet")
public class AServlet extends BaseServlet {

    public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("addUser()");

    }

    public void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("editUser()");
    }
    public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("deleteUser()");
    }


}
