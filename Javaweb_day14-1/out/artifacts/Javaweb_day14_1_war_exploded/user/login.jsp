<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/6/9
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入jstl的核心库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>登录</h1>
<p style="color: red; font-size: 21px">${msg }</p>
<form action="<c:url value="/LoginServlet" />" method="post">
    用户名：<input type="text" name="username" value="${user.username }" /><br/>
    密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" value="${user.password }" /><br/>
    <input type="submit" value="登录">
</form>

</body>
</html>
