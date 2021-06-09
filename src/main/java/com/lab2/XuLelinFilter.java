package com.lab2;

import javax.servlet.*;
import java.io.IOException;
//lab-2
public class XuLelinFilter implements Filter {
    public void destroy() {
    }
    public void init(FilterConfig config) throws ServletException {

    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("xllFilter -- before chain");
        chain.doFilter(req, resp);
        System.out.println("xllFilter -- after chain");
    }

}