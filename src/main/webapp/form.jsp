<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<main class="container">

    <header><h1>Wypełnij formularz</h1></header>

    <div class="col-lg-6 col-lg-offset-3">

        <form method="post" action="formAnswers" title="Formularz walidacji strony www">
            <c:forEach items="${questions.questionsAndAnswers}" var="question">
                <div class="form-group">
                    <label for="${question.title}">${question.title}</label>
                    <div class="radio">
                        <label>
                            <input type="radio" name="${question.key}" value="1">Tak
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="${question.key}" value="0" checked="checked">Nie <br/>
                        </label>
                    </div>
                </div>
            </c:forEach>
            <button type="submit" class="btn btn-warning">Wyślij</button>
            <button type="reset" class="btn btn-danger">Resetuj</button>
        </form>

    </div>

</main>
<jsp:include page="footer.jsp"/>