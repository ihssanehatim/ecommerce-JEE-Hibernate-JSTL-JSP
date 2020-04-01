package mini.projet.BO;
// Generated Mar 29, 2020 10:43:27 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Products generated by hbm2java
 */
public class Products  implements java.io.Serializable {


     private Integer idProd;
     private Categories categories;
     private double price;
     private String label;
     private String description;
     private int quantity;
     private byte[] image;
     private Set commandes = new HashSet(0);

    public Products() {
    }

	
    public Products(Categories categories, double price, String label, int quantity, byte[] image) {
        this.categories = categories;
        this.price = price;
        this.label = label;
        this.quantity = quantity;
        this.image = image;
    }
    public Products(Categories categories, double price, String label, String description, int quantity, byte[] image, Set commandes) {
       this.categories = categories;
       this.price = price;
       this.label = label;
       this.description = description;
       this.quantity = quantity;
       this.image = image;
       this.commandes = commandes;
    }
   
    public Integer getIdProd() {
        return this.idProd;
    }
    
    public void setIdProd(Integer idProd) {
        this.idProd = idProd;
    }
    public Categories getCategories() {
        return this.categories;
    }
    
    public void setCategories(Categories categories) {
        this.categories = categories;
    }
    public double getPrice() {
        return this.price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    public String getLabel() {
        return this.label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public byte[] getImage() {
        return this.image;
    }
    
    public void setImage(byte[] image) {
        this.image = image;
    }
    public Set getCommandes() {
        return this.commandes;
    }
    
    public void setCommandes(Set commandes) {
        this.commandes = commandes;
    }

    @Override
    public String toString() {
        return "Products{" + "idProd=" + idProd + ", categories=" + categories + ", price=" + price + ", label=" + label + ", description=" + description + ", quantity=" + quantity + ", image=" + image + ", commandes=" + commandes + '}';
    }
    /*
     @Override
     public boolean equals(Object o) { 
  
        // If the object is compared with itself then return true   
        Products c = (Products) o;
          
      return (this.idProd == c.idProd);
    }
      @Override
  public int hashCode() 
  {
     return this.idProd;
  }*/
} 


