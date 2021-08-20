<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<html>
<head>
    <title>adminDisplayStats</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="myStyles.css" type="text/css">
</head>
<body>
<h1><fmt:message key="label.yourRoleAdmin"/><br> <fmt:message key="label.statistics"/></h1>
<br>
<br>
<a href="adminValidate"> <fmt:message key="label.logOut"/></a>
<a href="adminActions"><fmt:message key="label.goBack"/></a>
<br>
<table>
    <tr>
        <th><fmt:message key="label.id"/></th>
        <th><fmt:message key="label.title"/></th>
        <th><fmt:message key="label.subgroup"/></th>
        <th><fmt:message key="label.avgMark"/></th>
        <th><fmt:message key="label.attendance"/></th>
    </tr>
    <c:forEach var="stats" items="${stats}">
        <tr>
            <td>${stats.id}</td>
            <c:set var="course" value="${stats.course}"/>
            <c:set var="title" value="${course.title}"/>
            <c:set var="subgroup" value="${course.subgroupNum}"/>
            <td>${title}</td>
            <td>${subgroup}</td>
            <td>${stats.avgMark}</td>
            <td>${stats.attendance}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
