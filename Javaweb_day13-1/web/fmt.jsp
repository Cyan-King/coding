<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/6/1
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    Date date = new Date();

    request.setAttribute("date", date);
%>

<fmt:formatDate value="${requestScope.date }" pattern="yyyy-MM-dd HH:mm:ss" />

<hr/>

<%
    Double num = 3.1415526;

    request.setAttribute("num", num);
%>

<fmt:formatNumber value="${requestScope.num }" pattern="#.##" />

</body>
</html>
