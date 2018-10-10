<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/8/19
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">

        function createXMLHttpRequest() {
            try {
                return new XMLHttpRequest();//大多数浏览器
            } catch (e) {
                try {
                    return ActvieXObject("Msxml2.XMLHTTP");//IE6.0
                } catch (e) {
                    try {
                        return ActvieXObject("Microsoft.XMLHTTP");//IE5.5及更早版本
                    } catch (e) {
                        alert("哥们儿，您用的是什么浏览器啊？");
                        throw e;
                    }
                }
            }
        }

        window.onload = function () {

            var btn = document.getElementById("btn");

            btn.onclick = function () {

                //第一步先得到XMLHttpRequest对象
                var xmlHttp = createXMLHttpRequest();
                //第二步打开服务器链接
                xmlHttp.open("GET", "<c:url value='/AServlet' />", "true");
                //第三步发送请求
                xmlHttp.send(null);
                //第四步得到响应
                xmlHttp.onreadystatechange = function () {
                  
                    if (xmlHttp.readyState == 4 && xmlHttp.status == 200){

                        var text = xmlHttp.responseText;
                        var h1 = document.getElementById("h1");
                        h1.innerHTML = text;

                    }
                    
                };

            };
        };

    </script>
</head>
<body>


<button id="btn">按钮</button>
<br/>

<h1 id="h1"></h1>

</body>
</html>
