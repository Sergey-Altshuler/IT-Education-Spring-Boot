<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<html>
<head>
    <title>StudentSuccessRegister</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="myStyles.css" type="text/css">
</head>
<body>
<h1><fmt:message key="label.yourRoleStudent"/> <br> <fmt:message key="label.successRegister"/></h1>
<br>
<br>
<a href="studentValidate"> <fmt:message key="label.goBack"/> </a>
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
