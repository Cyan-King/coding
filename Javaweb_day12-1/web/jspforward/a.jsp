<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/5/24
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>a.jsp</h1>

<%--forward转发--%>
<jsp:forward page="b.jsp">
    <jsp:param value="zhangsan" name="userName" />
    <jsp:param value="123" name="password" />
</jsp:forward>

</body>
</html>
