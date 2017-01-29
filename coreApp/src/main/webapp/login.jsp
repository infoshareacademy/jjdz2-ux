<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<main class="container">
    <title>Do log in, please!</title>
    <p>Use your facebook login and password to get access to our website.</p>
    <div class="form-group">
        <form method="post" action="facebook">
            login : <input type="text" name="username">
            password: <input type="password" name="password">
            <input type="submit" value="login">
            <input type="submit" value="createUser">
        </form>
    </div>

</main>
<jsp:include page="footer.jsp"/>
