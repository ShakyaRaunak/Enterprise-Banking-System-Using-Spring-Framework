<%-- 
    Document   : DeleteEmployee
    Created on : Mar 17, 2014, 10:12:48 AM
    Author     : Raunak Shakya
--%>

<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>

<%@page import="com.banking.model.Employee"%>
<%@page import="com.banking.controller.EmployeeController"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Integer id = Integer.parseInt(request.getParameter("eid"));
    if (id == null || !(id > 0)) {
        throw new RuntimeException("Employee id is not valid");
    }

    ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bsp/bankingsystemproject/applicationContext.xml");
    EmployeeController employeeController = (EmployeeController) ctx.getBean("employeeController");

    Integer status = employeeController.delete(id);
    if (!(status > 0)) {
        throw new RuntimeException("Customer could not be deleted");
    }
    response.sendRedirect("view.jsp");
%>
