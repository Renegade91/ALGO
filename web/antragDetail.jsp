<%-- 
    Document   : antragDetail
    Created on : 11.12.2017, 13:35:02
    Author     : 89449
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Stadtrat Stadt</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/stylesheet.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <div class="w3-container w3-teal">
            <header>
                <ul>
                    <li>
                        <a href="./index.html">Home</a>
                    </li>
                    <li>
                        <a href="./antrag.jsp">Anträge</a>
                    </li>
                    <li style="float:right">
                        <a class="active" href="./about.jsp">About</a>
                    </li>
                </ul> 
            </header>
        </div>
            <main> 
                
                <article class="begruessung"> 
                    <div align="center">
                    <table class="details">
                        <tr>
                            <td>AntragsNr:</td>
                            <td>01</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Typ:</td>
                            <td>Bauamt</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Thema:</td>
                            <td>Verschrottung des Denkmals</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Gestellt am:</td>
                            <td>10.12.2017</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Gestellt am:</td>
                            <td>10.12.2017</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Gestellt von:</td>
                            <td>Peter Griffin</td>
                            <td>
                                <a href="./ratsmitglied.jsp">
                                    <i class="fa fa-search"></i>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>Status:</td>
                            <td>genehmigt</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Dokumente:</td>
                            <td>Anlagen</td>
                            <td></td>
                        </tr>
                        
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
            <div class="w3-container w3-teal">
            <footer>
                <div>
                    <p>© 2017 by Arbeitsgruppe Blümchen</p>  
                </div>
            </footer>
            </div>
       
    </body>
</html>
