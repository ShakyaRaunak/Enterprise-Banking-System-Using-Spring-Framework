<%-- 
    Document   : DeleteEmployee
    Created on : Mar 17, 2014, 10:12:48 AM
    Author     : Raunak Shakya
--%>

<%@page import="com.bsp.bankingsystemproject.Employee"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="com.bsp.bankingsystemproject.EmployeeDao"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String empid = request.getParameter("eid");

    ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bsp/bankingsystemproject/applicationContext.xml");
    EmployeeDao edao = (EmployeeDao) ctx.getBean("edao");
    Employee e = new Employee();
    e.setEmpID(Integer.parseInt(empid));
    int status = edao.deleteEmployee(e);
    if(status>0){
        response.sendRedirect("ViewEmployee.jsp");
    }
%>
