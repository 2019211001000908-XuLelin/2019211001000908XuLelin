package com.xulelin.controller;

import com.xulelin.dao.UserDao;
import com.xulelin.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {

    Connection con = null;

    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO 1. - forward to WEB-INF/views/updateUser.jsp
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
        // TODO 2. - create a new jsp WEB-INF/views/updateUser.jsp
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // TODO 1 : get all parameters
        // TODO 2 : create a user model
        // TODO 3 : set 6 values into user model
        // TODO 4 : create an object of UserDao
        // TODO 5 : call updateUser() of UserDao for update information
        // TODO 6 : forward to WEB-INF/views/UserInfo.jsp

        int id = Integer.parseInt(request.getParameter("id"));
        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");
        String Email = request.getParameter("Email");
        String Gender = request.getParameter("Gender");

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date BirthDate = sdf.parse(request.getParameter("BirthDate"));

            User user = new User();
            user.setId(id);
            user.setUsername(Username);
            user.setPassword(Password);
            user.setEmail(Email);
            user.setGender(Gender);
            user.setBirthDate(BirthDate);

            UserDao userDao = new UserDao();
            Connection con = (Connection) getServletContext().getAttribute("con");
            try {
                if (userDao.updateUser(con, user) != 0) {
                    User u = userDao.findByUsernamePassword(con, Username, Password);
                    HttpSession session = request.getSession();
                    session.setMaxInactiveInterval(10);
                    session.setAttribute("user", u);
                    request.getRequestDispatcher("accountDetails").forward(request, response);
                }
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}