
import java.util.*;
import java.text.DateFormat;
 import java.text.SimpleDateFormat;
public class Cache_misterio extends Cache 
{
 
    
    private String resposta;
    private String pergunta;
    private Coordenada local ;//local onde pode ser encontrada o desafio que levará a cache final
    
    public Cache_misterio(){
    super(""," "," ",null,null,null,"");
    
    this.resposta="";
    this.pergunta="";
    this.local=new Coordenada();
    
    }
    
    public Cache_misterio(String nome,String resp,String per,String tam,String tp,Coordenada u,GregorianCalendar dateD, GregorianCalendar dateI,Coordenada loc,String nomeCr){
    super(nome,tam,tp,u,dateD,dateI,nomeCr);
    
    this.resposta =resp;
    this.pergunta=per;
    this.local=loc;
    }
    
    public Cache_misterio(Cache_misterio u){
    super(u.getNomeCache(),u.getTamanho(),u.getTipo(),u.getCoord(),u.getData(),u.getDataInserida(),u.getNomeCriador());
    
    this.resposta=u.getResposta();
    this.pergunta=u.getPergunta();
    this.local=u.getLocal();
    }
    
    public Coordenada getLocal(){
    return this.local;
    }
  
    
    public String getResposta(){
    return this.resposta;
    }
    
    
    public String getPergunta(){
    return this.pergunta;
    }
    
    public void setLocal(Coordenada loc) {
    this.local=loc;
    
    }
   
    
    public void setResposta(String resp){
    this.resposta=resp;
    }
   
    public void setPergunta(String perg){
    
    this.pergunta=perg;
    }
    
 
    
    public Cache_misterio clone(){
    
    return new Cache_misterio(this);
    }
    
    public boolean equals(Object o) {
     if(this == o) {
            return true;
        }
     
     if((o == null) || (this.getClass() != o.getClass())) {
            return false;
        }
      
        else {
        Cache_misterio u =(Cache_misterio) o;
        
        return(this.local.equals(u.getLocal()) && this.pergunta.equals(u.getPergunta()) && this.resposta.equals(u.getResposta())
        && super.getCoord().equals(u.getCoord()) && super.getTamanho().equals(u.getTamanho()) && super.getTipo().equals(u.getTipo()) 
        && super.getData().equals(u.getData()) && super.getDataInserida().equals(u.getDataInserida()) && super.getNomeCache().equals(u.getNomeCache()) 
       && super.getNomeCriador().equals(u.getNomeCriador())
        );
        
        
        
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
        s.append (super.getNomeCache() +"\n");
        s.append("Pergunta\n");
        s.append (this.pergunta+"\n");
        s.append("Localizacao\n");
        s.append (this.local.toString()+"\n");
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
