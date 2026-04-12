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

   response.setContentType("text/html");

   String name= request.getParameter("name");
   request.setAttribute("hobby", "Programming");

   request.getRequestDispatcher("/getIt.jsp").include(request, response);

%>


<h1>Hello, <%=name%></h1>
<a href="getIt.jsp">CLick to go to getIt.jsp </a>


</body>
</html>
