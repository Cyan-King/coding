<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/9/5
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<table border="1" cellspacing="0" cellpadding="5">
    <tr>
        <th>number</th>
                <% for (int i =0; i < 10; i++) { %>
        <th>
                <%= i %>
        </th>
        <% } %>
        </th>
    </tr>


    <tr>
        <th>number</th>
                <% for (int i =0; i < 10; i++) { %>
        <th>
            <%= (i*i) %>
        </th>
        <% } %>
        </th>
    </tr>

</table>

</body>
</html>
