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
    //读取session域中的数据
    String userName = (String) session.getAttribute("userName");
    if (userName == null){
        request.setAttribute("msg", "您还没有登陆");
        request.getRequestDispatcher("/session2/login.jsp").forward(request, response);//转发
        return;
    }
%>

<h1>welcome to NIMEI,<%=userName%></h1>

</body>
</html>
