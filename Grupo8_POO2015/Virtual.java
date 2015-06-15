
import java.util.*;
 import java.text.DateFormat;
 import java.text.SimpleDateFormat;
public class Virtual extends Actividade
{
    
    private Coordenada local;
    
    
    public Virtual(){
    super("","",null,0);
    
    this.local=new Coordenada();
    }
    
    public Virtual(String tipo,String meteo,GregorianCalendar date,Coordenada loc,int dur){
    super(tipo,meteo,date,dur);
    this.local=loc;

    }
    
    public Virtual(Virtual u)
    {
    super(u.getTipo(),u.getMeteorologia(),u.getData(),u.getDuracao());
    
    this.local=u.getLocal();
    
    
    }
    
   
    
 
    
    public Coordenada getLocal(){
    return this.local;
    }
    
    public void setLocal(Coordenada u) {
    
    this.local=u;
    }
    
  
    
    public Virtual clone(){
    return new Virtual(this);
    
    }
    
       public boolean equals(Object o) {
    if(this == o) {
            return true;
        }
        
        if((o == null) || (this.getClass() != o.getClass())) {
            return false;
    }
    else{
    
    Virtual u =(Virtual) o;
    return(super.getDuracao()==u.getDuracao() && this.local.equals(u.getLocal()) && super.getTipo().equals(u.getTipo()) && super.getMeteorologia().equals(u.getMeteorologia()) && super.getData().equals(u.getData()));
    
    
   }

  }
  
  public String toString(){
        StringBuilder s = new StringBuilder();
      
        int mess=super.getData().get(Calendar.MONTH)-1;
        int anos=super.getData().get(Calendar.YEAR);
        int dias =super.getData().get(Calendar.DAY_OF_MONTH);
        GregorianCalendar cal = new GregorianCalendar(anos,mess,dias);
        SimpleDateFormat formate = new SimpleDateFormat("d/MMM/yyyy");
        String d = formate.format(cal.getTime());
        
        
        s.append ("Local que foi visitado\n");
        s.append (this.local.toString() +"\n");
        s.append ("Tipo da actividade\n");
        s.append (super.getTipo() + "\n");
        s.append ("Data em que foi visitado\n");
        s.append (d+"\n");
        s.append ("Tempo\n");
        s.append (super.getMeteorologia() + "\n");
        s.append ("Duracao\n");
        s.append (super.getDuracao() + "\n") ;
        return s.toString();
        
        }
  
}
