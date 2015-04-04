<%-- 
    Document   : UpdateEmployee
    Created on : Mar 17, 2014, 10:12:39 AM
    Author     : Raunak Shakya
--%>

<%@page import="com.banking.utils.UserType"%>
<%@page import="com.banking.utils.Status"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>

<%@page import="com.banking.model.Employee"%>
<%@page import="com.banking.controller.EmployeeController"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Employee</title>
        <link rel="stylesheet" href="../stylesheets/style.css"/>
    </head>
    <body>
        <jsp:include page="EmpPagesHeader.jsp"/>

        <div class="container">
            <h3>Edit the customer information</h3>
            <%
                String empid = request.getParameter("eid");

                ApplicationContext ctx = new ClassPathXmlApplicationContext("com/banking/system/applicationContext.xml");
                EmployeeController employeeController = (EmployeeController) ctx.getBean("employeeController");
                Employee employee = employeeController.getSpecificEmployee(Integer.parseInt(empid));

            %>
            <form action="../updateEmployee" method="post">
                <table>
                    <tr>
                        <td>First Name :</td>
                        <td><input type="text" name="firstname" value="<%= employee.getFirstName()%>"/></td>
                        <td>&nbsp;</td>
                        <td>Middle Name :</td>
                        <td><input type="text" name="middlename" value="<%= employee.getMiddleName()%>"/></td>
                        <td>&nbsp;</td>
                        <td>Last Name :</td>
                        <td><input type="text" name="lastname" value="<%= employee.getLastName()%>"/></td>
                    </tr>
                    <tr>
                        <td>Home Contact :</td>
                        <td><input type="text" name="homecontact" value="<%= employee.getHomeContact()%>"/></td>
                        <td>&nbsp;</td>
                        <td>Mobile Contact :</td>
                        <td><input type="text" name="mobilecontact" value="<%= employee.getMobileNumber()%>"/></td>
                        <td>&nbsp;</td>
                        <td>Current Status :</td>
                        <td>
                            <%
                                if (employee.getType()== UserType.ADMIN) {
                            %>
                            <input type="checkbox" name="employeestatus"  value="active" checked/>
                            <%
                            } else {
                            %>
                            <input type="checkbox" name="employeestatus" value="active"/>
                            <%
                                }
                            %></td>
                    </tr>
                    <tr>
                        <td>Date of Birth :</td>
                        <td><input type="text" name="dateofbirth" value="<%= employee.getDateOfBirth()%>"/></td>
                        <td>&nbsp;</td>
                        <td>Date of Join :</td>
                        <td><input type="text" name="dateofjoin" value="<%= employee.getDateOfJoin()%>"/></td>
                    </tr>
                    <tr>
                        <td>Department :</td>
                        <td><input type="text" name="department" value="<%= employee.getDepartment()%>"/></td>
                        <td>&nbsp;</td>
                        <td>Post :</td>
                        <td><input type="text" name="post" value="<%= employee.getPost()%>"/></td>
                        <td>&nbsp;</td>
                        <td>Administrator :</td>
                        <td>
                            <%
                                if (employee.getType() == UserType.ADMIN) {
                            %>
                            <input type="checkbox" name="isadmin" value="active" checked/>
                            <%
                            } else {
                            %>
                            <input type="checkbox" name="isadmin" value="active"/>
                            <%
                                }
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;padding-top: 20px;">Address :</td>
                        <td colspan="7">
                            <textarea name="address" rows="6" cols="28"><%= employee.getAddressId()%></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="8">&nbsp;</td>
                    </tr>                    
                    <tr>
                        <td colspan="8" style="text-align: right;">
                            <input type="hidden" name="empid" value="<%= empid %>"/>
                            <input type="submit" name="submit" value="Update this employee" class="button"/>&nbsp;&nbsp;
                            <input type="reset" name="cancel" value="Forget this update" class="button"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
