package com.xulelin.week4.homework;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//use @WebServlet - no web.xml code
@WebServlet(
        urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name = "name", value = "Xu Lelin"),
                @WebInitParam(name = "studentId", value = "2019211001000908")
        }
)
public class ConfigDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = getServletConfig().getInitParameter("name");
        String studentId = getServletConfig().getInitParameter("studentId");
        PrintWriter writer = response.getWriter();
        writer.println("<br/>name:" + name);
        writer.println("<br/>studentId:" + studentId);
    }
}
