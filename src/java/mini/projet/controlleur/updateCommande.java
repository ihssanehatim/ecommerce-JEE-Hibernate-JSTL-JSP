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
import mini.projet.BO.Commande;
import mini.projet.DAO.CommandeMetier;

/**
 *
 * @author ihssane
 */
@WebServlet(name = "update", urlPatterns = {"/update"})
public class updateCommande extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            
           int idC = Integer.parseInt(req.getParameter("id"));
           
           Commande ToUpdate = new CommandeMetier().getCommandeWithId(idC); // to get all the fields except 'etat'
           
           System.out.println("etat 9dim :"+ToUpdate.getEtat());
           
         
           
           String newState = req.getParameter("etat");
           /// Address address, Products products, String etat, int qte
           
           System.out.println("etat jdid :"+newState);
           
             ToUpdate.setEtat(newState);
           
           new CommandeMetier().update(ToUpdate);
           
           req.getRequestDispatcher("mesCommandesViewAdmin.jsp").forward(req, response);
            
        }catch(NullPointerException e)
        {
            
        }catch(NumberFormatException ee)
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("mesCommandesViewAdmin.jsp").forward(request, response);
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
