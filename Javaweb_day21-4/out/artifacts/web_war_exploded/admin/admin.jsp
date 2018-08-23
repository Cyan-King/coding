<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/8/11
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>管理员您好，日安！</h1><br/>
<a href="<c:url value='/index.jsp' />">游客入口</a><br/>
<a href="<c:url value='/user/user.jsp' />">会员入口</a><br/>
<a href="<c:url value='/admin/admin.jsp' />">管理员入口</a><br/>
</body>
</html>
