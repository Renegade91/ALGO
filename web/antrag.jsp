<%-- 
    Document   : antrag
    Created on : 11.12.2017, 13:06:43
    Author     : 89449
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Stadtrat Stadt</title>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
        <jsp:include page="/header.jsp" />
    </head>
    <body>
        <jsp:include page="/menu.jsp" />

        <main> 
            <article class="begruessung"> 
                <h2>Hoverable Table</h2>
                <p>Move the mouse over the table rows to see the effect.</p>

                <table>
                    <c:import url="/listAntrage" charEncoding="UTF-8" />  
                </table>
            </article> 
        </main>

        <jsp:include page="/footer.jsp" />
    </body>
</html>
