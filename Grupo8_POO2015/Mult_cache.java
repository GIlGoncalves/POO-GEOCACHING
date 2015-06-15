
 import java.util.*;
 import java.text.DateFormat;
 import java.text.SimpleDateFormat;
public class Mult_cache extends Cache 
{
    private ArrayList<Coordenada> locais; //tem as coordenas das caches menos da ultima;
    
    
    public Mult_cache() {
        super(""," "," ",null,null,null,""); 
        ArrayList<Coordenada> coordenada=new ArrayList<Coordenada>();
    
    }
    
    public Mult_cache(String nome,String tam,String tp,Coordenada u,GregorianCalendar dateD, GregorianCalendar dateI,ArrayList<Coordenada> loc,String name) {
        super(nome,tam,tp,u,dateD,dateI,name);
        this.locais=new ArrayList<Coordenada>();
        for(Coordenada z : loc) {
        this.locais.add(z.clone());
        
        }
    
    }
    
    
    public Mult_cache(Mult_cache u) {
        super(u.getNomeCache(),u.getTamanho(),u.getTipo(),u.getCoord(),u.getData(),u.getDataInserida(),u.getNomeCriador());
        this.locais=u.getLocal();
    
    
    }
    
    public ArrayList<Coordenada> getLocal(){
    ArrayList<Coordenada> loc=new ArrayList<Coordenada>();
    
    for(Coordenada u:locais) {
    
    loc.add(u.clone());
    }
    return loc;
    }
    
    public void setCache(ArrayList <Coordenada> loc) {
     ArrayList<Coordenada> loca=new ArrayList<Coordenada>();
     for(Coordenada u:loc) {
        loc.add(u.clone());
        }
     this.locais=loc;
    }
    
    
    public Mult_cache clone(){
    
    return new Mult_cache(this);
    }
    
    public boolean verificaLocais(ArrayList<Coordenada> local)
    {
        boolean encontrado =true;
           if(this.locais.size()!= local.size()) return false;
    else{
            
            for(Coordenada t:local) {
            
                if(encontrado) {
             encontrado=this.locais.contains(t);
            
            }
            else return false;
            }
            
            }
    return true;
    }
    
    public boolean equals(Object o) {
      if(this==o) return true;
      if(((o == null) || (this.getClass() != o.getClass()))) {return false;}
       else {
           Mult_cache u =(Mult_cache) o;
          
            
            
           return(verificaLocais(u.getLocal()) && super.getCoord().equals(u.getCoord()) && super.getTamanho().equals(u.getTamanho()) && super.getTipo().equals(u.getTipo()) && 
           super.getData().equals(u.getData()) && super.getDataInserida().equals(u.getDataInserida()) && super.getNomeCache().equals(u.getNomeCache()) && 
           super.getNomeCriador().equals(u.getNomeCriador()));
            
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
        s.append ("Nome:       ");
        s.append (super.getNomeCache()+"\n");
        s.append ("Tamanho\n");
        s.append (super.getTamanho()+"\n");
        s.append ("Tipo\n");
        s.append (super.getTipo()+"\n");
        s.append ("Data descobeta \n");
        s.append (dddd+"\n");
        s.append ("Data inserida\n");
        s.append (d +"\n");
        s.append("Localizacao da cache final\n");
        s.append (super.getCoord()+"\n");
        for(Coordenada u : this.locais) {
         s.append("Localizacao\n");
        s.append (u.toString()+"\n");
        }
        
        return s.toString();

        }
      
      
    } 