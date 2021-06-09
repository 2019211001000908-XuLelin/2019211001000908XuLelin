package com.xulelin.controller;

import com.xulelin.dao.OrderDao;
import com.xulelin.model.Item;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/orderDetails")
public class OrderDetailsServlet extends HttpServlet {
    Connection con = null;

    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = request.getParameter("orderId") != null ?
                Integer.parseInt(request.getParameter("orderId")) : 0;
        System.out.println("orderId:" + orderId);
        OrderDao dao = new OrderDao();
        List<Item> items = dao.findItemsByOrderId(con, orderId);
        System.out.println(items.size());
        request.setAttribute("itemList", items);
        String path = "orderDetails.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    }
}