<%-- 
    Document   : index
    Created on : Mar 13, 2014, 5:34:25 PM
    Author     : Raunak Shakya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Banking System</title>
        <link rel="stylesheet" type="text/css" href="../stylesheets/app.css"/>
    </head>
    <body>
        <h1>Banking Enterprise System</h1>
        <div class="title_bar">
            <ul>
                <li><a href="${pageContext.servletContext.contextPath}/index.jsp">Home</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/index.jsp">About</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/index.jsp">Services</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/index.jsp">Career</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/index.jsp">Contact</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/login.jsp">Log in</a></li>
            </ul>
            <div class="clear"></div>
        </div>
        <div class="container">
            <div style="padding:20px;">
                <p>Welcome to the Banking Enterprise System Project</p>
                <p>This project covers topics such as Java Server Pages, Servlets and Spring Framework.</p>
            </div>
        </div>

    </body>
</html>
