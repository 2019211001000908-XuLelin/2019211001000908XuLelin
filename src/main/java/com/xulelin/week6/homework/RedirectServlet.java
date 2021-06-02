package com.xulelin.week6.homework;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //redirect - same server - Relative URL
        //1. start without /
        System.out.println("before redirect");

//        response.sendRedirect("index.jsp");//url
        System.out.println("after redirect");

        //2.start with /
//        response.sendRedirect("/index.jsp");

        //redirect - another server - Absolute URL
        response.sendRedirect("www.baidu.com");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
