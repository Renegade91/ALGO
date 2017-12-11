<%-- 
    Document   : index
    Created on : 11.12.2017, 15:16:22
    Author     : 89388
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% 
            System.out.println("test");
            Verwaltung.DBconn.createNewDatabase("test.db");
        %>
    </body>
</html>
