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
    <title>Admin_successChange</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="myStyles.css" type="text/css">
</head>
<body>
<h1><fmt:message key="label.yourRoleAdmin"/><br> <fmt:message key="label.newLoginAndPassword"/></h1>
<br>
<br>
<a href="adminValidate"> <fmt:message key="label.logOut"/></a>
<a href="adminActions"><fmt:message key="label.goBack"/></a>
<br>
<h2><fmt:message key="label.changesConfirmed"/></h2>
<br>
<div align="center">
    <h2>
        <fmt:message key="label.newPassword"/> ${password}
        <br>
        <fmt:message key="label.sendToEmail"/>
    </h2>
</div>
</body>
</html>
