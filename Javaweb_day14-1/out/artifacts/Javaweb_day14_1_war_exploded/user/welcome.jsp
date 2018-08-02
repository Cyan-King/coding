<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/6/9
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入jstl的核心库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>欢迎来到本页面</h1>

<c:choose>
    <c:when test="${empty sessionScope.sessionUser }">
        滚
    </c:when>
    <c:otherwise>
        用户名：${sessionScope.sessionUser.username }<br/>
        密&nbsp;&nbsp;&nbsp;码：${sessionScope.sessionUser.password }<br/>
        性&nbsp;&nbsp;&nbsp;别：${sessionScope.sessionUser.sex }<br/>
        爱&nbsp;&nbsp;&nbsp;好：${sessionScope.sessionUser.love }<br/>
    </c:otherwise>
</c:choose>

</body>
</html>
