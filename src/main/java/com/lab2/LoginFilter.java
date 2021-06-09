package com.lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(filterName = "LoginFilter",urlPatterns = {"/lab2/welcome.jsp"})
public class LoginFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        System.out.println("I am in LoginFilter --> init()");
    }

    public void destroy() {
        System.out.println("I am in LoginFilter --> destroy()");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("I am in LoginFilter --> doFilter() -- request before chain");

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        if (request.getSession() != null && request.getSession().isNew()){
            request.getRequestDispatcher("/lab2/welcome.jsp").forward(request,response);
        }else {
            response.sendRedirect(request.getContextPath() + "/lab2/login.jsp");
        }
        chain.doFilter(req, resp);
        System.out.println("I am in LoginFilter --> doFilter() -- request after chain");
    }



}