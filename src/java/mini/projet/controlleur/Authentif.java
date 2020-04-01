/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.projet.controlleur;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mini.projet.BO.Client;
import mini.projet.DAO.ClientMetier;

/**
 *
 * @author ihssane
 */

public class Authentif extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
      //  
        try{
             
           String user = req.getParameter("username");
           String pass = req.getParameter("password");
           
           Client c = new ClientMetier().getClientWithUsername(user);
           
           if(c != null)
           {
               if(c.getUsername().equals("admin") && c.getPassword().equals(pass))
               {
                   req.getSession().setAttribute("username", user);
                   req.getRequestDispatcher("mesCommandesViewAdmin.jsp").forward(req, resp);
               }
               else if(c.getPassword().equals(pass)){
                   req.getSession().setAttribute("username", user);
                   req.getRequestDispatcher("mesCommandesViewClient.jsp").forward(req, resp);
               }
               else
                   req.getRequestDispatcher("account.jsp").forward(req, resp);
           }
           else
                req.getRequestDispatcher("account.jsp").forward(req, resp);
           
            
        }catch(NullPointerException e)
        {
            
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        try{
         if(req.getParameter("id").equals("0")){ 
             System.out.println("yes");
             req.getSession().removeAttribute("username");
         }
        }catch(NullPointerException ee)
        {
            
        }
        
        if(req.getSession().getAttribute("username") == null)
            
            req.getRequestDispatcher("account.jsp").forward(req, resp);
        
        else if(req.getSession().getAttribute("username").equals("admin"))
            
            req.getRequestDispatcher("mesCommandesViewAdmin.jsp").forward(req, resp);
        
        else
            req.getRequestDispatcher("mesCommandesViewClient.jsp").forward(req, resp);
            
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
  
}

