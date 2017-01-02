<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />



<main class="container">

    <article class="test-results">
        <header><h1>Wyniki testu słów kluczowych dla<br>${domainurl}</h1></header>
        <a href="#" class="exact-form-show">Sprawdź inną stronę</a>

        <form action="keywords" method="post" class="form-inline exact-form">
            <input type="text" placeholder="Url domeny" name="domainurl">
            <button type="submit" class="btn btn-warning">Testuj</button>
        </form>

        <h2>Lista słów kluczowych na Twojej stronie:</h2>
        <p>Aby dodać słowo do ulubionych kliknij serduszko obok słowa kluczowego</p>
        <p>Aby sprawdzić wyniki wyszukiwania dla danej frazy kliknij w nią</p>
        <div class="recommendation-box">
            <ul class="keywords-list">
                <c:forEach items="${keyWords}" var="keyword">
                    <li><span class="glyphicon glyphicon-heart" aria-hidden="true"></span><a href="https://google.pl/#q=${keyword.keywordUrl}" target="_blank">${keyword.keyword}</a></li>
                </c:forEach>
            </ul>
        </div>


    </article>

</main>

<jsp:include page="footer.jsp" />
