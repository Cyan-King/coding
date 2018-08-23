<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>这就是一个游客没啥权限</h1><br/>
<a href="<c:url value='/index.jsp' />">游客入口</a><br/>
<a href="<c:url value='/user/user.jsp' />">会员入口</a><br/>
<a href="<c:url value='/admin/admin.jsp' />">管理员入口</a><br/>
</body>
</html>