<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
<h3>Wypełnij formularz</h3>

<form method="post" action="formAnswers" title="Formularz walidacji strony www">
    <c:forEach items="${questions}" var="question">
        <p>${question.title}</p>
        <input type="radio" name="${question.key}" value="1">Tak
        <input type="radio" name="${question.key}" value="0" checked="checked">Nie <br/>
    </c:forEach>
    <input type="submit" value="Wyślij"><input type="reset" value="Wyczyść">
</form>

</body>
</html>
