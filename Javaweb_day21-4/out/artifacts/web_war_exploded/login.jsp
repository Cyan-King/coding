<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/8/11
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>登录</h1><br/>
${msg }
<form action="<c:url value='/LoginServlet' />" method="post">
    用户名：<input type="text" name="username"/><br/>
    <input type="submit" value="登录"><br/>
</form>
</body>
</html>
