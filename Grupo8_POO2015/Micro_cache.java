
import java.util.*;
import java.text.DateFormat;
 import java.text.SimpleDateFormat;
public class Micro_cache extends Cache 
{
   
    
    public Micro_cache(){
        
    super(""," "," ",null,null,null,"");   
    
    }
    
    public Micro_cache(String nome,String tam,String tp,Coordenada u,GregorianCalendar dateD, GregorianCalendar dateI,String nameCriador){
    super(nome,tam,tp,u,dateD,dateI,nameCriador);
    
    }
    
    public Micro_cache(Micro_cache u) {
    super(u.getNomeCache(),u.getTamanho(),u.getTipo(),u.getCoord(),u.getData(),u.getDataInserida(),u.getNomeCriador());
    
    }
     
    
    
    
    public Micro_cache clone(){
    return new Micro_cache(this);
    
    }
    
      public boolean equals (Object o) {
    
        if(this==o) return true;
        
        if(((o == null) || (this.getClass() != o.getClass()))) {return false;}
        
        else {
            
        Micro_cache u= (Micro_cache) o;
        return (super.getCoord().equals(u.getCoord()) && super.getTamanho().equals(u.getTamanho()) && super.getTipo().equals(u.getTipo()) && super.getData().equals(u.getData())
                && super.getDataInserida().equals(u.getDataInserida()) && super.getNomeCache().equals(u.getNomeCache())&& 
                super.getNomeCriador().equals(u.getNomeCriador()) );
        
        }
    
    
    }
    
    
     
     public String toString(){
        StringBuilder s = new StringBuilder();
        int mes=super.getData().get(Calendar.MONTH)-1;
        int ano=super.getData().get(Calendar.YEAR);
        int dia =super.getData().get(Calendar.DAY_OF_MONTH);
        GregorianCalendar calz = new GregorianCalendar(ano,mes,dia);
        SimpleDateFormat formated = new SimpleDateFormat("d/MMM/yyyy");
        String dddd = formated.format(calz.getTime());
        int mess=super.getDataInserida().get(Calendar.MONTH)-1;
        int anos=super.getDataInserida().get(Calendar.YEAR);
        int dias =super.getDataInserida().get(Calendar.DAY_OF_MONTH);
        GregorianCalendar cal = new GregorianCalendar(anos,mess,dias);
        SimpleDateFormat formate = new SimpleDateFormat("d/MMM/yyyy");
        String d = formate.format(cal.getTime());
        
        s.append ("Email do criador\n");
        s.append (super.getNomeCriador()+"\n");
        s.append ("Nome\n");
        s.append (super.getNomeCache()+"\n");
        s.append("Localizacao\n");
        s.append (super.getCoord().toString()+"\n");
        s.append ("Tamanho\n");
        s.append (super.getTamanho()+"\n");
        s.append ("Tipo\n");
        s.append (super.getTipo()+"\n");
        s.append ("Data descobeta \n");
        s.append (dddd+"\n");
        s.append ("Data inserida\n");
        s.append (d +"\n");
      
        
        return s.toString();

        }
   
   
  
    
}
