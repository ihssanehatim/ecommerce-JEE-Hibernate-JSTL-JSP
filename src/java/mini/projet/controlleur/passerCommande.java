/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.projet.controlleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mini.projet.BO.Address;
import mini.projet.BO.Client;
import mini.projet.BO.Commande;
import mini.projet.BO.Products;
import mini.projet.DAO.ClientMetier;
import mini.projet.DAO.CommandeMetier;
import mini.projet.DAO.ProductsMetier;
import mini.projet.DAO.addressMetier;
import org.hibernate.HibernateException;

/**
 *
 * @author ihssane
 */
@WebServlet(name = "passerCommande", urlPatterns = {"/passerCommande"})
public class passerCommande extends HttpServlet {

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
        
      // doPost(request,response);
        request.getRequestDispatcher("mesCommandesViewClient.jsp").forward(request,response);
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
       
        //Client user = null;
       // String[] checked= req.getParameterValues("todo");
        
       // HashSet commandes = (HashSet) req.getSession().getAttribute("MAP");
        try{
         /* if(checked[0].equals("createAccount"))
               {
                      user = saveUser(req);
               }
               if(user==null)
               {
                   // saveAddress(req);
               }
               else{
                   
                //   saveAddressUser(user,req);
                   
               }*/
            
            saveAllCommande(req,resp);
           // req.getRequestDispatcher("blank.jsp").forward(req, resp);
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
         
        private Client saveUser(HttpServletRequest req)
        {
              String user;
              String pass;
              String ln;
              String fn;
              
            try{
                 ln = req.getParameter("ln");
                  fn = req.getParameter("fn");
                user = req.getParameter("username");
                pass = req.getParameter("password");
                Client c = new Client(user,pass,fn,ln);
                
                System.out.println("here :"+ln+" "+fn+" "+pass+" "+user);
                return c;
                
            }catch(NullPointerException e)
            {
                e.printStackTrace();
                return null; // error
            }
            
           // return 1;
        }
        
        private Address saveAddress(HttpServletRequest req)
        {
                int house;
                String city;
                String pays;
                String street;
              
            try{
                
                 house = Integer.parseInt( req.getParameter("house"));
                  city = req.getParameter("city");
                pays = req.getParameter("country");
                street = req.getParameter("street");
                
               Address a = new Address(city,pays,street,house);
               
                new addressMetier().create(a);
                
               // System.out.println("here :"+ln+" "+fn+" "+pass+" "+user);
                return a;
                
            }catch(NullPointerException e)
            {
             e.printStackTrace();
                return null; // error   
            }
            
        }
        
        private void saveAllCommande(HttpServletRequest req,HttpServletResponse response) throws ServletException, IOException
        {
           
            
            try{
                 HttpSession session = req.getSession();
            
            int n ;
            int quantity=1;
            int prodId = 0;
            int i = 1;
            int nbreOfProd = (int) session.getAttribute("nbreOfProd");
            
                 while(i <= nbreOfProd){
                           
                       System.out.println("here are the id  : "+ session.getAttribute("product"+i));
                       
                        quantity = (int) session.getAttribute("qte"+i);
                       
                        Products f = new ProductsMetier().retreiveProductFromID((int) session.getAttribute("product"+i));
                        
                       // toPass.put(new ProductsMetier().retreiveProductFromID((int) session.getAttribute("product"+i)) , quantity  );
                        
                        // price +=  quantity*f;
                        System.out.println("quantity ="+quantity);
                        //System.out.println("price g= "+price);
                        System.out.println("price f= "+f);
                        //System.out.println("this is the gotten qte : " + req.getParameter("qte"));
                        
                        /// enregistrer cette commande ;;
                        
                        
                       
                        
                       
                        ClientMetier myuser = new ClientMetier();
                        Client  newC = saveUser(req);
                        Client retreived = (Client) myuser.getClientWithUsername(  newC.getUsername());
                        
                      //  req.setAttribute("username",newC.getUsername());
                        
                      //  List<Commande> cmd = new CommandeMetier().getCommandeWithUsername(newC.getUsername());
                        
                      //  System.out.println("commande ="+ cmd.get(0) );
                        
                       // req.setAttribute("commandes", cmd );
                        
                        if(retreived == null)
                        {
                            myuser.create(saveUser(req));
                            new CommandeMetier().create(new Commande(saveAddress(req),saveUser(req),f,"recent",quantity));
                            session.removeAttribute("MAP");
                            session.removeAttribute("price");
                            session.removeAttribute("nbreOfProd");
                            session.setAttribute("username", newC.getUsername());
                            req.getRequestDispatcher("mesCommandesViewClient.jsp").forward(req,response);
                            
                        }
                        else if( ! retreived.getPassword().equals(newC.getPassword()))
                        {
                            ///erreuur !!
                            req.getRequestDispatcher("blank.jsp").forward(req,response);
                            
                        }
                        else{
                            
                            new CommandeMetier().create(new Commande(saveAddress(req),saveUser(req),f,"recent",quantity));
                             session.removeAttribute("MAP");
                            session.removeAttribute("price");
                            session.removeAttribute("nbreOfProd");
                            session.setAttribute("username", newC.getUsername());
                            req.getRequestDispatcher("mesCommandesViewClient.jsp").forward(req,response);
                           
                        }
                        
                    
                        
                       i++;
                    }
                 
                
            }catch(NullPointerException e)
            {
                
            }catch(HibernateException ee)
            {
                
            }
            
        }
     
           private int saveAddressUser(HttpServletRequest req , Client user,Set commandes)
        {
                int house;
                String city;
                String pays;
                String street;
              
            try{
                
                 house = Integer.parseInt( req.getParameter("house"));
                  city = req.getParameter("city");
                pays = req.getParameter("country");
                street = req.getParameter("street");
                
                new addressMetier().create(new Address(user,city,pays,street,house,commandes));
                
               // System.out.println("here :"+ln+" "+fn+" "+pass+" "+user);
                return 0;
                
            }catch(NullPointerException e)
            {
             e.printStackTrace();
                return 1; // error   
            }
            
        }
    
    
}
