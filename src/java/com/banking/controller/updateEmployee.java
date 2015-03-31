package com.banking.controller;

import com.banking.model.Employee;
import com.banking.utils.EmployeeDao;
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
public class updateEmployee extends HttpServlet {

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

        String empid = request.getParameter("empid");
        String firstname = request.getParameter("firstname");
        String middlename = request.getParameter("middlename");
        String lastname = request.getParameter("lastname");
        String homecontact = request.getParameter("homecontact");
        String mobilecontact = request.getParameter("mobilecontact");
        String dateofbirth = request.getParameter("dateofbirth");
        String dateofjoin = request.getParameter("dateofjoin");
        String address = request.getParameter("address");
        String department = request.getParameter("department");
        String post = request.getParameter("post");
        String employeestatus = request.getParameter("employeestatus");
        String checkadmin = request.getParameter("isadmin");
        int isactive = ("active".equals(employeestatus)) ? 1 : 0;
        int isadmin = ("active".equals(checkadmin)) ? 1 : 0;

        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/banking/system/applicationContext.xml");
        EmployeeDao employeeDao = (EmployeeDao) ctx.getBean("employeeDao");

        Employee employee = new Employee();
        employee.setId(Integer.parseInt(empid));
        employee.setFirstname(firstname);
        employee.setMiddlename(middlename);
        employee.setLastname(lastname);
        employee.setHomecontact(homecontact);
        employee.setMobilecontact(mobilecontact);
        employee.setDateofbirth(dateofbirth);
        employee.setDateofjoin(dateofjoin);
        employee.setDepartment(department);
        employee.setPost(post);
        employee.setAddress(address);
        employee.setIsactive(isactive);
        employee.setIsadmin(isadmin);
        int status = employeeDao.updateEmployee(employee);
        if (status > 0) {
            response.sendRedirect("EmployeePages/ViewEmployee.jsp");
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
