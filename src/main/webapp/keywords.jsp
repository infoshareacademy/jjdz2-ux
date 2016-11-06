<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>KeyWords</title>
</head>
<body>
<div>
    <form method="post" action="keywords">
        Wybierz stronę
        <select name="folder">
            <option value="infoshareacademy">infoshareacademy</option>
            <option value="wmh">wmh</option>
        </select>
        <input type="submit" value="OK">
    </form>
</div>


<H2>Lista słów kluczowych na stronie</H2>
<div>
    <p>${keyWords}</p>
</div>


</body>
</html>
