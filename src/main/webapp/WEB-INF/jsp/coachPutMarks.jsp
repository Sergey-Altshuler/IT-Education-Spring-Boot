<%@ page import="com.altshuler.it_education_springboot.info.ProjectInfo" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<html>
<head>
    <title>CoachPutMarks</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="myStyles.css" type="text/css">
</head>
<body>
<h1><fmt:message key="label.hello"/> <%=ProjectInfo.getCoach().getName()%> <%=ProjectInfo.getCoach().getSurname()%>!<br>
    <fmt:message key="label.putMarksAttendance"/></h1>
<br>
<br>
<a href="coachValidate"> <fmt:message key="label.logOut"/> </a>
<a href="coachEnter"> <fmt:message key="label.goBack"/> </a>
<br>
<table>
    <tr>
        <th><fmt:message key="label.student"/></th>
        <c:forEach var="mapElement" items="${titles}">
            <th>${mapElement.key}</th>
        </c:forEach>
        <th><fmt:message key="label.avgMark"/></th>
        <th><fmt:message key="label.attendance"/></th>
    </tr>
    <c:forEach var="courseMap" items="${courseMap}">
        <c:set var="miniMap" value="${courseMap.value}"/>
        <tr>
            <c:forEach var="miniMap" items="${miniMap}">
                <td>${miniMap.value}</td>
            </c:forEach>
        </tr>
    </c:forEach>

</table>


<br>
<br>
<div align="center">
    <form action="coachFillMarks" method="POST" class="decor">
        <div class="form-inner">
            <fmt:message key="label.NumOfLesson"/> <input required name="numLesson" type="text">
            <c:forEach var="student" items="${studentMap}">
                <fmt:message key="label.mark"/> ${student.value} <input required name=${student.key} type="text">

            </c:forEach>
            <input type="submit" value="OK"/>
        </div>
    </form>
</div>
<br>
<br>
<div align="center">
    <h2><fmt:message key="label.finishCourse"/></h2>
    <br>
    <a href="calculate?number=${number}"> <fmt:message key="label.finish"/> </a>
</div>
</body>
</html>
