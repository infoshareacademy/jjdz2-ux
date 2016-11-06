<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>KeyWords</title>
</head>
<body>
<div>
    <form method="post" action="keywords">
        Wybierz stronę
        <input tyle="text" name="link" value="http://www.">

        <input type="submit" value="OK">
    </form>
</div>




<H2>Lista słów kluczowych na stronie</H2>
<div>
    <p>${keyWords}</p>
</div>


</body>
</html>
