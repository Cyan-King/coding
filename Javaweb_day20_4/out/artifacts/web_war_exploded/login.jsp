<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %><%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/8/7
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    Locale locale = request.getLocale();
    ResourceBundle rb = ResourceBundle.getBundle("res", locale);
%>

<h1><%=rb.getString("login")%>
</h1>
<h1>登录</h1>
<form action="" method="post">
    <%=rb.getString("username")%>：<input type="text" name="username"/><br/>
    <%=rb.getString("password")%>：<input type="password" name="password"/><br/>
    <input type="submit" value="<%=rb.getString("login")%>"/>
</form>
</body>
</html>
