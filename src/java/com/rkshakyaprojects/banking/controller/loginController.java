/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rkshakyaprojects.banking.controller;

import com.rkshakyaprojects.banking.model.LoginBean;
import model.DBConnection;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Raunak Shakya
 */
public class loginController extends HttpServlet {

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

        String loginname = request.getParameter("username");
        String loginpass = request.getParameter("password");
        LoginBean bean = new LoginBean();
        bean.setLoginname(loginname);
        bean.setLoginpass(loginpass);
        boolean status = false;
        boolean admincheck;
        int userID;

        try {
            DBConnection dbcon = new DBConnection();
            if (dbcon.connect()) {
                status = bean.validate();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            //JOptionPane.showMessageDialog(null, "Error connecting to database!");
        }

        if (status) {
            userID = bean.getUserID();
            admincheck = bean.isIsadmin();
            HttpSession sess = request.getSession();
            sess.setAttribute("sessUserID", userID);
            sess.setAttribute("sessIsadmin", admincheck);
            if (admincheck == true) {
                RequestDispatcher rd = request.getRequestDispatcher("adminPage.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("empPage.jsp");
                rd.forward(request, response);

            }
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
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
