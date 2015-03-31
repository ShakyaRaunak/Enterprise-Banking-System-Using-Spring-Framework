<%-- 
    Document   : ViewDeletedEmployee
    Created on : Mar 26, 2014, 8:35:23 AM
    Author     : Raunak Shakya
--%>

<%@page import="com.bsp.bankingsystemproject.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.bsp.bankingsystemproject.EmployeeDao"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restore Employee</title>
        <link rel="stylesheet" href="../stylesheets/style.css"/>
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
                response.sendRedirect("../index.jsp");
            }
        %>
        
        <jsp:include page="EmpPagesHeader.jsp"/>

        <div class="container">
            <table class="viewtable">
                <tr>
                    <th>S.N.</th>
                    <th>Full Name</th>
                    <th>Address</th>
                    <th>Date Of Birth</th>
                    <th>Date Of Join</th>
                    <th>Department</th>
                    <th>Post</th>
                    <th>Contact</th>
                    <th>Actions</th>
                        <%
                            ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bsp/bankingsystemproject/applicationContext.xml");
                            EmployeeDao employeeDao = (EmployeeDao) ctx.getBean("employeeDao");
                            List<Employee> emplist = employeeDao.getDeletedEmployees();

                            int serialno = 0;
                            for (Employee emp : emplist) {
                                serialno++;
                                out.print("<tr>");
                                out.print("<td>" + serialno + "</td>");
                                out.print("<td>" + emp.getFirstname() + " " + emp.getMiddlename() + " " + emp.getLastname() + "</td>");
                                out.print("<td>" + emp.getAddress() + "</td>");
                                out.print("<td>" + emp.getDateofbirth() + "</td>");
                                out.print("<td>" + emp.getDateofjoin() + "</td>");
                                out.print("<td>" + emp.getDepartment() + "</td>");
                                out.print("<td>" + emp.getPost() + "</td>");
                                out.print("<td>" + emp.getHomecontact() + ", " + emp.getMobilecontact() + "</td>");
                                out.print("<td><a href='UpdateEmployee.jsp?eid=" + emp.getEmpID() + "'>Edit</a> | "
                                        + "<a href='RestoreEmployee.jsp?eid=" + emp.getEmpID() + "' class='deletelink'>Restore</a></td>");
                                out.print("</tr>");
                            }
                        %>
                </tr>
            </table>

    </body>
</html>
