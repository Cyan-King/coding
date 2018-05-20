<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/5/19
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String name = "";
    Cookie[] cookies = request.getCookies();
    if (cookies != null){
        for (Cookie c : cookies){
            if ("uname".equals(c.getName())){
                name = c.getName();
            }
        }
    }
%>

<%
    String message = "";
    String msg = (String) request.getAttribute("msg");//获取msg信息
    if (msg != null){
        message = msg;
    }
%>


<h1>登录页面</h1>
<font color="red"><b><%=message %> </b></font>
<form action="/Javaweb_day11-3/LoginServlet" method="post">

    用户名：<input type="text" name="userName" value="<%=name %>" /><br/>
    密  码：<input type="password" name="password" /><br/>
        <input type="submit" value="提交" />

</form>

</body>
</html>
