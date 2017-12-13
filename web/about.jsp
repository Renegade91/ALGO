<%-- 
    Document   : about
    Created on : 12.12.2017, 08:39:11
    Author     : 89449
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
                <h1>Impressum</h1> <br>
                <p>Arbeitsgruppe Blümchen</p>
                <p>Siemensallee 5000000</p>
                <p>803628 München</p>
                <p>Tel.: 011177777111</p>
                <p>Email: arbeitsgruppeblümchen@random.de </p> <br><br>

                <div id="about">
                    <h1>Datenschutz</h1><br>
                    <p><i>Allgemeine Datenschutzerklärung</i></p>
                    <p>Durch die Nutzung unserer Website erklären Sie sich mit der Erhebung,
                        Verarbeitung und Nutzung von Daten gemäß der nachfolgenden Beschreibung einverstanden. 
                        Unsere Website kann grundsätzlich ohne Registrierung besucht werden. Dabei werden Daten 
                        wie beispielsweise aufgerufene Seiten bzw. Namen der abgerufenen Datei, Datum und Uhrzeit 
                        zu statistischen Zwecken auf dem Server gespeichert, ohne dass diese Daten unmittelbar auf 
                        Ihre Person bezogen werden. Personenbezogene Daten, insbesondere Name, Adresse oder 
                        E-Mail-Adresse werden soweit möglich auf freiwilliger Basis erhoben. Ohne Ihre Einwilligung 
                        erfolgt keine Weitergabe der Daten an Dritte.</p>

                    <p><i>Datenschutzerklärung für Cookies</i></p><br>
                    <p>Unsere Website verwendet Cookies. Das sind kleine Textdateien, 
                        die es möglich machen, auf dem Endgerät des Nutzers spezifische, 
                        auf den Nutzer bezogene Informationen zu speichern, während er die Website nutzt. 
                        Cookies ermöglichen es, insbesondere Nutzungshäufigkeit und Nutzeranzahl der Seiten zu ermitteln, 
                        Verhaltensweisen der Seitennutzung zu analysieren, aber auch unser Angebot kundenfreundlicher zu gestalten. 
                        Cookies bleiben über das Ende einer Browser-Sitzung gespeichert und können bei einem erneuten Seitenbesuch wieder aufgerufen werden. 
                        Wenn Sie das nicht wünschen, sollten Sie Ihren Internetbrowser so einstellen, dass er die Annahme von Cookies verweigert.</p>
                </div>
            </article> 

        </main>

        <jsp:include page="/footer.jsp" />
    </body>
</html>
