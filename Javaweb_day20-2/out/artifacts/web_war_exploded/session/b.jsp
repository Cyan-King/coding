<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/8/4
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>获取session的值</h1>
<%
    out.print(session.getAttribute("xxx"));
%>

</body>
</html>
