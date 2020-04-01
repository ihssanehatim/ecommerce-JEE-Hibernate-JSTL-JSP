/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.projet.controlleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mini.projet.BO.Products;
import mini.projet.DAO.ProductsMetier;

/**
 *
 * @author ihssane
 */

public class MyCart extends HttpServlet {

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
            doPost(req,resp);
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
    protected void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            
        String s = req.getParameter("qte");
        System.out.println("id = "+ req.getParameter("id"));
         System.out.println("param qte = "+s );
            HttpSession session = req.getSession();
           String nbre =  req.getParameter("nbre");
            String id =  req.getParameter("id");
           System.out.println("nbre = "+ nbre);
           System.out.println("got : "+s);
           session.removeAttribute("product"+nbre);
          HashMap h = (HashMap) session.getAttribute("MAP");
          int quant = (int) session.getAttribute("qte"+nbre);
          double pr = (double) session.getAttribute("price");
         
          
         //Products f = (Products) h.get(new ProductsMetier().retreiveProductFromID(Integer.parseInt(id)));
         
         // System.out.println("this is the product : "+f);
          
           System.out.println("size h =  : "+h.size());
           
          
          
          String act = req.getParameter("act");
        if (act == null) {
    //no button has been selected
            } else if (act.equals("delete")) {
    //delete button was pressed
                /*
                Products a =new ProductsMetier().retreiveProductFromID(Integer.parseInt(id));
                 int v = (int) h.remove(a);
                 
                 pr -= a.getPrice()*quant;
                 session.setAttribute("MAP", h);
                 int i = (int) session.getAttribute("nbreOfProd");
                 i--;
                 session.setAttribute("nbreOfProd",i);
                 session.setAttribute("price",pr);
                 
                 */
                 
            } else if (act.equals("update")) {
                
                
    //update button was pressed
            } else {
    //someone has altered the HTML and sent a different value!
            }
          
         
        }catch(NullPointerException e)
        {
            
        }catch(NumberFormatException ee)
        {
            
        }
        
         req.getRequestDispatcher("cart.jsp").forward(req, response);
    }
}
