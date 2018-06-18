<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/5/31
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:url value="/AServlet" /><br/>
${pageContext.request.contextPath}/AServlet

<a href="<c:url value='/index.jsp'/>">点击这里</a><br/>
<<a href="/Javaweb_day13-1/index.jsp">点击这里</a>>

</body>
</html>
