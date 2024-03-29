<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title> List of users </title>
    <style>
        fieldset {
            width: 300px;
            border: 1px;
            margin: auto;   /* Выравниваем таблицу по центру окна  */
        }
        legend {
            border: 5px;
            margin: auto;
        }
    </style>
</head>

<body>

    <%@include file="navigation.jsp"%>
    <hr>

    <fieldset>
        <table width="400" border="1" cellpadding="4" cellspacing="0">
            <legend><h1><b> List of users </b></h1></legend>
            <tr bgcolor="#a9a9a9">
                <th> id </th>
                <th> name </th>
                <th> login </th>
                <th> role </th>
                <th> options </th>
            </tr>
            <%-- pass through all users --%>
            <c:forEach var="user" items="${users}">
                <tr>
                    <th> ${user.id} </th>
                    <th> ${user.name} </th>
                    <th> ${user.login} </th>
                    <th> ${user.role} </th>
                    <th>
                        <a href="/edit/${user.id}"> edit </a>
                        <a href="/delete/${user.id}"
                           onclick="if (!(confirm('Are you sure you want to delete this user?'))) return false"> delete </a>
                    </th>
                </tr>
            </c:forEach>
        </table>
    </fieldset>
</body>

</html>
