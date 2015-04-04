<%-- 
    Document   : RestoreEmployee
    Created on : Mar 26, 2014, 8:35:33 AM
    Author     : Raunak Shakya
--%>

<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>

<%@page import="com.banking.model.Employee"%>
<%@page import="com.banking.controller.EmployeeController"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Integer id = Integer.parseInt(request.getParameter("eid"));
    if (id == null || !(id > 0)) {
        throw new RuntimeException("Employee id is not valid");
    }

    ApplicationContext ctx = new ClassPathXmlApplicationContext("com/banking/system/applicationContext.xml");
    EmployeeController employeeController = (EmployeeController) ctx.getBean("employeeController");

    Integer status = employeeController.restore(id);
    if (!(status > 0)) {
        throw new RuntimeException("Customer could not be deleted");
    }
    response.sendRedirect("view.jsp");
%>
