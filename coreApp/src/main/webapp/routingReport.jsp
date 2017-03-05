<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>

<main class="container">
    <div class="col-lg-6 col-lg-offset-3">
        <%--<c:if test="${colors.isEmpty()}">--%>
            <%--<h2>Brak kolorów w bazie danych</h2>--%>
        <%--</c:if>--%>
        <%--<table class="table">--%>
            <%--<thead>--%>
            <%--<tr>--%>
                <%--<th>Kolor</th>--%>
                <%--<th>#HEX</th>--%>
                <%--<th>Wystąpień</th>--%>
            <%--</tr>--%>
            <%--</thead>--%>

            <%--<tbody>--%>
            <%--<c:forEach items="${colors}" var="color">--%>
                <%--<tr>--%>
                    <%--<td bgcolor="${color.hex}"></td>--%>
                    <%--<td>${color.hex}</td>--%>
                    <%--<td>${color.count}</td>--%>
                <%--</tr>--%>
            <%--</c:forEach>--%>
            <%--</tbody>--%>

        <%--</table>--%>
        ${routingReport}
    </div>
</main>

<jsp:include page="footer.jsp"/>