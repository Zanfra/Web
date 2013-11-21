/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DB.DBManager;
import java.sql.Statement;
import java.util.logging.Logger;
import javax.xml.registry.infomodel.User;

public class Login extends HttpServlet {

    private DBManager manager;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * protected void processRequest(HttpServletRequest request,
     * HttpServletResponse response) throws ServletException, IOException,
     * SQLException { response.setContentType("text/html;charset=UTF-8");
     *
     * Cookie[] cookies = request.getCookies(); Cookie cookie, cookie1, cookie2;
     * int autenticato = 0;
     *
     * if (cookies != null) { for (int i = 0; i < cookies.length; i++) { cookie
     * = cookies[i]; if (cookie.getName().equals("UTENTE")) { autenticato = 1;
     *
     * }
     * }
     * }
     *
     * if (autenticato == 0 && request.getParameter("username").equals("") ||
     * request.getParameter("password").equals("")) {
     * response.setContentType("text/html"); PrintWriter out =
     * response.getWriter();
     * out.println("<HTML><head><title>prova</title><body><H1>Completa i
     * campi</h1></body></HTML>"); } else if (autenticato == 0 &&
     * request.getParameter("username") != null) { String username =
     * request.getParameter("username"); String password =
     * request.getParameter("password"); //settare i cookie
     *
     * response.setContentType("text/html"); PrintWriter out =
     * response.getWriter();
            out.println("
     * <HTML><head><title>prova</title><body><H1>SONO DENTRO e ho inserito il
     * nome " + username + "</h1>"); // DBManager Manager = new
     * DBManager("sql3.freemysqlhosting.net"); if(Manager.authenticate(username,
     * password)){ out.println("connesso");} else{ out.println("non connesso");}
     * out.println("</body></HTML>"); }
     *
     * if (autenticato == 1) { String title = "active cookies";
     * out.println("autenticato"); } response.setContentType("text/html");
     * PrintWriter out = response.getWriter(); System.out.println("autenticato="
     * + autenticato); // out.println(uscita); out.close();
     *
     * // try (PrintWriter out = response.getWriter()) { // /* TODO output your
     * page here. You may use following sample code.
     */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Utente</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Utente at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }

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
    public void init() throws ServletException {
        this.manager = (DBManager) super.getServletContext().getAttribute("dbmanager");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>prova</h1>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
/**
        Cookie[] cookies = request.getCookies();
        Cookie cookie, cookie1, cookie2;
        int autenticato = 0;

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if (cookie.getName().equals("USERS")) {
                    autenticato = 1;

                }
            }
        }

        if (autenticato == 0 && request.getParameter("username").equals("") || request.getParameter("password").equals("")) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<HTML><head><title>prova</title><body><H1>Completa i campi</h1></body></HTML>");
        } else if (autenticato == 0 && request.getParameter("username") != null) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            //settare i cookie

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<HTML><head><title>prova</title><body><H1>SONO DENTRO2 e ho inserito il nome " + username + "</h1>");
            try {
                // DBManager Manager = new DBManager("sql3.freemysqlhosting.net");
                if (manager.authenticate("Prova")) {
                    out.println("connesso");
                } else {
                    out.println("non connesso");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("</body></HTML>");

        }

        if (autenticato == 1) {
            String title = "active cookies";
            out.println("autenticato");
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        System.out.println("autenticato=" + autenticato);
//        out.println(uscita);
        out.close();
        * 
        **/
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
