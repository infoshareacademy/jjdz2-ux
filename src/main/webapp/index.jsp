<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />
<section class="slider">
    <div class="container">
        <h2>Poznaj lepiej swoją stronę internetową</h2>
        <div class="row">
            <div class="col-lg-6 col-lg-offset-3">
                <nav class="type-test-nav">
                    <ul>
                        <li><a href="#" class="active" data-form="accessibility">UX</a></li>
                        <li><a href="#" data-form="colors">KOLORY</a></li>
                        <li><a href="#" data-form="keywords">SEO</a></li>
                        <li><a href="#" data-form="routing">LINKI</a></li>
                    </ul>
                </nav>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6 col-lg-offset-3">
                <form id="main-form" action="accessibility" method="post" class="form-inline">
                    <input class=""type="text" name="domainurl" placeholder="Podaj adres witryny"><button type="submit" class="btn btn-warning">Testuj</button>
                </form>
            </div>
        </div>
    </div>

</section>
<main class="container">
    <article>
        <header class=""><h1>Sprawdź poprawność swojej strony internetowej</h1></header>
        <ul class="services-list row">
            <li class="col-lg-3"><img src="images/ux-circle.jpg"><h3>Testy UX</h3><p>Sprawdź swoją stronę pod kątem doświoadczenia użytkownika. Przekonaj się czy Twoja strona spełnia obowiązujące standardy, a treść na niej zawarta będzie łatwo dostępna.</p></li>
            <li class="col-lg-3"><img src="images/color-circle.jpg"><h3>Testy Graficzne</h3><p>Zobacz jakich kolorów używasz na stronie. Sprawdź czy nie jest ich zbyt wiele. Lista kolorów, może okazać się przydatna do dalszego, graficznego rozwoju Twojej witryny.</p></li>
            <li class="col-lg-3"><img src="images/seo-circle.jpg"><h3>Testy SEO</h3><p>Przekonaj się, czy Twoja strona jest zoptymalizowana pod kątem wyszukiwarek sieciowych. Poznaj słowa kluczowe swojej i innych witryn. Zobacz jak działa konkurencja i bądź krok przed nimi</p></li>
            <li class="col-lg-3"><img src="images/reports-circle.jpg"><h3>Raporty</h3><p>Załóż bezpłatne konto i generuj raporty z analiz Twojej witryny i stron konkurencji. Twórz porównania i sprawdzaj postępy w procesie modyfikacji Twojej strony.</p></li>
        </ul>

        <h2 class="section-headline">Co dają Ci testy SIONACH?</h2>
        <div class="row">
            <img src="images/about-icons.jpg" alt="Testy Sionach" title="Testy Sionach" class="col-lg-3">
            <div class="col-lg-9">
                <p>Posiadanie internetowej, która promuje Twoją działalność jest obecnie obowiązkowe. Jeżeli nie ma Cię w sieci, to nie ma Cię wcale. Jednak sama stronie nie wystarczy aby być widocznycm w internecie i dobrze odebranym przez potencjalnych klientów. Witryna, która jest wizytówką Twojej firmy musi spełniać pewne wymagania, które opierają się na wypracowanych standardach. Przede wszystkim strona musi być przygotowana pod kątem użytkownika. Nie jest istotne czy strona spełnia nasze wymagania, ale czy spełni wymagania większości odwiedzających. Strona powinna być również spójna graficznie, czyli korzystać z określonej, spójnej gamy kolorów. Jeżeli chcesz dotrzeć do internautów ze swoją ofertą, musisz skupić się także nad optymalizacją witryny pod kątem wyszukiwarek. Źle soptymalizowana strona, może mieć problem z przebiciem się przez strony konkurencji.</p>
                <p>Dzięki naszym testom poznasz wszystkie słabe strony swojej witryny, a także porównasz ją z witrynami swojej konkurencji. Dzięki temu będziesz wiedzieć co robi konkurencja i co zmienić aby poprawić swoją widoczność. Testy zostały oprcowane na podstawie wieloletnich doświadczeń twórców witryn i pozycjonerów, którzy od lat zajmują się tym tematem. Dzięki naszym testom zwiększysz swoje szanse na wyższe pozycje w wyszukiwarkach takich jak Google czy Bing, oraz poprawisz konwersję na swojej witrynie.</p>
            </div>
        </div>
        <h2 class="section-headline">Zespół SIONACH</h2>

        <ul class="team-list">
            <li class="row"><div class="col-lg-3"><img src="images/alicjab.jpg"></div><div class="col-lg-9"><h3>Alicja Błażejewska</h3><p>Programista JAVA, JavaScript, C++. W zespole odpowiednialna jest za backedn produktu i bazę danych. Dba o to, aby wszystkie informacje przekazywane przez naszych użytkowników były odpowiednio przechowywane i aby każdy miał dostęp do swoich danych, mógł tworzyć porównania i generować raporty.</p></div></li>
            <li class="row"><div class="col-lg-3"><img src="images/pawelo.jpg"></div><div class="col-lg-9"><h3>Paweł Orszt</h3><p>Programista JAVA, Pythona i aplikacji mobilnych na Androida. W zespole zajmuje się backendem, a także zarządza, ustawia i naprawia wszsytko co związane jest z naszymi serwerami. To właśnie dzięki niemu nasz serwis jest dostępny dla użytkowników przez całą dobę i działa sprawnie i stabilnie.</p></div></li>
            <li class="row"><div class="col-lg-3"><img src="images/paweld.jpg"></div><div class="col-lg-9"><h3>Paweł Drzał</h3><p>Programista JAVA, webmaster. W zespole wspiera pracę pozostałych członków drużyny po stronie backendu, ponadto zajmuje się Frontendem, starając sie przygotować optymalnie wygodny nterfejs dla użytkowników serwisu. Aktywnie wspierany w swoich zadaniach przez wszytskich członków zespołu.</p></div></li>
        </ul>
    </article>
</main>
<jsp:include page="footer.jsp" />