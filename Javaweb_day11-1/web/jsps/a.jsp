<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/5/14
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1" width="60%" align="center">

    <tr align="center">
        <td>姓名</td>
        <td>年龄</td>
    </tr>

    <%
            for (int x = 0; x < 10; x++){

    %>
    <tr align="center">
        <td>戴长鹏</td>
        <td>21</td>
    </tr>

    <%
        }
    %>

</table>

</body>
</html>
