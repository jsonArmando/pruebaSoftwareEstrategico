/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.persona;
import modeloDao.personaDao;

/**
 *
 * @author json
 */
public class controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String listar = "vistas/listar.jsp";
    String add = "vistas/add.jsp";
    String editar = "vistas/editar.jsp";
    persona p = new persona();
    personaDao dao = new personaDao();
    int consecutivo;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controlador at " + request.getContextPath() + "</h1>");
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
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("Agregar")) {

            String nombre=request.getParameter("txtNombre");
            String apellido= request.getParameter("txtApellido");
            String telefono=request.getParameter("txtTelefono");
            String tipoIdentificacion = request.getParameter("txtTipoIdentificacion");
            String identificacion = request.getParameter("txtIdentificacion");
            String fechaNacimiento=request.getParameter("txtFechaNacimiento");
            p.setNombre(nombre);
            p.setApellido(apellido);
            p.setTelefono(telefono);
            p.setTipoIdentificacion(tipoIdentificacion);
            p.setIdentificacion(identificacion);
            p.setFechaNacimiento(fechaNacimiento);  
            dao.add(p);
            acceso=listar;
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idper",request.getParameter("id"));
            acceso=editar;
        }else if(action.equalsIgnoreCase("Actualizar")){
            consecutivo=Integer.parseInt(request.getParameter("txtid"));
            String nombre=request.getParameter("txtNombre");
            String apellido= request.getParameter("txtApellido");
            String telefono=request.getParameter("txtTelefono");
            String tipoIdentificacion = request.getParameter("txtTipoIdentificacion");
            String identificacion = request.getParameter("txtIdentificacion");
            String fechaNacimiento=request.getParameter("txtFechaNacimiento");
            p.setId(consecutivo);
            p.setNombre(nombre);
            p.setApellido(apellido);
            p.setTelefono(telefono);
            p.setTipoIdentificacion(tipoIdentificacion);
            p.setIdentificacion(identificacion);
            p.setFechaNacimiento(fechaNacimiento);  
            dao.edit(p);
            acceso=listar;
        }else if(action.equalsIgnoreCase("eliminar")){
            consecutivo=Integer.parseInt(request.getParameter("id"));
            p.setId(consecutivo);
            dao.eliminar(consecutivo);
            acceso = listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
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
