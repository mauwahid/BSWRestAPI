/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsw.controller.servlet;

import com.bsw.dao.Dao;
import com.bsw.dao.DaoManager;
import com.bsw.dao.TbBwCustDao;
import com.bsw.domain.TbBwCust;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hansome
 */
public class ResetServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        
        TbBwCustDao dao = DaoManager.getTbBwCustDao();
        String vercode = request.getParameter("vercode")!=null?request.getParameter("vercode"):"";
        System.out.println("vercode "+vercode);
        String username = "";
        if(!vercode.equalsIgnoreCase("")){
            username = dao.getUsernameByPasscode(request.getParameter("vercode"));
        
        }
        
            if(username.equalsIgnoreCase("")){
                try {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Reset Password</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Vercode is not valid</h1>");
                out.println("</body>");
                out.println("</html>");
            } finally {
                out.close();
            }
        }else{
                
            try {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Reset Password</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<form method=\"POST\" action='RecoveryServlet' name=\"frmRec\">\n");
                out.println("<h1>New Password : </h1>");
                out.println("<input type=\"password\" id=\"passNew\" name='passNew' value=\"\"/><br/>");
             //   out.println("<input type=\"passwor2d\" id=\"passNew2\" value=\"\"/>");
                out.println("<input type='hidden' id='username' name='username' value='"+username+"'/>");
                out.println("<input type=\"submit\" value=\"Submit\" />");
                out.println("</body>");
                out.println("</html>");
            } finally {
                out.close();
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
