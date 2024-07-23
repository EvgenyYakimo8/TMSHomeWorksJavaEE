<%--
  Created by IntelliJ IDEA.
  User: Жека
  Date: 22.07.2024
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<jsp:include page="_bootstrap.jsp"/>
<jsp:include page="_header.jsp"/>

<form action="/login" method="post">
    <input type="text" name="username" placeholder="username" value="${username}">
    <input type="text" name="password" placeholder="password">
    <button>Submit</button>
</form>
<p>${message}</p>
</body>
</html>
