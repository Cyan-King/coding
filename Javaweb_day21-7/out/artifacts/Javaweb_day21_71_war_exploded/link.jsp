<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/8/12
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>链接页面</h1>

<a href="<c:url value='/BookServlet?method=findAll' />">查询所有</a><br/>
<a href="<c:url value='/BookServlet?method=findByCategory&category=1' />">查询SE分类</a><br/>
<a href="<c:url value='/BookServlet?method=findByCategory&category=2' />">查询EE分类</a><br/>
<a href="<c:url value='/BookServlet?method=findByCategory&category=3' />">查询框架分类</a><br/>

</body>
</html>
