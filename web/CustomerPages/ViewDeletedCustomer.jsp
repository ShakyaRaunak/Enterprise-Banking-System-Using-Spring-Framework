<%-- 
    Document   : RestoreCustomer
    Created on : Mar 26, 2014, 7:48:44 AM
    Author     : Raunak Shakya
--%>

<%@page import="com.bsp.bankingsystemproject.CustomerAddress"%>
<%@page import="java.util.List"%>
<%@page import="com.bsp.bankingsystemproject.CustomerAddressDao"%>
<%@page import="com.bsp.bankingsystemproject.Customer"%>
<%@page import="com.bsp.bankingsystemproject.CustomerDao"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restore Customer</title>
        <link rel="stylesheet" href="../stylesheets/style.css"/>
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

        <jsp:include page="CustPagesHeader.jsp"/>

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
                            CustomerDao cdao = (CustomerDao) ctx.getBean("cdao");
                            List<Customer> custlist = cdao.getDeletedCustomers();

                            CustomerAddressDao cadao = (CustomerAddressDao) ctx.getBean("cadao");
                            int serialno = 0;
                            for (Customer cust : custlist) {
                                serialno++;
                                out.print("<tr>");
                                out.print("<td>" + serialno + "</td>");
                                out.print("<td>" + cust.getFirstname() + " " + cust.getMiddlename() + " " + cust.getLastname() + "</td>");

                                CustomerAddress custaddr = cadao.getSpecificCustomerAddress(cust.getAddressid());
                                out.print("<td>" + custaddr.getState() + ", " + custaddr.getCity() + "</td>");

                                out.print("<td>" + cust.getDateofbirth() + "</td>");
                                out.print("<td>" + cust.getDateofjoin() + "</td>");
                                out.print("<td>" + cust.getCustID() + "</td>");
                                out.print("<td>" + cust.getCustID() + "</td>");
                                out.print("<td>" + cust.getHomecontact() + ", " + cust.getMobilecontact() + "</td>");
                                out.print("<td><a href='UpdateCustomer.jsp?cid=" + cust.getCustID() + "'>Edit</a> | "
                                        + "<a href='RestoreCustomer.jsp?cid=" + cust.getCustID() + "' onclick='javascript:return confirmdelete();'>Restore</a></td>");
                                out.print("</tr>");
                            }
                        %>
                </tr>
            </table>
        </div>
    </body>
</html>
