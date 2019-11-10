<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <title> user form</title>

    <style>
        form {
            width: 13%;
            margin: auto;
            border: 5px;
        }

        input {
            float: right;
        }
    </style>
</head>

<body>

    <%@include file="navigation.jsp"%>
    <hr>

    <form:form action="/saveOrUpdateUser" modelAttribute="user" method="post">
        <fieldset>
            <legend><h2><b> ADD or EDIT </b></h2></legend>
            <form:hidden path="id"/>
            name: <form:input path="name" />
            <p>login: <form:input path="login" />
            <p>password: <form:password path="password"/>
            <p>role:
                <form:select path="role">
                    <form:option value="user" label="user"/>
                    <form:option value="admin" label="admin"/>
                </form:select>
            <p><button style="height:30px;width:220px"><b> send </b></button></p>
        </fieldset>
    </form:form>

</body>

</html>
