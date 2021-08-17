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
    <title>AdminChangeProperties</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="myStyles.css" type="text/css">
</head>
<body>
<h1><fmt:message key="label.yourRoleAdmin"/><br> <fmt:message key="label.changeAdminLoginPassword"/></h1>
<br>
<br>
<a href="adminValidate"> <fmt:message key="label.logOut"/></a>
<a href="adminActions"><fmt:message key="label.goBack"/></a>
<br>
<div align="center">
    <form action="adminChangeProperties" method="post">
        <fmt:message key="label.login"/>
        <br>
        <input name="login" type="text"/>
        <br>
        <fmt:message key="label.password"/>
        <br>
        <input name="password" type="password"/>
        <br>
        <fmt:message key="label.newPassword"/>
        <br>
        <input name="changed" type="password"/>
        <br>
        <fmt:message key="label.confirmPassword"/>
        <br>
        <input name="repeated" type="password"/>
        <br>
        <input type="submit" value="OK"/>
    </form>
</div>
</body>
