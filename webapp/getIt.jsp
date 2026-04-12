<%--
  Created by IntelliJ IDEA.
  User: LOQ
  Date: 11-04-2026
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
String name = request.getParameter("name");
%>

<p>getAttribute in this: ${hobby}</p>

<h1>I am from the getIt.jsp <%=name%></h1>

</body>
</html>
