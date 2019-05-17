<%--
  Created by IntelliJ IDEA.
  User: severek
  Date: 2/10/2019
  Time: 12:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Hello World</title>
</head>

<body>
index2
<c:forEach items="${usersFromServer}" var="user">
    <tr>
        <td>${user.name}</td>
        <td>${user.password}</td>
    </tr>
    <br/>
</c:forEach>
</body>
</html>
