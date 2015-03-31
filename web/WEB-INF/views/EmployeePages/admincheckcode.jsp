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
        response.sendRedirect("../index.jsp");
    }
%>
