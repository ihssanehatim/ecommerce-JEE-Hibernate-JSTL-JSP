package mini.projet.BO;
// Generated Mar 29, 2020 10:43:27 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Client generated by hbm2java
 */
public class Client  implements java.io.Serializable {


     private String username;
     private String password;
     private String fn;
     private String ln;
     private Set commandes = new HashSet(0);
     private Set addresses = new HashSet(0);

    public Client() {
    }

	
    public Client(String username, String password, String fn, String ln) {
        this.username = username;
        this.password = password;
        this.fn = fn;
        this.ln = ln;
    }
    public Client(String username, String password, String fn, String ln, Set commandes, Set addresses) {
       this.username = username;
       this.password = password;
       this.fn = fn;
       this.ln = ln;
       this.commandes = commandes;
       this.addresses = addresses;
    }
   
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFn() {
        return this.fn;
    }
    
    public void setFn(String fn) {
        this.fn = fn;
    }
    public String getLn() {
        return this.ln;
    }
    
    public void setLn(String ln) {
        this.ln = ln;
    }
    public Set getCommandes() {
        return this.commandes;
    }
    
    public void setCommandes(Set commandes) {
        this.commandes = commandes;
    }
    public Set getAddresses() {
        return this.addresses;
    }
    
    public void setAddresses(Set addresses) {
        this.addresses = addresses;
    }




}


