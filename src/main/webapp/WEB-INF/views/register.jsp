<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<section id="form"><!--form-->
    <div class="container">
        <div class="row">
            <div class="col-sm-4 col-sm-offset-1">
                <div class="login-form"><!--login form--><h2>Login to your
                    account</h2><% if (!(request.getAttribute("message") == null))
                    out.println("<h3>" + request.getAttribute("message") + "</h3>");%><% Cookie[] cookies = request.getCookies();
                    String Username = "";
                    String Password = "";
                    String rememberMe = "";
                    if (cookies != null) for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("cUsername")) Username = cookie.getValue();
                        if (cookie.getName().equals("cPassword")) Password = cookie.getValue();
                        if (cookie.getName().equals("cRememberMe")) rememberMe = cookie.getValue();
                    }%>
                    <form method="post" action="<%=basePath+"login"%>">
                        <input type="text" name="Username" placeholder="Username" value="<%=Username%>"><br>
                        <input type="password" name="Password" placeholder="Password" value="<%=Password%>"><br/><span>
                        <input type="checkbox" class="checkbox" name="remember"
                               value="1" <%="1".equals(rememberMe) ? "checked" : ""%>/> Keep me signed in</span>
                        <button type="submit" class="btn btn-default">Login</button>
                    </form>
                </div><!--/login form--></div>
            <div class="col-sm-1"><h2 class="or">OR</h2></div>
            <div class="col-sm-4">
                <div class="signup-form"><!--sign up form--><h2>New User
                    Registration!</h2><% if (!(request.getAttribute("message") == null))
                    out.println("<h3>" + request.getAttribute("message") + "</h3>");%>
                    <form method="post" action="register">
                        <input type="text" name="Username" placeholder="Username"/>
                        <input type="password" name="Password" placeholder="Password"/>
                        <input type="text" name="Email" placeholder="Email">
                        <label>Gender</label><span> &nbsp;
                        <input type="radio" style="width: 15px; height: 15px; display:inline;" name="Gender"
                               value="male" checked/>&nbsp;Male&nbsp;
                        <input type="radio" style="width: 15px; height: 15px;   display: inline;" name="Gender"
                               value="female"/>&nbsp;Female</span><span></span>
                        <input type="date" name="BirthDate" placeholder="Date of Birth (yyyy-mm-dd)">
                        <button type="submit" class="btn btn-default">Register</button>
                    </form>
                </div><!--/sign up form--></div>
        </div>
    </div>
</section>
<!--/form-->
<%@include file="footer.jsp" %>
