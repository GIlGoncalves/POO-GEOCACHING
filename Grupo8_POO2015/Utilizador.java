
import java.text.*;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Utilizador implements Serializable
{
   
    private String email;
    private String password;
    private String nome;
    private String morada;
    private GregorianCalendar dataNascimento;
    private String genero;
    private HashMap<String,Utilizador> amigos;
    private HashMap<String,Utilizador> pedidosPendentes;
    private TreeSet<Actividade> actividadesRealizadas;
    private HashMap<String,Cache> caches; // nome da cache que encontrou
    private HashMap<String,Cache> criou;  //que nome da cache criou
    
    
    
    public Utilizador(){
    this.email="";
    this.password="";
    this.nome="";
    this.morada="";
    this.dataNascimento=new GregorianCalendar();
    this.actividadesRealizadas= new TreeSet<Actividade>(new DataComparator());
    this.pedidosPendentes =new HashMap<String,Utilizador>();
    this.caches= new HashMap<String,Cache>();
    this.genero="";
    this.criou= new HashMap<String,Cache>();
    this.amigos=new HashMap<String,Utilizador>();
    }
      
    public Utilizador (String email, String pw, String nome, String genero,String morada, int dia, int mes, int ano)
    {
    
     this.email=email;
     this.password=pw;
     this.nome=nome;
     this.genero=genero;
     this.morada=morada;
     this.dataNascimento=new GregorianCalendar(ano,mes,dia);
     this.criou= new HashMap<String,Cache>();
     this.amigos=new HashMap<String,Utilizador>();
     this.actividadesRealizadas= new TreeSet<Actividade>(new DataComparator());
     this.pedidosPendentes =new HashMap<String,Utilizador>();
     this.caches= new HashMap<String,Cache>();
     }
    
     public Utilizador(String email, String pw, String nome, String genero,String morada, int dia, int mes, int ano, HashMap<String,Utilizador> amg,HashMap<String,Utilizador> pedidosPen,
     TreeSet<Actividade> actividadesRea,HashMap<String,Cache> cach, HashMap<String,Cache> cRi){
      this.email=email;
      this.password=pw;
      this.nome=nome;
      this.genero=genero;
      this.morada=morada;
      this.dataNascimento=new GregorianCalendar(ano,mes,dia);
      this.criou= new HashMap<String,Cache>();
      for(Cache u :cRi.values()){
        this.criou.put(u.getNomeCache(),u.clone()); 
        
        }
        
      this.amigos=new HashMap<String,Utilizador>();
      for(Utilizador g : amg.values()){
        this.amigos.put(g.getEmail(),g.clone());
        
        }
      
      this.actividadesRealizadas= new TreeSet<Actividade>(new DataComparator());
      for(Actividade j : actividadesRea) {
        this.actividadesRealizadas.add(j.clone());
        }
      this.pedidosPendentes =new HashMap<String,Utilizador>();
      for(Utilizador l :pedidosPen.values()) {
        this.pedidosPendentes.put(l.getEmail(),l.clone());
        }
      
      this.caches= new HashMap<String,Cache>();
        for(Cache o : cach.values()) {
        this.criou.put(o.getNomeCache(),o.clone());
        }
        
        
        
        
        
        
        }
    
    
    
    
    
  
    public Utilizador (Utilizador u) {
    this.email=u.getEmail();
    this.nome=u.getNome();
    this.morada=u.getMorada();
    this.dataNascimento=u.getData();
    this.genero= u.getGenero();
    this.amigos=u.getAmigos();
    this.pedidosPendentes=u.getPedidos();
    this.caches=u.getCache();
    this.password=u.getPw();
    this.criou=u.getCriou();
    this.actividadesRealizadas=u.getActividades();
    
    }
   
   
    public String getEmail(){
     return this.email;
    }
    public String getPw() {
    return this.password;
    }
    public String getNome(){
    return this.nome;
    }
    public String getGenero(){
    return this.genero;
    }
    public String getMorada(){
    return this.morada;
    }
    
    public GregorianCalendar getData(){
    return this.dataNascimento;
    }
    
   public HashMap<String,Cache> getCriou(){
    HashMap<String,Cache> cr =new HashMap<String,Cache> ();
    for(Cache u :this.criou.values()) {
     cr.put(u.getNomeCache(),u.clone());
    
    }
    
    return cr;
    }
    
    
    
    
    public void setEmail(String e) {
    this.email=e;
    }
    public void setPw(String p) {
    this.password = p;
    }
    
    public void setNome(String n) {
        this.nome = n;
    }
    
    public void setGenero(String g){
        this.genero = g;
    }
    
    public void setMorada(String m) {
      this.morada=m;
    }
    
     public void setData(GregorianCalendar d) {
         this.dataNascimento = d;
        }
     
        public Utilizador getUtilizadorByEmail(String mail) {
        Utilizador user = null;
        if (this.amigos.containsKey(mail)) {
            user = this.amigos.get(mail).clone();
        }
        return user;
    }
    
     public HashMap<String,Utilizador> getAmigos(){
        
        HashMap<String,Utilizador> amg=new HashMap<String,Utilizador>();
        for(Utilizador u:this.amigos.values()) {
        amg.put(u.getEmail(),u.clone());  
        
        
        }
        return amg;
        
        }
        
     public HashMap<String,Utilizador> getPedidos(){
        
        HashMap<String,Utilizador> pedidos=new HashMap<String,Utilizador>();
        
        for(Utilizador u:this.pedidosPendentes.values()) {
        pedidos.put(u.getEmail(),u.clone());
        
        }
        return pedidos;
        
        }
        
   public TreeSet<Actividade> getActividades(){
     TreeSet<Actividade> act=new TreeSet<Actividade> (new DataComparator());
    for(Actividade u :actividadesRealizadas) {
     act.add(u.clone());
            
      }
        
    return act;
        }
        
        
        public HashMap<String,Cache> getCache(){
          HashMap<String,Cache> cac=new  HashMap<String,Cache>();
         for(Cache u:caches.values()) {
            cac.put(u.getNomeCache(),u.clone());
            
            }
        return cac;
        
        }
        
   
        
    public void setAmigos(HashMap<String,Utilizador> amig){
    HashMap<String,Utilizador> amg=new HashMap<String,Utilizador>();
    
     for(Utilizador u:amig.values()) {
        amg.put(u.getEmail(),u);
        
        
        }
    
     this.amigos=amg;
    
    
    }
    
    public void setPedidos(HashMap<String,Utilizador> pedidos) {
    HashMap<String,Utilizador> pedido=new HashMap<String,Utilizador> ();
    for(Utilizador u : pedidos.values()){
     pedido.put(u.getEmail(),u.clone());
    
    }
    this.pedidosPendentes=pedido;
    
    
    }
    
    public void setActividade(TreeSet<Actividade> actividadesR) {
      TreeSet<Actividade> act=new TreeSet<Actividade> (new DataComparator());
      for(Actividade u: actividadesR){
        act.add(u.clone());
        }
      this.actividadesRealizadas=act;
    
    }
        
    
    public void setCaches(HashMap<String,Cache> cache){
       HashMap<String,Cache> cac=new HashMap<String,Cache>();
        for(Cache u: cache.values()) {
        cac.put(u.getNomeCache(),u.clone());
        
        }
        this.caches=cac;
        
    
    }
    
    public void setCriou(HashMap<String,Cache> criada) {
     HashMap<String,Cache> cria=new HashMap<String,Cache>();
        for(Cache u: criada.values()) {
        cria.put(u.getNomeCache(),u.clone());
        
        }
        this.criou=cria;
    
    }
    
   
        

    public Utilizador clone() {
    
    return new Utilizador(this);
    }
    
    /**
     * Verifica os amigos
     */
    public boolean verificaAmigos(HashMap<String,Utilizador> ami){
      if(this.amigos.size() != ami.size()) return false;
      else {
      boolean encontrado=true;
     for(Utilizador u :ami.values()){ 
        if(encontrado){
        encontrado=this.amigos.containsKey(u.getEmail());
       }
    
      else return false;
      }
     return encontrado;
    }
    
    
    }
    /**
     * Verifica os pedidos
     */
    public boolean verificaPedidos(HashMap<String,Utilizador> pedidos){
     if(this.pedidosPendentes.size() !=pedidos.size()) return false;
     else{
        boolean encontrado=true;
        for(Utilizador u:  pedidos.values()) {
        
            if (encontrado) {
           encontrado=this.pedidosPendentes.containsKey(u.getEmail());
        
        
        }
        else {return false;}
        
        }
         return encontrado;
        }
 
    }
    
    /**
     * Verifica as actividades
     */
    
    public boolean verificaActividades(TreeSet<Actividade> actividades) {
    if(this.actividadesRealizadas.size() !=actividades.size()) return false;
    else {
    boolean encontrado =true;
     for(Actividade u :actividades) {
        if(encontrado) {
        encontrado=this.actividadesRealizadas.contains(u);
        
        }
        else {return false;}
        }
     return encontrado;

    }
    
    }
    /**
     * Verifica as caches que encontrou
     */
    
    public boolean verificaCaches(HashMap<String,Cache> cache){
    if(this.caches.size() != cache.size()) return false;
    else{
    
    boolean encontrado=true;
    for(Cache u:cache.values()) {
    if(encontrado) {
    encontrado=this.caches.containsKey(u.getNomeCache());
    
    }
    else return false;
    
    
    }
    
    return encontrado;
    
    
    }
  
    }
    
    
    
    /**
     * Verifica as caches que criou;
     */
    
    public boolean verificaCachesCriadas(HashMap<String,Cache> cr) {
    if(this.criou.size() !=cr.size()) return false;
    else {
    boolean encontrado =true;
    for(Cache u :cr.values()) {
    if(encontrado) {  encontrado=this.criou.containsKey(u.getNomeCache());}
    else { return false;}
    }
    
    return encontrado;
    }
    
    }
    
    
    /**
     * Equals com os metodos de verificação
     *
     */
    
      public boolean equals (Object o) {
        if(this == o) {
            return true;
        }
        if((o == null) || (this.getClass() != o.getClass())) {
            return false;
        } else {
            Utilizador u = (Utilizador) o;
            return (this.email.equals(u.getEmail()) && this.genero.equals(u.getGenero()) && this.morada.equals(u.getMorada()) && this.dataNascimento==u.getData() && this.nome.equals(u.getNome()) && this.password.equals(u.getPw())
            && verificaAmigos(u.getAmigos()) && verificaPedidos(u.getPedidos()) && verificaActividades(u.getActividades()) && verificaCaches(u.getCache())  && verificaCachesCriadas(u.getCriou()));
            
           
        }
            
    }
    
    /**
     * Calcula a idade
     */
    
       public int calculaIdade(){
        GregorianCalendar agora = new GregorianCalendar();
        int mes = this.getData().get(Calendar.MONTH);
        int dia = this.getData().get(Calendar.DAY_OF_MONTH);
        int ano = this.getData().get(Calendar.YEAR);
        int mesAtual = agora.get(Calendar.MONTH) + 1;
        int diaAtual = agora.get(Calendar.DAY_OF_MONTH);
        int anoAtual = agora.get(Calendar.YEAR); 
        int idade = anoAtual - ano - 1;
        
        if (mes == mesAtual){
            if (dia >= diaAtual) idade++;
        }
        else if (mes < mesAtual) idade++;
        
        return idade;
    }
    
    
    /**
     * Pedidos de Amizade
     * Envia pedido de amizade
     */
    public void enviaPedido(Utilizador u) {
            
            u.pedidosPendentes.put(this.getEmail(),this.clone());
        
    }
    
    /**
     * Aceita pedido de amizade
     */
    public void aceitaPedido(Utilizador u)  {
        
            this.pedidosPendentes.remove(u.getEmail());
            u.pedidosPendentes.remove(this.getEmail());
            this.addAmigo(u.clone());
            u.addAmigo(this);
        
        }   
    
    
    /**
     * Adiciona amigo
     */
    public void addAmigo(Utilizador a)  {
      
            this.amigos.put(a.getEmail(),a.clone());
            
        }
    
    
    /**
     * Remover amigo
     */
    public void remAmigo(Utilizador a)  {
             
            
            this.amigos.remove(a.getEmail());
            
      
    }
   
     /**
     * Actividades 
     * Adiciona actividade 
     */
    public void addActividade(Actividade a) {
       
        this.actividadesRealizadas.add(a);
    }
    
    
    
    /**
     * Remove actividade 
     */
    public void removeActividade(GregorianCalendar date, String tipo) {
      TreeSet<Actividade> copia = new TreeSet<Actividade>(new DataComparator());
        for(Actividade a: this.actividadesRealizadas) {
           
            
            if(!(a.getData().getTimeInMillis() == date.getTimeInMillis() && a.getTipo().equals(tipo))) {
              copia.add(a);
            
            
        
            }
        
        
        }
        this.actividadesRealizadas=copia;
        
    }
        
    
  
        
        
        /**
         * Estatistica mensais das actividades 
         * 
         */
         
        public String estatisticaActividades(int mes){
        
        int nrActividadesDeProcura=0;
        int nrPasseios=0;
        int nrEventos=0;
        int nrCachesEscondidas=0;
        
        int tempoPasseios=0;
        int tempoEscondidas=0;
        int tempoProcura=0;
 
          
        for(Actividade a:this.actividadesRealizadas) {
                
             if(a.getTipo().equals("Procurar cache") && a.getData().get(Calendar.MONTH)==mes ){
                nrActividadesDeProcura++;
                tempoProcura+=a.getDuracao();
                
          }
          else {
              if(a.getTipo().equals("Esconder cache") && a.getData().get(Calendar.MONTH)==mes){
            nrCachesEscondidas++;
            tempoEscondidas+=a.getDuracao();
            
            }
            
            else {
                if(a.getTipo().equals("Evento") && a.getData().get(Calendar.MONTH)==mes) {
                
                
                nrEventos++;
                
                }
                  else {
                    if(a.getTipo().equals("Lazer")&&  a.getData().get(Calendar.MONTH)==mes){
                      
                          nrPasseios++;
                     
                       tempoPasseios+=a.getDuracao();
                      }
                    
                    }
            
            }        
        
        }
        }
        
        
        
        return new String("Actividade de procura  :  "+ "   "+  nrActividadesDeProcura + "\nTempo gasto na actividade de procura :  " +"    "+ tempoProcura + 
         "\nActividade de Lazer " +"      " +nrPasseios + "\nTempo gasto na actividade de lazer :"+"     "+tempoPasseios + "\nActividade de escoder cache:   "+"      " +nrCachesEscondidas + 
         "\nTempo gasto na activiade de esconder :  "+ "   "+tempoEscondidas + "\nEventos : " +"      "+ nrEventos );
        
        
    
    
}
        
        
/**        
* Estatistica anual       
 */
        
        public String estatisticaAnual (int ano)
        
        {
        int nrActividadesDeProcura=0;
        int nrPasseios=0;
        int nrEventos=0;
        int nrCachesEscondidas=0;
        
        int tempoPasseios=0;
        int tempoEscondidas=0;
        int tempoProcura=0;

          for(Actividade a:this.actividadesRealizadas) {
                 if(a.getTipo().equals("Procurar cache") && a.getData().get(Calendar.YEAR)==ano ){
                nrActividadesDeProcura++;
                tempoProcura+=a.getDuracao();
                
          }
          else {
              if(a.getTipo().equals("Esconder cache") && a.getData().get(Calendar.YEAR)==ano){
            nrCachesEscondidas++;
            tempoEscondidas+=a.getDuracao();
            
            }
            
            else {
                if(a.getTipo().equals("Evento") && a.getData().get(Calendar.YEAR)==ano) {
                
                
                nrEventos++;
                
                }
                  else { 
                      if(a.getTipo().equals("Lazer")&&  a.getData().get(Calendar.YEAR)==ano){
                      
                          nrPasseios++;
                     
                       tempoPasseios+=a.getDuracao();
                      }
                    }
            
            }        
        
        }
             
           
            }
        
        return new String("Actividade de procura : " + "      " +  nrActividadesDeProcura + "     "+ "\nTempo gasto na actividade de procura :" +"        " + tempoProcura + 
         "\nActividade de Lazer " + "   "+ nrPasseios + "\nTempo gasto na actividade de lazer :" + "     " +tempoPasseios + "\nActividade de escoder cache  " +"     " + nrCachesEscondidas + 
         "\nTempo gasto na activiade de esconder : " + "     "+ tempoEscondidas + "\nEventos : "+"     " + nrEventos );
        
        
    
        }
     
        /**
         * Estatistica mensal das caches
         */
        
        public String estatisticaMensalCache(int mes) {
        
         int nrMicroCaches=0;
         int nrMultCaches=0;
         int nrCacheMisterio=0;
         
         for(Cache a :this.caches.values()){
            
             if(a.getTipo().equals("MicroCache") && a.getData().get(Calendar.MONTH)==mes){
                nrMicroCaches++;
                
                }
             else {
                if(a.getTipo().equals("MultCache") && a.getData().get(Calendar.MONTH)==mes ) {
                
                    nrMultCaches++;
                
                }
                else {
                   if(a.getTipo().equals("CacheMisterio") && a.getData().get(Calendar.MONTH)==mes) {
                    
                       nrCacheMisterio++;
                    
                    }
                
                }
                
                
                }
             
             
            
            }
            return new String("Micro caches encontradas: " +"     " + nrMicroCaches + "\nNumero de Multicaches encontradas" +"   "+nrMultCaches + "\nNumero de caches misterios encontradas" +"   "+  nrCacheMisterio);
            
            
            }
        
            /**
             * Estatisticas anuais das caches
             */
        
        
       public String estatisticaAnualCache(int ano) {
        
         int nrMicroCaches=0;
         int nrMultCaches=0;
         int nrCacheMisterio=0;
         
         for(Cache a :this.caches.values()){
            
             if(a.getTipo().equals("MicroCache") && a.getData().get(Calendar.YEAR)==ano){
                nrMicroCaches++;
                
                }
             else {
                if(a.getTipo().equals("MultCache") && a.getData().get(Calendar.YEAR)==ano ) {
                
                    nrMultCaches++;
                
                }
                else {
                   if(a.getTipo().equals("CacheMisterio") && a.getData().get(Calendar.YEAR)==ano) {
                    
                       nrCacheMisterio++;
                    
                    }
                
                }
                
                
                }
             
             
            
            }
            return new String("Micro caches encontradas: " +"     " + nrMicroCaches + "\nNumero de Multicaches encontradas" +"   "+nrMultCaches + "\nNumero de caches misterios encontradas" +"   "+  nrCacheMisterio);
            
            
            }
        
            
            /**
             * Remove a cache se o utilizador a tiver criado passando o nome da cache como parametro;
             */
            public void removeCache(String nome) {
                this.criou.remove(nome);
           }
  
            
            
             /**
             * Adicionar cache que o utilizador tenha criado
             */
           
            public void addCache(Cache u) {
               
                this.criou.put(u.getNomeCache(),u.clone());
            }
            
            /**
             * Adiconar cache que o utilizador encontrou
             */
             public void adionarCache(Cache u) {
                this.caches.put(u.getNomeCache(),u.clone());
                   }
                   
                /**
                 * Remover cache que o utilizador tenha encontrado
                 */   
       
            public void removeEncontrada(String nome) {
            
            this.caches.remove(nome);
            }
            
         
            
    
            
      /** Devolve uma String como representação textual do Utilizador */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("========== Dados Pessoais =========== \n");
        s.append("Email: ").append(this.email).append("\n");
        s.append("Nome: ").append(this.nome).append("\n");
        s.append("Genero: ").append(this.genero).append("\n");
        s.append("Morada: ").append(this.morada).append("\n");
        s.append("Idade: ").append(" (" + this.calculaIdade()+ " anos)\n");
       
        return s.toString();
    }
    
            
        }
        
        
        
      
        
        
        
        
        
        
        
        
        
        
        
       
        
       
  
    

