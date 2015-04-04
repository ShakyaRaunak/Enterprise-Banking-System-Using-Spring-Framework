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
        <link rel="stylesheet" href="../stylesheets/app.css"/>
    </head>
    <body>
        <%
            try {
                Integer userId = Integer.parseInt(session.getAttribute("sessUserID").toString());
                if (userId == null || !(userId > 0)) {
                    //throw new RuntimeException("User id is not valid");
                    response.sendRedirect("index.jsp");
                }
            } catch (Exception exc) {
                throw new RuntimeException("User id is not valid");
            }
        %>

        <h1>Banking Enterprise System</h1>
        <div id="title_bar">
            <ul>
                <li><a href="../jsp/customer/view.jsp">Customers</a></li>
                <li><a href="../jsp/logout.jsp">Log out</a></li>
            </ul>
            <div class="clear"></div>
        </div>
    </body>
</html>
