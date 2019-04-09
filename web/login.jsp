<%--
  Created by IntelliJ IDEA.
  User: 山间清爽的风
  Date: 2019/4/9
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserLogin</title>
</head>
<body>
<form action="dologin.jsp" name="LoingForm" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登录"></td>
            <td> <a href="regin.jsp">注册</a></td>
        </tr>

    </table>
</form>
</body>
</html>
