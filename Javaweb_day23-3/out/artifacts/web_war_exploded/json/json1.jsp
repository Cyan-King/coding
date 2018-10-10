<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/8/24
  Time: 16:22
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

                var str = "{\"name\":\"Mike\", \"age\":18, \"sex\":\"male\"}";
                var Person = eval("(" + str + ")")
                var text = Person.name + ":" + Person.age + ":" + Person.sex;

                document.getElementById("h3").innerHTML = text;
            };
        };

    </script>

</head>
<body>

<h1>JSON应用</h1>
<button id="btn">按钮</button>
<h3 id="h3"></h3>

</body>
</html>
