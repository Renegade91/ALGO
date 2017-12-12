<%-- 
    Document   : ratsmitglied
    Created on : 12.12.2017, 08:38:57
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
                <div align="center">
                    <table class="details">
                        <c:import url="/detailRatsmitglied" charEncoding="UTF-8" />  
                    </table>
                </div>
                <br>
                <div class="w3-container">
                    <a href="antrag.jsp" class="w3-button w3-teal w3-round">
                        <i class="fa fa-arrow-left"></i>
                    </a>
                </div>
            </article>
        </main>

        <jsp:include page="/footer.jsp" />
    </body>
</html>
