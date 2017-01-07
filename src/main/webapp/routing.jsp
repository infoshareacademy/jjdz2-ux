<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>

<main class="container">

    <h2>Linki wewnętrzne</h2>

    <div class="recommendation-box">
        <c:forEach items="${innerLinks}" var="innerLink">
            <p>${innerLink}</p>
        </c:forEach>
    </div>

    <h2>Linki zewnętrzne</h2>

    <div class="recommendation-box">
        <c:forEach items="${outerLinks}" var="outerLink">
            <p>${outerLink}</p>
        </c:forEach>
    </div>

</main>


<jsp:include page="footer.jsp"/>