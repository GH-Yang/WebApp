<%--
  Created by IntelliJ IDEA.
  User: 山间清爽的风
  Date: 2019/4/8
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>userRegin</title>
</head>
<body>
<h1>注册操作页面</h1>
<form action="doregin.jsp" name="reginForm" method="post">
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
            <td>城市：</td>
            <td><input type="text" name="city"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="注册"></td>
        </tr>
    </table>
</form>

</body>
</html>
