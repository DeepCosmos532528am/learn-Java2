<%--
  Created by IntelliJ IDEA.
  User: LOQ
  Date: 02-04-2026
  Time: 01:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Hello TomCat started, Hello Bhai! </h1>
<form action="myservlet" method="post"><%-- using 'Get' method here exposes the data in the url but 'Post' does not--%>
    <input type="text" name="usernm" >
    <input type="password" name="passwd" >
        <input type="submit">
</form>
</body>
</html>
