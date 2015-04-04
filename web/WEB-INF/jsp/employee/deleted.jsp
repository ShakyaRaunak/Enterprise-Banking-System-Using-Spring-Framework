<%-- 
    Document   : ViewDeletedEmployee
    Created on : Mar 26, 2014, 8:35:23 AM
    Author     : Raunak Shakya
--%>

<%@page import="com.banking.model.Employee"%>
<%@page import="com.banking.controller.EmployeeController"%>

<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="java.util.List"%>

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
            boolean admincheck;
            try {
                Integer userId = Integer.parseInt(session.getAttribute("sessUserID").toString());
                admincheck = Boolean.parseBoolean(session.getAttribute("sessIsadmin").toString());
            } catch (Exception e) {
                userId = 0;
                admincheck = false;
            }
            if (userId == 0 || admincheck == false) {
                response.sendRedirect("../index.jsp");
            }
        %>

        <jsp:include page="header.jsp"/>

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
                            EmployeeController employeeDao = (EmployeeController) ctx.getBean("employeeDao");
                            List<Employee> employees = employeeDao.listDeletedEmployees();

                            int serialno = 0;
                            for (Employee employee : employees) {
                                serialno++;
                                out.print("<tr>");
                                out.print("<td>" + serialno + "</td>");
                                out.print("<td>" + employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName() + "</td>");
                                out.print("<td>" + employee.getAddressId() + "</td>");
                                out.print("<td>" + employee.getDateOfBirth() + "</td>");
                                out.print("<td>" + employee.getDateOfJoin() + "</td>");
                                out.print("<td>" + employee.getDepartment() + "</td>");
                                out.print("<td>" + employee.getPost() + "</td>");
                                out.print("<td>" + employee.getHomeContact() + ", " + employee.getMobileNumber() + "</td>");
                                out.print("<td><a href='UpdateEmployee.jsp?eid=" + employee.getId() + "'>Edit</a> | "
                                        + "<a href='RestoreEmployee.jsp?eid=" + employee.getId() + "' class='deletelink'>Restore</a></td>");
                                out.print("</tr>");
                            }
                        %>
                </tr>
            </table>
        </div>

    </body>
</html>
