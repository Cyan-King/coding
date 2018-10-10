<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'json3.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <%--404,haode1--%>
    <script type="text/javascript" src="../ajax-lib/ajaxutils"></script>

    <script type="text/javascript">
        window.onload = function() {
            var btn = document.getElementById("btn");
            btn.onclick = function() {
                /*
                1. ajax
                */
                ajax(
                    {
                        url:"<c:url value='/AServlet'/>",
                        type:"json",
                        callback:function(data) {
                            document.getElementById("h3").innerHTML = data.name + ", " + data.age + ", " + data.sex;
                        }
                    }
                );
            };
        };
    </script>
</head>

<body>
<%-- 点击按钮后，把服务器响应的数据显示到h3元素中 --%>
<button id="btn">点击这里</button>
<h1>显示自己封装的ajax小工具</h1>
<h3 id="h3"></h3>
</body>
</html>
