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

        <header><h1>Lista kolorów dla<br>${domainurl}</h1></header>
        <a href="#" class="exact-form-show">Sprawdź inną stronę</a>

        <form action="colors" method="post" class="form-inline exact-form">
            <input type="text" placeholder="Url domeny" name="domainurl">
            <button type="submit" class="btn btn-warning">Testuj</button>
        </form>


        <h2>Lista kolorów</h2>
        <div class="recommendation-box">
            <ul>
                <c:forEach items="${listOfColors}" var="colors">
                    <li>${colors}</li>
                </c:forEach>
            </ul>
        </div>

    </article>

</main>


<jsp:include page="footer.jsp" />
