/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verwaltung.view;

import Verwaltung.model.Ratsmitglied;
import Verwaltung.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 89388
 */
@WebServlet(name = "detailRatsmitglied", urlPatterns = {"/detailRatsmitglied"})
public class detailRatsmitglied extends HttpServlet {

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

        try (PrintWriter out = response.getWriter()) {

            int id = Integer.parseInt(request.getParameter("id"));
            Ratsmitglied rm = controller.instance().getRatsmitglied(id);

            out.println("<tr><td>Vorname:</td><td>" + rm.getVname() + "</td></tr>");
            out.println("<tr><td>Nachname:</td><td>" + rm.getNname() + "</td></tr>");
            out.println("<tr><td>Geburtstag:</td><td>" + rm.getGeburtstag()+ "</td></tr>");
            
            out.println("<tr><td>Ort:</td><td>" + rm.getBezirk()+ "</td></tr>");
            out.println("<tr><td>Telefon:</td><td>" + rm.getTelefon() + "</td></tr>");
            out.println("<tr><td>Addresse:</td><td>" + rm.getAdresse() + " " + rm.getHausnr() + "</td></tr>");
            
            out.println("<tr><td>Wahlperiode:</td><td>" + rm.getWahlperiode() + "</td></tr>");
            out.println("<tr><td>Fraktion:</td><td>" + rm.getFraktion() + "</td></tr>");
            out.println("<tr><td>Stadtratsarbeit:</td><td>" + rm.getStadtratsarbeit() + "</td></tr>");
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
