<%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/6/9
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入jstl的核心库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function _change() {
            //先要获取这个元素
            var ele = document.getElementById("verifyCode");
            //这个是为设置一个变量，来改变每次点击都能重复到VerifyCodeServlet
            ele.src = "<c:url value="/VerifyCodeServlet" />?xxx" + new Date().getTime();
        }
    </script>
</head>
<body>

<h1>注册</h1>
<p style="color: red; font-size: 21px">${msg }</p>
<form action="<c:url value="/RegistServlet" />" method="post">
    用户名：<input type="text" name="username" value="${user.username }" />${errors.username }<br/>
    密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" value="${user.password }" />${errors.password }<br/>
    性&nbsp;&nbsp;&nbsp;别：<input type="text" name="sex" value="${user.sex }" />${errors.password }<br/>
    年&nbsp;&nbsp;&nbsp;龄：<input type="text" name="age" value="${user.age}" />${errors.age }<br/>
    爱&nbsp;&nbsp;&nbsp;好：<input type="text" name="love" value="${user.love }" />${errors.password }<br/>
    验证码：<input type="text" name="verifyCode" value="${user.verifyCode }" size="3">
            <img id="verifyCode" src="<c:url value="/VerifyCodeServlet" />">
    <a href="javascript:_change()">看不清，换一张</a>${errors.verifyCode }<br/>
    <input type="submit" value="注册">
</form>

</body>
</html>
