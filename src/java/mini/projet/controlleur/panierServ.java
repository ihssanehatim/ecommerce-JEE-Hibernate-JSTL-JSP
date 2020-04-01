package mini.projet.controlleur;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mini.projet.BO.Address;
import mini.projet.BO.Categories;
import mini.projet.BO.Client;
import mini.projet.BO.Commande;
import mini.projet.BO.Products;
import mini.projet.DAO.CategoriesMetier;
import mini.projet.DAO.ClientMetier;
import mini.projet.DAO.ProductsMetier;
import mini.projet.DAO.addressMetier;


public class panierServ extends HttpServlet {
	private static int nbreOfProd = 0;
         private int qte =0;
        // static List<Products> p = new ArrayList<Products>();
	/**
	 * Servlet pour le controleur ;;
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
           
        
                   // req.getRequestDispatcher("checkout.jsp").forward(req, resp);
                    //  This Code is done in JSP
                    // emun= session.getAttributeNames();
           
                
                        doPost(req,resp);
            
			//req.getRequestDispatcher("checkout.jsp").forward(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp); 
		/*String nom,prenom;
		int matr;
		nom = req.getParameter("nom");
		prenom = req.getParameter("prenom");
		matr = Integer.parseInt( req.getParameter("matricule"));*/
           
	//	System.out.println(res+" heeere!!!");
            Client user = null;
            HttpSession session = req.getSession();
            double price = 0.0;
            int n ;
            int quantity=1;
            int prodId = 0;
            
          
            /// getting qte;   
            try{
                  
            qte = Integer.parseInt( req.getParameter("qte"));
         
           // String[] checked= req.getParameterValues("todo");
            
            System.out.println("this is the gotten qte : " + qte);
                
		prodId = Integer.parseInt( req.getParameter("id"));
                
              
                /// put in the session the id of product sent in param
                                       
                    nbreOfProd++;
                     session.setAttribute("qte" + nbreOfProd , qte );    /// chaque produit avec quantity
                     session.setAttribute("product" + nbreOfProd ,prodId);
                    session.setAttribute("nbreOfProd", nbreOfProd);
               //  n = nbreOfProd;
            System.out.println("n = "+nbreOfProd);
            int i=1;
              Map toPass = new HashMap();
            
                       while(i <= nbreOfProd){
                           
                       System.out.println("here are the id  : "+ session.getAttribute("product"+i));
                       
                        quantity = (int) session.getAttribute("qte"+i);
                       
                        double f = new ProductsMetier().retreiveProductFromID((int) session.getAttribute("product"+i)).getPrice();
                        
                        toPass.put(new ProductsMetier().retreiveProductFromID((int) session.getAttribute("product"+i)) , quantity  );
                        
                        price +=  quantity*f;
                        System.out.println("quantity ="+quantity);
                        System.out.println("price g= "+price);
                        System.out.println("price f= "+f);
                        //System.out.println("this is the gotten qte : " + req.getParameter("qte"));
                       i++;
                    }
            System.out.println("price = "+price);
            
            req.setAttribute("price", price);
            session.setAttribute("price", price);
            req.setAttribute("MAP", toPass);
            session.setAttribute("MAP", toPass);
            
             System.out.println("map = "+toPass.size());
            
            }catch(NumberFormatException e2)
            {
            // e2.printStackTrace();
             
            }catch(NullPointerException r)
            {
                
            }
             /*********************** PRICE : **********************/   
            //req.setAttribute("qte", qte);
           
            
            /*********************** END PRICE : **********************/    
            /** save billing address :
               
               if(checked[0].equals("createAccount"))
               {
                      user = saveUser(req);
               }
               if(user==null)
               {
                    saveAddress(req);
               }
               else{
                   
                   saveAddressUser(req,user,commandes);
               }
         **/
			req.getRequestDispatcher("checkout.jsp").forward(req, resp);

	}
           
}
