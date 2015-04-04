<%-- 
    Document   : adminPage
    Created on : Mar 17, 2014, 10:02:44 AM
    Author     : Raunak Shakya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrator</title>
        <link rel="stylesheet" href="../stylesheets/app.css"/>
    </head>
    <body>
        <%
            int userid;
            boolean admincheck;
            try {
                userid = Integer.parseInt(session.getAttribute("sessUserID").toString());
                admincheck = Boolean.parseBoolean(session.getAttribute("sessIsadmin").toString());
            } catch (Exception e) {
                userid = 0;
                admincheck = false;
            }
            if (userid == 0 || admincheck == false) {
                response.sendRedirect("index.jsp");
            }
        %>

        <h1>Banking Enterprise System</h1>
        <div id="title_bar">
            <ul>
                <li><a href="CustomerPages/ViewCustomer.jsp">Customers</a></li>
                <li><a href="EmployeePages/ViewEmployee.jsp">Employees</a></li>
                <li><a href="logout.jsp">Log out</a></li>
            </ul>
            <div class="clear"></div>
        </div>
    </body>
</html>
