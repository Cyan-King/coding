<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/8/19
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        //创建异步对象
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

            var userEle = document.getElementById("usernameEle");

            userEle.onblur = function () {
                //创建了异步对象
                var xmlHttp = createXMLHttpRequest();

                //打开与服务器的连接
                xmlHttp.open("POST", "<c:url value='/ValidateUsernameServlet' />", true);
                //设置请求头
                xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

                //发送请求,发送请求体
                xmlHttp.send("username=" + userEle.value);

                //得到响应
                xmlHttp.onreadystatechange = function () {
                    if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                        //得到Text的值
                        var text = xmlHttp.responseText;
                        var spanEle = document.getElementById("errorSpan");
                        if (text == "1") {
                            spanEle.innerHTML = "用户名已经注册";
                        } else {
                            spanEle.innerHTML = "";
                        }

                    }
                };
            };
        };
    </script>
</head>
<body>


<form action="" method="post">
    用户名：<input type="text" name="username" id="usernameEle"/><span id="errorSpan"></span><br/>
    密&nbsp&nbsp码：<input type="password" name="password"/><br/>
    <input type="submit" value="提交"/>

</form>

</body>
</html>
