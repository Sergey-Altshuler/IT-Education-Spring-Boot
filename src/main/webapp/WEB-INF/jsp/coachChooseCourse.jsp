<%@ page import="com.altshuler.it_education_springboot.info.ProjectInfo" %>
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
    <title>StudentChooseCourse</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="myStyles.css" type="text/css">
</head>
<body>
<h1><fmt:message key="label.hello"/> <%=ProjectInfo.getCoach().getName()%> <%=ProjectInfo.getCoach().getSurname()%>!<br>
    <fmt:message key="label.selectCourse"/></h1>
<br>
<br>
<a href="coachValidate"> <fmt:message key="label.logOut"/> </a>
<br>
<table>
    <tr>
        <th><fmt:message key="label.id"/></th>
        <th><fmt:message key="label.title"/></th>
        <th><fmt:message key="label.subgroup"/></th>
        <th><fmt:message key="label.edType"/></th>
        <th><fmt:message key="label.price"/></th>
        <th><fmt:message key="label.address"/></th>
        <th><fmt:message key="label.startDate"/></th>
        <th><fmt:message key="label.finishDate"/></th>
        <th><fmt:message key="label.placesRemaining"/></th>
        <th><fmt:message key="label.coachRequired"/></th>
        <th><fmt:message key="label.isStarted"/></th>
        <th><fmt:message key="label.pressAndRegister"/></th>
        <th><fmt:message key="label.pressAndUnregister"/></th>
        <th><fmt:message key="label.pressAndPutMarks"/></th>
    </tr>
    <c:forEach var="course" items="${courses}">
        <tr>
            <td>${course.id}</td>
            <td>${course.title}</td>
            <td>${course.subgroupNum}</td>
            <td>${course.educationType}</td>
            <td>${course.price}</td>
            <td>${course.address}</td>
            <td>${course.startDate}</td>
            <td>${course.finishDate}</td>
            <td>${course.remaining}/${course.numOfStudents}</td>
            <td>${course.coachRequired}</td>
            <td>${course.isStarted}</td>
            <td><a href="coachChooseCourse?number=${course.id}"><fmt:message key="label.register"/></a></td>
            <td><a href="coachUnregisterCourse?number=${course.id}"> <fmt:message
                    key="label.pressAndUnregister"/> </a></td>
            <td><a href="coachPutMarks?number=${course.id}"><fmt:message key="label.putMarks"/></a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
