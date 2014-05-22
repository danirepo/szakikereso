<%-- 
    Document   : searchSuccessView
    Created on : 2014.04.26., 19:22:50
    Author     : Dani
--%>

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
        <h1>Találati lista</h1>
        <c:forEach items="${foundList}" var="item">
            <div class="handyman">
                <h2><c:out value="${item.lastName}" />&nbsp;<c:out value="${item.firstName}" /></h2>
                <p class="profession"><c:if test="${item.profession != 'null'}"><c:out value=" ${item.profession}"/></c:if><c:if test="${item.profession2 != 'null'}">, <c:out value="${item.profession2}"/></c:if><c:if test="${item.profession3 != 'null'}">, <c:out value="${item.profession3}"/></c:if></p>
                    <p>Elérhetőségek:</p>
                            <p class="phone">Telefonszám: <c:out value="${item.phone}"/><br> E-mail: <c:out value="${item.email}"/><br>
                    Cím: <c:out value="${item.city}"/>, <c:out value="${item.street}"/> <c:out value="${item.number}"/>.</p>
                    <p>Értékelések:</p>
                    <div class="clear"></div>


                <c:forEach items="${ratingList}" var="ratingItem">
                    <c:if test="${item.email == ratingItem.szaki}">
                        <div class="rating">
                            <p class="six columns sender">Beküldő: <c:out value="${ratingItem.sender}"/></p>
                            <p class="three columns date"><c:out value="${ratingItem.date}"/></p>
                            <p class="two columns mark">Osztályzat: <c:out value="${ratingItem.mark}"/></p>
                            <p class="seven columns description"><c:out value="${ratingItem.description}"/></p>
                        </div>
                        <div class="clear"></div>
                    </c:if>
                </c:forEach>

                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <sec:authorize access="hasRole('ROLE_USER')">
                        <a href="<c:url value="/ertekeles.htm" />" itemid="${item.email}" class="rating">Értékelem</a>
                    </sec:authorize>

                </c:if>
            </div>
            <div class="clear"></div>
        </c:forEach>
        <p><c:out value="${notFound}"/></p>
    </div>
    <%@include file="footer.jsp" %>