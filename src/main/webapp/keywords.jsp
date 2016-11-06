<%--
  Created by IntelliJ IDEA.
  User: morhen
  Date: 06.11.16
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>KeyWords</title>
</head>
<body>
<div>
    <form method="post" action="keywords">
        Wybierz stronę <input type="text" name="folder">
        <br />
        <input type="submit" value="OK">
        <br />
    </form>
</div>


<H1>Lista słów kluczowych na stronie</H1>
<div>
    <p>${keyWords}</p>
</div>


</body>
</html>
