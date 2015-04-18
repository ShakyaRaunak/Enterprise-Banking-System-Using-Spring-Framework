<%-- 
    Document   : ViewEmployee
    Created on : Mar 17, 2014, 10:12:18 AM
    Author     : Raunak Shakya
--%>

<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="java.util.List"%>

<%@page import="com.banking.model.Employee"%>
<%@page import="com.banking.controller.EmployeeController"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Employee</title>
        <link rel="stylesheet" href="../stylesheets/style.css"/>
        <script type="text/javascript" src="../jquery/jquery-1.11.0.js"></script>
        <script type="text/javascript">
            $("document").ready(function () {
                $(".deletelink").on("click", function () {
                    return confirm("Are you sure to delete?");
                });
            });
        </script>
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
        <jsp:include page="../customer/header.jsp"/>

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
                            EmployeeController employeeController = (EmployeeController) ctx.getBean("employeeController");
                            List<Employee> employees = employeeController.list();

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
                                        + "<a href='DeleteEmployee.jsp?eid=" + employee.getId() + "' class='deletelink'>Delete</a></td>");
                                out.print("</tr>");
                            }
                        %>
                </tr>
            </table>
        </div>
    </body>
</html>
