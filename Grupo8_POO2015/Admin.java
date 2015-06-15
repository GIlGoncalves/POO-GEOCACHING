
import java.util.*;
import java.io.*;

public class Admin implements Serializable
{
    private final String email="admin@gmail.com";
    private final String nome= "Admin";
    private final String password= "admin1234";
    private HashMap<String,Cache> criou; //pelo admistrador 
    
    public Admin(){
    
    this.criou=new HashMap<String,Cache>();
    
    }
    
    public Admin(HashMap<String,Cache> cr) {
    
        for(Cache u :cr.values()) {
        
         this.criou.put(u.getNomeCache(),u.clone());
        }
        
    }
     
    public Admin(Admin u ){
    this.criou=u.getCriou();
    
    }
   
     /**
      * Adicioanar cache ao admin
      */
    
     
     public void addCacheAdim(Cache u){
        this.criou.put(u.getNomeCache(),u.clone());
        
        }
    
     
        /**
         * Remover cache
         */
     
     public void removeCacheAd(String nome) {
        
        this.criou.remove(nome);
        }
    
    
     public HashMap<String,Cache> getCriou(){
      HashMap<String,Cache> cr =new HashMap<String,Cache>();
      for(Cache u :this.criou.values()) {
       cr.put(u.getNomeCache(),u.clone());
    
      }
    
      return cr;
    }
    
    
     public void setCriou(HashMap<String,Cache> criada) {
     HashMap<String,Cache> cria=new HashMap<String,Cache>();
        for(Cache u: criada.values()) {
        cria.put(u.getNomeCache(),u.clone());
        
        }
        this.criou=cria;
    
    }
    
    
    public String toString() {
    StringBuilder s = new StringBuilder();
    
    s.append("Nome\n");
    s.append(this.nome+"\n");
    s.append("Email\n");
    s.append(this.email+"\n");

    return s.toString();
    }
    
    
    
}
