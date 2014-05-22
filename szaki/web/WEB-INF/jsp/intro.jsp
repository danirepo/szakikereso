<%-- 
    Document   : intro
    Created on : 2014.05.22., 20:17:54
    Author     : Dani
--%>

<%@include file="include.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Szakikereső</title>
        <%@include file="source.jsp" %>
    </head>
    <body>
        <div class="introImg">
            <img src="<c:url value="/images/logo.png"/>" alt="logo" class="introLogo pulsing"/>
        </div>
            
        <audio autoplay="autoplay" controls="controls">
            <source src="<c:url value="/music/music.mp3"/>" type="audio/mpeg">
            <source src="<c:url value="/music/music.ogg"/>" type="audio/ogg">
            <embed height="50" width="100" src="<c:url value="/music/music.mp3"/>">
        </audio>
        <a href="<c:url value="/index.htm" />" class="introLink">Intro átugrása</a>
    </body>
</html>
