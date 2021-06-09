<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%--//lab-2--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>validate</title>
</head>
<body>
<%--Todo 1: Use <jsp:useBean> to create a Login bean instance in request scope --%>
<jsp:useBean id="user" scope="request" class="com.lab2.login"/>
<%--Todo 2: Use <jsp:setProperty> to set  beans' property username and password--%>
<jsp:setProperty name="user" property="*"/>
<%
    //todo 3: use if check username is admin and ppassword is admin
    if (user.getUsername().equals("admin") && user.getPassword().equals("admin"))
    {
%>
<%--todo 4: use jsp:forward to welcome.jsp page--%>
<jsp:forward page="welcome.jsp"/>
<%--todo 5: else part{ --%>
<%
}else {
%>
<%
    // todo 6: print username or password error message
    out.println("username or password error message");
%>
<%--todo 7: use jsp:include login.jsp page --%>
<jsp:include page="login.jsp"/>
<%--todo 8: close else --%>
<%
    }
%>
</body>
</html>