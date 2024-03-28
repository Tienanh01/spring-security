<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login page </title>
</head>
<body>
        <h1><string>Employee Login</string></h1>

         <c:url value="/sign-in" var="sign-in"/>

        <form:form action="" method="post">
            <label>User name : </label> <input type="text" name="username">
            <label>Password : </label> <input type="text" name="password">
        </form:form>
</body>
</html>