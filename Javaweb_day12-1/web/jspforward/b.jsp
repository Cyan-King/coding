<h1>b.jsp</h1>

<%
    response.setCharacterEncoding("utf-8");
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    out.print(userName + ", " + password);
%>