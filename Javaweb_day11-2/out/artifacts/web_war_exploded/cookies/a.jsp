<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/5/15
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>创建Cookie</h1>
<%
    Cookie cookie1 = new Cookie("aa", "AA");
    response.addCookie(cookie1);

    Cookie cookie2 = new Cookie("AA", "BB");
    response.addCookie(cookie2);
%>
</body>
</html>
