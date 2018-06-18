<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title></title>
  </head>
  <body>

  <a href="<c:url value='/UserServlet' />">点击这里查看数据</a><br/>
  <a href="/UserServlet?method=doGet">点击</a><br/>
  用户名：${user.userName }<br/>
  密  码：${user.password }
  </body>
</html>