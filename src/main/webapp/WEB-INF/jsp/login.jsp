<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>

<html>
<head>
    <title>login page</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="myStyles.css" type="text/css">
</head>

<body>
<h1><fmt:message key="label.verify"/></h1>
<a href="welcome"> <fmt:message key="label.goBack"/> </a>
<div align="center">
    <form action="${pageContext.request.contextPath}/login" method="post">
        <fmt:message key="label.login"/>
        <br>
        <input required name="login" type="text"/>
        <br>
        <fmt:message key="label.password"/>
        <br>
        <input required name="password" type="password"/>
        <br>
        <br>
        <input type="submit" value="Sign in"/>
    </form>
</div>

<%--
<form action="${pageContext.request.contextPath}/login" method="POST">

    <div class="imgcontainer">
        <img src="users-avatar.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
        &lt;%&ndash;@declare id="username"&ndash;%&gt;&lt;%&ndash;@declare id="password"&ndash;%&gt;
        <label for="username"><b><fmt:message key="label.name"/></b></label>
        <label>
            <input type="text" placeholder="<fmt:message key="label.enterName"/>" name="username" required>
        </label>

        <label for="password"><b><fmt:message key="label.password"/></b></label>
        <label>
            <input type="password" placeholder="<fmt:message key="label.enterPassword"/>" name="password" required>
        </label>

        <button type="submit"><fmt:message key="label.signIn"/></button>
        <br>
        <div style="text-align: center;"><a href="${pageContext.request.contextPath}/sign-up-page">
            <fmt:message key="label.signUp"/></a></div>

    </div>

</form>
--%>

</body>
</html>

