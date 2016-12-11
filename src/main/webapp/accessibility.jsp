<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: drzalek
  Date: 30.10.16
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accessibility HTML</title>
</head>
<body>
<form action="accessibility" method="post">
    <lable>Podaj adres url domeny do sprawdzenia:</lable>
    <input type="text" placeholder="Url domeny" name="domainurl">
    <input type="submit" value="sprawdz">
</form>
<h2>Liczba linków na stronie</h2>
<p>${linksInHtml}</p>

<h2>Zdeprecjonowane tagi html</h2>
<p>${deprecatedTags}</p>
<ul>
    <c:forEach items="${deprecatedTags}" var="recommendationDeprecated">
        <li>${recommendationDeprecated}</li>
    </c:forEach>
</ul>
<h2>Ustawienia w sekcji head</h2>

<ul>
    <c:forEach items="${headRecommendations}" var="recommendation">
        <li>${recommendation}</li>
    </c:forEach>
</ul>
<h2>Nagłówki na stronie</h2>
<ul>
<c:forEach items="${headlinesHtml}" var="recommendationHeadline">
    <li>${recommendationHeadline}</li>
</c:forEach>
</ul>
</body>
</html>
