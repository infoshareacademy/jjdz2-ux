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
<p>bla bla bla</p>
${htmlcode}
</body>
</html>
