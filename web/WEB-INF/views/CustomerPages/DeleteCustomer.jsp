<%-- 
    Document   : DeleteCustomer
    Created on : Mar 17, 2014, 10:12:01 AM
    Author     : Raunak Shakya
--%>

<%@page import="com.banking.model.Customer"%>
<%@page import="com.banking.utils.CustomerDao"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String custid = request.getParameter("cid");

    ApplicationContext ctx = new ClassPathXmlApplicationContext("com/banking/system/applicationContext.xml");
    CustomerDao customerDao = (CustomerDao) ctx.getBean("customerDao");
    Customer customer = new Customer();
    customer.setId(Integer.parseInt(custid));
    int status = customerDao.deleteCustomer(customer);
    if(status>0){
        response.sendRedirect("ViewCustomer.jsp");
    }
%>
