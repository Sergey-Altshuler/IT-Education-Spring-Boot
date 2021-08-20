<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<html>
<head>
    <title>WrongData</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="myStyles.css" type="text/css">
</head>
<body style="background-color: lightyellow">
<h1 style="color: aliceblue;
    background-color: purple;
    text-align: center;
    font-family: Arial, serif;
    font-weight: bold;
width: auto;" align="center"><fmt:message key="label.incorrectData"/></h1>
<a href="welcome" style="
    display: inline-block;
    text-decoration: none;
    text-transform: uppercase;
    letter-spacing: 1px;
    margin: 15px 25px;
    padding: 15px 20px;
    font-size: 20px;
    font-weight: bold;
    font-family: 'Montserrat', sans-serif;
    transition: 0.5s ease-in-out;
"> <fmt:message key="label.goBack"/></a>
</body>
</html>
