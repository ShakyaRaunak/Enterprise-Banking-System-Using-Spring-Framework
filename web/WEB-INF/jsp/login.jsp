<%-- 
    Document   : login
    Created on : Mar 14, 2014, 8:22:51 AM
    Author     : Raunak Shakya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="../stylesheets/app.css"/>
    </head>
    <body>
        <jsp:include page="../jsp/includes/main.jsp"/>

        <div class="container">
            <h3>Login to your account</h3>
            <form action="./loginController" method="post">
                User name : <br/>
                <input type="text" name="username" autocomplete="off" required/>
                <br/><br/>
                Password : <br/>
                <input type="password" name="password" required/>
                <br/><br/>
                <input type="submit" name="submit" value="Login"/>
            </form>
        </div>
    </body>
</html>
