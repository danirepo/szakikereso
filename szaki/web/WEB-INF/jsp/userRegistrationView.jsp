<%-- 
    Document   : userRegistrationView
    Created on : 2014.04.24., 20:20:08
    Author     : Dani
--%>

<%@include file="include.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="userRegistrationView.title" /></title>
        <%@include file="source.jsp" %>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <h1>Regisztráció</h1>
        <p>Ha Ön szakember akkor válassza a <a href="<c:url value="/szakiregisztracio.htm" />">szakember regisztrációt</a></p>
        <spring:nestedPath path="userRegistration">
            <form:form commandName="userRegistration" method="POST">
                <form:errors path="*" cssClass="errorblock" element="div" />
                Vezetéknév:
                <spring:bind path="lastName">
                    <input type="text" name="${status.expression}" value="${status.value}" placeholder="Vezetéknév" />
                </spring:bind>
                Keresztnév:
                <spring:bind path="firstName">
                    <input type="text" name="${status.expression}" value="${status.value}" placeholder="Keresznév" />
                    <form:errors path="firstName" cssClass="error" />
                </spring:bind>
                E-mail:
                <spring:bind path="email">
                    <input type="text" name="${status.expression}" value="${status.value}" placeholder="E-mail" />
                </spring:bind>
                Jelszó:
                <spring:bind path="password">
                    <input type="password" name="${status.expression}" value="${status.value}" placeholder="Jelszó" />
                </spring:bind>
                Jelszó megerősitése:
                <spring:bind path="password2">
                    <input type="password" name="${status.expression}" value="${status.value}" placeholder="Jelszó" />
                </spring:bind>
                <input type="submit" value="Regisztráció" />
            </form:form>
        </spring:nestedPath>
        <%@include file="footer.jsp" %>
    </body>
</html>
