/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini.projet.DAO;

import java.util.ArrayList;
import java.util.List;
import mini.projet.BO.Address;
import mini.projet.BO.Commande;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ihssane
 */

public class CommandeMetier {
    
    	//// sql database ::
	Transaction tx = null;	
	

	public CommandeMetier() {
		super();
		// TODO Auto-generated constructor stub
	}

	
            public void create(Commande c) {
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

	
	public void delete(Commande c) {
            
         
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

	public void update(Commande newC) {
		// TODO Auto-generated method stub
            
		try {
			/*PreparedStatement pst = Connexion.getCon().prepareStatement("update client set matricule = ? , fn = ? , ln = ?  where matricule = ?");
			pst.clearParameters();
			pst.setInt(1, newC.getMatricule());
			//pst.setString(2, newC.getFirstname());
			//pst.setString(3, newC.getLastname());
			pst.setInt(4, matr);
			pst.executeUpdate();*/
                    
		  Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
                    tx = session.beginTransaction();
                    session.update(newC);
                    tx.commit();
                    
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
                        System.out.println("here prob commande update");
		}
	}

	
	public List<Commande> retreive() {
		// TODO Auto-generated method stub
		
		List<Commande> v = null;
		
		try {
			
			//ResultSet rs = Connexion.getCon().createStatement().executeQuery("Select * from client");
                    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
                    tx = session.beginTransaction();
                    // v = session.createQuery("from Client").list();
                    v = session.createCriteria(Commande.class).list();
                    tx.commit();
                
		
                    
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
                //System.out.println("table of commandes second elem fn: "+v.get(1).getClient().getFn());
		return v;
	}
/*
	
	public List<Commande> getCommandeWithUsername(String username) {
		// TODO Auto-generated method stub
		List<Commande> c = new ArrayList<Commande>();
		try {
			/*ResultSet rs = Connexion.getCon().createStatement().executeQuery("Select "
					+ "* from client where matricule = "+mat);
			rs.next();
			
			 c = new Client(rs.getInt(1),rs.getString(2),rs.getString(3));
                    
                    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
                    tx = session.beginTransaction();
                    
                    c = session.createQuery("From Commande c where c.client="+username).list();
                    
                    tx.commit();
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
                    System.out.println("here in commande query :( ;");
		}
		return c;
	}*/
         public List<Commande> getCommandeWithAddress(Address addr) {
		// TODO Auto-generated method stub
		List<Commande> c = new ArrayList<Commande>();
		try {
                    
                    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
                    tx = session.beginTransaction();
                     c = session.createQuery("From Commande c where c.address="+addr).list();
                    
                    tx.commit();
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return c;
	}
          public Commande getCommandeWithId(int id) {
		// TODO Auto-generated method stub
		List<Commande> c = new ArrayList<Commande>();
                
		try {
                    
                    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
                    tx = session.beginTransaction();
                    
                     c = session.createQuery("From Commande p where p.idCommade="+id).list();
                    
                    tx.commit();
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return c.get(0);
	}
        /* public static void main(String[] args)
         {
             List<Commande> c = new CommandeMetier().getCommandeWithUsername("hello");
             System.out.println("here :" + c.get(0).getIdCommade());
         }*/
}
