<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title> navigation bar </title>
    <style>
        table {
            margin: auto;
        }
    </style>
</head>

<body>
    <table border="3">
        <tr>
            <th><a href="<c:url value="/home"/>"> HOME </a></th>
            <th><a href="<c:url value="/admin/users"/>"> SHOW ALL USERS </a></th>
            <th><a href="<c:url value="/admin/showUserForm"/>"> ADD USER </a></th>
        </tr>
    </table>
</body>

</html>
