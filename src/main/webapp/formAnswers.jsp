<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<main class="container">
    <article class="test-results">

        <header><h1>Wyniki</h1></header>

        <div>
            <c:forEach items="${answers}" var="answer">
                <c:choose>
                    <c:when test="${answer.contains(\"?\")}">
                        <h2>${answer}</h2>
                    </c:when>
                    <c:otherwise>
                        <div class="recommendation-box">
                                ${answer}
                        </div>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
    </article>
</main>
<jsp:include page="footer.jsp"/>
