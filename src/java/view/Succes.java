/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.credito;


/**
 *
 * @author Qualqum experience
 */
@WebServlet(name = "Succes", urlPatterns = {"/Succes.view"})
public class Succes extends HttpServlet {

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
        
        credito cred1 = (credito) request.getAttribute("personal");
        
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
              out.println("<a href=\"#\" class=\"brand-logo\">Ready!</a>");
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
              out.println("<h1 style=\"color: #57EF98\">Simulacion de credito</h1>");
              out.println("<h2 style=\"color: blue\"></h2>");
              
              
             double precioPesos =  cred1.getMonto()*27284.16;    
              
              double creditoSinInteres = precioPesos;
              double creditoConInteres = precioPesos;
            
              if(cred1.getCuotas()<=10){
             
              creditoConInteres = creditoConInteres+creditoConInteres*0.30;
              }
              if((cred1.getCuotas()>10) && (cred1.getCuotas()<=20)){
           
              
              creditoConInteres = creditoConInteres+creditoConInteres*0.35;
              }
              if((cred1.getCuotas()>20)){
         
              creditoConInteres = creditoConInteres+creditoConInteres*0.40;
              }
              
              //Hasta aqui aumenta en base a la cantidad de cuotas...
              double valorSegIncendio=0;
              double valorSegDesgravamen=0;
              
              
              if(cred1.isSegIncendio()==true){
                valorSegIncendio =  creditoSinInteres*0.05;
              }
                      
                      
              
              if(cred1.isSegDesgravamen()==true){
                valorSegDesgravamen = creditoSinInteres*0.10;
              }
              
              double totalCredito=0;
              
              totalCredito = valorSegDesgravamen +valorSegIncendio+ creditoConInteres;
              
              
              double interes = 0;
              interes = creditoConInteres - creditoSinInteres;
              
              
              
              
              out.println("<h7>El nombre es: " + cred1.getNombre()+ "</h7><br>");   
              out.println("<h7>El monto es: " + cred1.getMonto()+ " UF</h7><br>");   
              out.println("<h7>La cantidad de cuotas es: " + cred1.getCuotas()+ "</h7><br>");   
              out.println("<h7>---------------------------------------------------------------------------------------------</h7><br>");   
              out.println("<h7>El seguro de Desgravamen es: " + cred1.isSegDesgravamen()+ "</h7><br>");   
              out.println("<h7>El seguro de Desgravamen vale: " + valorSegDesgravamen + "</h7><br>");   
              out.println("<h7>---------------------------------------------------------------------------------------------</h7><br>");   
              out.println("<h7>El seguro de incendio es: " + cred1.isSegIncendio()+ "</h7><br>");   
              out.println("<h7>El seguro de incendio vale: " + valorSegIncendio + "</h7><br>");  
              out.println("<h7>---------------------------------------------------------------------------------------------</h7><br>");   
              out.println("<h7>El monto del credito sin interes es: " + creditoSinInteres + "</h7><br>");   
              out.println("<h7>Interes credito: " + interes+ "</h7><br>"); 
              out.println("<h7>Monto credito con interes: " +creditoConInteres+ "</h7><br>");
              out.println("<h7>Monto credito con interes + Desgravamen + Incendio: " +totalCredito+ "</h7><br>");
              //Mostrar Tabla
               out.println("<table>");
               out.println("<thead>");
               out.println("<tr>");
               out.println("<th>Numero de Cuota</th>");
               out.println("<th>Valor cuota</th>");
               out.println("<th>Interes cuota</th>");
               out.println("<th>Cuota + interes</th>");
               out.println("</tr>");
               out.println("</thead>");
               out.println("<tbody>");
               
               
               //creando ArrayList con valores
               
               //Numero de cuotas de 1 a -?30 valor cuota, interes cuota, cuota + interes
               double valorCuota;
               valorCuota = creditoSinInteres/cred1.getCuotas();
               double interesCuota = 0;
               interesCuota = interes/cred1.getCuotas();
               
               double cuotaIntereses = 0;
               cuotaIntereses= valorCuota+interesCuota;
               
                double o = 0;
               
               int i; 

              
                  for(o=1; o<=cred1.getCuotas(); o++)
                  {    
                      double[] tabla = new double[] {o,valorCuota,interesCuota,cuotaIntereses};
               
                      out.println("<tr>");
                  for(i=0; i<=3; i++){
                      System.out.println(tabla[i]);   
          
              
               out.println("<td>"+tabla[i]+"</td>");
        }  out.println("</tr>");  }
              
               out.println("</tbody>");
               out.println("</table>");
               out.println("<h5>Monto credito con interes + Desgravamen + Incendio: " +totalCredito+ "</h5><br>");
              //fin mostrar en una tabla
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
