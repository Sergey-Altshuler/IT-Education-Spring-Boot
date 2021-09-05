<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<html>
<head>
    <title>ChooseLanguage</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="myStyles.css" type="text/css">
</head>
<body style="background-color: lightyellow">
<h1 align="center" style="color: aliceblue;
    background-color: purple;
    text-align: center;
    font-family: Arial, serif;
    font-weight: bold;
width: auto;"><fmt:message key="label.welcomeToITWorld"/>
</h1>
<br>
<h2 align="center" style="color: black;
    font-family: Arial, serif;
font-weight: bold;
text-align: center;
width: auto"><fmt:message key="label.chooseLanguage"/></h2>
<br>
<br>
<br>
<div align="center" style="font-size: large">
    <button type="button" style=" background-color: lavender;
    border: 3px solid red;
    padding: 12px 20px;
    text-align: center;
    display: inline-block;
    font-size: 20px;
    vertical-align: middle;"><a
            href="chooseLanguage?lang=en">
        <fmt:message key="label.English"/></a>
    </button>
    <button type="button" style="background-color: lavender;
    border: 3px solid red;
    padding: 12px 20px;
    text-align: center;
    display: inline-block;
    font-size: 20px;
    vertical-align: middle;"><a
            href="chooseLanguage?lang=ru">
        <fmt:message key="label.Russian"/></a>
    </button>
</div>
<br>
<br>
<br>
<br>
<div align="center">
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
"><fmt:message key="label.continue"/></a>
</div>
</body>
</html>
