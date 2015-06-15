
import java.util.*;
 import java.text.DateFormat;
 import java.text.SimpleDateFormat;
public class Esconder extends Actividade
{
  
  
  private Coordenada local;
  private String tipoCache; //Tipo de cache que foi escondido
  private String tamanho; 
  
  // a data que foi escondida já lhe passado em cima
  
  public Esconder (){
    super("","",null,0);
    
    this.local=new Coordenada();
    this.tipoCache="";
    this.tamanho="";
    
    }
  
    public Esconder (int dur,Coordenada loc,String tipoCaches,String tam,GregorianCalendar date,String tipo,String meteo) {
        super(tipo,meteo,date,dur);
        
        this.local=loc;
        this.tipoCache=tipoCaches;
        this.tamanho=tam;
        
    }
   
    
    public Esconder(Esconder u){
    super(u.getTipo(),u.getMeteorologia(),u.getData(),u.getDuracao());
    
    this.tipoCache=u.getTipoCache();
    this.tamanho=u.getTamanho();
    this.local=u.getLocal();
    } 
     
    public String getTamanho(){
    return this.tamanho;
    }
    
    public String getTipoCache(){
    
     return this.tipoCache;
    
    }
    
    public void setTipoCache(String tipoCaches) {
    
    this.tipoCache=tipoCaches;
    }
    
    
   public void setTamanho(String tam)
    {
     this.tamanho=tam;
    }
    
   
   
 
    
    
  
    public Coordenada getLocal(){
    return this.local;
    }
    
    public void setLocal(Coordenada u) {
    
    this.local=u;
    }
   
    public Esconder clone(){
    return new Esconder(this);
    
    }
  
    public boolean equals(Object o) {
    if(this == o) {
            return true;
        }
        
        if((o == null) || (this.getClass() != o.getClass())) {
            return false;
    }
    
    else{
    
    Esconder u =(Esconder) o;
     return ( this.local.equals(u.getLocal()) && super.getDuracao()==u.getDuracao() && this.tipoCache.equals(u.getTipoCache()) && this.tamanho.equals(u.getTamanho())
           && super.getTipo().equals(u.getTipo()) && super.getMeteorologia().equals(u.getMeteorologia()) && super.getData().equals(u.getData())); 
    
    
    }
   }
   
   
     public String toString(){
        int mess=super.getData().get(Calendar.MONTH)-1;
        int anos=super.getData().get(Calendar.YEAR);
        int dias =super.getData().get(Calendar.DAY_OF_MONTH);
        GregorianCalendar cal = new GregorianCalendar(anos,mess,dias);
        SimpleDateFormat formate = new SimpleDateFormat("d/MMM/yyyy");
        String d = formate.format(cal.getTime());
         
        StringBuilder s = new StringBuilder();
        s.append ("Local que foi escondido");
        s.append (this.local.toString() + "\n");
        s.append ("Tipo de cache que foi escondido");
        s.append (this.tipoCache + "\n");
        s.append ("Tipo da actividade");
        s.append (super.getTipo());
        s.append ("Data quando foi escondida\n");
        s.append (d + "\n");
        s.append ("Tempo\n");
        s.append (super.getMeteorologia() + "\n");
        s.append ("Duracao \n");
        s.append (super.getDuracao() +"\n");
        return s.toString();
        
        }
   
   
   
    
}
