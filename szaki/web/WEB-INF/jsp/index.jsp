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
    <div class="text sixteen columns">
        <img src="images/advers.png" alt="Reklám szöveg" title="Reklám szöveg"/>
        <img src="images/handymanOnLadder.png" alt="Szerelő" title="Szerelő"/>
    </div>
    <div class="clear"></div>
    <div class="boxes">
        <h2>Miért minket válasszon!</h2>
        <div class="four columns box">
            <img src="images/bag.png" alt="szerszámtáska" title="szerszámtáska" class="shadow"/>
            <h3>Sokszínűség</h3>
            <p>Adatbázisunkban sokfajta foglalkozást megtalálsz.</p>
        </div>
        <div class="four columns box">
            <img src="images/handyman.png" alt="szakember" title="szakember" class="shadow"/>
            <h3>Pontosság</h3>
            <p>A keresett személy gyors kiválasztása különböző szűrők segítségével.</p>
        </div>
        <div class="four columns box">
            <img src="images/helmet.png" alt="sisak" title="sisak" class="shadow"/>
            <h3>Biztonság</h3>
            <p>A személyes adatok védelme, biztonságos tárolása.</p>
        </div>
        <div class="four columns box">
            <img src="images/star.png" alt="csillag" title="csillag" class="shadow"/>
            <h3>Értékelések</h3>
            <p>Minden munkavállalót értékelhetsz az elvégzett munka alapján.</p>
        </div>
    </div>
    <div class="clear"></div>
    <%@include file="footer.jsp" %>
