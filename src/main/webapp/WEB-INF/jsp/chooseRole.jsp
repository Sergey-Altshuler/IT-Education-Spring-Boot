<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<html>
<head>
    <title>ChooseRole</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="myStyles.css" type="text/css">
</head>
<body>
<h1><fmt:message key="label.selectRole"/></h1>
<form action="logout" method="post">
    <input type="submit" value="Sign Out"/>
</form>
<div align="center">
    <form action="chooseRole" method="post">
        <p><input name="role" type="radio" value="admin" checked class="radio"> <fmt:message key="label.admin"/></p>
        <p><input name="role" type="radio" value="student" class="radio"> <fmt:message key="label.student"/></p>
        <p><input name="role" type="radio" value="coach" class="radio"> <fmt:message key="label.coach"/></p>
        <p><input type="submit" value="OK"></p>
    </form>
</div>
</body>
</html>
