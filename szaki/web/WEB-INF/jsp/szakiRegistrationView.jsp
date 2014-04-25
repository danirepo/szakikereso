<%-- 
    Document   : szakiRegistrationView
    Created on : 2014.04.25., 12:25:02
    Author     : Dani
--%>

<%@include file="include.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <spring:nestedPath path="szakiRegistration">
            <form:form commandName="szakiRegistration" method="POST">
                Vezetéknév:
                <spring:bind path="lastName">
                    <input type="text" name="${status.expression}" value="${status.value}" placeholder="Vezetéknév" /><br />
                </spring:bind>
                Keresztnév:
                <spring:bind path="firstName">
                    <input type="text" name="${status.expression}" value="${status.value}" placeholder="Keresztnév" /><br />
                </spring:bind>
                Vállakozás neve:
                <spring:bind path="nameOfCompany">
                    <input type="text" name="${status.expression}" value="${status.value}" placeholder="Vállalkozás neve" /><br />
                </spring:bind>
                E-mail
                <spring:bind path="email">
                    <input type="text" name="${status.expression}" value="${status.value}" placeholder="E-mail" /><br />
                </spring:bind>
                Telefonszám:
                <spring:bind path="phone">
                    <input type="text" name="${status.expression}" value="${status.value}" placeholder="Telefonszám" /><br />
                </spring:bind>
                Szakma:
                <c:forEach items="${profession}" var="prof">
                    <p><c:out value="${prof.value}"/></p>
                </c:forEach>
                Ország:
                <spring:bind path="country">
                    <select name="${status.expression}">
                        <option value="Magyar" selected="selected">Magyar</option>
                        <option value="Svéd">Svéd</option>
                    </select><br />
                </spring:bind>
                Megye:
                <spring:bind path="county">
                    <select name="${status.expression}">
                        <option value="Baranya" selected="selected">Baranya</option>
                        <option value="Békés">Békés</option>
                    </select><br />
                </spring:bind>
                Város:
                <spring:bind path="city">
                    <input type="text" name="${status.expression}" value="${status.value}" placeholder="Város" /><br />
                </spring:bind>
                Utca:
                <spring:bind path="street">
                    <input type="text" name="${status.expression}" value="${status.value}" placeholder="Utca" /><br />
                </spring:bind>
                Házszám:
                <spring:bind path="number">
                    <input type="text" name="${status.expression}" value="${status.value}" placeholder="Házszám" /><br />
                </spring:bind>
                Jelszó:
                <spring:bind path="password">
                    <input type="password" name="${status.expression}" value="${status.value}" placeholder="Jelszó" /><br />
                </spring:bind>
                Jelszó:
                <input type="password" name="password" placeholder="Jelszó" /><br />
                <input type="submit" value="Regisztráció" />
            </form:form>
        </spring:nestedPath>
    </body>
</html>
