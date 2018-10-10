<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/10/5
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>servlet3.0上传</h1>
<form action="<c:url value="/AServlet" />" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username"/><br/>
    上&nbsp;&nbsp;&nbsp;传：<input type="file" name="upload" /><br/>
    <input type="submit" value="上传">
</form>
</body>
</html>
