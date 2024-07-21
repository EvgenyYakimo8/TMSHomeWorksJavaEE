<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Жека
  Date: 21.07.2024
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h1>Привет, ${name}!</h1>
<%
        if ((Boolean) request.getAttribute("flag")){
            out.print("<h1>Is Enabled</h1>");
        }
%>

<ul>
    <%
        for (String s : (List<String>) request.getAttribute("list")) {
            out.print("<li>" + s + "</li>");
        }
    %>
</ul>
</body>
</html>