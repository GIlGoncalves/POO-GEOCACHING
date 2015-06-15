
import java.io.*;
import java.util.*;


public class GeoCaching implements Serializable
{
   
    private HashMap<String,Cache> cache;  //criadas pelo vários utilizadores;
    private HashMap<String,Utilizador> listaUtilizadores;
    private TreeSet<String> listaActividades; //se quiser adicionar mais alguma actividade
    private Admin admin; //adim do sistema; 
    private HashMap<String,Cache> report;
  
   
    
    public GeoCaching(){
    this.cache=new HashMap<String,Cache>();
    this.listaUtilizadores=new HashMap<String,Utilizador>();
    this.listaActividades= new TreeSet<String> ();
    this.report = new HashMap<String,Cache>();
    this.admin=new Admin();
    
    
    }
    
    public GeoCaching(HashMap<String,Cache> ca, HashMap<String,Utilizador>lista,TreeSet<String> act,HashMap<String,Cache> rpo,Admin ad){
     
        this.cache =new HashMap<String,Cache>();
        for(Cache u :ca.values()){
        this.cache.put(u.getNomeCache(),u.clone());
        }
        
        
        this.listaUtilizadores=new HashMap<String,Utilizador>();
       
        for(Utilizador u : lista.values()) {
        
        this.listaUtilizadores.put(u.getEmail(),u.clone());
        
        }
        
        this.listaActividades=new TreeSet<String> ();
        
        for(String u :listaActividades) {
        
        this.listaActividades.add(u);
        }
    
        for(Cache u : rpo.values()) {
        
        this.report.put(u.getNomeCache(),u.clone());
        }
        this.admin=ad;
        
        
    }
    
    
    public GeoCaching(GeoCaching u) {
    
    this.cache=u.getCache();
    this.listaUtilizadores=u.getUtilizador();
    this.listaActividades=u.getListaActividades();
    this.report =u.getReport();
    this.admin=u.getAdmin();
    
    
    
    
    
    }
    
 
    
    
    public HashMap<String,Cache> getReport(){
       HashMap<String,Cache>rpo= new HashMap<String,Cache>();
      for(Cache u : this.report.values()) {
        
        rpo.put(u.getNomeCache(),u.clone());
        }
        return rpo;
        
    }
    
    public void setReport(HashMap<String,Cache> rpo) {
    
        HashMap<String,Cache> rp= new HashMap<String,Cache> ();
        for(Cache u :rpo.values()) {
        rp.put(u.getNomeCache(),u.clone());
        
        }
        this.report=rp;
    
    
    }
    
    
    public HashMap<String,Cache> getCache(){
    
      HashMap<String,Cache> ca = new HashMap<String,Cache>();
      
      for(Cache u : this.cache.values()) {
        ca.put(u.getNomeCache(),u.clone());
        
        }
      
      return ca;
    
    
    }
    
    public HashMap<String,Utilizador> getUtilizador(){
     HashMap<String,Utilizador> lista = new HashMap<String,Utilizador>();
     
      for(Utilizador u : this.listaUtilizadores.values()) {
        lista.put(u.getEmail(),u.clone());
        
        }
      return lista;
    
    }
    
    public Admin getAdmin(){
    return  this.admin;
    }
    
    public TreeSet<String> getListaActividades(){
       TreeSet<String> act= new TreeSet<String> ();
       
       for(String u :this.listaActividades) {
        act.add(u);
        
        }
    
        return act;
    }
    
    
     public void setCache(HashMap<String,Cache> cac) {
        HashMap<String,Cache> ca = new HashMap<String,Cache>();
         
        for(Cache u : cac.values()) {
         ca.put(u.getNomeCache(),u.clone());
        
        }
        this.cache=ca;
        
        }
    
        public void setUtilizador(HashMap<String,Utilizador> utilizadorL) {
        
        HashMap<String,Utilizador> utilizador= new HashMap<String,Utilizador>();
        for(Utilizador u : utilizadorL.values()) {
        utilizador.put(u.getEmail(),u.clone());
        
        }
        this.listaUtilizadores=utilizador; 
        
        }
        
        
        public void setActividades(TreeSet<String> listaA) {
        
        TreeSet<String> lista=new TreeSet<String> ();
        for(String a : listaA) {
        lista.add(a);
        
        }
        
        this.listaActividades=lista;
        }
        
        
        public void adicionaAtividade(String s) {
        this.listaActividades.add(s);
       }
       
       /**
        * Adicionar actividade ao utilizador
        */
       public void adicionaAtividadeUtilizador(Actividade a,String email) {
        this.listaUtilizadores.get(email).addActividade(a);
        }
       
       public boolean getUtilizadorEmail(String email ) {
         boolean encontrado = false;
        if (this.listaUtilizadores.containsKey(email)) {
            encontrado=true;
        }
        return encontrado;
      }
      
  
      
         
       public void adicionaUtilizador(Utilizador u) {
        this.listaUtilizadores.put(u.getEmail(),u.clone());
      }
      
