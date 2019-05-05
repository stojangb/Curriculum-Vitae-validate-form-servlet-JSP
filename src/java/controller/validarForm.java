/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import model.credito;

/**
 *
 * @author Qualqum experience
 */
@WebServlet(name = "validarCV", urlPatterns = {"/validarcv.do"})

public class validarForm extends HttpServlet {

    // Inicio funcion para comprobar si una cadena esta vacia
//    public static boolean verificarCadenaVacia(String cadena) {
//        boolean vacia = false;
//        if (cadena.toLowerCase().trim().length() == 0) {
//            vacia = true;
//        }
//        return vacia;
//    }
    // Fin funcion para comprobar si una cadena esta vacia
    // Inicio funcion para comprobar si una cadena contiene numeros.
//Ver si un String contiene un numero
    public static boolean verificarNumeros(String numOlet) {
        boolean num = false;
        if ((numOlet.contains("0") || numOlet.contains("1") || numOlet.contains("2")) || numOlet.contains("3") || numOlet.contains("4") || numOlet.contains("5") || numOlet.contains("6") || numOlet.contains("7") || numOlet.contains("8") || numOlet.contains("9") || numOlet.contains("+")) {
            System.out.println("tiene numeros");
            num = true;
        }
        return num;

    }

    // Fin funcion para comprobar si una cadena contiene numeros.
    //Inicio funcion para verificar rut
    public static boolean validarRut(String rut) {

        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }

    //Fin funcion para verificar rut
    //Inicio Validacion de Fecha
    public static boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    //Fin Validacion de Fecha

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Curriculum</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Curriculum Vitae Creado con errores!</h1>");
            //   out.println("<h1>Curriculum Vitae nombre:"+request.getParameter("nombres")+" </h1>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
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
        List errorMsgs = new ArrayList();
        try {
            String nombres = request.getParameter("nombres");

            String montoNumString = request.getParameter("monto");

            String seguroDesgravamen = request.getParameter("seguroDesgravamen");
            String seguroIncendio = request.getParameter("seguroIncendio");
            String cuotaAnios = request.getParameter("cuotaanios");

            double montoDouble = Integer.parseInt(montoNumString);
            int cuotaAniosNum = Integer.parseInt(cuotaAnios);
            

            boolean seguroIncendioBoolean = true;
            boolean seguroDesgravamenBoolean = true;
            
            
            if ((nombres == null) || (nombres.trim().length() == 0)) {
                errorMsgs.add("Favor Ingresar nombre");
            }

            if ((montoNumString == null) || (montoNumString.trim().length() == 0)) {
                errorMsgs.add("Favor Ingresar monto");
            }

            

            


            if (verificarNumeros(nombres) == true) {
                errorMsgs.add("El nombre contiene numeros");
            }

            if (montoDouble <= 0 == true) {
                errorMsgs.add("Ingrese un monto válido, superior a 0");
            }

            if (seguroDesgravamen.equals("si") == true) {
                seguroDesgravamenBoolean = true;

            } else {

                seguroDesgravamenBoolean = false;
            }

            if (seguroIncendio.equals("si") == true) {
                seguroIncendioBoolean = true;

            } else {

                seguroIncendioBoolean = false;
            }

            if ((seguroDesgravamen.equals("si") == true) || (seguroDesgravamen.equals("no") == true)) {

            } else {
                errorMsgs.add("Ingrese una opción en seguro de desgravamen");
            }

            if ((seguroIncendio.equals("si") == true) || (seguroIncendio.equals("no") == true)) {

            } else {
                errorMsgs.add("Ingrese una opción en seguro de incendio");
            }

            if ((cuotaAniosNum > 0 == true) && (cuotaAniosNum < 31 == true)) {

            } else {
                errorMsgs.add("Ingrese un numero de cuotas");
            }

            if (!errorMsgs.isEmpty()) {
                request.setAttribute("errorMsgs", errorMsgs);
                RequestDispatcher view = request.getRequestDispatcher("/Error.view");
                view.forward(request, response);
                return;
            }

            //Constructor... Al final.. se rellena ..... ,PrimerApellido,SegundoApellido,Rut,numeroDeTelefono,Direccion,Ciudad,Pais,FechaDeNacimiento,Genero,EstadoCivil
            //Capa Negocio
            credito cred2 = new credito(nombres, montoDouble, cuotaAniosNum, seguroDesgravamenBoolean, seguroIncendioBoolean);

            request.setAttribute("personal", cred2); //Cambiar en success
            RequestDispatcher view = request.getRequestDispatcher("/Succes.view");
            view.forward(request, response);

        } catch (RuntimeException e) {
            errorMsgs.add("Error tiempo de ejecución" + e.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/error.view");
            view.forward(request, response);
        }

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
