<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title> ${user.login}'s page </title>

    <style>
        fieldset {
            width: 13%;
            margin: auto;
            border: 5px;
        }

        legend {
            border: 5px;
            margin: auto;
        }

        table {
            border: black; border: 10px;
        }

    </style>

</head>
<body>
    <fieldset>
        <legend><h2><b> <a href="<c:url value="/logout" />">Logout</a> </b></h2></legend>
        <h3>Your id: ${user.id}</h3>
        <h3>Your name: ${user.name}</h3>
        <h3>Your login: ${user.login}</h3>
        <h3>Your role: ${user.role}</h3>
    </fieldset>
</body>
</html>
