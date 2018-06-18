<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/5/31
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--进行判断参数不无空，错误的这个--%>
<c:if test="${not empty param.name }">
    您没有给出参数${param.name }
</c:if>


<c:choose>
    <c:when test="${empty param.name}">
        得到了参数${param.name }
    </c:when>
    <c:otherwise>
        没得到参数${param.name }
    </c:otherwise>
</c:choose>

</body>
</html>
