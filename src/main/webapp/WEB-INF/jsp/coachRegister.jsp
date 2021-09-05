<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<html>
<head>
    <title>CoachRegister</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="myStyles.css" type="text/css">
</head>
<body>
<h1><fmt:message key="label.yourRoleCoach"/> <br> <fmt:message key="label.fillTheForm"/></h1>
<br>
<br>
<a href="coachValidate"> <fmt:message key="label.goBack"/> </a>
<br>
<div align="center">
    <form action="coachRegister" method="POST">
        <br>
        <fmt:message key="label.login"/>
        <br>
        <input name="login" required type="text">
        <br>
        <fmt:message key="label.password"/>
        <br>
        <input name="password" required type="password">
        <br>
        <fmt:message key="label.confirmPassword"/>
        <br>
        <input name="repeated" required type="password">
        <br>
        <fmt:message key="label.name"/>
        <br>
        <input name="name" required type="text">
        <br>
        <fmt:message key="label.surname"/>
        <br>
        <input name="surname" required type="text">
        <br>
        <fmt:message key="label.age"/>
        <br>
        <input name="age" required type="text" pattern="[1-9][0-9]{0,2}">
        <br>
        <br>
        <input type="submit" value="OK"/>
    </form>
</div>
</body>
</html>