      public void enviarPedidoAoUtilizador(String email,String amigo) {
        this.listaUtilizadores.get(email).enviaPedido(this.listaUtilizadores.get(amigo));
        }
      
      public void adicionaAmigoAoUtilizador(String email,String amigo) {
        this.listaUtilizadores.get(email).aceitaPedido(this.listaUtilizadores.get(amigo));
        
        }
         
        public void removeAmigoDeUtilizador(String origem, String amigo) {
        this.listaUtilizadores.get(origem).remAmigo(this.listaUtilizadores.get(amigo));
      }
        
       /**
             * Adicionar  cache micro ao sistema e ao utilizador;
             */
    
             public void criarCacheMicro(String nome,String tipo,Coordenada loc,String tam,GregorianCalendar date,String email) {
                 GregorianCalendar d =new GregorianCalendar(0,1,0);
               Micro_cache a = new Micro_cache(nome,tam,tipo,loc,d,date,email);
              
                       this.cache.put(a.getNomeCache(),a.clone());
                     
                       this.listaUtilizadores.get(email).addCache(a);
                
                
            }
        
        /**
         * Adicionar Multi-caches ao sistema
         */
        public void criarCacheMult(String nome,String tipo,Coordenada loc,String tam,GregorianCalendar date,ArrayList<Coordenada> cord,String email) 
        {         
            GregorianCalendar d =new GregorianCalendar(0,1,0);
            Mult_cache a =new Mult_cache(nome,tam,tipo,loc,d,date,cord,email);
        
                  this.cache.put(a.getNomeCache(),a.clone());
                  this.listaUtilizadores.get(email).addCache(a);
                  
         
        }
        
         /**
          * Adicionar cache misterio ao sistma
          * 
          */
            
         
         public void criarCacheMisterio(String nome,String resposta,String pergunta,String tipo,Coordenada finalLoc,String tam,GregorianCalendar date,String email,Coordenada loc)  {
            
             GregorianCalendar d =new GregorianCalendar(0,1,0);
            
            Cache_misterio a = new Cache_misterio(nome,resposta.toLowerCase(),pergunta.toLowerCase(),tam,tipo,finalLoc,d,date,loc,email);
           
                    this.cache.put(a.getNomeCache(),a.clone());
                    this.listaUtilizadores.get(email).addCache(a);
                    
                }
      
      
      
      
                
           /**
            * Adicionar uma micro cache ao admin
            */
        public void adicionarCacheAdminMicro(String nome,String tipo,Coordenada loc,String tam,GregorianCalendar date){
          GregorianCalendar k =new GregorianCalendar(0,1,0);
        
           Micro_cache a = new Micro_cache(nome,tam,tipo,loc,k,date,"admin@gmail.com");
           
           this.admin.addCacheAdim(a);
           this.cache.put(a.getNomeCache(),a.clone());
        }
           
        /**
         * Adicionar mult cache ao admin
         */
        
        public void adicionarCacheAdminMult(String nome,String tipo,Coordenada loc,String tam,GregorianCalendar date,ArrayList<Coordenada> cord){
           GregorianCalendar k =new GregorianCalendar(0,1,0);
            Mult_cache a =new Mult_cache(nome,tam,tipo,loc,k,date,cord,"admin@gmail.com");
            
           this.admin.addCacheAdim(a);
           this.cache.put(a.getNomeCache(),a.clone());
            
        
        }
        
        /**
         * Adicionar cache misterio ao adim
         */
        
        public void adicionarCacheAdimMist(String nome,String resposta,String pergunta,String tipo,Coordenada finalLoc,String tam,GregorianCalendar date,Coordenada loc){
            GregorianCalendar k =new GregorianCalendar(0,1,0);
            Cache_misterio a = new Cache_misterio(nome,resposta.toLowerCase(),pergunta.toLowerCase(),tam,tipo,finalLoc,k,date,loc,"admin@gmail.com");
            this.admin.addCacheAdim(a);
            this.cache.put(a.getNomeCache(),a.clone());
        
        
        
        }
        
        /**
         * Report abuse se a cache for de um utilizador
         */
        public void reportAbuse(String nomeCache,String email) {
          Cache u = this.cache.get(nomeCache);
          
          
          this.report.put(u.getNomeCache(),u.clone());
          this.cache.remove(nomeCache);
          this.listaUtilizadores.get(email).removeCache(nomeCache);
        
        }
        
        /**
         * Repor abuse se a cache criada for do admin
         */
        public void reportAbuseAdmin(String nomeCache) {
        
        
            Cache u =this.cache.get(nomeCache);
            
            this.report.put(u.getNomeCache(),u.clone());
            this.cache.remove(nomeCache);
            this.admin.removeCacheAd(nomeCache);
        
        
        }
        
        
      
        
        
        /**
         * Remover cache que tenha sido reportada 
         */
        public void removeReportCache(String nomeCache) {
           this.report.remove(nomeCache);
        }
        
        
        /**
         * Adicionar a actividade de procura ao utilizador
         */
        
