<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/5/31
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<%
    request.setAttribute("code", "<script>alert('tttt');</script>");
%>--%>

<%---直接替代了下面那行代码-%>
<c:set var="code" value="<script>alert('tttt');</script>" scope="request" />

<c:out value="${code }" escapeXml="false" ></c:out><%--这句话直接替代下面那句代码而且直接使用escapeXML的默认值为true直接转义了--%>
<%--${code }--%>
</body>
</html>
