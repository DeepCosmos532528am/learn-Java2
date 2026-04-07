<%--
  Created by IntelliJ IDEA.
  User: LOQ
  Date: 07-04-2026
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <h1>This below link is to navigate to the 'MyServlet1' servlet</h1>
     <a href="href-customServlet1" value="Sachin" >Custom Servlet 1</a>
   <h1>This below link is to navigate to the 'MyServlet2' servlet</h1>
   <a href="href-customServlet2" methods="Get">Custom Servlet 2</a> <%--See in the methods attribute try putting Post instead of Get, and notice in the MyCustomServlet2 accordingly the method would call if parents version super.service(req, resp) could get invoked--%>


</body>
</html>
