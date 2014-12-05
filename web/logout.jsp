<%-- 
    Document   : logout
    Created on : Mar 14, 2014, 8:32:46 AM
    Author     : Raunak Shakya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log out</title>
    </head>
    <body>
        <%
            HttpSession sess=request.getSession();
            sess.invalidate();
            response.sendRedirect("index.jsp");
        %>
    </body>
</html>
