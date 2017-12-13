/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verwaltung.view;

import Verwaltung.model.Antrag;
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
@WebServlet(name = "detailAntrag", urlPatterns = {"/detailAntrag"})
public class detailAntrag extends HttpServlet {

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
            Antrag a = controller.instance().getAntrag(id);

            out.println("<tr><td>AntragsNr:</td><td>" + a.getAntragsnummer() + "</td><td></td></tr>");
            out.println("<tr><td>Typ:</td><td>" + a.getTyp() + "</td><td></td></tr>");
            out.println("<tr><td>Thema:</td><td>" + a.getBetreff() + "</td><td></td></tr>");
            out.println("<tr><td>Gestellt am:</td><td>" + a.getGestelltam() + "</td><td></td></tr>");
            out.println("<tr><td>Gestellt von:</td><td>" + a.getName() + "</td><td>"
                    + "<a href=\"./ratsmitglied.jsp?id=" + a.getRatsmitglied().getId() + "&back=" + a.getAntragsnummer() + "\">"
                    + "<i class=\"fa fa-search\"></i>"
                    + "</a></td></tr>"
            );

            out.println("<tr><td>Status:</td><td>" + a.getStatus() + "</td><td></td></tr>");
            out.println("<tr><td>Dokumente:</td><td>" + a.getDetails() + "</td><td></td></tr>");

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
