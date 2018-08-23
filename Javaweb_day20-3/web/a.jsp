<%@ page import="com.wei.User" %><%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/8/4
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>向session中保存数据</h1>

<%
    session.setAttribute("xxx", new User());
%>

</body>
</html>
