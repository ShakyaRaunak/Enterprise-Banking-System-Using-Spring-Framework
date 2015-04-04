<%-- 
    Document   : ViewCustomer
    Created on : Mar 17, 2014, 10:11:41 AM
    Author     : Raunak Shakya
--%>

<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="java.util.ArrayList"%>
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
        <title>View Customer</title>
        <link rel="stylesheet" href="../stylesheets/style.css"/>
        <script>
            function confirmdelete() {
                var deleteconfirm = confirm("Are you sure to delete?");
                if (deleteconfirm === true) {
                    return true;
                } else {
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <%
            int userid;
            try {
                userid = Integer.parseInt(session.getAttribute("sessUserID").toString());
            } catch (Exception e) {
                userid = 0;
            }
            if (userid == 0) {
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
                    <th>Total Balance</th>
                    <th>Account No.</th>
                    <th>Contact</th>
                    <th>Actions</th>
                        <%
                            ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bsp/bankingsystemproject/applicationContext.xml");
                            CustomerController customerController = (CustomerController) ctx.getBean("customerController");
                            List<Customer> customers = customerController.list();

                            AddressController addressController = (AddressController) ctx.getBean("addressController");
                            int serialno = 0;
                            for (Customer customer : customers) {
                                serialno++;
                                out.print("<tr>");
                                out.print("<td>" + serialno + "</td>");
                                out.print("<td>" + customer.getFirstName() + " " + customer.getMiddleName() + " " + customer.getLastName() + "</td>");

                                Address address = addressController.findById(customer.getAddressId());
                                out.print("<td>" + address.getState() + ", " + address.getCity() + "</td>");

                                out.print("<td>" + customer.getDateOfBirth() + "</td>");
                                out.print("<td>" + customer.getDateOfJoin() + "</td>");
                                out.print("<td>" + "" + "</td>");
                                out.print("<td>" + "" + "</td>");
                                out.print("<td>" + //customer.getHomeContact() + ", " + customer.getMobileContact() + 
                                        "</td>");
                                out.print("<td><a href='update.jsp?cid=" + customer.getId() + "'>Edit</a> | "
                                        + "<a href='delete.jsp?cid=" + customer.getId() + "' onclick='javascript:return confirmdelete();'>Delete</a></td>");
                                out.print("</tr>");
                            }
                        %>
                </tr>
            </table>
        </div>
    </body>
</html>
