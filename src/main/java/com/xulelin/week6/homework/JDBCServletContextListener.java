package com.xulelin.week6.homework;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//tell tomcat this class is a listener class
@WebListener
public class JDBCServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        //called when tomcat start
        ServletContext context = sce.getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("i am in contextInitialized()-->" + con);//when
            //set connection as a context attribute -- for all jsp and servlet
            context.setAttribute("con", con);//name=value
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        //called when tomcat stop
        System.out.println("i am in contextDestroyed()");//when
        //remove connection from context
        sce.getServletContext().removeAttribute("con");
    }
}
