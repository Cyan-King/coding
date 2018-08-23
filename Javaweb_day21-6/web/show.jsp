<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/8/12
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1 align="center">图书列表</h1>

<table align="center" width="50%" border="1" >
    <tr>
        <th>书名</th>
        <th>单价</th>
        <th>分类</th>
    </tr>

    <c:forEach items="${BookList }" var="book">
        <tr>
            <td>${book.bname }</td>
            <td>${book.price }</td>

            <c:choose>
                <c:when test="${book.category eq 1 }"><td style="color: red">JavaSE</td></c:when>
                <c:when test="${book.category eq 2 }"><td style="color: yellow">JavaEE</td></c:when>
                <c:when test="${book.category eq 3 }"><td style="color: green">框架</td></c:when>
            </c:choose>
        </tr>
    </c:forEach>



</table>

</body>
</html>
