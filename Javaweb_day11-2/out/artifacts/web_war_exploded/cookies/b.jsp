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

<h1>获取Cookie信息</h1>
<%
    Cookie[] cookies = request.getCookies();
    if(cookies != null) {
        for(Cookie c : cookies) {
            System.out.println(c.getName() + "=" + c.getValue() + "<br/>");
        }
    }
%>

</body>
</html>
