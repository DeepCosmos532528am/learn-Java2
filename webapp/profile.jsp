<%--
  Created by IntelliJ IDEA.
  User: LOQ
  Date: 11-04-2026
  Time: 02:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String username =(String) session.getAttribute("user_key");
%>

<h1>Hey! <%=username%> </h1>
<h1>Your Profile is Ready</h1>

</body>
</html>
