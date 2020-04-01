package mini.projet.DAO;


import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import mini.projet.BO.Client;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientMetier {

	//// sql database ::
        private int res = 0;
	Transaction tx = null;	
	

	public ClientMetier() {
		super();
		// TODO Auto-generated constructor stub
                res = 0;
		
	}

	
	public void create(Client c) {
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
                    res = 0;
                    
		} 
                catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
                        res = 1;
		}
		
	}
        public int getRes()
        {
            return res;
        }
	
	public void delete(Client c) {
            
         
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

	public void update(int matr,Client newC) {
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

	
	public List<Client> retreive() {
		// TODO Auto-generated method stub
		
		List<Client> v = new ArrayList<Client>();
		Object[][] o = null;
		try {
			
			//ResultSet rs = Connexion.getCon().createStatement().executeQuery("Select * from client");
                    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
                    tx = session.beginTransaction();
                    // v = session.createQuery("from Client").list();
                    v = session.createCriteria(Client.class).list();
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
          
                System.err.println("table of clients second elem fn: "+v.get(1).getFn());
		return v;
	}

	
	public Client getClientWithUsernamePass(String username,String pass) {
		// TODO Auto-generated method stub
		List <Client> c = null;
		try {
			/*ResultSet rs = Connexion.getCon().createStatement().executeQuery("Select "
					+ "* from client where matricule = "+mat);
			rs.next();
			
			 c = new Client(rs.getInt(1),rs.getString(2),rs.getString(3));*/
                    
                    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
                    tx = session.beginTransaction();
                    
                   
                    c = (List <Client>) session.createSQLQuery("select username from Client where username= '" + username+"' and password= '"+pass+"'").list();
                  //  System.out.println("this is the client : " + c.getUsername());
                    tx.commit();

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}catch(NullPointerException ee)
                {
                    
                }catch(IndexOutOfBoundsException eee)
                {
                    
                }
		return (Client) c.get(0);
	}
        public Client getClientWithUsername(String username) {
		// TODO Auto-generated method stub
		Client c = null;
		try {
			/*ResultSet rs = Connexion.getCon().createStatement().executeQuery("Select "
					+ "* from client where matricule = "+mat);
			rs.next();
			
			 c = new Client(rs.getInt(1),rs.getString(2),rs.getString(3));*/
                    
                    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
                    tx = session.beginTransaction();
                     
                     c = (Client) session.get(Client.class,username);
                    
                    tx.commit();
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}catch(NullPointerException ee)
                {
                    
                }
		return c;
	}

}
