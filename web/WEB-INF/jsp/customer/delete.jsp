<%-- 
    Document   : DeleteCustomer
    Created on : Mar 17, 2014, 10:12:01 AM
    Author     : Raunak Shakya
--%>

<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>

<%@page import="com.banking.model.Customer"%>
<%@page import="com.banking.controller.CustomerController"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Integer id = Integer.parseInt(request.getParameter("cid"));
    if (id == null || !(id > 0)) {
        throw new RuntimeException("Customer id is not valid");
    }

    ApplicationContext ctx = new ClassPathXmlApplicationContext("com/banking/system/applicationContext.xml");
    CustomerController customerController = (CustomerController) ctx.getBean("customerController");
    Integer status = customerController.delete(id);
    if (!(status > 0)) {
        throw new RuntimeException("Customer could not be deleted");
    }
    response.sendRedirect("view.jsp");
%>
