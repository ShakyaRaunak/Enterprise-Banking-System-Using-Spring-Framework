<%-- 
    Document   : RestoreCustomer
    Created on : Mar 26, 2014, 7:48:44 AM
    Author     : Raunak Shakya
--%>

<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="java.util.List"%>

<%@page import="com.banking.model.Customer"%>
<%@page import="com.banking.model.Address"%>
<%@page import="com.banking.controller.CustomerController"%>
<%@page import="com.banking.controller.AddressController"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restore Customer</title>
        <link rel="stylesheet" href="../stylesheets/app.css"/>
    </head>
    <body>
        <%
            Integer userId;
            try {
                userId = Integer.parseInt(session.getAttribute("sessUserID").toString());
                if (userId == null || !(userId > 0)) {
                    response.sendRedirect("../index.jsp");
                }
            } catch (Exception e) {
                throw new RuntimeException("UserId not valid");
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
                    <th>Total Balance</th>
                    <th>Account No.</th>
                    <th>Contact</th>
                    <th>Actions</th>
                        <%
                            ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bsp/bankingsystemproject/applicationContext.xml");
                            CustomerController customerController = (CustomerController) ctx.getBean("customerDao");
                            List<Customer> customers = customerController.listDeletedCustomers();

                            AddressController addressController = (AddressController) ctx.getBean("addressController");
                            int serialno = 0;
                            for (Customer customer : customers) {
                                serialno++;
                                out.print("<tr>");
                                out.print("<td>" + serialno + "</td>");
                                out.print("<td>" + customer.getFirstName() + " " + customer.getMiddleName() + " " + customer.getLastName() + "</td>");

                                Address address = addressController.getAddress();
                                out.print("<td>" + address.getState() + ", " + address.getCity() + "</td>");

                                out.print("<td>" + customer.getDateOfBirth() + "</td>");
                                out.print("<td>" + customer.getDateOfJoin() + "</td>");
                                out.print("<td>" + customer.getId() + "</td>");
                                out.print("<td>" + customer.getId() + "</td>");
                                out.print("<td>" + //customer.getHomecontact() + ", " + customer.getMobilecontact() + 
                                        "</td>");
                                out.print("<td><a href='UpdateCustomer.jsp?cid=" + customer.getId() + "'>Edit</a> | "
                                        + "<a href='RestoreCustomer.jsp?cid=" + customer.getId() + "' onclick='javascript:return confirmdelete();'>Restore</a></td>");
                                out.print("</tr>");
                            }
                        %>
                </tr>
            </table>
        </div>
    </body>
</html>
