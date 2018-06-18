<%@ page import="com.wei.el.Address" %>
<%@ page import="com.wei.el.Employee" %><%--
  Created by IntelliJ IDEA.
  User: Cyan-King
  Date: 2018/5/28
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    Address address = new Address();
    address.setCity("丰城");
    address.setStree("上塘街");
    Employee employee = new Employee();
    employee.setName("魏国平");
    employee.setPay(1123123);
    employee.setAddress(address);

    //设置requeqt域----前面是参数名后面是参数值
    request.setAttribute("elm",employee);
%>
<%--使用El表达式在用el表达式我们用的是参数名来搜索域中参数值--%>
${requestScope.elm.getAddress().getStree() }<br/>
<%--全域查找elm这个属性--%>
${requestScope.elm.address.city}<br/>
${requestScope.elm.name}<br/>
${elm.pay}<br/>


</body>
</html>
