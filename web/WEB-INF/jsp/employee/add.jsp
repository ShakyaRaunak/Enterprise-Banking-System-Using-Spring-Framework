<%-- 
    Document   : AddEmployee
    Created on : Mar 17, 2014, 10:12:29 AM
    Author     : Raunak Shakya
--%>

<%@page import="com.sun.org.apache.xerces.internal.util.Status"%>

<%@page import="com.banking.utils.Status" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Employee</title>
        <link rel="stylesheet" href="../stylesheets/app.css"/>
    </head>
    <body>
        <%
            try {
                Integer userId = Integer.parseInt(session.getAttribute("UserId").toString());
                if (userId == null || !(userId > 0)) {
                    throw new RuntimeException("Employee id is not valid");
                }
                com.banking.utils.Status status = com.banking.utils.Status.valueOf(session.getAttribute("sessIsadmin").toString());
            } catch (Exception e) {
                
                //response.sendRedirect("../index.jsp");
            }
        %>

        <jsp:include page="../employee/header.jsp"/>

        <div class="container">
            <h3>Enter new employee information</h3>
            <form action="../addEmployee" method="post">
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
                        <td>Current Status :</td>
                        <td><input type="checkbox" name="employeestatus" value="active"/></td>
                    </tr>
                    <tr>
                        <td>Date of Birth :</td>
                        <td><input type="text" name="dateofbirth"/></td>
                        <td>&nbsp;</td>
                        <td>Date of Join :</td>
                        <td><input type="text" name="dateofjoin"/></td>
                    </tr>
                    <tr>
                        <td>Department :</td>
                        <td><input type="text" name="department"/></td>
                        <td>&nbsp;</td>
                        <td>Post :</td>
                        <td><input type="text" name="post"/></td>
                        <td>&nbsp;</td>
                        <td>Administrator :</td>
                        <td><input type="checkbox" name="isadmin" value="active"/></td>

                    </tr>
                    <tr>
                        <td style="vertical-align: top;padding-top: 20px;">Address :</td>
                        <td colspan="7">
                            <textarea name="address" rows="6" cols="28"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="8">&nbsp;</td>
                    </tr>                    
                    <tr>
                        <td colspan="8" style="text-align: right;">
                            <input type="submit" name="submit" value="Add this employee" class="button"/>&nbsp;&nbsp;
                            <input type="reset" name="cancel" value="Forget this employee" class="button"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>

    </body>
</html>
