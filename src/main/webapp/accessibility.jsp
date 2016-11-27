<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: drzalek
  Date: 30.10.16
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accessibility HTML</title>
</head>
<body>
<form action="accessibility" method="post">
    <lable>Podaj adres url domeny do sprawdzenia:</lable>
    <input type="text" placeholder="Url domeny" name="domainurl">
    <input type="submit" value="sprawdz">
</form>
<h2>Liczba linków na stronie</h2>
<p>${linksInHtml}</p>

<h2>Zdeprecjonowane tagi html</h2>
<p>${deprecatedTags}</p>
<h2>Ustawienia w sekcji head</h2>

<h3>Występowanie elementów</h3>

<c:choose>
    <c:when test="${descriptionOccurance>1}">
        <p>Meta desription występuje więcej niż raz na Twojej stronie</p>
    </c:when>
    <c:when test="${descriptionOccurance==0}">
        <p>Meta desription nie występuje na Twojej stronie</p>
    </c:when>
    <c:otherwise>
        <p>Meta desription występuje prawidłowo tylko raz na Twojej stronie</p>
    </c:otherwise>
</c:choose>
<c:if test="${metaKeywordsOccurance>0}">
    <p>Meta keywords występuje na Twojej stronie, obecnie nie zaleca się ustawiania tego meta tagu.</p>
</c:if>

<c:choose>
    <c:when test="${titleOccurance>1}">
        <p>Tag title występuje więcej niż raz na Twojej stronie</p>
    </c:when>
    <c:when test="${titleOccurance==0}">
        <p>Tag title nie występuje na Twojej stronie</p>
    </c:when>
    <c:otherwise>
        <p>Tag title występuje prawidłowo tylko raz na Twojej stronie</p>
    </c:otherwise>
</c:choose>

<c:choose>
    <c:when test="${relCanonicalOccurance>1}">
        <p>Kanoniczny adres witryny występuje więcej niż raz na Twojej stronie</p>
    </c:when>
    <c:when test="${relCanonicalOccurance==0}">
        <p>Kanoniczny adres witryny nie występuje na Twojej stronie</p>
    </c:when>
    <c:otherwise>
        <p>Kanoniczny adres witryny występuje prawidłowo tylko raz na Twojej stronie</p>
    </c:otherwise>
</c:choose>

<h3>Poprawność elementów w sekcji head</h3>
<c:choose>
    <c:when test="${descriptionLength>160}">
        <p>Meta desription Jest zbyt długie i wynosi ${descriptionLength} - optymalnie powinno wynosić 150-160 znaków</p>
    </c:when>
    <c:when test="${descriptionLength<150}">
        <p>Meta desription Jest zbyt krótkie i wynosi ${descriptionLength} - optymalnie powinno wynosić 150-160 znaków</p>
    </c:when>
    <c:otherwise>
        <p>Meta desription ma prawidłową długośc 150-160 znaków</p>
    </c:otherwise>
</c:choose>

<c:choose>
    <c:when test="${titleLength>60}">
        <p>Meta desription Jest zbyt długie i wynosi ${titleLength} - optymalnie powinno wynosić 50-60 znaków</p>
    </c:when>
    <c:when test="${titleLength<50}">
        <p>Meta desription Jest zbyt krótkie i wynosi ${titleLength} - optymalnie powinno wynosić 50-60 znaków</p>
    </c:when>
    <c:otherwise>
        <p>Meta desription ma prawidłową długośc 150-160 znaków</p>
    </c:otherwise>
</c:choose>

<c:choose>
    <c:when test="${isRelCanonical}">
        <p>Kanoniczny adres strony został prawidłowo ustawiony</p>
    </c:when>
    <c:otherwise>
        <p>Sprawdź czy kanoniczny adres strony jest poprawnym adresem URL i czy został ustawiony</p>
    </c:otherwise>
</c:choose>

<c:choose>
    <c:when test="${htmlLnag}">
        <p>Język strony został ustawiony prawidłowo</p>
    </c:when>
    <c:otherwise>
        <p>Język strony nie został ustawiony lub jest ustawiony w sposób nieprawidłowy</p>
    </c:otherwise>
</c:choose>

</body>
</html>
