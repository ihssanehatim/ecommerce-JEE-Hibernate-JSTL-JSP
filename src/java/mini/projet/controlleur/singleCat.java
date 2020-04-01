/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.projet.controlleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mini.projet.BO.Categories;
import mini.projet.BO.Products;
import mini.projet.DAO.CategoriesMetier;
import mini.projet.DAO.ProductsMetier;

/**
 *
 * @author ihssane
 */

public class singleCat extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a s-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
            int categorie= 1;
            
            try{
		 categorie = Integer.parseInt( req.getParameter("id"));
            }catch(NumberFormatException e)
            {
             e.printStackTrace();
            }
		
                List<Products> listProd = new ProductsMetier().retreiveProduct(categorie);
	ProductsMetier CategoryOfProduct = new ProductsMetier();
             String catName=CategoryOfProduct.getCatWithID(categorie).getLabel();
		req.setAttribute("listProducts", listProd );
               req.setAttribute("Prod",CategoryOfProduct);
                req.setAttribute("name",catName);
		req.getRequestDispatcher("store.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp); 
	
	}// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

}