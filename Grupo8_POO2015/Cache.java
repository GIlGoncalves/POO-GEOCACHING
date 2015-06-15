
import java.util.*;
import java.io.*;
public abstract class Cache implements Serializable
{
   private Coordenada local;
   private String tamanho;
   private String tipo;
   private GregorianCalendar dataDaDescobeta;
   private GregorianCalendar dataInserida; 
   private String nomeCache;
   
   private String nomeCriador; //na verdade é o email que irá receber.
   
   public Cache() {
    this.local=new Coordenada();
    this.tamanho="";
    this.tipo="";
    this.dataDaDescobeta=new GregorianCalendar();
    this.dataInserida= new GregorianCalendar();
    this.nomeCache="";
    
    this.nomeCriador="";
    }
   
   public Cache(String nome,String tam,String tp,Coordenada u, GregorianCalendar dateD, GregorianCalendar dateI,String nomeCr){
    this.tamanho=tam;
    this.local=u;
    this.tipo=tp;
    this.dataDaDescobeta=dateD;
    this.dataInserida= dateI;
    this.nomeCache=nome;
    
    this.nomeCriador=nomeCr;
    }
    
    public Cache(Cache u){
    this.local=u.getCoord();
    this.tamanho=u.getTamanho();
    this.tipo=u.getTipo();
    this.dataDaDescobeta=u.getData();
    this.dataInserida=u.getDataInserida();
    this.nomeCache=u.getNomeCache();
   
    this.nomeCriador=u.getNomeCriador();
    }
    
    public String getNomeCriador(){
    return this.nomeCriador;
    }
    
    public void setNomeCriador(String name) {
    this.nomeCriador=name;
    }
    
    
    
    
    public String getNomeCache(){
    return this.nomeCache;
    }
    
    public GregorianCalendar getData(){
    return this.dataDaDescobeta;
    }
    
    public GregorianCalendar getDataInserida(){
    return this.dataInserida;
    }
    
    public Coordenada getCoord(){
    return this.local;
    }
    
    public String getTamanho(){
    return this.tamanho;
    }
    
    public String getTipo(){
    return this.tipo;
    }
    
    public void setNomeCache(String nome){
    this.nomeCache=nome;
    }
    
    public void setData(GregorianCalendar date){
    this.dataDaDescobeta=date;
    }
    
    public void setDataInserida(GregorianCalendar date){
    this.dataInserida=date;
    }
    
    public void setCoord(Coordenada loc)
    {
    this.local=loc;
    }
    public void setTamanho(String tam)
    {
     this.tamanho=tam;
    }
    
    public void setTipo(String tp) {
    this.tipo=tp;
    }
    
   
        public abstract Cache clone();
        public abstract String toString();
        public abstract boolean equals(Object o);
  
   
  
}
