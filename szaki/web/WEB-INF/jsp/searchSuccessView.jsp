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
    <h1>Találati lista</h1>
    <c:out value="${loggedUser}" />
    <c:forEach items="${foundList}" var="item">
        <p><c:out value="${item.lastName}" />&nbsp;<c:out value="${item.firstName}" />, 
            <c:if test="${item.profession != 'null'}"><c:out value=" ${item.profession}"/></c:if> 
            <c:if test="${item.profession2 != 'null'}">, <c:out value="${item.profession2}"/></c:if>
            <c:if test="${item.profession3 != 'null'}">, <c:out value="${item.profession3}"/></c:if></p>
            <p>Értékelések:</p>
        <c:forEach items="${ratingList}" var="ratingItem">
            <c:if test="${item.email == ratingItem.szaki}">
                <c:out value="${ratingItem.mark}"/>
                <c:out value="${ratingItem.description}"/>
                <c:out value="${ratingItem.sender}"/>
                <c:out value="${ratingItem.szaki}"/>
                <c:out value="${ratingItem.date}"/>
            </c:if>
        </c:forEach>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <sec:authorize access="hasRole('ROLE_USER')">
                <a href="<c:url value="/ertekeles.htm" />" itemid="${item.email}" class="rating">Értékelés</a>
            </sec:authorize>

        </c:if>
    </c:forEach>
    <p><c:out value="${notFound}"/></p>
    <%@include file="footer.jsp" %>