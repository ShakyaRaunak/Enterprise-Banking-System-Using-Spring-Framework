<%-- 
    Document   : empPage
    Created on : Mar 26, 2014, 6:58:29 AM
    Author     : Raunak Shakya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee</title>
        <link rel="stylesheet" href="stylesheets/style.css"/>
    </head>
    <body>
        <%
            int userid;
            try {
                userid = Integer.parseInt(session.getAttribute("sessUserID").toString());
            } catch (Exception e) {
                userid=0;
            }
            if (userid == 0) {
                response.sendRedirect("index.jsp");
            }
        %>
        
        <h1>Banking Enterprise System</h1>
        <div id="title_bar">
            <ul>
                <li><a href="CustomerPages/ViewCustomer.jsp">Customers</a></li>
                <li><a href="logout.jsp">Log out</a></li>
            </ul>
            <div class="clear"></div>
        </div>
    </body>
</html>
