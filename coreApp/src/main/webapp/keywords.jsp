<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>


<main class="container">

    <article class="test-results">
        <c:if test="${badconnect != null}">
            <div class="alert alert-danger alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                    ${badconnect}</div>
        </c:if>
        <c:if test="${refusedConnection != null}">
            <div class="alert alert-danger alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                    ${refusedConnection}</div>
        </c:if>
        <c:if test="${badform != null}">
            <div class="alert alert-danger alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                    ${badform}</div>
        </c:if>
        <header><h1>Wyniki testu słów kluczowych dla<br><span class="url">${domainurl}</span></h1></header>
        <a href="#" class="exact-form-show">Sprawdź inną stronę</a>

        <form action="keywords" method="post" class="form-inline exact-form">
            <input type="text" placeholder="Url domeny" name="domainurl">
            <button type="submit" class="btn btn-warning">Testuj</button>
        </form>

        <h2>Lista słów kluczowych na Twojej stronie:</h2>
        <p>Aby dodać słowo do ulubionych kliknij serduszko obok słowa kluczowego</p>
        <p>Aby sprawdzić wyniki wyszukiwania dla danej frazy kliknij ikonkę linku wychodzącego</p>
        <div class="recommendation-box">
            <ul class="keywords-list">
                <c:forEach items="${keyWords}" var="keyword">
                    <li><span class="glyphicon ${keyword.glyphicon} likeit" aria-hidden="true" data-user="${sessionData.userId}" data-keyword="${keyword.keyword}"></span><a
                            href="https://google.pl/#q=${keyword.googleLinkToKeyword}" target="_blank"><span class="glyphicon glyphicon-new-window likeit" aria-hidden="true"></span></a>${keyword.keyword}
                    </li>
                </c:forEach>
            </ul>
        </div>
    </article>
</main>

<jsp:include page="footer.jsp"/>
