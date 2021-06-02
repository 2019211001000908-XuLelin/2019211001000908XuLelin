package com.xulelin.week5.homework;

import com.xulelin.dao.UserDao;
import com.xulelin.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    public Connection con;

    public void init() throws ServletException {
        super.init();
//        String driver = getServletContext().getInitParameter("driver");
//        String url = getServletContext().getInitParameter("url");
//        String username = getServletContext().getInitParameter("username");
//        String password = getServletContext().getInitParameter("password");
//
//        try{
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, username, password);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");

        UserDao userDao = new UserDao();

        try {
            User user = userDao.findByUsernamePassword(con, Username, Password);
            if (user != null) {
                //valid
                //week 8 code
                //add code for remember me
                String rememberMe = request.getParameter("rememberMe");
                if (rememberMe != null && rememberMe.equals("1")) {
                    //want to remember me
                    //create 3 cookies
                    Cookie usernameCookie = new Cookie("cUsername", user.getUsername());
                    Cookie passwordCookie = new Cookie("cPassword", user.getPassword());
                    Cookie rememberMeCookie = new Cookie("cRememberMe", rememberMe);

                    //set age of cookies
                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);

                    //add cookies into response
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }

                //create a session
                HttpSession session = request.getSession();
                //check session id
                System.out.println("session id -->" + session.getId());
                session.setMaxInactiveInterval(10);

                //set user model into request
                session.setAttribute("user", user);
                request.getRequestDispatcher("WEB-INF/views/UserInfo.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        /* String sql = "select * from usertable where Username='" + Username + "' and Password='" + Password + "'";

        try {
            System.out.println("con:" + con);
            Statement sta = con.createStatement();
            System.out.println(sql);
            ResultSet rs = sta.executeQuery(sql);

            if (rs.next()) {
//                writer.println("Login Success!!!");
//                writer.println("Welcome" + Username);
                request.setAttribute("id", rs.getInt("id"));
                request.setAttribute("Username", rs.getString("Username"));
                request.setAttribute("Password", rs.getString("Password"));
                request.setAttribute("Email", rs.getString("Email"));
                request.setAttribute("Gender", rs.getString("Gender"));
                request.setAttribute("BirthDate", rs.getString("BirthDate"));

                request.getRequestDispatcher("UserInfo.jsp").forward(request, response);

            } else {
//                writer.println("Username or Password Error!!!");
                request.setAttribute("message", "Username or Password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println(e);
        }*/
    }
}
