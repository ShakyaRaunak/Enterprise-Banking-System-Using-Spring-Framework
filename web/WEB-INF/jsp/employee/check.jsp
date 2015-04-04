<%
    int userId;
    boolean admincheck;
    try {
        userId = Integer.parseInt(session.getAttribute("sessUserID").toString());
        admincheck = Boolean.parseBoolean(session.getAttribute("sessIsadmin").toString());
    } catch (Exception e) {
        userId = 0;
        admincheck = false;
    }
    if (userId == 0 || admincheck == false) {
        response.sendRedirect("../index.jsp");
    }
%>
