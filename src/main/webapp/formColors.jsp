<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Colors</title>
</head>
<body>

<div>
    <%--action "color" do servlet colors, "keywords" do keywords srvlet--%>
    <%--action to sciezka na jaka ma byc wyslane zadanie http--%>
    <form method="post" action="colors">
        Choose page:
        <select name="choose">
            <option value="infoshareacademy">infoshareacademy</option>
            <option value="wmh">wmh</option>
        </select>
        <input type="submit" value="OK">
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
