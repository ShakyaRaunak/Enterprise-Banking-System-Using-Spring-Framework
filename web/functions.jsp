<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!

boolean loggedin(){
    if(session.getAttribute("sessUser").equals("admin"))
        return true;
    else
        return false;
}

%>