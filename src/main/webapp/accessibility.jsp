<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />

<main class="container">

<article class="test-results">
    <c:if test="${badconnect != null}">
        <div class="alert alert-danger alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        ${badconnect}</div>
    </c:if>
    <c:if test="${badform != null}">
        <div class="alert alert-danger alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        ${badform}</div>
    </c:if>

    <header><h1>Wyniki testu dostępności dla<br>${domainurl}</h1></header>
    <a href="#" class="exact-form-show">Sprawdź inną stronę</a>

    <form action="accessibility" method="post" class="form-inline exact-form">
        <input type="text" placeholder="Url domeny" name="domainurl">
        <button type="submit" class="btn btn-warning">Testuj</button>
    </form>
    <h2>Liczba linków na stronie</h2>
    <div class="recommendation-box"><p>${linksInHtml}</p></div>


    <h2>Zdeprecjonowane tagi html</h2>
    <div class="recommendation-box">
    <ul>
        <c:forEach items="${deprecatedTags}" var="recommendationDeprecated">
            <li>${recommendationDeprecated}</li>
        </c:forEach>
    </ul>
    </div>
    <h2>Ustawienia w sekcji head</h2>
    <div class="recommendation-box">
    <ul>
        <c:forEach items="${headRecommendations}" var="recommendation">
            <li>${recommendation}</li>
        </c:forEach>
    </ul>
    </div>
    <h2>Nagłówki na stronie</h2>
    <div class="recommendation-box">
    <ul>
        <c:forEach items="${headlinesHtml}" var="recommendationHeadline">
            <li>${recommendationHeadline}</li>
        </c:forEach>
    </ul>
    </div>
</article>

</main>


<jsp:include page="footer.jsp" />
