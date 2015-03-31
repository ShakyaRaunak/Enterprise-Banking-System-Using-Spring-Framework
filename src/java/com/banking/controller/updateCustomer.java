package com.banking.controller;

import com.banking.model.Customer;
import com.banking.model.Address;
import com.banking.utils.AddressDao;
import com.banking.utils.CustomerDao;
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
public class updateCustomer extends HttpServlet {

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

        String custid = request.getParameter("custid");
        String firstname = request.getParameter("firstname");
        String middlename = request.getParameter("middlename");
        String lastname = request.getParameter("lastname");
        String homecontact = request.getParameter("homecontact");
        String mobilecontact = request.getParameter("mobilecontact");
        String dateofbirth = request.getParameter("dateofbirth");
        String dateofjoin = request.getParameter("dateofjoin");
        String zipCode = request.getParameter("zipcode");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String street = request.getParameter("street");
        String streetnumber = request.getParameter("streetnumber");
        String apartmentnumber = request.getParameter("apartmentnumber");
        String customerstatus = request.getParameter("customerstatus");
        Boolean isactive = ("active".equals(customerstatus));
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/banking/system/applicationContext.xml");
        CustomerDao customerDao = (CustomerDao) ctx.getBean("customerDao");
        AddressDao addressDao = (AddressDao) ctx.getBean("addressDao");

        Customer specificCustomer = customerDao.getSpecificCustomer(Integer.parseInt(custid));
        int addressid = specificCustomer.getAddress();
        Address customerAddress = addressDao.getSpecificAddress(addressid);
        
        Address address = new Address();
        address.setId(addressid);
        address.setZipCode(zipCode);
        address.setCity(city);
        address.setState(state);
        address.setStreet(street);
        address.setStreetNumber(streetnumber);
        address.setApartmentNumber(apartmentnumber);
        int updateCustomerAddress = addressDao.updateCustomerAddress(address);

        Customer customer = new Customer();
        customer.setId(Integer.parseInt(custid));
        customer.setFirstName(firstname);
        customer.setMiddleName(middlename);
        customer.setLastName(lastname);
        customer.setPhone(homecontact);
        customer.setDateOfBirth(dateofbirth);
        customer.setDateOfJoin(dateofjoin);
        customer.setIsActive(isactive);
        updateCustomerAddress = customerDao.updateCustomer(customer);
        if (updateCustomerAddress > 0) {
            response.sendRedirect("CustomerPages/ViewCustomer.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
