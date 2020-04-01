package mini.projet.DAO;


import java.util.ArrayList;
import java.util.List;
import mini.projet.BO.Address;
import mini.projet.BO.Client;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class addressMetier {

	//// sql database ::
	Transaction tx = null;	
	

	public addressMetier() {
		super();
		// TODO Auto-generated constructor stub
	}

	
            public void create(Address c) {
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

	
	public void delete(Address c) {
            
         
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

	public void update(Address newC) {
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
		}
	}

	
	public List<Address> retreive() {
		// TODO Auto-generated method stub
		
		List<Address> v = new ArrayList<Address>();
		Object[][] o = null;
		try {
			
			//ResultSet rs = Connexion.getCon().createStatement().executeQuery("Select * from client");
                    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
                    tx = session.beginTransaction();
                    // v = session.createQuery("from Client").list();
                    v = session.createCriteria(Address.class).list();
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
          
                System.out.println("table of clients second elem fn: "+v.get(1).getClient().getFn());
		return v;
	}

	
	public List<Address> getAddressWithUsername(String username) {
		// TODO Auto-generated method stub
		List<Address> c = null;
		try {
			/*ResultSet rs = Connexion.getCon().createStatement().executeQuery("Select "
					+ "* from client where matricule = "+mat);
			rs.next();
			
			 c = new Client(rs.getInt(1),rs.getString(2),rs.getString(3));*/
                    
                    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
                    tx = session.beginTransaction();
                     c = session.createQuery("From Address a where a.username="+username).list();
                    
                    tx.commit();
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return c;
	}
        public Address getAddressWithId(int id) {
		// TODO Auto-generated method stub
		Address c = null;
		try {
			/*ResultSet rs = Connexion.getCon().createStatement().executeQuery("Select "
					+ "* from client where matricule = "+mat);
			rs.next();
			
			 c = new Client(rs.getInt(1),rs.getString(2),rs.getString(3));*/
                    
                    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
                    tx = session.beginTransaction();
                     c = (Address) session.get(Address.class, id);
                    tx.commit();
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return c;
	}

}
