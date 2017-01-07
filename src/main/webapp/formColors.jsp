<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Colors</title>
</head>
<body>

<div>
    <form method="post" action="setHTMLpath">
        Enter a path to your HTML file: <input type="text" name="HTMLpathColors">
    </form>
</div>

<div>
    <div>The colors are:</div>
    <div>
        <ul>
            <c:forEach items="${listOfColors}" var="listOfUniqueColors">
            <li> ${listOfUniqueColors} </li>
                </c:forEach>
        </ul>
    </div>
</div>

</body>
</html>
