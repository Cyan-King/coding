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
                xmlHttp.open("GET", "<c:url value='/BServlet' />", "true");
                //第三步发送请求
                xmlHttp.send(null);
                //第四步得到响应
                xmlHttp.onreadystatechange = function () {

                    if (xmlHttp.readyState == 4 && xmlHttp.status == 200){

                        var doc = xmlHttp.responseXML;

                        //得到student元素
                        var ele = doc.getElementsByTagName("student")[0];
                        //得到student中的number的属性值
                        var number = ele.getAttribute("number");
                        //得到student下属的各个元素

                        var name;
                        if (window.addEventListener){
                            // ele.getElementsByTagName("name")[0].textContent;//支持其他浏览器哦
                            name = ele.getElementsByTagName("name")[0].textContent;
                        } else {
                            name = ele.getElementsByTagName("name")[0].text;//支持IE
                        }

                        var age;
                        if (window.addEventListener){
                            age =  ele.getElementsByTagName("age")[0].textContent;//支持其他浏览器哦
                        } else {
                            age = ele.getElementsByTagName("age")[0].text;//支持IE
                        }

                        var sex;
                        if (window.addEventListener){
                            sex = ele.getElementsByTagName("sex")[0].textContent;//支持其他浏览器哦
                        } else {
                            sex = ele.getElementsByTagName("sex")[0].text;//支持IE
                        }

                        var text = number + ", " + name + ", " + age + ", " + sex;

                        document.getElementById("h1").innerHTML = text;
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