        public void adicionaActividadeProcura(GregorianCalendar d,String tipoProcura ,String meteorologia,String tipoDeActividade,ArrayList<Coordenada> cm,int dura,String email){
        
            Procura a = new Procura (d,tipoProcura,meteorologia,tipoDeActividade,cm,dura);
            this.listaUtilizadores.get(email).addActividade(a);
        
        }
        
        /**
         * Adicionar uma actividade de esconder uma cache
         */
        
        public void adicionarActividadeEsconder(int dur,Coordenada loc,String tipoCaches,String tam,GregorianCalendar date,String tipo,String meteo,String email){
        
        
            Esconder a =new Esconder(dur,loc,tipoCaches,tam,date,tipo,meteo);
            this.listaUtilizadores.get(email).addActividade(a);
        
        }
        
        /**
         * Adiciona uma actividade de lazer
         */
        public void adicionarActividadeLazer(String tipo,String meteo,GregorianCalendar date,Coordenada loc,int dur,String email) {
        
         
            Virtual a = new Virtual(tipo,meteo,date,loc,dur);
            this.listaUtilizadores.get(email).addActividade(a);
        
        }
        
    /**
     * Adicionar evento
     */
        
    public void adicionarEvento(int nrP, int ta,GregorianCalendar d,GregorianCalendar dateF ,String meteorologia,String tipoDeActividade,HashMap<String,Utilizador> convida,int dura,Coordenada k,String email){
    
        Cache_evento a = new Cache_evento(nrP,ta,d,dateF,meteorologia,tipoDeActividade,convida,dura,k);
        this.listaUtilizadores.get(email).addActividade(a);
        
        }
        
        /**
         * Remover actividade do utilizador
         */
        public void removeActividade( String tipo,GregorianCalendar d,String email ){
        
            this.listaUtilizadores.get(email).removeActividade(d,tipo);
        }
        
        /**
         * Voltar a inserir uma cache que foi reportada se o email não for o do admin
         * 
         */
        public void inserCacheReportada(String email, String nome) {
          
            Cache u =this.report.get(nome);
            
          
          this.listaUtilizadores.get(email).addCache(u);
          this.cache.put(u.getNomeCache(),u.clone());
          this.report.remove(nome);
          
        }
        
        /**
         * Inser cache que foi reportada se o email for o do admin
         */
        public void inserCacheAdmin(String nome){
        
            Cache u = this.report.get(nome);
            
            this.cache.put(u.getNomeCache(),u.clone());
            this.admin.addCacheAdim(u);
            this.report.remove(nome);
        
        }
       
        public GeoCaching clone(){
        return new GeoCaching(this);
        }
        
        /**
         * Remover cache do admin e do sistema
         */
       public void removeCacheAdmin(String nomeCache){
        this.cache.remove(nomeCache);
        this.admin.removeCacheAd(nomeCache);
        }
        
        /**
         * Remover cache do sistema e do utilizador
         */
      
        public void removeCacheUtilizador(String nomeCache,String email) {
        this.listaUtilizadores.get(email).removeCache(nomeCache);
        this.cache.remove(nomeCache);
        }
        
        public Utilizador getUtilizadorByEmail(String mail) {
        Utilizador user = null;
        if (this.listaUtilizadores.containsKey(mail)) {
            user = this.listaUtilizadores.get(mail).clone();
        }
        return user;
      }
        
    
        
    public boolean verificaAmizade(String email, String amigo){
     return this.listaUtilizadores.get(email).getAmigos().containsKey(amigo); 
    
    
    }
    
    
    /**
     * Adicionar uma cache que tenha sido encontrada pelo utilizador
     */
    public void encontrarCache(String email,Cache u){
    
        this.cache.remove(u.getNomeCache());
    
        this.cache.put(u.getNomeCache(),u.clone());
    
        this.listaUtilizadores.get(email).adionarCache(u);
    
    
    
    }
    
    /**
     * Estatistica de uma actividade mensal 
     */
     public String estatisticaMensal(String email,int mes) {
        
       return  this.listaUtilizadores.get(email).estatisticaActividades(mes);
        }
        
        /**
         * Estatistica de uma actividade anual
         */
    public String estatisticaAnual(String email , int ano) {
    
    
       return  this.listaUtilizadores.get(email).estatisticaAnual(ano);
    }
    
    /**
     * Estatistica de cache por mes
     */
    public String estatisticaCacheMensal(String email, int mes) {
     return this.listaUtilizadores.get(email).estatisticaMensalCache(mes);
    }
    
    /**
     * Estatistica anuais de caches
     */
    public String estatisticaCacheAnual(String email,int ano) {
    return this.listaUtilizadores.get(email).estatisticaAnualCache(ano);
    
    }
    
    /**
     * Remover uma cache que ele tenha encontrado
     */
    public void removeCacheEncontrada(String email,String nomeCache){
    
        this.listaUtilizadores.get(email).removeEncontrada(nomeCache);
    
    
    }
    
    }
    
    
    
    