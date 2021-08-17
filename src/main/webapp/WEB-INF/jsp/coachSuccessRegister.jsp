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
    <title>CoachSuccessRegister</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="myStyles.css" type="text/css">
</head>
<body>
<h1><fmt:message key="label.yourRoleCoach"/> <br> <fmt:message key="label.successRegister"/></h1>
<br>
<br>
<a href="coachValidate"> <fmt:message key="label.goBack"/> </a>
<br>
<div align="center">
    <h2>
        <fmt:message key="label.password"/> ${password}
        <br>
        <fmt:message key="label.sendToEmail"/>
    </h2>
</div>
</body>
</html>
