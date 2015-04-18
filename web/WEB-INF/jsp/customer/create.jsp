<%-- 
    Document   : AddCustomer
    Created on : Mar 17, 2014, 10:11:31 AM
    Author     : Raunak Shakya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Customer</title>
        <link rel="stylesheet" href="../stylesheets/style.css"/>
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
        <jsp:include page="../customer/header.jsp"/>

        <div class="container">
            <h3>Enter new customer information</h3>
            <form action="../addCustomer" method="post">
                <table>
                    <tr>
                        <td>First Name :</td>
                        <td><input type="text" name="firstname"/></td>
                        <td>&nbsp;</td>
                        <td>Middle Name :</td>
                        <td><input type="text" name="middlename"/></td>
                        <td>&nbsp;</td>
                        <td>Last Name :</td>
                        <td><input type="text" name="lastname"/></td>
                    </tr>
                    <tr>
                        <td>Home Contact :</td>
                        <td><input type="text" name="homecontact"/></td>
                        <td>&nbsp;</td>
                        <td>Mobile Contact :</td>
                        <td><input type="text" name="mobilecontact"/></td>
                        <td>&nbsp;</td>
                        <td>Zip-Code :</td>
                        <td><input type="text" name="zipcode"/></td>
                    </tr>
                    <tr>
                        <td>Date of Birth :</td>
                        <td><input type="text" name="dateofbirth"/></td>
                        <td>&nbsp;</td>
                        <td>Date of Join :</td>
                        <td><input type="text" name="dateofjoin"/></td>
                    </tr>
                    <tr>
                        <td>City :</td>
                        <td><input type="text" name="city"/></td>
                        <td>&nbsp;</td>
                        <td>State :</td>
                        <td><input type="text" name="state"/></td>
                    </tr>
                    <tr>
                        <td>Street :</td>
                        <td><input type="text" name="street"/></td>
                        <td>&nbsp;</td>
                        <td>Street No. :</td>
                        <td><input type="text" name="streetnumber"/></td>
                        <td>&nbsp;</td>
                        <td>Apartment No. :</td>
                        <td><input type="text" name="apartmentnumber"/></td>
                    </tr>
                    <tr>
                        <td>Current Status :</td>
                        <td><input type="checkbox" name="customerstatus" value="active"/></td>
                    </tr>
                    <tr>
                        <td colspan="8">&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="8" style="text-align: right;">
                            <input type="submit" name="submit" value="Add this customer" class="button"/>&nbsp;&nbsp;
                            <input type="reset" name="cancel" value="Forget this customer" class="button"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
