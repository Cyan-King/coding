<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/5/31
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<%--step是1结果是：1 2 3 4 5 6 7 8 9 10--%>
<%--step是2结果是：1 3 5 7 9--%>
<c:forEach var="i" begin="1" end="10" step="1">
    ${i }
</c:forEach>
<br/>

<%
    String [] strs = {"one", "two", "three"};
    request.setAttribute("strs", strs);
%>

<c:forEach items="${requestScope.strs }" var="str">
    ${str}
</c:forEach>
<hr/>

<%
    ArrayList<String> list = new ArrayList<String>();
    list.add("一");
    list.add("二");
    list.add("三");

    application.setAttribute("list", list);
%>

<c:forEach items="${applicationScope.list }" var="lists" varStatus="vs">
    ${vs.first } ${vs.last } ${vs.index } ${vs.count } ${vs.current } ${lists }<br/>
</c:forEach>

</body>
</html>
