<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>
<html lang="${language}">
<head>
    <title>CoachValidation</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="myStyles.css" type="text/css">
</head>
<body>
<h1><fmt:message key="label.yourRoleCoach"/> <br> <fmt:message key="label.fillTheForm"/></h1>
<a href="chooseRolePage"> <fmt:message key="label.goBack"/> </a>
<br>
<div align="center">
    <form action="coachEnter" method="get">
        <fmt:message key="label.login"/>
        <br>
        <input required name="login" type="text"/>
        <br>
        <fmt:message key="label.password"/>
        <br>
        <input required name="password" type="password"/>
        <br>
        <fmt:message key="label.confirmPassword"/>
        <br>
        <input required name="repeated" type="password"/>
        <br>
        <input type="submit" value="OK"/>
    </form>
</div>
<h2><fmt:message key="label.ifNotRegistered"/></h2>
<div align="center">
    <a href="coachMoveToRegister"> <fmt:message key="label.register"/></a>
</div>
</body>
</html>
