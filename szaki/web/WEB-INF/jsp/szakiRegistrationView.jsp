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
        <title><fmt:message key="szakiRegistrationView.title" /></title>
        <%@include file="source.jsp" %>
        <style>
            .error {
                color: #ff0000;
            }

            .errorblock {
                color: #000;
                background-color: #ffEEEE;
                border: 3px solid #ff0000;
                padding: 8px;
                margin: 16px;
            }
        </style>
    </head>
    <%@include file="header.jsp" %>
    <div class="content sixteen columns">
        <h1>Szakember regisztráció</h1>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <p>Ha Ön értékelni szeretné a szakemberek válassza a <a href="<c:url value="/regisztracio.htm" />" >felhasználó regisztrációt</a></p>
            <spring:nestedPath path="szakiRegistration">
                <form:form commandName="szakiRegistration" method="POST">
                    <form:errors path="*" cssClass="errorblock" element="div"></form:errors>
                        <label>Vezetéknév:</label>
                    <spring:bind path="lastName">
                        <input type="text" name="${status.expression}" value="${status.value}" placeholder="Vezetéknév" /><br />
                    </spring:bind>
                    <label>Keresztnév:</label>
                    <spring:bind path="firstName">
                        <input type="text" name="${status.expression}" value="${status.value}" placeholder="Keresztnév" /><br />
                    </spring:bind>
                    <label>Vállakozás neve:</label>
                    <spring:bind path="nameOfCompany">
                        <input type="text" name="${status.expression}" value="${status.value}" placeholder="Vállalkozás neve" /><br />
                    </spring:bind>
                    <label>E-mail:</label>
                    <spring:bind path="email">
                        <input type="text" name="${status.expression}" value="${status.value}" placeholder="E-mail" /><br />
                    </spring:bind>
                    <label>Telefonszám:</label>
                    <spring:bind path="phone">
                        <input type="text" name="${status.expression}" value="${status.value}" placeholder="30/123-4567" /> pl.: 30/123-4567<br />
                    </spring:bind>
                    <label>Szakma:</label>
                    <div class="profession">
                        <c:forEach items="${professionsList}" var="prof">
                            <form:checkbox path="profession" id="${prof.id}" value="${prof.id}" label="${prof.name}" /><br />
                        </c:forEach><br /></div>
                    <div class="clear"></div>
                    <label>Ország:</label>
                    <spring:bind path="country">
                        <select name="${status.expression}">
                            <option value="Magyar" selected="selected">Magyar</option>
                            <option value="Svéd">Svéd</option>
                        </select><br />
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
                        </select><br />
                    </spring:bind>
                    <label>Város:</label>
                    <spring:bind path="city">
                        <input type="text" name="${status.expression}" value="${status.value}" placeholder="Város" /><br />
                    </spring:bind>
                    <label>Utca:</label>
                    <spring:bind path="street">
                        <input type="text" name="${status.expression}" value="${status.value}" placeholder="Utca" /><br />
                    </spring:bind>
                    <label>Házszám:</label>
                    <spring:bind path="number">
                        <input type="text" name="${status.expression}" value="${status.value}" placeholder="Házszám" /><br />
                    </spring:bind>
                    <label>Jelszó:</label>
                    <spring:bind path="password">
                        <input type="password" name="${status.expression}" value="${status.value}" placeholder="Jelszó" /><br />
                    </spring:bind>
                    <label>Jelszó:</label>
                    <spring:bind path="password2">
                        <input type="password" name="${status.expression}" value="${status.value}" placeholder="Jelszó" /><br />
                    </spring:bind>
                    <input type="submit" value="Regisztráció" />
                </form:form>
            </spring:nestedPath>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <p>Ön már regisztrált!</p>
        </c:if>
    </div>
    <%@include file="footer.jsp" %>
