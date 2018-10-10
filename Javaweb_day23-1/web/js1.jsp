<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/8/18
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>


    <script type="text/javascript">

        window.onload = function () {

            var btn = document.getElementById("btn");

            btn.onclick = function () {
                var h1 = document.getElementById("h1");

                h1.innerHTML = "这就是点击事件的局部刷新效果";
            }
        }

    </script>

</head>
<body>

<button id="btn">按钮</button>
<br/>

<h1 id="h1"></h1>

</body>
</html>
