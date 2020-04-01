package mini.projet.DAO;


import java.util.ArrayList;
import java.util.List;
import mini.projet.BO.Categories;
import mini.projet.BO.Products;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductsMetier {

	//// sql database ::
	Transaction tx = null;	
	
	public ProductsMetier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void create(Products c) {
		// TODO Auto-generated method stub
		
		
		try {
			/*PreparedStatement pst =  Connexion.getCon().prepareStatement("insert into Client values(?,?,?);");
			pst.clearParameters();
			pst.setInt(1, c.getMatricule());
			//pst.setString(2, c.getFirstname());
			//pst.setString(3, c.getLastname());
			pst.executeUpdate();*/
                    
                    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
                    tx = session.beginTransaction();
                    session.save(c);
                    tx.commit();
                    
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
                     
		}
		
	}

	public void delete(Products c) {
            
         
		// TODO Auto-generated method stub
		try {
			/*PreparedStatement pst = Connexion.getCon().prepareStatement("delete from Client where matricule = ?");
			pst.clearParameters();
			pst.setInt(1, c.getMatricule());
			pst.executeUpdate();*/
              Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
                    tx = session.beginTransaction();
                    session.delete(c);
                    tx.commit();
                    
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
                       
		}
	}

	public void update(int matr,Products newC) {
		// TODO Auto-generated method stub
            
		try {
                    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
                    tx = session.beginTransaction();
                    session.update(newC);
                    tx.commit();
                    
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public List<Products> retreive() {
		// TODO Auto-generated method stub
		
		List<Products> v = new ArrayList<Products>();
		Object[][] o = null;
		try {
			
			//ResultSet rs = Connexion.getCon().createStatement().executeQuery("Select * from client");
                    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
                    tx = session.beginTransaction();
                    // v = session.createQuery("from Client").list();
                    v = session.createCriteria(Products.class).list();
                    tx.commit();
                        
                    /*   int i = 0;
			while(i< v.size())
			{
				//Client c = new Client(v.get(i).getMatricule(),v.get(i).getFn(),v.get(i).getLn());
				v.add();
				//System.out.println(v);
                                i++;
			}*/
			
		
                    
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
               // System.err.println("table of clients second elem fn: "+v.get(1).getFn());
		return v;
	}

	
	public Categories getCatWithID(int mat) {
		// TODO Auto-generated method stub
		Categories c = null;
		try {
			/*ResultSet rs = Connexion.getCon().createStatement().executeQuery("Select "
					+ "* from client where matricule = "+mat);
			rs.next();
			
			 c = new Client(rs.getInt(1),rs.getString(2),rs.getString(3));*/
                    
                    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
                    tx = session.beginTransaction();
                     c = (Categories) session.get(Categories.class, mat);
                    
                    tx.commit();
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return c;
	}
      public List<Products> retreiveProduct(int categorie) {
		// TODO Auto-generated method stub
		
		List<Products> v = new ArrayList<Products>();
		
		try {
			
			//ResultSet rs = Connexion.getCon().createStatement().executeQuery("Select * from client");
                    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
                    tx = session.beginTransaction();
                    // v = session.createQuery("from Client").list();
                    v = session.createQuery("From Products p where p.categories="+categorie).list();
               //     System.out.println("products of this category are :"+v.get(0).getLabel());
                 //    System.out.println("products of this category are :"+v.get(1).getLabel());
                    tx.commit();  
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
               // System.err.println("table of clients second elem fn: "+v.get(1).getFn());
		return v;
	}
	  public Products retreiveProductFromID(int idprod) {
		// TODO Auto-generated method stub
		
		List<Products> v = new ArrayList<Products>();
		
		try {
			
			//ResultSet rs = Connexion.getCon().createStatement().executeQuery("Select * from client");
                    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
                    tx = session.beginTransaction();
                    // v = session.createQuery("from Client").list();
                    v = session.createQuery("From Products p where p.idProd="+idprod).list() ;
               //     System.out.println("products of this category are :"+v.get(0).getLabel());
                 //    System.out.println("products of this category are :"+v.get(1).getLabel());
                    tx.commit();  
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
               // System.err.println("table of clients second elem fn: "+v.get(1).getFn());
		return v.get(0);
	}
	
}
