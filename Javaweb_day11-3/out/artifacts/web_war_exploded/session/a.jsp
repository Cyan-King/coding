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
<h1>session保存数据</h1>
<%
    //我们使用session域中的setAttribute发发保存数据----每个域都用三种方法setAttribute(),getAttribute(),还有removeAttribute()
    session.setAttribute("aaa","魏国平");
%>

</body>
</html>
