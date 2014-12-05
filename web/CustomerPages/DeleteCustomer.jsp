<%-- 
    Document   : DeleteCustomer
    Created on : Mar 17, 2014, 10:12:01 AM
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
    CustomerDao cdao = (CustomerDao) ctx.getBean("cdao");
    Customer c = new Customer();
    c.setCustID(Integer.parseInt(custid));
    int status = cdao.deleteCustomer(c);
    if(status>0){
        response.sendRedirect("ViewCustomer.jsp");
    }
%>
