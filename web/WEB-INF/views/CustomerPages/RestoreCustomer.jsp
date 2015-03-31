<%-- 
    Document   : RestoreCustomer
    Created on : Mar 26, 2014, 7:54:12 AM
    Author     : Raunak Shakya
--%>

<%@page import="com.bsp.bankingsystemproject.Customer"%>
<%@page import="com.bsp.bankingsystemproject.CustomerDao"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String custid = request.getParameter("cid");

    ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bsp/bankingsystemproject/applicationContext.xml");
    CustomerDao customerDao = (CustomerDao) ctx.getBean("customerDao");
    Customer c = new Customer();
    c.setCustID(Integer.parseInt(custid));
    int status = customerDao.restoreCustomer(c);
    if(status>0){
        response.sendRedirect("ViewDeletedCustomer.jsp");
    }
%>
