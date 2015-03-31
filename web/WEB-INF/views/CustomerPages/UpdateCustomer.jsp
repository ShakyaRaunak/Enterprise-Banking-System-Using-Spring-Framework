<%-- 
    Document   : UpdateCustomer
    Created on : Mar 17, 2014, 10:11:50 AM
    Author     : Raunak Shakya
--%>

<%@page import="com.banking.model.Address"%>
<%@page import="com.banking.utils.AddressDao"%>
<%@page import="com.banking.model.Customer"%>
<%@page import="com.banking.utils.CustomerDao"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
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
        
        <jsp:include page="CustPagesHeader.jsp"/>

        <div class="container">
            <h3>Edit the customer information</h3>
            <%
                String custid = request.getParameter("cid");

                ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bsp/bankingsystemproject/applicationContext.xml");
                CustomerDao customerDao = (CustomerDao) ctx.getBean("customerDao");
                AddressDao addressDao = (AddressDao) ctx.getBean("addressDao");
                
                Customer c = customerDao.getSpecificCustomer(Integer.parseInt(custid));
                Address ca = addressDao.getSpecificAddress(c.getId());

            %>
            <form action="../updateCustomer" method="post">
                <table>
                    <tr>
                        <td>First Name :</td>
                        <td><input type="text" name="firstname" value="<%= c.getFirstName()%>"/></td>
                        <td>&nbsp;</td>
                        <td>Middle Name :</td>
                        <td><input type="text" name="middlename" value="<%= c.getMiddleName()%>"/></td>
                        <td>&nbsp;</td>
                        <td>Last Name :</td>
                        <td><input type="text" name="lastname" value="<%= c.getLastName()%>"/></td>
                    </tr>
                    <tr>
                        <td>Home Contact :</td>
                        <td><input type="text" name="homecontact" value=""/></td>
                        <td>&nbsp;</td>
                        <td>Mobile Contact :</td>
                        <td><input type="text" name="mobilecontact" value=""/></td>
                        <td>&nbsp;</td>
                        <td>Zip-Code :</td>
                        <td><input type="text" name="zipcode" value="<%= ca.getZipCode()%>"/></td>
                    </tr>
                    <tr>
                        <td>Date of Birth :</td>
                        <td><input type="text" name="dateofbirth" value="<%= c.getDateOfBirth()%>"/></td>
                        <td>&nbsp;</td>
                        <td>Date of Join :</td>
                        <td><input type="text" name="dateofjoin" value="<%= c.getDateOfJoin()%>"/></td>
                    </tr>
                    <tr>
                        <td>City :</td>
                        <td><input type="text" name="city" value="<%= ca.getCity()%>"/></td>
                        <td>&nbsp;</td>
                        <td>State :</td>
                        <td><input type="text" name="state" value="<%= ca.getState()%>"/></td>
                    </tr>
                    <tr>
                        <td>Street :</td>
                        <td><input type="text" name="street" value="<%= ca.getStreet()%>"/></td>
                        <td>&nbsp;</td>
                        <td>Street No. :</td>
                        <td><input type="text" name="streetnumber" value="<%= ca.getStreetNumber()%>"/></td>
                        <td>&nbsp;</td>
                        <td>Apartment No. :</td>
                        <td><input type="text" name="apartmentnumber" value="<%= ca.getApartmentNumber()%>"/></td>
                    </tr>
                    <tr>
                        <td>Current Status :</td>
                        <td>
                            <%
                                if (c.getIsActive() == true) {
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
                            <input type="hidden" name="custid" value="<%= custid%>"/>
                            <input type="submit" name="submit" value="Update this customer" class="button"/>&nbsp;&nbsp;
                            <input type="reset" name="cancel" value="Forget this update" class="button"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
