<%--
  Created by IntelliJ IDEA.
  User: 山间清爽的风
  Date: 2019/4/8
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="dao.UserDao" %>
<%@page import="entity.User" %>

<html>
<head>
    <title>dologin</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    User users=new User();
    UserDao userDao=new UserDao();
    users.setUsername(request.getParameter("username"));
    users.setPassword(request.getParameter("password"));
%>
用户名：<%=users.getUsername()%>
密码：<%=users.getPassword()%>

<%

    if(userDao.IsUser(users))
    {
        request.setAttribute("username",users.getUsername());
        request.getRequestDispatcher("login_success.jsp").forward(request,response);
    }
    else
        response.sendRedirect("login_false.jsp");
%>

</body>
</html>
