<%-- 
    Document   : UpdateEmployee
    Created on : Mar 17, 2014, 10:12:39 AM
    Author     : Raunak Shakya
--%>

<%@page import="com.bsp.bankingsystemproject.Employee"%>
<%@page import="com.bsp.bankingsystemproject.EmployeeDao"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
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

                ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bsp/bankingsystemproject/applicationContext.xml");
                EmployeeDao edao = (EmployeeDao) ctx.getBean("edao");
                Employee e = edao.getSpecificEmployee(Integer.parseInt(empid));

            %>
            <form action="../updateEmployee" method="post">
                <table>
                    <tr>
                        <td>First Name :</td>
                        <td><input type="text" name="firstname" value="<%= e.getFirstname()%>"/></td>
                        <td>&nbsp;</td>
                        <td>Middle Name :</td>
                        <td><input type="text" name="middlename" value="<%= e.getMiddlename()%>"/></td>
                        <td>&nbsp;</td>
                        <td>Last Name :</td>
                        <td><input type="text" name="lastname" value="<%= e.getLastname()%>"/></td>
                    </tr>
                    <tr>
                        <td>Home Contact :</td>
                        <td><input type="text" name="homecontact" value="<%= e.getHomecontact()%>"/></td>
                        <td>&nbsp;</td>
                        <td>Mobile Contact :</td>
                        <td><input type="text" name="mobilecontact" value="<%= e.getMobilecontact()%>"/></td>
                        <td>&nbsp;</td>
                        <td>Current Status :</td>
                        <td>
                            <%
                                if (e.getIsactive() == 1) {
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
                        <td><input type="text" name="dateofbirth" value="<%= e.getDateofbirth()%>"/></td>
                        <td>&nbsp;</td>
                        <td>Date of Join :</td>
                        <td><input type="text" name="dateofjoin" value="<%= e.getDateofjoin()%>"/></td>
                    </tr>
                    <tr>
                        <td>Department :</td>
                        <td><input type="text" name="department" value="<%= e.getDepartment()%>"/></td>
                        <td>&nbsp;</td>
                        <td>Post :</td>
                        <td><input type="text" name="post" value="<%= e.getPost()%>"/></td>
                        <td>&nbsp;</td>
                        <td>Administrator :</td>
                        <td>
                            <%
                                if (e.getIsadmin() == 1) {
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
                            <textarea name="address" rows="6" cols="28"><%= e.getAddress()%></textarea>
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
