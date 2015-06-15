
/**
 * Abstract class Actividade - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
import java.util.*;
import java.io.*;
public abstract class Actividade implements Serializable
{

   
    private String tipo; //tipo da actividade, que pode ser procura, esconder uma cahce, dar um passeio, ou ir a um evento;
    private String meteorologia;
    private GregorianCalendar data;
    private int duracao; //em minutos
     
    public Actividade(){
    this.tipo="";
    this.meteorologia="";
    this.data=new GregorianCalendar();
    this.duracao=0;
    }
    
    public Actividade (String tp,String metor,GregorianCalendar date,int dur) {
    this.tipo=tp;
    this.meteorologia=metor;
    this.data=date;
    this.duracao=dur;
    }
    
    public Actividade(Actividade u) {
    this.tipo=u.getTipo();
    this.meteorologia=u.getMeteorologia();
    this.data=u.getData();
    this.duracao=u.getDuracao();
    
    
    }
    
    public GregorianCalendar getData() {
       return this.data;
   }
    
   public void setInicio(GregorianCalendar date) {
       this.data = date;
   }
   
   public String getTipo(){
    return this.tipo;
    }

   public void setTipo(String tp) {
   this.tipo=tp;
   }
   
  public abstract Actividade clone();
   
  public abstract boolean equals(Object o);
  
   public String getMeteorologia(){
    return this.meteorologia;
    }
   
    public void setMeteorologia(String meteo){
    this.meteorologia=meteo;
    }
    
    
    public void setDuracao(int d)         {this.duracao = d;}
    public int getDuracao()           {return this.duracao;}
     public abstract String toString();
    
   
  
}
