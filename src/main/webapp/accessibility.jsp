<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />

<main class="container">

<article>
    <header><h1>Wyniki testu dostępności Twojej strony internetowej</h1></header>
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
</article>
    <form action="accessibility" method="post">
        <input type="text" placeholder="Url domeny" name="domainurl">
        <input type="submit" value="sprawdz">
    </form>
</main>


<jsp:include page="footer.jsp" />
