<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>

  <%--存放代码块--%>
  <%
    int a = 10;
  %>

  <%--这个是局部变量使用了之后就直接销毁了--%>
  <%
    System.out.println(a++ + "kk");
  %>

  <%--表达式--%>
  <%=a + "ll"%>

  </body>
</html>