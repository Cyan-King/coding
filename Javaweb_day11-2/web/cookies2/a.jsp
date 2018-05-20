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

<h1>cookie的生命时间设置</h1>
<%
    Cookie cookie1 = new Cookie("aaa", "AAA");
    //谁知cookie的生命时间将这个cookie存到硬盘中去
    cookie1.setMaxAge(60*60);
    response.addCookie(cookie1);
%>
</body>
</html>
