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
        Write or paste the url of your page:
        <input class=""type="text" name="domainurl" placeholder="Podaj adres witryny">
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
