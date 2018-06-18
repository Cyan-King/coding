<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/5/29
  Time: 8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--这个获取得到项目名，然后以后我们就不用再form，href之类的里面的项目路径就不用写了，直接写这行代码就好--%>
${pageContext.request.contextPath }

</body>
</html>
