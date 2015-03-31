package com.banking.controller;

import com.banking.model.Address;
import com.banking.model.Customer;
import com.banking.utils.CustomerDao;
import com.banking.utils.AddressDao;
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
        String customerstatus = request.getParameter("customerstatus");
        Boolean isactive = ("active".equals(customerstatus));
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bsp/bankingsystemproject/applicationContext.xml");
        CustomerDao customerDao = (CustomerDao) ctx.getBean("cdao");
        AddressDao addressDao = (AddressDao) ctx.getBean("cadao");

        Address address = new Address();
        address.setZipCode(zipcode);
        address.setCity(city);
        address.setState(state);
        address.setStreet(street);
        address.setStreetNumber(streetnumber);
        address.setApartmentNumber(apartmentnumber);
        int saveCustomerAddress = addressDao.saveCustomerAddress(address);

        Customer customer = new Customer();
        Address custAddress = addressDao.getCustomerAddressID();
        customer.setAddress(custAddress.getId());
        customer.setFirstName(firstname);
        customer.setMiddleName(middlename);
        customer.setLastName(lastname);
        customer.setPhone(homecontact);
        customer.setDateOfBirth(dateofbirth);
        customer.setDateOfJoin(dateofjoin);
        customer.setIsActive(isactive);
        saveCustomerAddress = customerDao.saveCustomer(customer);
        if (saveCustomerAddress > 0) {
            response.sendRedirect("CustomerPages/ViewCustomer.jsp");
        } else {
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
    }

}
