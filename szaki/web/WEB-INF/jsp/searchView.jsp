<%-- 
    Document   : searchView
    Created on : 2014.04.26., 16:56:31
    Author     : Dani
--%>

<%@page import="com.szaki.domain.Login"%>
<%@include file="include.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="searchView.title" /></title>
        <%@include file="source.jsp" %>
    </head>
    <%@include file="header.jsp" %>
    <div class="content sixteen columns">
        <h1>Keresés!</h1>
        <form:form commandName="searching" method="POST">
            <label>Ország:</label>
            <spring:bind path="country">
                <select name="${status.expression}">
                    <option value="Magyar" selected="selected">Magyar</option>
                    <option value="Svéd">Svéd</option>
                </select>
            </spring:bind>
            <label>Megye:</label>
            <spring:bind path="county">
                <select name="${status.expression}">
                    <option value="Bács-Kiskun" selected="selected">Bács-Kiskun</option>
                    <option value="Baranya">Baranya</option>
                    <option value="Békés">Békés</option>
                    <option value="Borsod-Abaúj-Zemplén">Borsod-Abaúj-Zemplén</option>
                    <option value="Csongrád">Csongrád</option>
                    <option value="Fejér">Fejér</option>
                    <option value="Győr-Moson-Sopron">Győr-Moson-Sopron</option>
                    <option value="Hajdú-Bihar">Hajdú-Bihar</option>
                    <option value="Heves">Heves</option>
                    <option value="Jász-Nagykun-Szolnok">Jász-Nagykun-Szolnok</option>
                    <option value="Komárom-Esztergom">Komárom-Esztergom</option>
                    <option value="Nógrád">Nógrád</option>
                    <option value="Pest">Pest</option>
                    <option value="Somogy">Somogy</option>
                    <option value="Szabolcs-Szatmár-Bereg">Szabolcs-Szatmár-Bereg</option>
                    <option value="Tolna">Tolna</option>
                    <option value="Vas">Vas</option>
                    <option value="Veszprém">Veszprém</option>
                    <option value="Zala">Zala</option>
                </select>
            </spring:bind>
            <label>Szakma:</label>
            <%--<spring:bind path="*">                
                <c:forEach items="${listOfProfessions}" var="prof">                    
                    <form:checkbox path="profession" id="${prof.id}" value="${prof.id}" label="${prof.name}" />
                </c:forEach>
            </spring:bind>--%>
            <spring:bind path="profession">
                <form:select path="profession">
                    <c:forEach items="${listOfProfessions}" var="prof">
                        <form:option value="${prof.id}"><c:out value="${prof.name}"/></form:option>
                    </c:forEach>
                </form:select>
            </spring:bind>
            <input type="submit" value="keresés" />
        </form:form>
    </div>
    <%@include file="footer.jsp" %>
