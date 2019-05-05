/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Qualqum experience
 */
@WebServlet(name = "Error", urlPatterns = {"/Error.view"})
public class Error extends HttpServlet {

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

        List errorMsgs = (List) request.getAttribute("errorMsgs");

        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<!--Import Google Icon Font-->");
            out.println("<link href=\"http://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">");
            out.println("<!--Import materialize.css-->");
            out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"css/materialize.min.css\"");
            out.println("media=\"screen,projection\"/>");
            out.println("<!--Let browser know website is optimized for mobile-->");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>");
            out.println("<nav>");
            out.println("<div class=\"nav-wrapper\">");
            out.println("<a href=\"#\" class=\"brand-logo\">Error!</a>");
            out.println("<ul id=\"nav-mobile\" class=\"right hide-on-med-and-down\">");
            out.println("<li><a href=\"sass.html\"></a></li>");
            out.println("<li><a href=\"badges.html\"></a></li>");
            out.println("<li><a href=\"collapsible.html\">Stojan Gasic</a></li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("</nav>");
            out.println("</head>");
            out.println("<body>");
            out.println("  <!-- Contenido-->");
            out.println("<div class=\"container\">");
            out.println("<h1 style=\"color: red\">Favor solucionar los siguientes problemas</h1>");

            out.println("<ul>");
            Iterator items = errorMsgs.iterator();
            while (items.hasNext()) {
                String message = (String) items.next();
                out.println("  <li>" + message + "</li>");
            }
            out.println("</ul>");

            out.println("</div>");
            out.println("<script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-2.1.1.min.js\"></script>");
            out.println("<script type=\"text/javascript\" src=\"js/materialize.min.js\"></script>");
            out.println("</body>");
            out.println("</html>");

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
