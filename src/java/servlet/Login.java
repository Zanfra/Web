/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DB.DBManager;
import DB.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author djinask
 */
public class Login extends HttpServlet {

    private DBManager manager;
    //  Cookie[] cookies = request.getCookies();
    //    Cookie cookie, cookie1, cookie2;
    //  int autenticato = 0;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><link href=\"web/css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("<title>Servlet Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Inserisci i tuoi dati di autenticazione:</h1>");
            out.println("<form action=\"Login\" method=\"post\">");
            out.println("Mail:<input type=\"text\" name=\"mail\">");
            out.println("<br>");
            out.println("Password:<input type=\"password\" name=\"pass\">");
            out.println("<br>");
            out.println("<input type=\"submit\" value=\"Login\">");
            out.println("<br>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }

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
    public void init() throws ServletException {

        this.manager = (DBManager) super.getServletContext().getAttribute("dbmanager");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String mail = request.getParameter("mail");
        String password = request.getParameter("pass");
        PrintWriter out = response.getWriter();

        out.println("<HTML><head><link href=\"./././web/css/bootstrap.min.css\" rel=\"stylesheet\"><title>Wellcome!</title><body><H1>");
        Users user = null;
        try {

            user = manager.authenticate(mail, password);
           
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        if (user == null) {
           // response.sendRedirect("/Login");
                      out.println("<H1>Non trovato<H1>");
  
        } else {
            HttpSession session = request.getSession(true);

            session.setAttribute("user", user);

                      out.println("<H1>Trovato " +user.getName() +"<H1>");
        }

        out.println("</H1></body></HTML>");
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
