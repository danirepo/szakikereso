<%@page contentType="text/html" pageEncoding="UTF-8"%>
<body>
    <div class="container">
        <div id="header">
            <div class="clearfix">
                <div class="logo">
                    <a href="<c:url value="/index.htm" />"><img src="<c:url value="/images/megegylogo.png"/>" alt="LOGO" height="80" width="240"></a>
                </div>
                <div class="login">
                    <a href="<c:url value="/regisztracio.htm" />"><h1>Regisztráció</h1> </a>
                    <a href="<c:url value="/login.htm" />"><h1>Belépés</h1> </a>
                    <label>Email cím
                        <input type="text" size="20"></label>
                    <label>Jelszó
                        <input type="text" size="20"></label>
                </div>
                <ul class="navigation">
                    <li class="active">
                        <a href="<c:url value="/index.htm" />">Főoldal</a>
                    </li>
                    <li>
                        <a href="<c:url value="/kereses.htm" />">Keresés</a>
                    </li>
                    <li>
                        <a href="contact.html">Szakemberek</a>
                    </li>
                    <li>
                        <a href="<c:url value="/regisztracio.htm" />">Regisztráció</a>
                    </li>
                </ul>
            </div>
        </div>