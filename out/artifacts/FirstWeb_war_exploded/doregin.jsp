<%--
  Created by IntelliJ IDEA.
  User: 山间清爽的风
  Date: 2019/4/8
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="entity.User"  %>
<%@page import="dao.UserDao" %>

<html>
<head>
    <title>doregin</title>
</head>
<body>
<%
    UserDao userdao=new UserDao();
    User user=new User();
    request.setCharacterEncoding("utf-8");

%>
<%
user.setUsername(request.getParameter("username"));
user.setPassword(request.getParameter("password"));
user.setCity(request.getParameter("city"));
%>
用户名：<%=user.getUsername()%>
密码：<%=user.getPassword()%>
城市：<%=user.getCity()%>
<%

if(userdao.userRegin(user))
{

%>
<a href="login.jsp"  ><h1>返回登录</h1></a>
<%
    }

else
    {
        out.println("注册失败！");
    }

%>
</body>
</html>
