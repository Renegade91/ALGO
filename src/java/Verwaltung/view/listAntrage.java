/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verwaltung.view;

import Verwaltung.controller;
import Verwaltung.model.Antrag;
import java.util.List;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 89388
 */
@WebServlet(name = "listAntrage", urlPatterns = {"/listAntrage"})
public class listAntrage extends HttpServlet {

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

            // gen Header
            out.println(
                    "<tr>"
                    + "<th>Typ</th>"
                    + "<th>Thema</th>"
                    + "<th>Gestellt am</th>"
                    + "<th>Gestellt von</th>"
                    + "<th>Status</th>"
                    + "<th>Details</th>"
                    + "</tr>"
            );

            ArrayList<Antrag> Antrage = controller.instance().getAntragAlle();

            for (Antrag a : Antrage) {

                out.println("<tr>");
                
                out.println("<td>" + a.getTyp()+ "</td>");
                out.println("<td>" + a.getBetreff() + "</td>");
                out.println("<td>" + a.getGestelltam() + "</td>");
                out.println("<td>" + a.getName() + "</td>");

                out.println("<td>" + a.getStatus() + "</td>");

                out.println("<td>");
                out.println("<a href=\"./antragDetail.jsp?id=" + a.getAntragsnummer() + "\">");
                out.println("<i class=\"fa fa-search\"></i>");
                out.println("</a>");
                out.println("</td>");

                out.println("</tr>");
            }
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
