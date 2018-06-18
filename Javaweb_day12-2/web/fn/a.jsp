<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/5/29
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--在这里我们要使用jstl.jar包idea是没有整个jar包的--%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String [] strs = {"a","b","c"};
    List list = new ArrayList();
    list.add("a");
    pageContext.setAttribute("arr", strs);
    pageContext.setAttribute("list",list);


%>

${fn:length(arr) }<br/>
${fn:length(list) }<br/>
${fn:replace(Arrays.toString(arr), "a", "p")}
</body>
</html>
