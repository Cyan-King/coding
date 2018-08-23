<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/8/15
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<form action="<c:url value="/UploadServlet">" method="post" enctype="multipart/form-data">--%>
<%--用户名：<input type="text" name="username"/><br/>--%>
<%--上 传：<input type="file" name="zhaoPian"/><br/>--%>
<%--<input type="submit" value="上传"/>--%>
<%--</form>--%>

<h1>上传</h1><br/>
<h2>${msg }</h2>

<form action="<c:url value='/UploadServlet2' />" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username"/><br/>
    上  传：<input type="file" name="zhaoPian"/><br/>
    <input type="submit" value="上传"/>
</form>

</body>
</html>
