
import java.util.*;
 import java.text.DateFormat;
 import java.text.SimpleDateFormat;
public class Cache_evento extends Actividade
{
    private int nrPessoas;
    private int tamanho;
    private HashMap<String,Utilizador> convidados;
    private GregorianCalendar dataFim;
    private Coordenada local;
    
    public Cache_evento(){
    super("","",null,0);
    this.local = new Coordenada();
    this.nrPessoas=0;
    this.tamanho=0;
    this.convidados=new HashMap<String,Utilizador>();
    this.dataFim=new GregorianCalendar ();
    }
    
    public Cache_evento(int nrP, int ta,GregorianCalendar d,GregorianCalendar dateF ,String meteorologia,String tipoDeActividade,HashMap<String,Utilizador> convida,int dura,Coordenada k){
    super(tipoDeActividade,meteorologia,d,dura);
      this.local=k;
    this.nrPessoas=nrP;
    this.tamanho=ta;
      
    for(Utilizador u :convida.values()) {
    
    this.convidados.put(u.getEmail(),u.clone());
    }
    
    this.dataFim=new GregorianCalendar ();
    }
    
   
    
     public Cache_evento(Cache_evento u) {
      
         super(u.getTipo(),u.getMeteorologia(),u.getData(),u.getDuracao() );
         this.nrPessoas=u.getNrPessoas();
         this.dataFim=u.getDataFim();
        this.tamanho=u.getTamanho();
       this.convidados=u.getConvidados();
       this.local =u.getLocal();
        
        }
     
        public void  setConvidados(HashMap<String,Utilizador> convida){
        HashMap<String,Utilizador> convi =new HashMap<String,Utilizador>();
        int i=0;
        
        for(Utilizador u :convida.values()){
         convi.put(u.getEmail(),u.clone());
        
        }
        this.convidados=convi;
    
    }
        
    public Coordenada getLocal(){
    return this.local;
    
    } 
    
    public void setLocal(Coordenada k) {
    this.local=k;
    
    }
    
     public int getNrPessoas () {
    return this.nrPessoas;

    }
   
    
    
    public int getTamanho(){
    return this.tamanho;
    }
    
    public void setNrPessoas(int nrP){
    
    this.nrPessoas=nrP;
    }
    
    
    public void setTamanho(int tam) {
    this.tamanho=tam;
    }
    
    
    
    public Cache_evento clone(){
    return new Cache_evento(this);
    
    }
    
    public String toString(){
    
     StringBuilder s = new StringBuilder();
        int mes=this.getData().get(Calendar.MONTH)-1;
        int ano=this.getData().get(Calendar.YEAR);
        int dia =this.getData().get(Calendar.DAY_OF_MONTH);
        GregorianCalendar calz = new GregorianCalendar(ano,mes,dia);
        SimpleDateFormat formated = new SimpleDateFormat("d/MMM/yyyy");
        String dddd = formated.format(calz.getTime());
        int mess=super.getData().get(Calendar.MONTH)-1;
        int anos=super.getData().get(Calendar.YEAR);
        int dias =super.getData().get(Calendar.DAY_OF_MONTH);
        GregorianCalendar cal = new GregorianCalendar(anos,mess,dias);
        SimpleDateFormat formate = new SimpleDateFormat("d/MMM/yyyy");
        String d = formate.format(cal.getTime());
     
     
     s.append ("Local :");
     s.append (this.local.toString()+"\n");
     s.append ("Capacidade :\n");
     s.append (this.tamanho+"\n");
     s.append ("Numero de pessoas\n"); 
     s.append (this.nrPessoas+ "\n");
     s.append ("Meteorologia\n");
     s.append (super.getMeteorologia() + "\n");
     s.append ("Inicio\n");
     s.append (d+"\n");
     s.append ("Fim\n");
     s.append (dddd + "\n");
     return s.toString();
    }
    
   
    
    public HashMap<String,Utilizador> getConvidados(){
    HashMap<String,Utilizador> convi = new HashMap<String,Utilizador>();
     
      for(Utilizador u :this.convidados.values()) {
        convi.put(u.getEmail(),u.clone());
        
        }
     return convi;
    
    }
    
    
    public boolean verficaConvidados(HashMap<String,Utilizador> convi) {
     
        if(this.convidados.size()!=convi.size()) {return false;}
        
        else {
           boolean encontrado=true;
           
           for(Utilizador u :convi.values()) {
            
            if(encontrado) {
            
            encontrado=this.convidados.containsKey(u.getEmail());
            
            }
            else {
            return false;
            
            }
            }
          return encontrado;
        
        }
     
    
    
    }
    
    public boolean equals (Object o) {
     if (this==o)
     return true;
     if((o==null) || this.getClass() !=o.getClass()) {
        return false;
        }
     
        Cache_evento u = (Cache_evento) o ;
        
        return (this.local.equals(u.getLocal()) && super.getDuracao()==u.getDuracao() && this.nrPessoas==u.getNrPessoas() && this.tamanho==u.getTamanho() && verficaConvidados(u.getConvidados())
           && super.getTipo().equals(u.getTipo()) && super.getMeteorologia().equals(u.getMeteorologia()) && super.getData().equals(u.getData()) && this.local.equals(u.getLocal()) && 
           this.dataFim.equals(u.getDataFim()));
     
        
     
       
    } 
  
   
   
   public GregorianCalendar getDataFim() {
       return this.dataFim;
   }
   
   
   public void setFim(GregorianCalendar date) {
       this.dataFim = date;
   }
    
    
}
