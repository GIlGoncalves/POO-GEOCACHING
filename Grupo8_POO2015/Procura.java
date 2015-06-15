
 import java.util.*;
 import java.text.DateFormat;
 import java.text.SimpleDateFormat;
 public class Procura extends Actividade
 {
    private ArrayList<Coordenada> caminho;
    private String tipoDaProcura;


    public Procura(){
    super("","",null,0);
    this.tipoDaProcura="";
    this.caminho = new ArrayList<Coordenada>();
    
   } 
   
   public Procura (GregorianCalendar d,String tipoDaProc,String meteorologia,String tipoDeActividade,ArrayList<Coordenada> cm,int dura) {
    super(tipoDeActividade,meteorologia,d,dura);
    this.tipoDaProcura = tipoDaProc;
    this.caminho = new ArrayList<Coordenada>();
    
    for(Coordenada z :cm) {
    
        this.caminho.add(z.clone());
    
    }
    
    }
   
    public Procura(Procura u){
    super(u.getTipo(),u.getMeteorologia(),u.getData(),u.getDuracao() );
    this.caminho=u.getCaminho();
    this.tipoDaProcura=u.getTipoDaProcura();
    
    }
    
   
  
    
   public String getTipoDaProcura() {
       return this.tipoDaProcura;
   }
    
   
   
   public void setFim(String tipo) {
       this.tipoDaProcura = tipo;
   }
    
   
    
    public ArrayList<Coordenada> getCaminho(){
     ArrayList<Coordenada> coord=new ArrayList<Coordenada>();
     for(Coordenada u: caminho) {
        coord.add(u.clone());
        }
     return coord;
    
    }
     
    public void setCaminho(ArrayList<Coordenada>cam){
        ArrayList<Coordenada> cami=new ArrayList<Coordenada>();
        for(Coordenada u:cam){
        cami.add(u.clone());
        }
     this.caminho=cami;
    
    }
    
 
    public Procura clone(){
    return new Procura(this);
    
    }
    
    public boolean verificaCaminho(ArrayList<Coordenada> cam){
    if(this.caminho.size() != cam.size()) return true;
    
    else {
     boolean encontrado=true;
     int i=0;
     while(i<=cam.size()-1 && encontrado) {
        encontrado=this.caminho.contains(cam.get(i));
        i++;
        }
     return encontrado;
    
    
    }
    
    }
    
    public boolean equals (Object o){
    
        if(this==o) return true;
        if(((o == null) || (this.getClass() != o.getClass()))) {return false;}
        else{
        Procura u =(Procura) o;
        
        return(verificaCaminho(u.getCaminho())  &&  this.tipoDaProcura.equals(u.getTipoDaProcura()) && super.getData().equals(u.getData()) && super.getTipo().equals(u.getTipo())
                && super.getMeteorologia().equals(u.getMeteorologia()) && super.getDuracao()==u.getDuracao()) ;
        
        }
    }
    
    public String imprimeCaminho(){
       StringBuilder s = new StringBuilder();
        
       for(Coordenada u : this.caminho) {
        s.append(u.toString() +"\n");
        
        
        
        }
       return s.toString();
    
    }
     
     public String toString(){
        StringBuilder s = new StringBuilder();
        
        int mess=super.getData().get(Calendar.MONTH)-1;
        int anos=super.getData().get(Calendar.YEAR);
        int dias =super.getData().get(Calendar.DAY_OF_MONTH);
        GregorianCalendar cal = new GregorianCalendar(anos,mess,dias);
        SimpleDateFormat formate = new SimpleDateFormat("d/MMM/yyyy");
        String d = formate.format(cal.getTime());
        
        
        s.append ("Tipo da actividade\n");
        s.append (super.getTipo() + "\n");
        s.append ("Data do inicio da procura\n");
        s.append (d + "\n");
        s.append ("Tipo  da procura\n");
        s.append (this.tipoDaProcura+"\n");
        s.append ("Tempo\n");
        s.append (super.getMeteorologia() + "\n");
        s.append ("Duracao");
        s.append (super.getDuracao() + "\n");
        s.append ("Caminho\n");
        s.append (imprimeCaminho()+"\n");
        return s.toString();
        
        }
    
    
    
      
     
     
 }
    
    

