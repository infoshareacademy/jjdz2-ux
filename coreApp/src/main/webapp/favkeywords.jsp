<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>


<main class="container">

    <article class="test-results">



        <header><h1>Dodaj słowa kluczowe do ulubionych<br></h1></header>

        <form method="post" action="domainkeywords">
            <div class="form-group">
                <label for="favdomain">Adres URL strony internetowej</label>
                <input type="text" class="form-control" name="favdomain" id="favdomain" placeholder="Adres URL">
            </div>
            <div class="form-group">
                <label for="favkeywords">Słowa kluczowe</label>
                <input type="text" class="form-control" name="favkeywords" id="favkeywords" placeholder="Lista słów kluczowych po przecinku">
            </div>


            <button type="submit" class="btn btn-warning">Dodaj</button>
        </form>
        <h2>Sprawdź słowka kluczowe dla swoich domen</h2>

    </article>
</main>

<jsp:include page="footer.jsp"/>
