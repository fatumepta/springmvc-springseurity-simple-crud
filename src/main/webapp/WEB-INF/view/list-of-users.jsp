<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title> list of users </title>
</head>

<body>
    <h2> List of Users </h2>
    <c:forEach var="user" items="${users}">
        <h2>${user}</h2><br>
    </c:forEach>
</body>

</html>
