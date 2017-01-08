<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />

<main class="container">
    <div class="col-lg-6 col-lg-offset-3">

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

            <table class="table">
                <thead>
                <tr>
                    <th>Kolor</th>
                    <th>#HEX</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${listOfColors}" var="color">
                    <tr>
                        <td bgcolor="${color}"></td>
                        <td>${color}</td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>


    </article>
    </div>

</main>


<jsp:include page="footer.jsp" />
