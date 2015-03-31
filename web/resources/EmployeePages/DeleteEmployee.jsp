<%-- 
    Document   : DeleteEmployee
    Created on : Mar 17, 2014, 10:12:48 AM
    Author     : Raunak Shakya
--%>

<%@page import="com.banking.model.Employee"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="com.banking.utils.EmployeeDao"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String empid = request.getParameter("eid");

    ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bsp/bankingsystemproject/applicationContext.xml");
    EmployeeDao employeeDao = (EmployeeDao) ctx.getBean("employeeDao");
    Employee employee = new Employee();
    employee.setId(Integer.parseInt(empid));
    int status = employeeDao.deleteEmployee(employee);
    if (status > 0) {
        response.sendRedirect("ViewEmployee.jsp");
    }
%>
