<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form answer</title>
</head>
<body>
<h3>Wyniki</h3>
<div>
    <c:forEach items="${answers}" var="answer">
        <p>${answer}</p>
    </c:forEach>
</div>

</body>
</html>
