<%@include file="include.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="index.title" /></title>
        <%@include file="source.jsp" %>
    </head>

    <%@include file="header.jsp" %>
    <div id="contents">
        <div id="adbox">
            <div class="clearfix">
                <img class ="workers" src="images/handyman_on_ladder.png">
                <img class="szoveg" src="images/szoveg.png" width="500" height="400">
            </div>
        </div>
        <div class="featured">
            <h2>Miért minket válassz?</h2>
            <ul class="clearfix">
                <li>
                    <div class="frame1">
                        <div class="box">
                            <img src="images/meeting.jpg" alt="Img" height="130" width="197">
                        </div>
                    </div>
                    <p>
                        <b>Sokszínűség</b> Adatbázisunkban sokfajta foglalkozást megtalálsz.
                    </p> <br><br>
                    <a href="search.html" target="_blank" class="more">Keresés</a>
                </li>
                <li>
                    <div class="frame1">
                        <div class="box">
                            <img src="images/handshake.jpg" alt="Img" height="130" width="197">
                        </div>
                    </div>
                    <p>
                        <b>Pontosság</b> A keresett személy gyors kiválasztása különböző
                        szűrők segítségével.
                    </p><br>
                    <a href="index.html" class="more">Szakemberek</a>
                </li>
                <li>
                    <div class="frame1">
                        <div class="box">
                            <img src="images/smile.jpg" alt="Img" height="130" width="197">
                        </div>
                    </div>
                    <p>
                        <b>Biztonság</b> A személyes adatok védelme, biztonságos tárolása.
                    </p> <br><br>
                    <a href="registration.html" target="_blank" class="more"> Regisztáció </a>
                </li>
                <li>
                    <div class="frame1">
                        <div class="box">
                            <img src="images/family-small.jpg" alt="Img" height="130" width="197">
                        </div>
                    </div>
                    <p>
                        <b>Értékelések, vélemények</b> Minden munkavállalót értékelhetsz az elvégzett
                        munka alapján.
                    </p><br>
                    <a href="index.html" class="more">Értékelések</a>
                </li>
            </ul>
        </div>
    </div>
    <%@include file="footer.jsp" %>
