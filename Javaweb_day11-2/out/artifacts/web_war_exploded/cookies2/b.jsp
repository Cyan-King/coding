<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/5/15
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>删除cookie</h1>
<%
    Cookie cookie1 = new Cookie("aaa",  "AAA");
    // 心黑手辣的删除同名的cookie
    cookie1.setMaxAge(0);
    response.addCookie(cookie1);
%>

</body>
</html>
