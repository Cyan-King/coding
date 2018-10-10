<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/8/21
  Time: 10:47
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
            //异步四步
            //得到xmlHttpRequest对象
            var xmlHttp = createXMLHttpRequest();
            //打开服务器连接
            xmlHttp.open("GET", "<c:url value='/ProvinceServlet' />", true);
            //服务器响应
            xmlHttp.send(null);
            //服务器响应结束
            xmlHttp.onreadystatechange = function () {

                //双重判断
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200){
                    //取得了服务器发送的数据
                    var text = xmlHttp.responseText;
                    // alert(text);
                    //将字符串分割开来
                    var arr = text.split(",");
                    //遍历每一个省份
                    for(var i = 0; i < arr.length; i++){
                        //创建option元素
                        var op = document.createElement("option");
                        //设置实际值
                        op.value = arr[i];
                        //设置显示值，也可以说时创建一个文本节点
                        var textNode = document.createTextNode(arr[i]);
                        //将文本节点添加到option里面
                        op.appendChild(textNode)

                        //将文本节点加入到option中
                        document.getElementById("p").appendChild(op);
                    }
                }

            };

            var proEle = document.getElementById("p");
            proEle.onchange = function () {

                //第一步先得到XMLHttpRequest对象
                var xmlHttp = createXMLHttpRequest();
                //第二步打开服务器链接
                /**************我们这个是POST请求方式所以要修改为POST，在open里面修改*************/
                xmlHttp.open("POST", "<c:url value='/CityServlet' />", true);
                /*************设置请求头：Content-Type********************/
                //在之前这个请求头打错无法读取到请求体
                xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

                //第三步发送请求
                /**********************修改send方法，发送请求体*********************/
                // xmlHttp.send(null);
                xmlHttp.send("pname=" + proEle.value);
                //第四步得到响应
                xmlHttp.onreadystatechange = function () {

                    if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                        //移除select中的所有option第一个除外
                        var citySelect = document.getElementById("c");
                        //获得其中的所有option
                        var optionEle = citySelect.getElementsByTagName("option");
                        while (optionEle.length > 1){//移除所有的在optionEle[1]上的option元素
                            optionEle.removeChild(optionEle[1]);
                        }

                        //得到cityServlet发送的数据
                        var doc = xmlHttp.responseXML;
                        //得到所有的city元素
                        var cityEleList = doc.getElementsByTagName("city");
                        for (var i = 0; i < cityEleList.length; i++){
                            //遍历得到所有city元素
                            var cityEle = cityEleList[i];

                            var cityName
                            if (window.addEventListener){
                                cityName = cityEle.textContent;
                            }else {
                                cityName = cityEle.text;
                            }



                            //进行添加元素
                            var op = document.createElement("option");//创建option元素
                            //设置option  valeue值
                            op.value = cityName;
                            //创建文本字节
                            var textNode = document.createTextNode(cityName);
                            op.appendChild(textNode);

                            citySelect.appendChild(op);
                        }
                    }

                };
            };

        };

    </script>
</head>
<body>

<select name="province" id="p" >
    <option>===请选择省份===</option>
</select>

<select name="city" id="c">
    <option>===请选择城市===</option>
</select>

</body>
</html>
