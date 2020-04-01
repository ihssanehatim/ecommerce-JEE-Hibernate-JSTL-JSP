package mini.projet.controlleur;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mini.projet.BO.Categories;
import mini.projet.BO.Products;
import mini.projet.DAO.CategoriesMetier;
import mini.projet.DAO.ProductsMetier;


public class DisplayProducts extends HttpServlet {
	
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
		List<Categories> listCat = new CategoriesMetier().retreive();
                List<Products> listProd = new ProductsMetier().retreive();
                 ProductsMetier CategoryOfProduct = new ProductsMetier();
		req.setAttribute("listCategories", listCat );
		req.setAttribute("listProducts", listProd );
                req.setAttribute("Prod",CategoryOfProduct);
		//req.getRequestDispatcher("affichage.jsp").forward(req, resp);
                //System.out.println("|| here ||");
		//System.out.println("|here:"+CategoryOfProduct.getLabel());
		req.getRequestDispatcher("index.jsp").forward(req, resp);
                
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp); 
		String nom,prenom;
		int matr;
		nom = req.getParameter("nom");
		prenom = req.getParameter("prenom");
		matr = Integer.parseInt( req.getParameter("matricule"));
           
	//	System.out.println(res+" heeere!!!");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}