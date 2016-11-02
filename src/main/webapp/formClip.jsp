<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div>
    <form method="post" action="setHTMLpath">
    Enter a path to your HTML file: <input type="text" name="HTML_path">
    </form>
</div>

<div>
    <form method="post" action="setCSSpath">
        Enter a path to your HTML file: <input type="text" name="CSS_path">
    </form>
</div>

<div>
    <div>The colors are:</div>
    <div>
        <ul>
            <c:forEach items="${listOfColors}" var="listOfUniqueColors">
            <li> ${listOfUniqueColors} </li>
                </c:forEach>
        </ul>
    </div>
</div>

</body>
</html>
