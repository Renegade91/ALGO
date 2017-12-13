<%-- 
    Document   : index
    Created on : 13.12.2017, 14:38:54
    Author     : 89388
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
        <jsp:include page="/header.jsp" />
    </head>
    <body>
        <jsp:include page="/menu.jsp" />

        <main> 
            <article class="begruessung"> 
                <h1>Herzlich Willkommen auf Seite des Stadtrats Stadts</h1> 
                <p>Auf dieser Seite verwalten wir alle Anträge, Beschlüsse und soweiter.</p>
            </article> 

        </main>

        <jsp:include page="/footer.jsp" />
    </body>
</html>
