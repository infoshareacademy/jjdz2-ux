<%--
  Created by IntelliJ IDEA.
  User: ablazejewska
  Date: 10.12.16
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Do log in, please!</title>
    <p>Use your facebook login and password to get access to our website.</p>
    <form method="post" action="getUser">
        login   : <input type="text" name="username">
        password: <input type="password" name="password">
        <input type="submit" value="login">
        <input type="submit" value="createUser">
    </form>
</head>
<body>

</body>
</html>
