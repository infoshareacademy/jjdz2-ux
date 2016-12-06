<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
<h3>Wypełnij formularz</h3>
<form method="post" action="form" title="Formularz walidacji strony www">
    <p>Czy Twoje ilustracje na stronie są opatrzone wypełnionymi atrybutaki alt ?</p>
    <input type="radio" name="question_1" value="1">Tak
    <input type="radio" name="question_1" value="0" checked="checked">Nie <br/>

    <p>Czy na Twojej stronie znajdują się nagłówhi h1, h2, h3 ?</p>
    <input type="radio" name="question_2" value="1">Tak
    <input type="radio" name="question_2" value="0" checked="checked">Nie <br/>

    <p>Czy wszystkie podstrony posiadają unikalny tytuł ?</p>
    <input type="radio" name="question_3" value="1">Tak
    <input type="radio" name="question_3" value="0" checked="checked">Nie <br/>

    <p>Czy każda z podstron zawiera opis ?</p>
    <input type="radio" name="question_4" value="1">Tak
    <input type="radio" name="question_4" value="0" checked="checked">Nie <br/>

    <p>Czy wszyskie media na stronie są ładowane w ostatniej kolejności ?</p>
    <input type="radio" name="question_5" value="1">Tak
    <input type="radio" name="question_5" value="0" checked="checked">Nie <br/>
    <input type="submit" value="Wyślij"><input type="reset" value="Wyczyść">
</form>
<br/>
<h3>Wyniki</h3>
<div>
    <ul>
        <c:forEach items="${answers}" var="answer">
        <li> ${answer.title}: <b>${answer.answers.answer1}</b>
            </c:forEach>
    </ul>
    <p>${answers}</p>
</div>
</body>
</html>
