<%--
  Created by IntelliJ IDEA.
  User: xulelin
  Date: 2021/4/13
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@include file="header.jsp" %>
<h1>User Info</h1>
<table>

    <tr>
        <td>Username:</td>
        <td><%=request.getAttribute("Username")%>
        </td>
    </tr>
    <tr>
        <td>Password:</td>
        <td><%=request.getAttribute("Password")%>
        </td>
    </tr>
    <tr>
        <td>Email:</td>
        <td><%=request.getAttribute("Email")%>
        </td>
    </tr>
    <tr>
        <td>Gender:</td>
        <td><%=request.getAttribute("Gender")%>
        </td>
    </tr>
    <tr>
        <td>BirthDate:</td>
        <td><%=request.getAttribute("BirthDate")%>
        </td>
    </tr>
</table>
<%@include file="footer.jsp" %>
