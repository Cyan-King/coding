<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/8/27
  Time: 16:23
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

            //得到异步对象
            var xmlHttp = createXMLHttpRequest();

            //打开连接
            xmlHttp.open("GET", "<c:url value="/ProvniceServlet" />", true);

            //发送请求
            xmlHttp.send(null);

            //做出响应
            xmlHttp.onreadystatechange = function () {
                //做出双重判断
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200){
                    var proArry =eval( "(" + xmlHttp.responseText + ")");

                    for (var i = 0; i < proArry.length; i++ ){
                        //得到所有pro对象了
                        var pro = proArry[i];
                        //得到option的元素
                        var op = document.createElement("option");
                        //在这里我们就要去给他实际值和显示值了
                        op.value = pro.pid;

                        var textNode = document.createTextNode(pro.name);
                        //将显示值添加到option中
                        op.appendChild(textNode);

                        //再将这个option元素添加到provnice中
                        document.getElementById("p").appendChild(op);
                    }

                }
            };

            document.getElementById("p").onchange = function () {

                //得到异步对象
                var xmlHttp = createXMLHttpRequest();

                //打开连接
                xmlHttp.open("POST", "<c:url value="/CityServlet" />", true);

                xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

                //发送请求
                xmlHttp.send("pid=" + this.value);

                //做出响应
                xmlHttp.onreadystatechange = function () {
                    //做出双重判断
                    if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                        //清楚功能
                        var citySelet = document.getElementById("c");
                        var optionEle = citySelet.getElementsByTagName("option");
                        while (optionEle.length > 1){
                            citySelet.removeChild(optionEle[1]);
                        }

                        var cityArray = eval("(" + xmlHttp.responseText + ")");

                        for (var i = 0; i < cityArray.length; i++){
                            //得到所有
                            var city = cityArray[i];
                            //得到option的元素
                            var op = document.createElement("option");
                            //在这里我们就要去给他实际值和显示值了
                            op.value = city.cid;

                            var textNode = document.createTextNode(city.name);
                            //将显示值添加到option中
                            op.appendChild(textNode);

                            //再将这个option元素添加到provnice中
                            citySelet.appendChild(op);
                        }
                    }
                };

            };


        };

    </script>

</head>
<body>


<select name="province" id="p">
    <option>===请选择省份===</option>
</select>

<select name="city" id="c">
    <option>===请选择城市===</option>
</select>

</body>
</html>
