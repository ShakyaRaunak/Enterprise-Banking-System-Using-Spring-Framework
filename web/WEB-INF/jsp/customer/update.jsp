<%-- 
    Document   : UpdateCustomer
    Created on : Mar 17, 2014, 10:11:50 AM
    Author     : Raunak Shakya
--%>

<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>

<%@page import="com.banking.model.Customer"%>
<%@page import="com.banking.model.Address"%>
<%@page import="com.banking.controller.CustomerController"%>
<%@page import="com.banking.controller.AddressController"%>
<%@page import="com.banking.utils.Status"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Customer</title>
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

        <jsp:include page="header.jsp"/>

        <div class="container">
            <h3>Edit the customer information</h3>

            <%
                Integer id = Integer.parseInt(request.getParameter("cid"));
                if (id == null || !(id > 0)) {
                    throw new RuntimeException("Customer id is not valid");
                }

                ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bsp/bankingsystemproject/applicationContext.xml");
                CustomerController customerController = (CustomerController) ctx.getBean("customerController");
                AddressController addressController = (AddressController) ctx.getBean("addressController");

                Customer customer = customerController.findById(id);
                Address address = addressController.findById(customer.getAddressId());
            %>

            <form action="../updateCustomer" method="post">
                <table>
                    <tr>
                        <td>First Name :</td>
                        <td><input type="text" name="firstname" value="<%= customer.getFirstName()%>"/></td>
                        <td>&nbsp;</td>
                        <td>Middle Name :</td>
                        <td><input type="text" name="middlename" value="<%= customer.getMiddleName()%>"/></td>
                        <td>&nbsp;</td>
                        <td>Last Name :</td>
                        <td><input type="text" name="lastname" value="<%= customer.getLastName()%>"/></td>
                    </tr>
                    <tr>
                        <td>Home Contact :</td>
                        <td><input type="text" name="homecontact" value=""/></td>
                        <td>&nbsp;</td>
                        <td>Mobile Contact :</td>
                        <td><input type="text" name="mobilecontact" value=""/></td>
                        <td>&nbsp;</td>
                        <td>Zip-Code :</td>
                        <td><input type="text" name="zipcode" value="<%= address.getZipCode()%>"/></td>
                    </tr>
                    <tr>
                        <td>Date of Birth :</td>
                        <td><input type="text" name="dateofbirth" value="<%= customer.getDateOfBirth()%>"/></td>
                        <td>&nbsp;</td>
                        <td>Date of Join :</td>
                        <td><input type="text" name="dateofjoin" value="<%= customer.getDateOfJoin()%>"/></td>
                    </tr>
                    <tr>
                        <td>City :</td>
                        <td><input type="text" name="city" value="<%= address.getCity()%>"/></td>
                        <td>&nbsp;</td>
                        <td>State :</td>
                        <td><input type="text" name="state" value="<%= address.getState()%>"/></td>
                    </tr>
                    <tr>
                        <td>Street :</td>
                        <td><input type="text" name="street" value="<%= address.getStreetName()%>"/></td>
                        <td>&nbsp;</td>
                        <td>Street No. :</td>
                        <td><input type="text" name="streetnumber" value="<%= address.getStreetNumber()%>"/></td>
                        <td>&nbsp;</td>
                        <td>Apartment No. :</td>
                        <td><input type="text" name="apartmentnumber" value="<%= address.getApartmentNumber()%>"/></td>
                    </tr>
                    <tr>
                        <td>Current Status :</td>
                        <td>
                            <%
                                if (customer.getStatus() == Status.ACTIVE) {
                            %>
                            <input type="checkbox" name="customerstatus"  value="active" checked/>
                            <%
                            } else {
                            %>
                            <input type="checkbox" name="customerstatus" value="active"/>
                            <%
                                }
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="8">&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="8" style="text-align: right;">
                            <input type="hidden" name="custid" value="<%= id%>"/>
                            <input type="submit" name="submit" value="Update this customer" class="button"/>&nbsp;&nbsp;
                            <input type="reset" name="cancel" value="Forget this update" class="button"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
