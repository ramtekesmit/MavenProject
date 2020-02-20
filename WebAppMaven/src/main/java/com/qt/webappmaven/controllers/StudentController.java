/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.webappmaven.controllers;

import com.qt.webappmaven.beans.TblStudents;
import com.qt.webappmaven.models.Students;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Acer
 */
@WebServlet(name = "StudentController", urlPatterns = {"/StudentController"})
public class StudentController extends HttpServlet {

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
        String action = request.getParameter("action");
        TblStudents beans = new TblStudents();
        String message = null;
        Students model = new Students();
        if (action.equals("insert")) {
            try {
                beans.setName(request.getParameter("stdName"));
                beans.setRollNo(Integer.parseInt(request.getParameter("stdRollNo")));
                beans.setAge(Integer.parseInt(request.getParameter("stdAge")));
                beans.setGender(request.getParameter("stdGender"));
                beans.setDob(request.getParameter("stdDob"));
                beans.setPhone(request.getParameter("stdPhone"));
                beans.setEmail(request.getParameter("stdEmail"));
                beans.setAddress(request.getParameter("stdAddress"));
                message = model.insert(beans);
                response.sendRedirect("Students.jsp?message=" + message);
            } catch (IOException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } else if (action.equals("delete")) {
            beans.setId(Integer.parseInt(request.getParameter("stdId")));
            message = model.delete(beans);
            response.sendRedirect("Students.jsp?message=" + message);
        } else if (action.equals("update")) {
            beans.setId(Integer.parseInt(request.getParameter("stdId")));
            beans.setName(request.getParameter("stdName"));
            beans.setRollNo(Integer.parseInt(request.getParameter("stdRollNo")));
            beans.setAge(Integer.parseInt(request.getParameter("stdAge")));
            beans.setGender(request.getParameter("stdGender"));
            System.out.println("New DOB: "+request.getParameter("newDob"));
            System.out.println("old DOB: "+request.getParameter("oldDob"));
            if (request.getParameter("newDob").equals("") || request.getParameter("newDob").equals("null") || request.getParameter("newDob").equals(null)) {
                beans.setDob(request.getParameter("oldDob"));
            } else {
                beans.setDob(request.getParameter("newDob"));
            }
            beans.setPhone(request.getParameter("stdPhone"));
            beans.setEmail(request.getParameter("stdEmail"));
            beans.setAddress(request.getParameter("stdAddress"));
            message = model.update(beans);
            response.sendRedirect("Students.jsp?message=" + message);
        }

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
