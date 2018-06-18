<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="w" uri="http://mycompany.com" %>
<html>
  <head>
    <title></title>
  </head>
  <body>

  <%--如果xxx这个参数存在的话我们就不执行myTag4如果不为空的话就myTag4。也就是说我们有xxx这个属性我就不执行myTag4,--如果没有xxx这个属性我们就执行myTag4--%>
  <%--empty的意思就是空的意思--%>
  <w:myTag5 test="${empty param.xxx }">
    <w:myTag4 />
  </w:myTag5>

  <h1><w:myTag1 /></h1>
  <h1><w:myTag2 /></h1>

  <hr/>
<%--这个标签内表我们使用scriptless--%>
  <%
    request.setAttribute("xxx", "张三");
  %>

  <w:myTag3>
    ${xxx }
  </w:myTag3>

  <w:myTag3>
    魏国平
  </w:myTag3>

  </body>
</html>