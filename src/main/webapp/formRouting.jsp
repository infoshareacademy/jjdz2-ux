<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Accessibility</title>
</head>
<body>

<div>
    <form method="post" action="setHTMLpath">
        Enter a path to your HTML file: <input type="text" name="HTML_path3">
    </form>
</div>

<div>
    <div>Info about accessibility:</div>
    <div>
        <ul>
            <c:forEach items="${listRouting}" var="listItemRouting">
                <li> ${listItemRouting} </li>
            </c:forEach>
        </ul>
    </div>
</div>

</body>
</html>