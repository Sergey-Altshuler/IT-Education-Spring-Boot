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
    <title>Admin_addCourse</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="myStyles.css" type="text/css">
</head>
<body>
<h1><fmt:message key="label.yourRoleAdmin"/> <br> <fmt:message key="label.createNewCourse"/></h1>
<br>
<br>
<a href="adminValidate"> <fmt:message key="label.logOut"/></a>
<a href="adminActions"><fmt:message key="label.goBack"/></a>
<br>
<div align="center">
    <form action="adminAddCourse" method="POST">
        <br>
        <fmt:message key="label.title"/>
        <br>
        <input name="title" required type="text">
        <br>
        <fmt:message key="label.edType"/>
        <br>
        <select name="educationType" required>
            <option selected value="онлайн"><fmt:message key="label.online"/></option>
            <option value="вечерняя"><fmt:message key="label.evening"/></option>
        </select>
        <br>
        <fmt:message key="label.price"/>
        <br>
        <input name="price" required type="text" pattern="[1-9][0-9]*">
        <br>
        <fmt:message key="label.address"/>
        <br>
        <select name="address" required>
            <option selected value="Минск, Скрыганова-14"><fmt:message key="label.chooseAddress1"/></option>
            <option value="Минск, Гикало-3"><fmt:message key="label.chooseAddress2"/></option>
            <option value="Могилёв"><fmt:message key="label.chooseAddress3"/></option>
        </select>
        <br>
        <fmt:message key="label.numOfStudents"/>
        <br>
        <select name="numOfStudents" required>
            <option selected value="1"> 1</option>
            <option value="2"> 2</option>
            <option value="3"> 3</option>
            <option value="4"> 4</option>
            <option value="5"> 5</option>
            <option value="6"> 6</option>
            <option value="7"> 7</option>
            <option value="8"> 8</option>
            <option value="9"> 9</option>
        </select>
        <br>
        <fmt:message key="label.numOfLessons"/>
        <br>
        <select name="numOfLessons" required>
            <option selected value="4"> 4</option>
            <option value="5"> 5</option>
            <option value="6"> 6</option>
            <option value="7"> 7</option>
            <option value="8"> 8</option>
            <option value="9"> 9</option>
        </select>
        <br>
        <fmt:message key="label.startDate"/>
        <br>
        <input name="startDate" type="date" value="2021-08-01" min="2021-08-01" max="2024-01-01" required>
        <br>
        <fmt:message key="label.finishDate"/>
        <br>
        <input name="finishDate" type="date" value="2021-08-01" min="2021-08-01" max="2024-01-01" required>
        <br>
        <br>
        <input value=<fmt:message key="label.createNewCourse"/> type="submit"/>
    </form>
</div>
</body>
</html>