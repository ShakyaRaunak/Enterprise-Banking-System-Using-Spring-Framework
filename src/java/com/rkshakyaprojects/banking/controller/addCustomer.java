/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rkshakyaprojects.banking.controller;

import com.rkshakyaprojects.banking.model.Customer;
import com.rkshakyaprojects.banking.model.CustomerAddress;
import com.rkshakyaprojects.banking.model.CustomerAddressDao;
import com.rkshakyaprojects.banking.model.CustomerDao;
import com.rkshakyaprojects.banking.model.CustomerStreet;
import com.rkshakyaprojects.banking.model.CustomerStreetDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Raunak Shakya
 */
public class addCustomer extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String firstname = request.getParameter("firstname");
        String middlename = request.getParameter("middlename");
        String lastname = request.getParameter("lastname");
        String homecontact = request.getParameter("homecontact");
        String mobilecontact = request.getParameter("mobilecontact");
        String dateofbirth = request.getParameter("dateofbirth");
        String dateofjoin = request.getParameter("dateofjoin");
        String zipcode = request.getParameter("zipcode");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String street = request.getParameter("street");
        String streetnumber = request.getParameter("streetnumber");
        String apartmentnumber = request.getParameter("apartmentnumber");
        String customerstatus=request.getParameter("customerstatus");
        int isactive;
        if("active".equals(customerstatus)){
            isactive=1;
        }else{
            isactive=0;
        }
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bsp/bankingsystemproject/applicationContext.xml");
        CustomerDao cdao = (CustomerDao) ctx.getBean("cdao");
        CustomerAddressDao cadao=(CustomerAddressDao)ctx.getBean("cadao");
        CustomerStreetDao csdao = (CustomerStreetDao) ctx.getBean("csdao");

        CustomerStreet cs = new CustomerStreet();
        cs.setStreet(street);
        cs.setStreetnumber(streetnumber);
        cs.setApartmentnumber(apartmentnumber);
        int status = csdao.saveCustomerStreet(cs);

        CustomerStreet custstrt = csdao.getCustomerStreetID();
        CustomerAddress ca = new CustomerAddress();
        ca.setStreetid(custstrt.getStreetid());
        ca.setZipcode(zipcode);
        ca.setCity(city);
        ca.setState(state);
        status = cadao.saveCustomerAddress(ca);

        Customer c = new Customer();
        CustomerAddress custaddr = cadao.getCustomerAddressID();
        c.setAddress(custaddr.getAddressid());
        c.setFirstName(firstname);
        c.setMiddleName(middlename);
        c.setLastName(lastname);
        c.setPhone(homecontact);
        c.setDateOfBirth(dateofbirth);
        c.setDateOfJoin(dateofjoin);
        c.setIsActive(isactive);
        status = cdao.saveCustomer(c);
        if(status>0){
            response.sendRedirect("CustomerPages/ViewCustomer.jsp");
        }else{
            response.sendRedirect("error.jsp");
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
