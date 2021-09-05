<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<html>
<head>
    <title>Admin_actions</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="myStyles.css" type="text/css">
</head>
<body>
<h1><fmt:message key="label.yourRoleAdmin"/><br> <fmt:message key="label.makeYourChoice"/></h1>
<br>
<a href="adminValidate"><fmt:message key="label.logOut"/></a>
<br>
<a href="adminMoveToAddCourse"><fmt:message key="label.createNewCourse"/> </a>
<br>
<a href="adminDisplayCourses"> <fmt:message key="label.displayCourses"/></a>
<br>
<a href="adminDisplayStats"><fmt:message key="label.displayStatistics"/></a>
<br>
<a href="adminMoveToChangeProperties"><fmt:message key="label.changeAdminLoginPassword"/></a>
</body>
</html>
