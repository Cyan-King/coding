<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/5/18
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>session获取数据</h1>
<%
    String s = (String) session.getAttribute("aaa");
%>

<%=s %>
</body>
</html>
