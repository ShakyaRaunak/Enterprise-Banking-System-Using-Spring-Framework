package com.banking.servlet;

import com.banking.controller.AddressController;
import com.banking.controller.CustomerController;
import com.banking.model.Address;
import com.banking.model.Customer;
import com.sun.org.apache.xerces.internal.util.Status;
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
        String mobileContact = request.getParameter("mobilecontact");
        String dateofbirth = request.getParameter("dateofbirth");
        String dateofjoin = request.getParameter("dateofjoin");
        String zipcode = request.getParameter("zipcode");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String street = request.getParameter("street");
        String streetnumber = request.getParameter("streetnumber");
        String apartmentnumber = request.getParameter("apartmentnumber");
        String customerstatus = request.getParameter("customerstatus");
        Status status = Status.valueOf(customerstatus);
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bsp/bankingsystemproject/applicationContext.xml");
        CustomerController customerController = (CustomerController) ctx.getBean("customerController");
        AddressController addressController = (AddressController) ctx.getBean("addressController");

        Address address = new Address();
        address.setZipCode(zipcode);
        address.setCity(city);
        address.setState(state);
        address.setStreetName(street);
        address.setStreetNumber(streetnumber);
        address.setApartmentNumber(apartmentnumber);
        Integer addressSaved = addressController.save(address);
        if (!(addressSaved > 0)) {
            throw new RuntimeException("Address could not be saved");
        }
        
        Customer customer = new Customer();
        Address customerAddress = addressController.getAddress();
        customer.setAddressId(customerAddress.getId());
        customer.setFirstName(firstname);
        customer.setMiddleName(middlename);
        customer.setLastName(lastname);
        customer.setPhone(homecontact);
        customer.setDateOfBirth(dateofbirth);
        customer.setDateOfJoin(dateofjoin);
        //customer.setStatus(status);
        Integer customerSaved = customerController.save(customer);
        if (!(customerSaved > 0)) {
            throw new RuntimeException("Customer could not be saved");
            //response.sendRedirect("error.jsp");
        }
        response.sendRedirect("customer/view.jsp");
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
