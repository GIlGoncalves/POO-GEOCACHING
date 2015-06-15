

import static java.lang.System.out;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.beans.*;
import java.util.Collection;

public class Gestor implements Serializable 
{
   private Utilizador user;
   private GeoCaching geoCach;
   private Menus menu;
   private Input input;
   private Admin admin;
   
   
   
     private void limpaTerminal() {
        System.out.print('\u000C');
    }
    
    public Gestor (){
    this.geoCach=new GeoCaching();
     this.menu = new Menus();
    
    }
   
    public Gestor(GeoCaching geo) {

        this.geoCach = geo.clone();
        this.menu = new Menus();
    }
    
    
    public String consultaCacheAmigo() throws UtilizadorException, AmizadeException, IOException{
    HashMap<String,Utilizador> amigos=this.geoCach.getUtilizadorByEmail(this.user.getEmail()).getAmigos();
      out.println("===============Lista de Amigos===================");
      for(Utilizador u : amigos.values()) {
        
        out.println("Nome : "+u.getNome() + "Email : " + u.getEmail());
        
        
        }
      out.print("\nEscreva o mail a consultar : ");
      String escolhido =input.lerString();
      if(!(this.geoCach.getUtilizadorEmail(escolhido))) {
        throw new UtilizadorException("Este utilizador não existe");
        
        }
     else if(!(this.geoCach.getUtilizadorByEmail(this.user.getEmail()).getAmigos().containsKey(escolhido))) {
        throw new AmizadeException("Este utilizador não é seu amigo");
        
        }
    
     return escolhido;
     }
     
     public String consultaCacheEstatistica() throws UtilizadorException, AmizadeException, IOException{
    HashMap<String,Utilizador> amigos=this.geoCach.getUtilizadorByEmail(this.user.getEmail()).getAmigos();
      out.println("===============Lista de Amigos===================");
      for(Utilizador u : amigos.values()) {
        
        out.println("Nome : "+u.getNome() + "Email : " + u.getEmail());
        
        
        }
      out.print("\nEscreva o mail a consultar : ");
      String escolhido =input.lerString();
      if(!(this.geoCach.getUtilizadorEmail(escolhido))) {
        throw new UtilizadorException("Este utilizador não existe");
        
        }
     else if(!(this.geoCach.getUtilizadorByEmail(this.user.getEmail()).getAmigos().containsKey(escolhido))) {
        throw new AmizadeException("Este utilizador não é seu amigo");
        
        }
    
     return escolhido;
     }
    
    
    public String consultaActividadesAmigo() throws UtilizadorException, AmizadeException, IOException
    
    {
     HashMap<String,Utilizador> amigos=this.geoCach.getUtilizadorByEmail(this.user.getEmail()).getAmigos();
      out.println("===============Lista de Amigos===================");
      for(Utilizador u : amigos.values()) {
        
        out.println("Nome : "+u.getNome() + "Email : " + u.getEmail());
        
        
        }
      out.print("\nEscreva o mail a consultar : ");
      String escolhido =input.lerString();
      if(!(this.geoCach.getUtilizadorEmail(escolhido))) {
        throw new UtilizadorException("Este utilizador não existe");
        
        }
     else if(!(this.geoCach.getUtilizadorByEmail(this.user.getEmail()).getAmigos().containsKey(escolhido))) {
        throw new AmizadeException("Este utilizador não é seu amigo");
        
        }
    
     return escolhido;
    }
    
    
    public String consultaEstatisticaAmigo() throws UtilizadorException, AmizadeException, IOException
    
    {
     HashMap<String,Utilizador> amigos=this.geoCach.getUtilizadorByEmail(this.user.getEmail()).getAmigos();
      out.println("===============Lista de Amigos===================");
      for(Utilizador u : amigos.values()) {
        
        out.println("Nome : "+u.getNome() + "Email : " + u.getEmail());
        
        
        }
      out.print("\nEscreva o mail a consultar : ");
      String escolhido =input.lerString();
      if(!(this.geoCach.getUtilizadorEmail(escolhido))) {
        throw new UtilizadorException("Este utilizador não existe");
        
        }
     else if(!(this.geoCach.getUtilizadorByEmail(this.user.getEmail()).getAmigos().containsKey(escolhido))) {
        throw new AmizadeException("Este utilizador não é seu amigo");
        
        }
    
     return escolhido;
    }
    
    public String consultaCacheAmigoCriada() throws UtilizadorException, AmizadeException, IOException
    
    {
     HashMap<String,Utilizador> amigos=this.geoCach.getUtilizadorByEmail(this.user.getEmail()).getAmigos();
      out.println("===============Lista de Amigos===================");
      for(Utilizador u : amigos.values()) {
        
        out.println("Nome : "+u.getNome() + "Email : " + u.getEmail());
        
        
        }
      out.print("\nEscreva o mail a consultar : ");
      String escolhido =input.lerString();
      if(!(this.geoCach.getUtilizadorEmail(escolhido))) {
        throw new UtilizadorException("Este utilizador não existe");
        
        }
     else if(!(this.geoCach.getUtilizadorByEmail(this.user.getEmail()).getAmigos().containsKey(escolhido))) {
        throw new AmizadeException("Este utilizador não é seu amigo");
        
        }
    
     return escolhido;
    }
    
    
    
    
    public void verPedidos() throws IOException,AmizadeException {
        out.println("========Pedidos de amizade========");
        
        if(this.geoCach.getUtilizadorByEmail(this.user.getEmail()).getPedidos().size()==0) {
          throw new AmizadeException("Não tem pedidos de amizade");
        
        }
        else {
             for(Utilizador user:this.user.getPedidos().values()){
                
                out.println("Nome :"+user.getNome()+"----"+ "Email:"+ user.getEmail());
                
                }
             out.println("Prima ENTER para continuar.");
              input.lerString();
        
        }
    
    
    }
    
    public void enviarPedido()throws IOException,CredenciaisException,UtilizadorException,AmizadeException {
    
        out.println("========Enviar Pedidos de amizade========");
        out.println("Email :"); String email=input.lerString();
         
           if(this.geoCach.getUtilizadorByEmail(email).getPedidos().containsKey(this.user.getEmail())) {
           
               throw new AmizadeException("Já enviou pedido de amizade a este utilizador");
        }
           else {
               
               if(this.geoCach. getUtilizadorByEmail(email).getAmigos().containsKey(this.user.getEmail())) {
            
            throw new AmizadeException("Já é seu amigo");
            }
            
            else { 
                if(!(this.geoCach.getUtilizador().containsKey(email))) {
                  
                    throw new UtilizadorException("Este utilizador não existe");
                 }
            
             else 
             { if(this.geoCach.getUtilizadorByEmail(this.user.getEmail()).getPedidos().containsKey(email)) {
                
                throw new AmizadeException("Este utilizador já lhe mandou um pedido de amizade");
                
                }
                else {this.geoCach.enviarPedidoAoUtilizador(this.user.getEmail(),email);
                 out.println("Pedido enviado com sucesso");
                    input.lerString();
                }
                
                }
        }
         }
        }
      
    
    
    
    
    public void adicionaAmigo() throws IOException,CredenciaisException,UtilizadorException,ParseException,ClassNotFoundException,EmailExisteException,AmizadeException
    {
        out.println("========Adcionar Amigo========");
        out.println("Email :"); String email=input.lerString();
        
        if(this.geoCach.getUtilizadorByEmail(this.user.getEmail()).getPedidos().containsKey(email))
        
        {
          this.geoCach.adicionaAmigoAoUtilizador(this.user.getEmail(),email);
          
        out.println("Amigo adicionado com sucesso. Prima ENTER para continuar.");
        input.lerString();
        
        }
        else {
            if(this.geoCach.getUtilizadorByEmail(this.user.getEmail()).getAmigos().containsKey(email)) {
        
             throw new AmizadeException("Já é teu amigo\n");
            }
            else {
                 throw new UtilizadorException("Este utilizador não existe\n"); 
            
            }
        }
 
    }
    
     public void verListaAmigos() {
        out.println("\n======== Lista de Amigos ========\n");
        HashMap<String,Utilizador> amigos =this.geoCach.getUtilizadorByEmail(this.user.getEmail()).getAmigos();
       
        for (Utilizador a : amigos.values()) {
            
            out.println(a.getNome()+" - "+a.getEmail());
            
        }
        
    }
    
    
      public void removeAmigo() throws IOException,AmizadeException {
        HashMap<String,Utilizador> amigos = this.geoCach.getUtilizadorByEmail(this.user.getEmail()).getAmigos();
        out.println("========== Lista Amigos ==========");
        for (Utilizador b : amigos.values()) {
            
            out.println("Nome : "+b.getNome()+ " - Email: ("+b.getEmail()+")");
        }
        out.print("\nEscreva o email do amigo que quer remover: ");
        String escolha = input.lerString();
        
        if(!(this.geoCach.verificaAmizade(this.user.getEmail(),escolha))){
             throw new AmizadeException("Este utilizador não é seu amigo.");
        }
        this.geoCach.removeAmigoDeUtilizador(this.user.getEmail(), escolha);
        this.geoCach.removeAmigoDeUtilizador(escolha,this.user.getEmail());
        out.println("Amigo removido com suceso. Prima ENTER para continuar.");
        input.lerString();
    }
    
    public void verificaCoord(Coordenada a) throws IOException, CoordenadaException {
     HashMap <String,Cache> cachesExistentes =this.geoCach.getCache();
     
     for(Cache o :cachesExistentes.values()) {
        
        if(o instanceof Micro_cache) {
         Micro_cache u = (Micro_cache)o;
         
         if(u.getCoord().equals(a)){
            throw new CoordenadaException("Neste local já se encontra uma cache");
            
            }
        
        }
        else {
            if(o instanceof Mult_cache) {
             Mult_cache u = (Mult_cache)o;
             if(u.getLocal().contains(a) || u.getCoord().equals(a)) {
                throw new CoordenadaException("Neste local já se encontra uma cache");
                }
            
            
            }
            
           else {
               Cache_misterio u = (Cache_misterio)o;
              if(u.getCoord().equals(a) || u.getLocal().equals(a)) {
                 throw new CoordenadaException("Neste local já se encontra uma cache");
                }
            }
           
        }
 
        }
     
    }
     
    public void verificaNome(String nome) throws CacheException,IOException{
     if(this.geoCach.getCache().containsKey(nome)) {
        throw new CacheException("Este nome já existe");
        }
    
    }
    
    public void verificaNomeCache(String nome) throws CacheException,IOException
    {
      if(!(this.geoCach.getCache().containsKey(nome))) {
         throw new CacheException("Este nome não existe");
        
        }
    }
    
    public void verificaNomeReport(String nomeCache) throws CacheException,IOException 
    
    {
     if(!(this.geoCach.getReport().containsKey(nomeCache))) {
        throw new CacheException("Este nome não existe");
        }
    
    }
    
    public void verificaAdmin(String nomeCache) throws CacheException,IOException {
    
    
        if(!(this.geoCach.getAdmin().getCriou().containsKey(nomeCache))) {
    
        throw new CacheException("Esta cache não pertence ao adim");
           }
    
    }
    
    
    /**
     * Verifica se o o email corresponde ao criador da cache
     */
    public void verificaEmail(String nomeCache,String email) throws CacheException,IOException
    
    {
    
        if(!(this.geoCach.getUtilizadorByEmail(email).getCriou().containsKey(nomeCache))) {
    
       throw new CacheException("Este não é o criador desta cache");
      }
  
    }
    
    /**
     * Verifica se estas a remover uma cache que não é tua
     */ 
     public void verificaCacheCriada(String nomeCache)throws CacheException,IOException {
        if(!(this.geoCach.getUtilizadorByEmail(this.user.getEmail()).getCriou().containsKey(nomeCache))) {
         
            throw new CacheException("Não criaste esta cache, não a podes remover, mas podes reporta-la.");
        
        }
        
        
        }
    
        /**
        * Verifixa se estas a remover uma cache que não encontraste
       */
    public void verificaCacheEncontradaRemove(String nomeCache) throws CacheException,IOException{
    
     if(!(this.geoCach.getUtilizadorByEmail(this.user.getEmail()).getCache().containsKey(nomeCache))) {
         
            throw new CacheException("Não encontraste esta cache, não a podes remover.");
        
        }
    
    }
    
    public void verificaCriaste (String nomeCache) throws CacheException,IOException{
      
      if((this.geoCach.getUtilizadorByEmail(this.user.getEmail()).getCriou().containsKey(nomeCache))) {
         
            throw new CacheException("Criaste esta cache, não a podes reportar.");
        
        }
      
    
    }
    
    
    public void menuLoginAdmin() throws IOException,EmailExisteException,CredenciaisException,UtilizadorException
    {
       out.println("====================== Login do Adim ==========================");
        out.print("Email: "); String email = input.lerString();
        
        if(email.equals("admin@gmail.com")) {
        
            out.print("Password: "); String password = input.lerString();
        
            if(password.equals("admin1234")) {
        
                this.admin=this.geoCach.getAdmin();
        
        }
        
        else {
              throw new  CredenciaisException("A password que introduziu esta  errada.");
 
        }
        
       }
       else {
            throw new CredenciaisException("O email não é o do Admin");
            
            }
    
    
    }
    
    public void menuAdmin()throws IOException,CredenciaisException,UtilizadorException,ParseException,ClassNotFoundException,EmailExisteException,AmizadeException,CoordenadaException
    ,CacheException
    { int opcao=-1;
        while(opcao!=0) {
            this.limpaTerminal();
            out.print(menu.MenuAdminLogado("Admin"));
            opcao=Integer.parseInt(input.lerString());
        
         
            
            
            switch (opcao) {
                case 1:
               
                int opc=-1;
                int grauLatitude,grauLongitude;
                char latitude,longitude;
                double minLatitude,minLongitude;
                String tamanho;
                String tipo;
                int dia,mes,ano;
                String nomeCache="";
                boolean encontrado=false;
                Coordenada u =new Coordenada();
                
                  do{
                   out.println(this.menu.tipoDeCache());
                    opc=input.lerInt();
                  }
                   while((opc!=1)&& opc!=2 && opc!=3);
                  
                  if(opc==1){
                    
                    tipo="MicroCache";
                    tamanho ="Micro";
                    do{
                        encontrado=false;
                    try{
                       out.println("Inser o local onde guardou a cache: " );
                       do{
                      out.print("Inser o grau da Latitude     ");
                      
                      grauLatitude=input.lerInt();
                      } while(0<grauLatitude && grauLatitude>90);
                   
                      do{
                        out.print ("Inser a direcao  da latitude 'N' ou 'S':       ");
                        latitude=input.lerChar();
   
                       }while(latitude !='N' && latitude !='S');
                    
                       out.print("Inser os minutos da latitude :   ");
                       minLatitude=input.lerDouble();

                         do{
                          out.print ("Inser o grau da Longitude ");
                          grauLongitude=input.lerInt();
                        } while(0<grauLongitude && grauLongitude>180);
                     
                        do{
                          out.print("Inser a direcção da Longitude  'W' ou 'E'   :      ");
                          longitude=input.lerChar();
                        
                          }while(longitude != 'W' &&  longitude !='E');
                     
                         out.print("Inser os minutos da longitude :     ");
                         minLongitude=input.lerDouble();
                         
                         u =new Coordenada(grauLatitude,latitude,minLatitude,grauLongitude,longitude,minLongitude);
                        
                        this.verificaCoord(u);
                         
                      } catch(CoordenadaException e) {
                        out.println(e.getMessage());
                        out.println("Prima Enter para continuar\n");
                        input.lerString();
                        encontrado=true;
                        
                        }
                     }while(encontrado);
                        
                        
                      do {
                         out.print ("Inser o mes que a colucou:   ");
                         mes=input.lerInt();
                        
                        }while(mes > 12 || mes <= 0);
                    
                        do{
                         
                            out.print("Inser o ano que a colucou:   ");
                            ano=input.lerInt();
                        }while(ano > 2015 || ano < 1850);
                     
                       if (mes == 2 && (( ((ano % 4) == 0) && (ano % 100 != 0) ) || ((ano % 400) == 0))){
                        do {
                         
                         out.println("Dia: ");
                         dia = input.lerInt();
                           }while (dia > 29 || dia <= 0);
                       }
        
                       else { 
                       if (mes == 2) {
                           do{
                            
                             out.println("Dia: ");
                             dia = input.lerInt();
                           }while (dia >= 29 || dia <= 0);
                           }
        
                     else { 
                       if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            
                       do{
                        
                        out.println("Dia: ");
                        dia = input.lerInt();
                           }while (dia > 31 || dia <= 0);
                           }
        
                         else 
                        do{
                           
                           out.println("Dia: ");
                           dia = input.lerInt();
                            }while (dia > 30 || dia <= 0);
                         }
                     }
                     
                        do{
                        try{
                        encontrado=false;
                         
                        out.print ("Inser o nome da cache:  ");
                        nomeCache=input.lerString();
                         this.verificaNome(nomeCache);
                      } catch(CacheException e) {
                        out.println(e.getMessage());
                        out.println("Prima Enter para continuar");
                         input.lerString();
                         encontrado=true;
                        
                        }
                    } while(nomeCache.equals("") || encontrado );
                        
                       
                        GregorianCalendar a = new GregorianCalendar (ano,mes,dia);
                        this.geoCach.adicionarCacheAdminMicro(nomeCache,tipo,u,tamanho,a);
                      
                      
                   }  
                   
                   
                    else {
                       if(opc==2) {
                           int op=-1;
                           int nrCaminho=0;
                           tipo="MultCache";
                           ArrayList<Coordenada> caminho =new ArrayList<Coordenada>();
                           do{
                            out.println(menu.tamanhosDeCache());
                           
                            op=input.lerInt();
                            
                            }while(op<0 || op>3);
                            
                            if(op==1) {tamanho="Small";}
                            else {
                                if(op==2) {tamanho="Medium"; }
                                else {tamanho ="Large";}
                                 
                            }
                            
                              do{
                          encontrado=false;
                      try{
                         out.println("Inser o local onde guardou a cache final: " );
                         do{
                         out.print("Inser o grau da Latitude     ");
                      
                         grauLatitude=input.lerInt();
                        } while(0<grauLatitude && grauLatitude>90);
                   
                        do{
                          out.print ("Inser a direcao  da latitude 'N' ou 'S':       ");
                          latitude=input.lerChar();
   
                       }while(latitude !='N' && latitude !='S');
                    
                         out.print("Inser os minutos da latitude :   ");
                         minLatitude=input.lerDouble();

                           do{
                          out.print ("Inser o grau da Longitude ");
                          grauLongitude=input.lerInt();
                         } while(0<grauLongitude && grauLongitude>180);
                     
                        do{
                          out.print("Inser a direcção da Longitude  'W' ou 'E'   :      ");
                          longitude=input.lerChar();
                        
                          }while(longitude != 'W' &&  longitude !='E');
                     
                         out.print("Inser os minutos da longitude :     ");
                         minLongitude=input.lerDouble();
                         
                         u =new Coordenada(grauLatitude,latitude,minLatitude,grauLongitude,longitude,minLongitude);
                        
                        this.verificaCoord(u);
                         
                      } catch(CoordenadaException e) {
                        out.println(e.getMessage());
                        out.println("Prima Enter para continuar\n");
                        input.lerString();
                        encontrado=true;
                        
                        }
                     }while(encontrado);
                      
                    do{     
                      out.println("Quantas caches voçês colocou atê chegar a final?");
                      nrCaminho=input.lerInt();
                     }while(opc==0);  
                            
                     while(nrCaminho!=0) {
    
                             do{
                          encontrado=false;
                      try{
                         out.println("Inser o local onde guardou as outras caches: " );
                         do{
                         out.print("Inser o grau da Latitude     ");
                      
                         grauLatitude=input.lerInt();
                        } while(0<grauLatitude && grauLatitude>90);
                   
                        do{
                          out.print ("Inser a direcao  da latitude 'N' ou 'S':       ");
                          latitude=input.lerChar();
   
                       }while(latitude !='N' && latitude !='S');
                         out.print("Inser os minutos da latitude :   ");
                         minLatitude=input.lerDouble();

                           do{
                          out.print ("Inser o grau da Longitude ");
                          grauLongitude=input.lerInt();
                         } while(0<grauLongitude && grauLongitude>180);
                     
                        do{
                          out.print("Inser a direcção da Longitude  'W' ou 'E'   :      ");
                          longitude=input.lerChar();
                        
                          }while(longitude != 'W' &&  longitude !='E');
                     
                         out.print("Inser os minutos da longitude :     ");
                         minLongitude=input.lerDouble();
                         
                         u =new Coordenada(grauLatitude,latitude,minLatitude,grauLongitude,longitude,minLongitude);
                        
                        this.verificaCoord(u);
                         
                         } catch(CoordenadaException e) {
                        out.println(e.getMessage());
                        out.println("Prima Enter para continuar\n");
                        input.lerString();
                        encontrado=true;
                        
                        }
                     }while(encontrado);
                         caminho.add(u.clone());
                        nrCaminho--;
                        
                        }         
                     
                
                         
                     do {
                         out.print ("Inser o mes que a colucou:   ");
                         mes=input.lerInt();
                        
                        }while(mes > 12 || mes <= 0);
                    
                        do{
                         
                            out.print("Inser o ano que a colucou:   ");
                            ano=input.lerInt();
                        }while(ano > 2015 || ano < 1850);
                     
                       if (mes == 2 && (( ((ano % 4) == 0) && (ano % 100 != 0) ) || ((ano % 400) == 0))){
                        do {
                         
                         out.println("Dia: ");
                         dia = input.lerInt();
                           }while (dia > 29 || dia <= 0);
                       }
        
                       else { 
                       if (mes == 2) {
                           do{
                            
                             out.println("Dia: ");
                             dia = input.lerInt();
                           }while (dia >= 29 || dia <= 0);
                           }
        
                     else { 
                       if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            
                       do{
                        
                        out.println("Dia: ");
                        dia = input.lerInt();
                           }while (dia > 31 || dia <= 0);
                           }
        
                         else 
                        do{
                           
                           out.println("Dia: ");
                           dia = input.lerInt();
                            }while (dia > 30 || dia <= 0);
                         }
                     }
                     
                      do{
                        try{
                        encontrado=false;
                         
                        out.print ("Inser o nome da cache:  ");
                        nomeCache=input.lerString();
                         this.verificaNome(nomeCache);
                      } catch(CacheException e) {
                        out.println(e.getMessage());
                        out.println("Prima Enter para continuar");
                         input.lerString();
                         encontrado=true;
                        
                        }
                    
                     } while(nomeCache.equals("") || encontrado );
                       
                        GregorianCalendar a = new GregorianCalendar (ano,mes,dia);
                        this.geoCach.adicionarCacheAdminMult(nomeCache,tipo,u,tamanho,a,caminho);
                    
                    
                     
                 }
                   else {
                    tipo="CacheMisterio";
                    String pergunta ="";
                    String resposta="";
                    Coordenada localDopuzzle = new Coordenada();
                    int op=-1;
                     do{
                           out.println(menu.tamanhosDeCache());
                            op=input.lerInt();
                            
                            }while(op<0 || op>3);
                            
                            if(op==1) {tamanho="Small";}
                            else {
                                if(op==2) {tamanho="Medium"; }
                                else {tamanho ="Large";}
                                 
                            }
                    
                      do{
                          encontrado=false;
                      try{
                         out.println("Inser o local onde guardou a cache final: " );
                         do{
                         out.print("Inser o grau da Latitude     ");
                      
                         grauLatitude=input.lerInt();
                        } while(0<grauLatitude && grauLatitude>90);
                   
                        do{
                          out.print ("Inser a direcao  da latitude 'N' ou 'S':       ");
                          latitude=input.lerChar();
   
                       }while(latitude !='N' && latitude !='S');
                    
                         out.print("Inser os minutos da latitude :   ");
                         minLatitude=input.lerDouble();

                           do{
                          out.print ("Inser o grau da Longitude ");
                          grauLongitude=input.lerInt();
                         } while(0<grauLongitude && grauLongitude>180);
                     
                        do{
                          out.print("Inser a direcção da Longitude  'W' ou 'E'   :      ");
                          longitude=input.lerChar();
                        
                          }while(longitude != 'W' &&  longitude !='E');
                     
                         out.print("Inser os minutos da longitude :     ");
                         minLongitude=input.lerDouble();
                         
                         u =new Coordenada(grauLatitude,latitude,minLatitude,grauLongitude,longitude,minLongitude);
                        
                        this.verificaCoord(u);
                         
                      } catch(CoordenadaException e) {
                        out.println(e.getMessage());
                        out.println("Prima Enter para continuar\n");
                        input.lerString();
                        encontrado=true;
                        
                        }
                     }while(encontrado);
                     
                      do{
                          encontrado=false;
                      try{
                         out.println("Inser o local onde guardou a cache final: " );
                         do{
                         out.print("Inser o grau da Latitude     ");
                      
                         grauLatitude=input.lerInt();
                        } while(0<grauLatitude && grauLatitude>90);
                   
                        do{
                          out.print ("Inser a direcao  da latitude 'N' ou 'S':       ");
                          latitude=input.lerChar();
   
                       }while(latitude !='N' && latitude !='S');
                    
                         out.print("Inser os minutos da latitude :   ");
                         minLatitude=input.lerDouble();

                           do{
                          out.print ("Inser o grau da Longitude ");
                          grauLongitude=input.lerInt();
                         } while(0<grauLongitude && grauLongitude>180);
                     
                        do{
                          out.print("Inser a direcção da Longitude  'W' ou 'E'   :      ");
                          longitude=input.lerChar();
                        
                          }while(longitude != 'W' &&  longitude !='E');
                     
                         out.print("Inser os minutos da longitude :     ");
                         minLongitude=input.lerDouble();
                         
                         localDopuzzle =new Coordenada(grauLatitude,latitude,minLatitude,grauLongitude,longitude,minLongitude);
                        
                        this.verificaCoord(u);
                         
                      } catch(CoordenadaException e) {
                        out.println(e.getMessage());
                        out.println("Prima Enter para continuar\n");
                        input.lerString();
                        encontrado=true;
                        
                        }
                     }while(encontrado);
                     
                     do{
                        out.println("Introduza a pergunta para o puzzle");
                        pergunta=input.lerString();
                        
                        
                        }while(pergunta.equals(""));
                     
                        do{
                         out.println("Introduza a resposta a sua pergunta ");
                         resposta=input.lerString();
                            
                        }while(resposta.equals(""));
                     
                     
                      do 
                      {
                         out.print ("Inser o mes que a colucou:   ");
                         mes=input.lerInt();
                        
                        }while(mes > 12 || mes <= 0);
                    
                        do{
                         
                            out.print("Inser o ano que a colucou:   ");
                            ano=input.lerInt();
                        }while(ano > 2015 || ano < 1850);
                     
                       if (mes == 2 && (( ((ano % 4) == 0) && (ano % 100 != 0) ) || ((ano % 400) == 0))){
                        do {
                         
                         out.println("Dia: ");
                         dia = input.lerInt();
                           }while (dia > 29 || dia <= 0);
                       }
        
                       else { 
                       if (mes == 2) {
                           do{
                            
                             out.println("Dia: ");
                             dia = input.lerInt();
                           }while (dia >= 29 || dia <= 0);
                           }
        
                     else { 
                       if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            
                       do{
                        
                        out.println("Dia: ");
                        dia = input.lerInt();
                           }while (dia > 31 || dia <= 0);
                           }
        
                         else 
                        do{
                           
                           out.println("Dia: ");
                           dia = input.lerInt();
                            }while (dia > 30 || dia <= 0);
                         }
                     }
                     
                      do{
                        try{
                        encontrado=false;
                         
                        out.print ("Inser o nome da cache:  ");
                        nomeCache=input.lerString();
                         this.verificaNome(nomeCache);
                      } catch(CacheException e) {
                        out.println(e.getMessage());
                        out.println("Prima Enter para continuar");
                         input.lerString();
                         encontrado=true;
                        
                        }
                    
                     } while(nomeCache.equals("") || encontrado );
                    
                    
                        GregorianCalendar a = new GregorianCalendar (ano,mes,dia);
                        this.geoCach.adicionarCacheAdimMist(nomeCache,resposta,pergunta,tipo,u,tamanho,a,localDopuzzle);

                    } 

                }
                break;
             
              case 2:   
                int inpu;
                String nameCache="";
                out.println("===============Remover Cahces Criadas====================");
                out.println("ID -        Nome -           tipo   ");
                HashMap<String,Cache> criadas=this.geoCach.getAdmin().getCriou();
               
                int id=0;
                int remove;
                
                if(criadas.size()==0) {
                    out.println ("Não tem caches para remover");  
                    out.println("\n\nPrima ENTER para continuar.");
                    input.lerString();
                    break ;
                }
                else {
                for(Cache cache :criadas.values()) {
                 
                    id++; 
                    out.println(id+ "           " +cache.getNomeCache() + "                     " +  cache.getTipo());
                }
              
                out.println ("Deseja remover alguma cache?");
                out.println ("1 - Sim");
                out.println  ("2 - Não ");
                inpu = input.lerInt();
                boolean encontrados=false;
                do{
                 
                    if(inpu==1) {
                   
                        do{
                           
                            try{
                              encontrados=false;
                                out.println ("Introduza o nome da Cache");
                    
                              nameCache=input.lerString();
                             this.verificaNomeCache(nameCache);
                           }catch (CacheException e) {
                             
                               encontrados=true;
                               out.println(e.getMessage());
                             
                               out.println("Prima ENTER para continuar.");
                             
                               input.lerString();
                             
                            }
                          
                          
                        }while(encontrados);
                    
                    
                    this.geoCach.removeCacheAdmin(nameCache);
                    out.println ("Cache removida com sucesso");
                    criadas=this.geoCach.getAdmin().getCriou();
                 }
                 
                 
                 out.println ("Deseja remover mais alguma cache?");
                 out.println  ("1 -Sim ");
                 out.println  ("2 - Não");
                 remove=input.lerInt();

               }while(remove==1 && (criadas.size()!=0));
                
             }
              limpaTerminal();
              out.println("Prima Enter para continuar");
              input.lerString();
              
              break;
              
              case 3:
              int idz=0;
              int cont,esc;
              String nameCach="";
              String nomeCreador="";
               out.println("===============Remover caches reportadas================");
                out.println("ID - Nome -         Nome do criador ");
               HashMap<String,Cache> reportadas= this.geoCach.getReport();
               
               if(reportadas.size()==0) {
                    out.println ("Não existe caches reportadas");  
                    out.println("\n\nPrima ENTER para continuar.");
                    input.lerString();
                    break ;
                }
                else {
                
                    for(Cache cache :reportadas.values()) {
                 
                    idz++; 
                    out.println(idz+ "    "+cache.getNomeCache() + "                     " +  cache.getNomeCriador());
                }
                
                do {
                  out.println("\n");
                  out.println ("2 - Remover cache");
                  out.print (menu.MenuVerDetalhesCache()+"\n");
                  esc=input.lerInt();
                }while(esc!=1 && esc!=0 && esc!=2); 
                
                if(esc==1) {
                 out.println("Insira o id:");
                 idz=input.lerInt();
                 Cache b =null;
                 cont=1;
                 
                  for(Cache cache :reportadas.values()) {
                   b = (Cache) cache;
                   
                   if(idz<=cont) {
                    
                    break;
                    }
                   cont++;
                    }
                     limpaTerminal();
                     out.println(b);
                     out.println("Prima ENTER para continuar.");
                     input.lerString();
                    
                    
                  }
                
                
                  else {
                   if(esc==2) {
                   do{
                   boolean achado=false;
                    
                    
                   do {
                     try{   
                          achado=false; 
                        
                          out.println ("Introduza o nome da Cache");
                          nameCach=input.lerString();
                          this.verificaNomeReport(nameCach);
                      }catch(CacheException e)
                      { 
                        achado=true;
                        out.println (e.getMessage());
                        out.println("Prima ENTER para continuar.");
                        input.lerString();
                        }
                    
                     }while(achado);
                  
                  
                    this.geoCach.removeReportCache(nameCach);
                    out.println ("Cache removida com sucesso");
                    reportadas=this.geoCach.getReport();
                   
                 
                 
                   out.println ("Deseja remover mais alguma cache?");
                   out.println  ("1 -Sim ");
                   out.println  ("2 - Não");
                   remove=input.lerInt();

                  }while(remove==1 && (reportadas.size()!=0));
                  
                 }
                  
                  
               }   
            
            }
            
             if(reportadas.size()==0) {
                 limpaTerminal();
                  out.println("Não existem mais caches para eliminar");
                  out.println("Prima Enter para continuar");
                  input.lerString();
                }
            
                else {
                limpaTerminal();
                 out.println ("As restantes caches irão voltar para o sistema");
                 for(Cache caches :reportadas.values()) {
                    String emailDo = caches.getNomeCriador();
                    
                    if(emailDo.equals("admin@gmail.com")) {
                        this.geoCach.inserCacheAdmin(caches.getNomeCache());
                    }
                     
                     else {this.geoCach.inserCacheReportada(caches.getNomeCriador(),caches.getNomeCache());}
                    
                    }
                  out.println("Prima Enter para continuar");
                  input.lerString();
                
                
                }
            break;
            
            case 4:
            int ide=0;
            int esck;
            out.println("=======Consultar Caches criadas===============");
            out.println("ID -    Tipo de Cache ");
            HashMap<String,Cache> criadasAdmin = this.geoCach.getAdmin().getCriou();
            
             for(Cache cach : criadasAdmin.values()) {
                ide++;
                 out.println (ide +"   " +  cach.getTipo());
                 
          
                }
             
                do {
                
                    out.println("\n");
                    out.println(menu.MenuVerDetalhesCache());
                    esck = input.lerInt();
                
                }while(esck !=1 && esck !=0);
                
                if(esck==1) {
                  
                    out.print("Insira o id:   ");
                     int conta=1;
                    ide=input.lerInt();
                    Cache ccc =null;
                    for(Cache cacH : criadasAdmin.values()) {
                     ccc=(Cache) cacH;
                     if(ide<=conta) {
                        break;
                        }
                     conta++;
                    
                    }
                    
                    limpaTerminal();
                    out.println(ccc);
                    out.println ("Prima Enter para continuar\n");
                    input.lerString();
                }
            
            break;
            
            case 0:
            return;
                
            default:
                    out.println("\nOpcão Inválida! \nPrima Enter para continuar");
                    input.lerString();
                    limpaTerminal();
            
            
          }
          

          
          
        }

    }
    
    public void menuLogin() throws IOException,CredenciaisException,UtilizadorException,ParseException,ClassNotFoundException,EmailExisteException,AmizadeException
    
    {
        out.println("====================== Login Utilizador ==========================");
        out.print("Email: "); String email = input.lerString();
        
        if(this.geoCach.getUtilizador().containsKey(email)) {
        
            out.print("Password: "); String password = input.lerString();
        
            if(this.geoCach.getUtilizador().get(email).getPw().equals(password)) {
        
                this.user=this.geoCach.getUtilizador().get(email);
        
        }
        
        else {
              throw new  CredenciaisException("A password que introduziu esta  errada.");
 
        }
        
       }
       else {
            throw new CredenciaisException("O email não existe");
            
            }
            
        }

    public void cachesUser() throws IOException,CoordenadaException,CacheException,ClassNotFoundException
    {
      int opcao=-1;

      while(opcao !=0) {
           limpaTerminal();
           out.println (menu.MenuCache());
           opcao=input.lerInt();
          
          
          switch(opcao){
            
            case 1:
            String nomeCachess="";
              int ide=0;
            int esck;
            out.println("=======Consultar Caches encontradas===============\n");
            out.println("ID -    Tipo de Cache -     Nome da Cache ");
            HashMap<String,Cache> encontradas = this.geoCach.getUtilizadorByEmail(this.user.getEmail()).getCache();
            
             for(Cache cach : encontradas.values()) {
                ide++;
                 out.println (ide +"     " +  cach.getTipo() + "                           " +cach.getNomeCache());
                 
          
                }
             try{
                do {
                
                    out.println("\n");
                    out.println("2 - Remover cache");
                    out.println(menu.MenuVerDetalhesCache());
                    esck = input.lerInt();
                
                }while(esck !=1 && esck !=0 && esck !=2);
                
                if(esck==1) {
                  
                    out.print("Insira o id:   ");
                     int conta=1;
                    ide=input.lerInt();
                    Cache ccc =null;
                    for(Cache cacH : encontradas.values()) {
                     ccc=(Cache) cacH;
                     if(ide<=conta) {
                        break;
                        }
                     conta++;
                      
                    }
                    
                    limpaTerminal();
                    out.println(ccc);
                    out.println ("Prima Enter para continuar\n");
                    input.lerString();
                }
               else {
                   if(esck==2) {
                    
                      out.print ("Insira o nome da cache que quer remover :        ");
                      nomeCachess=input.lerString();
                      this.verificaCacheEncontradaRemove(nomeCachess);
                      this.geoCach.removeCacheEncontrada(this.user.getEmail(),nomeCachess);
                      out.println("Cache encontrada removida com sucesso");
                      out.println ("Prima Enter para continuar\n");
                      input.lerString();
                      
                    }
              
                }
            }catch(CacheException e)
            {
             out.println(e.getMessage());
             out.println ("Prima Enter para continuar\n");
                      input.lerString();
             
            }
            break;
            
            
            case 2 :
            int esk;
            int mes,ano;
            
                        do {
                            out.println("Ver Estatísticas por Mês ou por Ano?");
                            out.println("1 - Mês");
                            out.println("2 - Ano");
                            out.print("Opção: ");
                            esk = Integer.parseInt(input.lerString());
                        } while (esk != 1 && esk != 2);
                        
                        if(esk==1) {
                            out.println("Indique o mês que quer ver (0-Dezembro-1 - Janeiro, 2 - Fevereiro, ..., 11-Novembro): ");
                            mes = Integer.parseInt(input.lerString());
                            limpaTerminal();
                            String res =this.geoCach.estatisticaCacheMensal(this.user.getEmail(),mes);
                            out.println(res);
                            out.println("\n\nPrima ENTER para continuar.");
                            input.lerString();
                          
                        }
                        
                        if (esk == 2) {
                            out.print("\nIndique o ano que quer ver: ");
                            ano = Integer.parseInt(input.lerString());
                            String res =this.geoCach.estatisticaCacheAnual(this.user.getEmail(),ano);
                            out.println(res);
                            out.println("\n\nPrima ENTER para continuar.");
                            input.lerString();
                        }
            break;
            
           
            case 3: 
            int id=0;
            int t;
            String nomeCache="";
            String criadorCache="";
            boolean nomeCa=false;
            boolean email=false;
            out.println("==========Report abuse============");
            out.println ("=====Caches existentes no sistema==========");
            out.println ("Tipo - Nome da Cache - Criador da cache  ");
              HashMap<String,Cache> cachesExistentes= this.geoCach.getCache();
              
              for(Cache fr : cachesExistentes.values()) {
                id++;
                 out.println (fr.getTipo() +"     "+  fr.getNomeCache() + "       " + fr.getNomeCriador());
                }
              
                if(cachesExistentes.size()==0) {
                     out.println ("Não existem caches para reportar");  
                    out.println("\n\nPrima ENTER para continuar.");
                    input.lerString();
                    break ;
                }
              
                else {
                
              do{  
                out.println("Quer fazer report de alguma");
                out.println ("1 - Sim");
                out.println ("2 - Não");
                t=input.lerInt();
              }while(t!=1 && t!=2 && cachesExistentes.size()!=0 );
              
                if(t==1) {
                  
                    do{
                        try{
                        nomeCa=false;
                        out.print ("Introduza o nome da cache:        ");
                   
                        nomeCache=input.lerString();
                        this.verificaNomeCache(nomeCache);
                     }catch(CacheException e) 
                     {
                        nomeCa=true;
                         out.println(e.getMessage());
                         out.println("Prima ENTER para continuar.");
                          input.lerString();
                        
                        
                      }
                        
                   }while(nomeCa);
                 
                  do{ 
                      try{
                      email=false;
                      out.print ("Introduza o email do criador :     ") ;
                   
                      criadorCache=input.lerString();
                      if(criadorCache.equals("admin@gmail.com")) {
                        email=false;
                        }
                      else {this.verificaEmail(nomeCache,criadorCache);}
                      
                     }catch(CacheException e) {
                         email=true;
                         out.println(e.getMessage());
                         out.println("Prima ENTER para continuar.");
                         input.lerString();
                        }
                   
                  }while(email); 
                  try{
                  
                      if(criadorCache.equals("admin@gmail.com")) {
                          this.verificaAdmin(nomeCache);
                    
                          this.geoCach.reportAbuseAdmin(nomeCache);
                    
                          cachesExistentes= this.geoCach.getCache();
                    
                          out.println ("Cache reportada com sucesso");
                    
                          out.println("Prima ENTER para continuar.");
                    
                          input.lerString();
                     }
                     
                     
                     else 
                  
                     {
                      this.verificaCriaste(nomeCache);
                      this.geoCach.reportAbuse(nomeCache,criadorCache);
                      cachesExistentes= this.geoCach.getCache();
                      out.println ("Cache reportada com sucesso");
                      out.println("Prima ENTER para continuar.");
                      input.lerString();
                    }
                    
                }
                    
                    
                    catch(CacheException e){
                      out.println(e.getMessage());
                      out.println("Prima ENTER para continuar.");
                      input.lerString();
                    
                    } 
                  
 
                
                
                }
            
            }
            break;

            case 4: 
              out.print("===============Caches criadas==============================\n");
              id=0;
                 HashMap<String,Cache> criadas = this.geoCach.getUtilizadorByEmail(this.user.getEmail()).getCriou();
                 out.println ("==========Caches Criadas ==============\n");
                 out.println ("ID  - nome da Cache");
                 for(Cache ola :criadas.values()){
                     id++;
                     out.println (id +"   "+ola.getNomeCache());
                    
                    }
                 opcao=-1;
               int esd=-1;
               do {
                   out.println("\n");
                   out.println("O que deseja fazer?");
                   out.println("1 - Ver cache");
                   out.println("2 - Remover cache");
                   out.println("0 - Voltar atras");
                   opcao=input.lerInt();
  
                }while(opcao!=1 && opcao!=2 && opcao!=0);
                
                if(opcao==1) {

                    do{
                       out.println("\n");
                       out.println(menu.MenuVerDetalhesCache());
                       esd=input.lerInt();
                   }while(esd!=0&& esd!=1);
                  
                   if(esd==1){
                       out.print("Insira o id:   ");
                       id=input.lerInt();
                       Cache d=null;
                       int contar=1;
                       
                       for(Cache ca : criadas.values()) {
                           d=(Cache) ca;
                           if(id<=contar) {
                            break;
                            }
                          contar++;
                        }
                       limpaTerminal();
                       out.println(d);
                       out.println("Prima ENTER para continuar.");
                       input.lerString();
                    
                    }
                }
                 
                 else { 
                    if(opcao==2)
                    {
                      
                    out.println ("==========Remover caches ==============");
                    out.println ("ID  - nome da Cache");
                    id=0;
                    String nome="";
                    boolean encontrado=false;
                 
                    for(Cache ola :criadas.values()){
                     id++;
                     out.println (id +"   "+ola.getNomeCache());
                    
                    }
                    do{
                        try{
                        encontrado=false;
                        out.println("Introduza o nome da cache que quer remover");
                        nome=input.lerString();
                        this.verificaCacheCriada(nome);
                       }catch(CacheException e) {
                         encontrado=true;
                         out.println(e.getMessage());
                         out.println("Prima Enter para continuar");
                         input.lerString();
                         
                        
                        }
                    
                    }while(encontrado && !(nome.equals("")));
                    
                    this.geoCach.removeCacheUtilizador(nome,this.user.getEmail());
                    out.println("Cache removida com sucesso");
                    out.println ("Prima Enter para continuar");
                    input.lerString();
                   
                }

              }
                break;
                

                
                case 5:
                id=0;
                out.println("===============Caches existente no Sistema=======================");
                HashMap<String,Cache> cachesDoSistema= this.geoCach.getCache();
                out.println ("ID  -  Tipo da Cache  -  Email do criador");
                out.println ("----------------------------------------------");
                  for(Cache u :cachesDoSistema.values()){
                      id++;
                      out.println(id + "    "+ u.getTipo() + "      " +u.getNomeCriador() );
                }
                
                int esc=-1;
                int idz;
               
                do{
                    out.println("\n");
                    out.print(menu.MenuVerDetalhesCache());
                    esc=input.lerInt();
                }while(esc!=1 && esc!=0);
                
                if(esc==1){
                    out.print("Insira o id :  ");
                    idz=input.lerInt();
                   
                    Cache u =null;
                    int cont=1;
                    for(Cache caches :cachesDoSistema.values()){
                    
                        u=(Cache)caches;
                        if(idz<=cont){
                        break;
                        }
                    
                      else { cont++;}
                    }
                    
                    
                    limpaTerminal();
                     out.println(u);
                     out.println("Prima ENTER para continuar.");
                    input.lerString();
                    
                
                }
     
            break ;
              case 0:
              return ;
              default: out.println("\nOpcao Invalida! \nPrima Enter para continuar");
                               input.lerString();
                               limpaTerminal();
            
            }

        }
  
    }
    
    
    
    
    
    
    public void menuUser() throws IOException,CredenciaisException,UtilizadorException,ParseException,ClassNotFoundException,EmailExisteException,AmizadeException,CoordenadaException
    ,CacheException,ActividadeException
    {
    
       int opcao=-1;
       while(opcao!=0) {
        limpaTerminal();
        out.println( menu.MenuClienteLogado(this.user.getNome()));
        opcao=Integer.parseInt(input.lerString());
        switch (opcao) {
        
            case 1:
                 limpaTerminal();
                 out.println(this.user);
                 out.println("Prima enter para voltar atrás");
                 input.lerString();
                 break;
        
             case 2:
             
                  this.amigos();
                  break;
             
              case 3: try {
                      this.actividades();
                     } catch (ClassNotFoundException e) {
                        
                        }     
                        break;
                      case 4: gravaObjS();
                      break;
                      
                      case 5:
                     
                      try{
                        this.cachesUser();
                        
                        }catch (ClassNotFoundException e){}
                      break;
                      
                      
                      case 6:
                      try{
                      this.verPedidos();
                    } catch (AmizadeException e){
                        out.println(e.getMessage());
                    
                    }
                    out.println("Prima enter para voltar atrás");
                    input.lerString();
                    
                    break;
                    
                    case 7: 
                    try{
                      this.enviarPedido();
                    } catch (AmizadeException e){
                        out.println(e.getMessage());
                        out.println("Prima ENTER para continuar");
                        input.lerString();
                    
                    } catch(UtilizadorException ee){
                        out.println(ee.getMessage());
                        out.println("Prima ENTER para continuar");
                        input.lerString();
                    }
                    
                    out.println("Prima ENTER para continuar");
                    input.lerString();
                    break;
                    
                      
                      case 0:
                      return ;
                       default: out.println("\nOpcao Invalida! \nPrima Enter para continuar");
                               input.lerString();
                               limpaTerminal();
        
        
        }

        }

    }
    
    
    public void amigos() throws AmizadeException,IOException,CredenciaisException,UtilizadorException,ParseException,ClassNotFoundException,EmailExisteException
    
    {
        int opcao=-1;
        while(opcao!=0) {
        
            limpaTerminal();
            out.print(menu.MenuAmigos());
            opcao=Integer.parseInt(input.lerString());
           switch(opcao) {
            
               case 1:
                this.verListaAmigos();
                out.println("\n Prima enter para continuar");
                input.lerString();
                break;
                case 2:
                limpaTerminal();
                try{
                    this.adicionaAmigo();
                }  catch(UtilizadorException e){
                        out.println(e.getMessage());
                        out.println("Prima ENTER para continuar");
                        input.lerString();
                    } catch(AmizadeException ee){
                        out.println(ee.getMessage());
                        out.println("Prima ENTER para continuar");
                       input.lerString();
                    }
                    
            
               break;
                  case 3:
                  limpaTerminal();
                  try{
                    this.removeAmigo();
    
                     }catch(AmizadeException ee){
                        out.println(ee.getMessage());
                        out.println("Prima ENTER para continuar");
                       input.lerString();
                    }
                break;
                case 4:
                
                limpaTerminal();
                int op=-1;
              
                String amigo="";
                  try {
                      while(op!=0) {
                        
                          amigo=this.consultaActividadesAmigo();
                          TreeSet<Actividade> actividades = this.geoCach.getUtilizadorByEmail(amigo).getActividades();
                          limpaTerminal();
                          
                           out.println("A consultar atividades mais recentes de " + this.geoCach.getUtilizadorByEmail(amigo).getNome() + ": ");
                                out.println("-----------------------------------------------------------------");
                                out.println("ID - Tipo        -        Duração        -        Data");
                                out.println("-----------------------------------------------------------------");
                           Iterator itz = actividades.iterator();
                        
                           int cont=0;
                           int id=0;

                           while(itz.hasNext()&&cont<10) {
                            Actividade a =(Actividade)itz.next();
                            id++;
                             int mes=a.getData().get(Calendar.MONTH)-1;
                             int ano=a.getData().get(Calendar.YEAR);
                             int dia =a.getData().get(Calendar.DAY_OF_MONTH);
                             GregorianCalendar calz = new GregorianCalendar(ano,mes,dia);
                             
                             SimpleDateFormat formated = new SimpleDateFormat("d/MMM/yyyy");
                             String dddd = formated.format(calz.getTime());
                             
                            out.println(id+ "  " + a.getTipo() + "            " + a.getDuracao() + "                   " + dddd);
                            cont++;
                            
                            }
                           out.println("-----------------------------------------------------------------");

                         int esc = -1;
                         int idz;
                                do {
                                    out.println("\n");
                                    out.print(menu.MenuVerDetalhesAtividade());
                                    esc = Integer.parseInt(input.lerString());
                                } while (esc != 1 && esc != 0);
                         
                                if(esc==1) {
                                out.print("Insira o id");
                                idz= Integer.parseInt(input.lerString());
                                int contz=0;
                                Actividade b =null;
                                itz=actividades.iterator();
                                
                                while (itz.hasNext() && contz < idz) {
                                        b = (Actividade)itz.next();
                                        cont++;
                                        
                                    }
                                    limpaTerminal();
                                    out.println(b);
                                    out.println("Prima ENTER para continuar.");
                                    input.lerString();
                            }
                        
                           

                        }
                      

                    }catch (UtilizadorException e) {
                            out.println(e.getMessage());
                            out.println("Prima ENTER para continuar.");
                            amigo = "";
                            input.lerString();
                        } catch (AmizadeException ee) {
                            out.println(ee.getMessage());
                            out.println("Prima ENTER para continuar.");
                            amigo = "";
                            input.lerString();
                        }
                break;
              
               case 5:
               
                limpaTerminal();
                String amigos="";
                try{
                  amigos=this.consultaEstatisticaAmigo();
                  int opc=-1;
                  int mes=-1;
                  int ano=-1;
                  
                  do {
                            out.println("Ver Estatísticas por Mês ou por Ano?");
                            out.println("1 - Mês");
                            out.println("2 - Ano");
                            out.print("Opção: ");
                            opc = input.lerInt();
                        } while (opc != 1 && opc != 2);
                        
                        if (opc == 1) {
                            out.println("Indique o mês que quer ver (0 - Dezembro ,1 - Janeiro, 2 - Fevereiro, ..., 11- Novembro): ");
                            mes = input.lerInt();
                            limpaTerminal();
                            String res =this.geoCach.estatisticaMensal(amigos,mes);
                            out.println(res);
                            out.println("\n\nPrima ENTER para continuar.");
                            input.lerString();
                          
                        }
                        
                        if (opc == 2) {
                            out.print("\nIndique o ano que quer ver: ");
                            ano = Integer.parseInt(input.lerString());
                            String res =this.geoCach.estatisticaAnual(amigos,ano);
                            out.println(res);
                            out.println("\n\nPrima ENTER para continuar.");
                            input.lerString();
                        }
                        
                       
                        
                 } catch (UtilizadorException e) {
                        out.println(e.getMessage());
                        out.println("Prima ENTER para continuar.");
                        amigo = "";
                        input.lerString();
                    } catch (AmizadeException ee) {
                        out.println(ee.getMessage());
                        out.println("Prima ENTER para continuar.");
                        amigo = "";
                        input.lerString();
                    } 
               
               
               
               break;
            
               case 6:  
               limpaTerminal();
                int oppp=-1;
               
                String amigoEscolhido="";
               
               try{
                   while(oppp!=0) {
                    
                     amigoEscolhido=this.consultaCacheAmigo();
                     HashMap<String,Cache> cache= this.geoCach.getUtilizadorByEmail(amigoEscolhido).getCache();
                     limpaTerminal();
                     out.println("A consulta das caches mais recentes encontradas pelo: " +this.geoCach.getUtilizadorByEmail(amigoEscolhido).getNome() + ":");
                     out.println("---------------------------------------------------------------------------");
                     out.println("ID  -  Nome da cache -   Tipo de cache    - Data que a encontrou");
                     out.println("---------------------------------------------------------------------------");
                     
                     int cont=0;
                     int id=0;
                     
                    for(Cache a :cache.values()) {
                        
                        id++;
                             int mes=a.getData().get(Calendar.MONTH)-1;
                             int ano=a.getData().get(Calendar.YEAR);
                             int dia =a.getData().get(Calendar.DAY_OF_MONTH);
                             GregorianCalendar calz = new GregorianCalendar(ano,mes,dia);
                             
                             SimpleDateFormat formated = new SimpleDateFormat("d/MMM/yyyy");
                             String dddd = formated.format(calz.getTime());
                        
                        if(cont<10) 
                        {
                       out.println(id+"       " + a.getNomeCache()+ "          "  + a.getTipo() + "            " + dddd);
                       cont++;
                      }

                    else break;
                
                   }
                     out.println("----------------------------------------------------------------");
                     int esc=-1;
                     int idz;
                     
                     do {
                          out.println("\n");
                          out.print(menu.MenuVerDetalhesCache());
                          esc = Integer.parseInt(input.lerString());
                        } while (esc != 1 && esc != 0);
                    
                     if(esc==1) {
                        out.print("Insira o id\n");
                        idz=Integer.parseInt(input.lerString());
                        Cache b=null;
                        cont =1;
                      
                        
                        for(Cache u : cache.values()) {
                             b = (Cache)u;
                            if(idz<=cont) {
                              break;
                            
                            }
                            cont ++;
                         }
                        
                        limpaTerminal();
                        out.println(b);
                        out.println("Prima ENTER para continuar");
                        input.lerString();
                    }
                    
               
                }
                }catch (UtilizadorException e) {
                            out.println(e.getMessage());
                            out.println("Prima ENTER para continuar.");
                            amigo = "";
                            input.lerString();
                        } catch (AmizadeException ee) {
                            out.println(ee.getMessage());
                            out.println("Prima ENTER para continuar.");
                            amigo = "";
                            input.lerString();
                        }
               break;
            
            
              case 7: limpaTerminal();
                     String amigoEs="";
                     try{
                        amigoEs=this.consultaCacheEstatistica();
                        int esk = -1;
                        int mes = -1;
                        int ano = 0;
                        
                        do {
                            out.println("Ver Estatísticas por Mês ou por Ano?");
                            out.println("1 - Mês");
                            out.println("2 - Ano");
                            out.print("Opção: ");
                            esk = Integer.parseInt(input.lerString());
                        } while (esk != 1 && esk != 2);
                        
                        if(esk==1) {
                            out.println("Indique o mês que quer ver (0 - Dezembro ,1 - Janeiro, 2 - Fevereiro, ..., 11- Novembro): ");;
                            mes = Integer.parseInt(input.lerString());
                            limpaTerminal();
                            String res =this.geoCach.estatisticaCacheMensal(amigoEs,mes);
                            out.println(res);
                            out.println("\n\nPrima ENTER para continuar.");
                            input.lerString();
                          
                        }
                        
                        if (esk == 2) {
                            out.print("\nIndique o ano que quer ver: ");
                            ano = Integer.parseInt(input.lerString());
                            String res =this.geoCach.estatisticaCacheAnual(amigoEs,ano);
                            out.println(res);
                            out.println("\n\nPrima ENTER para continuar.");
                            input.lerString();
                        }

                     } catch (UtilizadorException e) {
                        out.println(e.getMessage());
                        out.println("Prima ENTER para continuar.");
                        amigo = "";
                        input.lerString();
                    }   catch (AmizadeException ee) {
                        out.println(ee.getMessage());
                        out.println("Prima ENTER para continuar.");
                        amigo = "";
                        input.lerString();
                    } 
              break;
              
              case 8:
              limpaTerminal();
              String amigoss="";
              try {
                amigoss=this.consultaCacheAmigoCriada();
                HashMap<String,Cache> criadas = this.geoCach.getUtilizadorByEmail(amigoss).getCriou();
                limpaTerminal();
                out.println("Consular as caches cridas pelo amigo " + this.geoCach.getUtilizadorByEmail(amigoss).getNome() + ":");
                out.println("------------------------------------------------------------------------------------");
                out.println("ID   -       Tipo    \n ");
               
                int cont=0;
                int id=0;
                  for(Cache a :criadas.values() ){
                    if(cont<10){
                    id++;
                    out.println(id + "   "+ a.getTipo() + "    " + "\n" + "Local"+a.getCoord().toString() );
                    cont++;
                  }
                  else break ;
                  }
                   int esc=-1;
                   int idz;
                
                    do {
                          out.println("\n");
                          out.print(menu.MenuVerDetalhesCache());
                          esc = Integer.parseInt(input.lerString());
                        } while (esc != 1 && esc != 0);
                    
                     if(esc==1) {
                        out.print("Insira o id\n");
                        idz=Integer.parseInt(input.lerString());
                        Cache b=null;
                        cont =1;

                        
                        for(Cache u : criadas.values()) {
                             b = (Cache)u;
                            if(idz<=cont) {
                                
                                break;
                            
                            }
                            cont ++;
                         }
                        
                       limpaTerminal();
                       out.println(b);
                       out.println("Prima ENTER para continuar.");
                       input.lerString();
                   }   
                } catch (UtilizadorException e) {
                         out.println(e.getMessage());
                        out.println("Prima ENTER para continuar.");
                        amigo = "";
                        input.lerString();
                    }   catch (AmizadeException ee) {
                        out.println(ee.getMessage());
                        out.println("Prima ENTER para continuar.");
                        amigo = "";
                        input.lerString();
                
                    }

              break;
              
              case 0:
                return;
                default:
                    System.out.println("\nOpcão Inválida! \nPrima Enter para continuar");
                    input.lerString();
                    limpaTerminal();
            
            
            
            }
        
        
        
        }
    
    }
 
    public void registo() throws IOException,UtilizadorException,ParseException,ClassNotFoundException,EmailExisteException,CredenciaisException,AmizadeException,CoordenadaException
    ,CacheException,ActividadeException
    {
        int ano,mes,dia;
        out.println("=========== Novo Utilizador ===========");
        out.print("Email: "); String email = input.lerString();
        
        while((geoCach.getUtilizador().containsKey(email)) || email.equals("")) {
          out.println(" Por fazor introduza um email diferente, ou escreva 'Sair' para voltar ao menu inicial");
          out.println ("Email :");
          email=input.lerString();
          
          if(email.equals("Sair")) {
            this.inicial();
            
            }
        
        }
        
        
        
        out.println("Password: (Min 5 caracters) "); String password = input.lerString();
        
        while(password.equals("") || password.length()<5) {
          out.println("Não tem os caracters minimos permitidos\n");
          out.println("Password: (Min 5 caracters) "); 
           password = input.lerString();
        
        
        }
        
        
        
        out.print("Nome: "); String nome = input.lerString();
        
        while(nome.equals("")) {
        out.println("Nome :");
        nome = input.lerString();
        
        
        }
        
        
        out.println("Genero: "); String genero;
        
          do{
            out.println("1 - Masculino");
            out.println("2 - Feminino");
            out.print("Opção: ");
            genero = input.lerString();
        } while(!(genero.equals("1") || genero.equals("2")));
        
        if(genero.equals("1")) { 
            genero = "Masculino";
        } 
        else { 
            genero ="Feminino"; 
        }
         
         out.println("Data de Nascimento: ");
        
        out.println("Ano: ");
        
        ano = input.lerInt();
        
        while (ano > 2015 || ano < 1850) {
            out.println("\nERRO: Input invalido.");
            out.println("Ano: ");
            ano = input.lerInt();
        }
        
         out.println("Mês: ");
        
        mes = input.lerInt();
        
        while (mes > 12 || mes <= 0) {
            out.println("\nERRO: Input invalido.");
            out.println("Mês: ");
            mes =input.lerInt();
        }
        
        out.println("Dia: ");
        
        dia = input.lerInt();
        
        if (mes == 2 && (( ((ano % 4) == 0) && (ano % 100 != 0) ) || ((ano % 400) == 0))){
            while (dia > 29 || dia <= 0) {
             out.println("\nERRO: Input invalido.");
             out.println("Dia: ");
            dia = input.lerInt();
            }
        }
        
            else { 
                if (mes == 2) {
                    while (dia >= 29 || dia <= 0){
                        out.println("\nERRO: Dia invalido.");
                        out.println("Dia: ");
                        dia = input.lerInt();
                    }
                   }
        
                   else { 
                       if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            
                    while (dia > 31 || dia <= 0){
                        out.println("\nERRO: Dia invalido.");
                        out.println("Dia: ");
                        dia = input.lerInt();
                    }
                }
        
                    else 
                    while (dia > 30 || dia <= 0){
                         out.println("\nERRO: Dia invalido.");
                         out.println("Dia: ");
                        dia = input.lerInt();
                    }
                }
            }
                    
         out.println("Morada");
         String morada = input.lerString();
         
         while(morada.equals("")) {
            out.println ("Introduza outra vez a morada:");
            out.println("Morada");
            morada = input.lerString();
            
            
            }
           
           if(geoCach.getUtilizador().containsKey(email)) {
            throw new EmailExisteException("O email já existe no sistema");
            
            } 
            
            Utilizador u = new Utilizador(email,password,nome,genero,morada,dia,mes,ano);
            this.geoCach.adicionaUtilizador(u);
                    
                    
    }
        

    public void inicial() throws IOException,CredenciaisException,UtilizadorException,ParseException,ClassNotFoundException,EmailExisteException,AmizadeException,CoordenadaException
    ,CacheException,ActividadeException
    {
        int opcao =-1;
        
       
        
        while(opcao !=0) {
        
         out.print(menu.MenuPrincipal());
         opcao=input.lerInt();
         
         switch(opcao) {
            
            case 1:
              try { 
                this.limpaTerminal();
                this.registo();
                out.println("Registado com Sucesso!\n\n Prima enter para continuar!");
                }
              catch (UtilizadorException e){
                out.println(e.getMessage());
                
                }
             input.lerString();
                this.limpaTerminal();
             
             break;
            
             case 2:
                    try{
                    this.limpaTerminal();
                    this.menuLogin();
                    this.menuUser();
                } catch(CredenciaisException e) {
                
                    out.println(e.getMessage());
                    input.lerString();
                }
                 this.limpaTerminal();
             break;
             
             case 3:
                    leObjS();
                break;
                case 4:
                try{
                this.limpaTerminal();
                this.menuLoginAdmin();
                this.menuAdmin();
               }catch(CredenciaisException e) {
                
                    out.println(e.getMessage());
                    input.lerString();
                }
                 this.limpaTerminal();
                break;
                
                case 0:
                    System.exit(0);
                default:
                    System.out.println("\nOpcao Invalida! \nPrima Enter para continuar");
                   input.lerString();
                    limpaTerminal();
            
            }

        }
    }
    
    
    public void actividades() throws IOException,UtilizadorException,ParseException,ClassNotFoundException,EmailExisteException,CredenciaisException,AmizadeException,CoordenadaException
    ,CacheException,ActividadeException
    
    {
        
        int opcao=-1;
        
        while(opcao!=0) {
         
             limpaTerminal();
            out.println(this.menu.MenuAtividades());
            
             opcao=input.lerInt();
            switch(opcao) {
          
                case 1:
                limpaTerminal();
                out.println("===================Escolha uma actividade====================");
                
                TreeSet<String>lista=this.geoCach.getListaActividades();
                int op=-1;
                int opc=1;
                 for(String a :lista) {
                    
                    out.println(opc + "  " +a );
                    opc++;
                    
                    }
                    out.print("0 - voltar atras\n");
                    out.print("\nOpção   ");
                    op=input.lerInt();
                    String ativid="";
                     Iterator it = lista.iterator();
                    int x=0;
                    while(it.hasNext() && x<op){
                     ativid=(String)it.next();
                     x++;
                    }
                    
                    limpaTerminal();
                    out.println("Novo registo de " + ativid + "preencha os campos : \n");
                    String tipo="";
                    String tempo="";
                    int duracao=0;
                    GregorianCalendar d=new GregorianCalendar();
                    int escolhaDoTempo=0;
                    
                    
                    switch(op){
                        case 1:
                        limpaTerminal();
                        tipo="Esconder cache";
                        Cache cache = this.criaCache();
                        
                        do{
                            out.print("Introduza a duracão desta actividade (min):          ");
                            duracao=input.lerInt();
                        }while(duracao==0);
                        
                        do{
                        out.println(menu.meteorologia());
                        escolhaDoTempo=input.lerInt();
                       
                       }while(escolhaDoTempo<0 || escolhaDoTempo>3 );
                        
                       if(escolhaDoTempo==1) {
                            tempo="Sol";
                        }
                        else {
                            if(escolhaDoTempo==2) { tempo="Chuca";}
                            else tempo="Vento";  
                        }
                        
                        this.geoCach.adicionarActividadeEsconder(duracao,cache.getCoord(),cache.getTipo(),cache.getTamanho(),cache.getDataInserida(),cache.getTipo(),
                         tempo,this.user.getEmail());
                         
                        
                        break;
                        
                        case 2: //evento;
                        
                        break;
                        case 3: 
                        int prova;
                        int mes=0;
                        int dia=0;
                        int ano=0;
                       
                        limpaTerminal();
                        tipo="Lazer";
                        
                        out.println("Neste tipo de actividade é costume o utilizador deixar uma prova ou seja criar uma cache\n");
                        
                        out.println("Deseja criar uma cache como prova que esteve nesse lugar?");
                        out.println("1 - Sim");
                        out.println("2 - Não");
                        op=input.lerInt();
                        
                        if(op==1){
                        Cache u = this.criaCache();
                         
                        do{
                            out.print("Introduza a duracão desta actividade (min):          ");
                            duracao=input.lerInt();
                        }while(duracao==0);
                        
                         do{
                        out.println(menu.meteorologia());
                        escolhaDoTempo=input.lerInt();
                       
                        }while(escolhaDoTempo<0 || escolhaDoTempo>3 );
                        
                       if(escolhaDoTempo==1) {
                            tempo="Sol";
                        }
                        else {
                            if(escolhaDoTempo==2) { tempo="Chuca";}
                            else tempo="Vento";  
                        }
                        
                        this.geoCach.adicionarActividadeLazer(tipo,tempo,u.getDataInserida(),u.getCoord(),duracao,this.user.getEmail());
                      }
                        
                      else {
                          
                        do{
                            out.print("Introduza a duracão desta actividade (min):          ");
                            duracao=input.lerInt();
                        }while(duracao==0);
                        
                         do{
                        out.println(menu.meteorologia());
                        escolhaDoTempo=input.lerInt();
                       
                        }while(escolhaDoTempo<0 || escolhaDoTempo>3 );
                        
                        if(escolhaDoTempo==1) {
                            tempo="Sol";
                        }
                        else {
                            if(escolhaDoTempo==2) { tempo="Chuca";}
                            else tempo="Vento";  
                        }
                        
                         out.println("Inser o local que realizou esta actividade:: " );
                         Coordenada coord=this.criaCoordenada();
                        GregorianCalendar a = this.criaData();
                        this.geoCach.adicionarActividadeLazer(tipo,tempo,a,coord,duracao,this.user.getEmail());
                     
                     
                        
                         }
                      
                      
                        break;
                        
                        case 4:
                       int escolherCaminho=-1;
                       String tipoActividade="";
                       tipo="Procurar cache";
                       boolean encontrarMicro,encontrarMult,encontrarMisterio;
                       int tamanhoDoCaminho=0;
                       ArrayList<Coordenada> caminho= new ArrayList<Coordenada>();
                       String pergunta="";
                       String respostaUser="";
                       GregorianCalendar a = this.criaData();
                       boolean encontrado=false;
                       do{
                        out.println("Selecionar o tipo de procura");
                        out.println("1 - Procurar MicroCaches");
                        out.println("2 - Procurar MultCaches");
                        out.println("3 - Procurar CacheMisterio");
                        escolherCaminho=input.lerInt();
                        
                        }while(escolherCaminho!=1 && escolherCaminho!=2 && escolherCaminho!=3);
                       
                        if(escolherCaminho==1) {
                           tipoActividade="Procurar MicroCaches";
                        }
                       
                       else { 
                           if(escolherCaminho==2) {
                            tipoActividade="Procurar MultCaches";
                        }
                        else tipoActividade="Procurar CacheMisterio";
                        
                        
                        }
                       
                        do{
                         out.print("Introduza quantos lugar visitou:       ");
                         tamanhoDoCaminho=input.lerInt();
                        }while(tamanhoDoCaminho==0); 
                       
                       do{
                          out.println("Inser o local que realizou esta actividade:: " );
                           Coordenada coord=this.criaCoordenada();
                            
                           if(tipoActividade.equals("Procurar MicroCaches")) {
                            encontrarMicro=verificaSeEncontrouMicroCache(coord,a);
                             if(encontrarMicro) {
                              out.println ("Parabens descobriu uma MicroCache");
                              out.println("Prima ENTER para continuar.");
                              input.lerString();
                              encontrado=true;
                            
                            }
                            
                            }
                          else {
                              if(tipoActividade.equals("Procurar CacheMisterio")) {
                                
                                  pergunta=this.verificaSeEncontrouCacheMisterio(coord);
                                 
                                  if(!(pergunta.equals(""))) {
                                      
                                      do{
                                      out.println("Responda ao desafio para encontrar a cache final");
                                      out.print (pergunta+" :" +"       ");
                                      respostaUser=input.lerString().toLowerCase();
                                     }while(respostaUser.equals(""));
                                     
                                     Coordenada teste =verificaMisterioCache(coord,pergunta,respostaUser);
                                     
                                     if(!(teste.getLocalLatitude()==-1)) {
                                        out.println ("A coordenada final é :\n");
                                        out.println(teste);
                                        tamanhoDoCaminho++;
                                        out.println("Prima ENTER para continuar.");
                                        input.lerString();
                                        }
                                } 
                                }
                             }
                           
                           
                           caminho.add(coord);
                          tamanhoDoCaminho--;
                          }while(tamanhoDoCaminho!=0);
                        encontrarMisterio=this.verificaMisterio(caminho,a);
                        
                        if( encontrarMisterio && tipoActividade.equals("Procurar CacheMisterio")) {
                            
                            out.println("Parabens encontras-te uma cache misterio ");
                            out.println("Prima ENTER para continuar.");
                            input.lerString();
                           encontrado=true;
                        }
                        
                        else {
                            if(tipoActividade.equals("Procurar MultCaches")) {
                                encontrarMult=verificaSeEncontrouMulCache(caminho,a);
                                if(encontrarMult) {
                                out.println("Parabens encontras-te uma mult cache ");
                                out.println("Prima ENTER para continuar.");
                                input.lerString();
                                encontrado=true;
                                }
                            }
                        }
                         
                        if(encontrado==false) {out.println("Melhor sorte para a proxima vez");}
                        
                        do{
                            out.print("Introduza a duracão desta actividade (min):          ");
                            duracao=input.lerInt();
                        }while(duracao==0);
                        
                         do{
                         out.println(menu.meteorologia());
                         escolhaDoTempo=input.lerInt();
                       
                        }while(escolhaDoTempo<0 || escolhaDoTempo>3 );
                        
                        if(escolhaDoTempo==1) {
                            tempo="Sol";
                        }
                        else {
                            if(escolhaDoTempo==2) { tempo="Chuca";}
                            else tempo="Vento";  
                        }
                        
                        this.geoCach.adicionaActividadeProcura(a,tipoActividade,tempo,tipo,caminho,duracao,this.user.getEmail());
                        break;
                        
                          case 0:
                          return;
                         default:
                        System.out.println("\nOpcao Invalida! \nPrima Enter para continuar");
                        input.lerString();
                        limpaTerminal();
                        
                        
                    
                    }
   
                        out.println("\nAtividade registada com sucesso.\n");
                       out.print("Prima ENTER para continuar.");
                      input.lerString();
                      
                    
                break;
                
                case 2:
                 TreeSet<Actividade> recentes =this.geoCach.getUtilizadorByEmail(this.user.getEmail()).getActividades();
                 
                    out.println ("--------------------------------------------------------------");
                    out.println("ID - Tipo        -        Duração        -        Data");
                    out.println("-----------------------------------------------------------------");
                    Iterator itz = recentes.iterator();
                    int cont = 0;
                    int id = 0;
                     tipo="";
                    
                    GregorianCalendar date;
                     while (itz.hasNext() && cont < 10) {
                        Actividade a = (Actividade)itz.next();
                        id++;
                        int mess=a.getData().get(Calendar.MONTH)-1;
                        int anos=a.getData().get(Calendar.YEAR);
                        int dias =a.getData().get(Calendar.DAY_OF_MONTH);
                        GregorianCalendar cal = new GregorianCalendar(anos,mess,dias);
                        SimpleDateFormat formate = new SimpleDateFormat("d/MMM/yyyy");
                        String de = formate.format(cal.getTime());
                        
                        out.println(id + "   "+a.getTipo()+ "              " + a.getDuracao() + "                      " + de);
                        cont++;
                    }
                      
                    out.println("-----------------------------------------------------------------");
                    int esc = -1;
                    int idz;
                    do {
                        out.println("\n");
                        out.print(menu.MenuVerDetalhesAtividade());
                        esc = input.lerInt();
                    } while (esc != 1 && esc != 0);
                    
                    if (esc == 1) {
                        out.print("Insira o id: ");
                        idz = input.lerInt();
                        Actividade b = null;
                        cont = 0;
                        itz = recentes.iterator();
                        while (itz.hasNext() && cont < idz) {
                            b = (Actividade)itz.next();
                            cont++;
                            
                        }
                        limpaTerminal();
                        out.println(b);
                        out.print("\n"+menu.MenuRemoverAtividade());
                        int remover = -1;
                        
                        do{
                            out.print("Opção: ");
                            remover = input.lerInt();
                       } while(remover != 1 && remover != 0);
                    
                    if(remover == 1) {
                       do{
                           out.println("Insira o tipo da actividade");
                       
                           tipo=input.lerString();
                       }while(tipo.equals(""));
                       out.println("Inser a data:");
                       
                       date=this.criaData();
                        
                       this.geoCach.removeActividade(tipo,date,this.user.getEmail());
                        out.println("Actividade removida com sucesso.\nPrima ENTER para continuar.");
                        input.lerString();
                       
                    }
                   
                    
                 }
                
                break;
                
                 case 3:
                 
                  TreeSet<Actividade> completa = this.geoCach.getUtilizadorByEmail(this.user.getEmail()).getActividades();
                    out.println("-----------------------------------------------------------------");
                    out.println("ID - Tipo        -        Duração        -        Data");
                    out.println("-----------------------------------------------------------------");
                    Iterator todas = completa.iterator();
                    cont = 0;
                    id = 0;
                    
                    id = 0;
                    while (todas.hasNext() && cont < completa.size()) {
                         Actividade a = (Actividade)todas.next();
                        id++;
                        int mess=a.getData().get(Calendar.MONTH)-1;
                        int anos=a.getData().get(Calendar.YEAR);
                        int dias =a.getData().get(Calendar.DAY_OF_MONTH);
                        GregorianCalendar cal = new GregorianCalendar(anos,mess,dias);
                        SimpleDateFormat formate = new SimpleDateFormat("d/MMM/yyyy");
                        String de = formate.format(cal.getTime());
                        
                        out.println(id + "   "+a.getClass().getSimpleName()+ "              " + a.getDuracao() + "                      " + de);
                        
                    }
                    out.println("-----------------------------------------------------------------");
                    esc = -1;
                    idz = 0;
                    do {
                        out.println("\n");
                        out.print(menu.MenuVerDetalhesAtividade());
                        esc = input.lerInt();
                    } while (esc != 1 && esc != 0);
                    
                    if (esc == 1) {
                        out.print("Insira o id: ");
                        idz = input.lerInt();
                        Actividade b = null;
                        cont = 0;
                        itz = completa.iterator();
                        while (itz.hasNext() && cont < idz) {
                            b = (Actividade)itz.next();
                            cont++;
                        }
                        limpaTerminal();
                        out.println(b);
                        out.print("\n"+menu.MenuRemoverAtividade());
                        int remover = -1;
                        
                        do{
                            out.print("Opção: ");
                            remover = input.lerInt();
                       } while(remover != 1 && remover != 0);
                    
                     
                     if(remover == 1) {
                       do{
                           out.println("Insira o tipo da actividade");
                       
                           tipo=input.lerString();
                       }while(tipo.equals(""));
                       out.println("Inser a data:");
                       
                       date=this.criaData();
                        
                       this.geoCach.removeActividade(tipo,date,this.user.getEmail());
                        out.println("Actividade removida com sucesso.\nPrima ENTER para continuar.");
                        input.lerString();
                       
                     }
                    
                  }

                 break;
                 
                 case 4:

                 int esk = -1;
                int mes = -1;
                int ano = 0;
                String res="";
                       
               do {
                            out.println("Ver Estatísticas por Mês ou por Ano?");
                            out.println("1 - Mês");
                            out.println("2 - Ano");
                            out.print("Opção: ");
                            esk = input.lerInt();
               } while (esk != 1 && esk != 2);
                        
               if(esk==1) {
                out.println("Indique o mês que quer ver (0 - Dezembro ,1 - Janeiro, 2 - Fevereiro, ..., 11- Novembro): ");;
                 mes = input.lerInt();
                 
                 res =this.geoCach.estatisticaMensal(this.user.getEmail(),mes);
                          
                 }
                        
              if (esk == 2) {
                out.print("\nIndique o ano que quer ver: ");
                
                ano = input.lerInt();
                res =this.geoCach.estatisticaAnual(this.user.getEmail(),ano);
                            
                }
                limpaTerminal();
                  out.println(res);
                  out.println("\n\nPrima ENTER para continuar.");
                 input.lerString();
                           
                 break;

        
                case 0:
                    
                return;
                default: 
                    System.out.println("\nOpcão Inválida! \nPrima Enter para continuar");
                    input.lerString();
                    limpaTerminal();
        
        
                }
       }
    }
    
    
    public boolean verificaSeEncontrouMicroCache( Coordenada coordenada,GregorianCalendar date) 
    {
      HashMap<String,Cache> caches=this.geoCach.getCache();
      
      
      for(Cache u : this.geoCach.getCache().values()) {
        
          if(u instanceof Micro_cache) {
         
              Micro_cache h = (Micro_cache)u;
          
              if(coordenada.equals(h.getCoord())) {
            
             h.setData(date);
             this.geoCach.encontrarCache(this.user.getEmail(),h);
             return true;
            
            }
        
        
        }
  
    }
    return false;
   }
    
    public boolean verificaSeEncontrouMulCache(ArrayList<Coordenada> coordenada,GregorianCalendar date) {
        HashMap<String,Cache> caches=this.geoCach.getCache();
        
        for(Cache u :caches.values()) {
        
            if(u instanceof Mult_cache) {
        
            Mult_cache h = (Mult_cache)u;
            
            if(coordenada.containsAll(h.getLocal())) {
             
                if(coordenada.contains(h.getCoord())) {
                   h.setData(date);
                   this.geoCach.encontrarCache(this.user.getEmail(),h);
                   return true;
                }
             
            }
        
            }
        
        }
        
        return false;
        
    }
    
    public String verificaSeEncontrouCacheMisterio(Coordenada coordenada ){
    
        HashMap<String,Cache> caches=this.geoCach.getCache();
         for(Cache u :this.geoCach.getCache().values()){
             
             if(u instanceof Cache_misterio) {
            
             Cache_misterio h =(Cache_misterio)u;
             if(coordenada.equals(h.getLocal())) {
                
                 return h.getPergunta();
                
                }
            }

    
        }
    return "";
   }
   
    public Coordenada verificaMisterioCache(Coordenada coordenada ,String pergunta, String resposta) {
     
         HashMap<String,Cache> caches=this.geoCach.getCache();
         Coordenada a =new Coordenada();
         
         for(Cache u : this.geoCach.getCache().values()){
             
             if(u instanceof Cache_misterio) {
                 Cache_misterio h =(Cache_misterio)u;
                 
                 if(coordenada.equals(h.getLocal()) && h.getPergunta().equals(pergunta) && h.getResposta().equals(resposta)) {
                    return h.getCoord();
                    }
                
                }
            
            
            }
        return a;
    }
    
    public boolean verificaMisterio(ArrayList<Coordenada> a,GregorianCalendar date) {
     
        
       for(Cache u :this.geoCach.getCache().values()) {
        
           if(u instanceof Cache_misterio) {
             
               Cache_misterio h =(Cache_misterio)u;
               if(a.contains(u.getCoord())) {
           
                   h.setData(date);
            
                   this.geoCach.encontrarCache(this.user.getEmail(),h);
           
                   return true;
        
        
             }
         }
         
        }
      return false;
    
    
    }
    
   public Coordenada criaCoordenada() {
         int grauLatitude,grauLongitude;
        char latitude,longitude;
       double minLatitude,minLongitude;     
    
   do{
    out.print("Inser o grau da Latitude     ");
                      
     grauLatitude=input.lerInt();
   }  while(0<grauLatitude && grauLatitude>90);
                   
     do{
      out.print ("Inser a direcao  da latitude 'N' ou 'S':       ");
      latitude=input.lerChar();
   
    }while(latitude !='N' && latitude !='S');
                    
    out.print("Inser os minutos da latitude :   ");
    minLatitude=input.lerDouble();

    do{
     out.print ("Inser o grau da Longitude ");
     grauLongitude=input.lerInt();
      } while(0<grauLongitude && grauLongitude>180);
                     
     do{
      out.print("Inser a direcção da Longitude  'W' ou 'E'   :      ");
      longitude=input.lerChar();
                        
      }while(longitude != 'W' &&  longitude !='E');
                     
    out.print("Inser os minutos da longitude :     ");
    minLongitude=input.lerDouble();
    
    Coordenada coord=new Coordenada(grauLatitude,latitude,minLatitude,grauLongitude,longitude,minLongitude);
    return coord;
}
   

public GregorianCalendar criaData() {
    int mes,ano,dia;
 
    do {
   
        out.print ("Inser o mes que realizou esta actividade:    ");
    
        mes=input.lerInt();
                        
   
    }while(mes > 12 || mes <= 0);
                    
  
    do{
                         
    
        out.print("Inser o ano que realizou esta actividade:    ");
                            
        ano=input.lerInt();
                        
    }while(ano > 2015 || ano < 1850);
                     
                        
                        
    if (mes == 2 && (( ((ano % 4) == 0) && (ano % 100 != 0) ) || ((ano % 400) == 0))){
                        
                           
        do {
                         
                         
                                
            out.println("Dia: ");
                         
                                
            dia = input.lerInt();
                           
                           
        }while (dia > 29 || dia <= 0);
                        
                        
    }
        
                        
                        
    else { 
                        
                           
        if (mes == 2) {
                            
                                
            do{
                            
                             
                                    
                out.println("Dia: ");
                             
                                    
                dia = input.lerInt();
                           
                                
            }while (dia >= 29 || dia <= 0);
                           
        }
        
                       
                            
        else { 
                       
                               
            if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            
                       
                                   
                do{
                        
                        
                                       
                    out.println("Dia: ");
                        
                                        
                    dia = input.lerInt();
                          
                }while (dia > 31 || dia <= 0);
                          
            }
        
                         
            else 
                        
                         
            do{
                           
                           
                out.println("Dia: ");
                           
                dia = input.lerInt();
                           
            }while (dia > 30 || dia <= 0);
                         
        }
                    
    }
                        
    GregorianCalendar a = new GregorianCalendar (ano,mes,dia);
                     
    return a;
}



    public Cache criaCache() throws IOException,CoordenadaException,CacheException,ClassNotFoundException
    {
    
                int opc=-1;
                int grauLatitude,grauLongitude;
                char latitude,longitude;
                double minLatitude,minLongitude;
                String tamanho;
                String tipo;
                int dia=0;
                int mes=0;
                int ano=0;
                String nomeCache="";
                boolean encontrado=false;
                Coordenada u =new Coordenada();
                
                  do{
                   out.println(this.menu.tipoDeCache());
                    opc=input.lerInt();
                  }
                   while((opc!=1)&& opc!=2 && opc!=3);
                  
                  if(opc==1){
                    
                    tipo="MicroCache";
                    tamanho ="Micro";
                    do{
                        encontrado=false;
                    try{
                       out.println("Inser o local onde guardou a cache: " );
                       do{
                      out.print("Inser o grau da Latitude entre 0 e 90          ");
                      
                      grauLatitude=input.lerInt();
                      } while(0<grauLatitude && grauLatitude>90);
                   
                      do{
                        out.print ("Inser a direcao  da latitude 'N' ou 'S':       ");
                        latitude=input.lerChar();
   
                       }while(latitude !='N' && latitude !='S');
                    
                       out.print("Inser os minutos da latitude :     ");
                       minLatitude=input.lerDouble();

                         do{
                          out.print ("Inser o grau da Longitude entre 0 e 180        ");
                          grauLongitude=input.lerInt();
                        } while(0<grauLongitude && grauLongitude>180);
                     
                        do{
                          out.print("Inser a direcção da Longitude  'W' ou 'E'   :         ");
                          longitude=input.lerChar();
                        
                          }while(longitude != 'W' &&  longitude !='E');
                     
                         out.print("Inser os minutos da longitude :     ");
                         minLongitude=input.lerDouble();
                         
                         u =new Coordenada(grauLatitude,latitude,minLatitude,grauLongitude,longitude,minLongitude);
                        
                        this.verificaCoord(u);
                         
                      } catch(CoordenadaException e) {
                        out.println(e.getMessage());
                        out.println("Prima Enter para continuar\n");
                        input.lerString();
                        encontrado=true;
                        
                        }
                     }while(encontrado);
                        
                        
                      do {
                         out.print ("Inser o mes que a colucou:   ");
                         mes=input.lerInt();
                        
                        }while(mes > 12 || mes <= 0);
                    
                        do{
                         
                            out.print("Inser o ano que a colucou:   ");
                            ano=input.lerInt();
                        }while(ano > 2015 || ano < 1850);
                     
                       if (mes == 2 && (( ((ano % 4) == 0) && (ano % 100 != 0) ) || ((ano % 400) == 0))){
                        do {
                         
                         out.println("Dia: ");
                         dia = input.lerInt();
                           }while (dia > 29 || dia <= 0);
                       }
        
                       else { 
                       if (mes == 2) {
                           do{
                            
                             out.println("Dia: ");
                             dia = input.lerInt();
                           }while (dia >= 29 || dia <= 0);
                           }
        
                     else { 
                       if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            
                       do{
                        
                        out.println("Dia: ");
                        dia = input.lerInt();
                           }while (dia > 31 || dia <= 0);
                           }
        
                         else 
                        do{
                           
                           out.println("Dia: ");
                           dia = input.lerInt();
                            }while (dia > 30 || dia <= 0);
                         }
                     }
                        do{
                        try{
                        encontrado=false;
                         
                        out.print ("Inser o nome da cache:  ");
                        nomeCache=input.lerString();
                         this.verificaNome(nomeCache);
                      } catch(CacheException e) {
                        out.println(e.getMessage());
                        out.println("Prima Enter para continuar");
                         input.lerString();
                         encontrado=true;
                        
                        }
                    } while(nomeCache.equals("") || encontrado );
                        
                       
                        GregorianCalendar a = new GregorianCalendar (ano,mes,dia);
                        this.geoCach.criarCacheMicro(nomeCache,tipo,u,tamanho,a,this.user.getEmail());
                      
                      Micro_cache micro = new Micro_cache(nomeCache,tamanho,tipo,u,null,a,this.user.getEmail());
                      return micro;
                   }  
                   
                   
                    else {
                       if(opc==2) {
                           int op=-1;
                           int nrCaminho=0;
                           tipo="MultCache";
                           ArrayList<Coordenada> caminho =new ArrayList<Coordenada>();
                           do{
                            out.println(menu.tamanhosDeCache());
                            op=input.lerInt();
                            
                            }while(op<0 || op>3);
                            
                            if(op==1) {tamanho="Small";}
                            else {
                                if(op==2) {tamanho="Medium"; }
                                else {tamanho ="Large";}
                                 
                            }
                            
                              do{
                          encontrado=false;
                      try{
                         out.println("Inser o local onde guardou a cache final: " );
                         do{
                         out.print("Inser o grau da Latitude     ");
                      
                         grauLatitude=input.lerInt();
                        } while(0<grauLatitude && grauLatitude>90);
                   
                        do{
                          out.print ("Inser a direcao  da latitude 'N' ou 'S':       ");
                          latitude=input.lerChar();
   
                       }while(latitude !='N' && latitude !='S');
                    
                         out.print("Inser os minutos da latitude :   ");
                         minLatitude=input.lerDouble();

                           do{
                          out.print ("Inser o grau da Longitude ");
                          grauLongitude=input.lerInt();
                         } while(0<grauLongitude && grauLongitude>180);
                     
                        do{
                          out.print("Inser a direcção da Longitude  'W' ou 'E'   :      ");
                          longitude=input.lerChar();
                        
                          }while(longitude != 'W' &&  longitude !='E');
                     
                         out.print("Inser os minutos da longitude :     ");
                         minLongitude=input.lerDouble();
                         
                         u =new Coordenada(grauLatitude,latitude,minLatitude,grauLongitude,longitude,minLongitude);
                        
                        this.verificaCoord(u);
                         
                      } catch(CoordenadaException e) {
                        out.println(e.getMessage());
                        out.println("Prima Enter para continuar\n");
                        input.lerString();
                        encontrado=true;
                        
                        }
                     }while(encontrado);
                      
                    do{     
                      out.println("Quantas caches voçês colocou atê chegar a final?");
                      nrCaminho=input.lerInt();
                     }while(opc==0);  
                            
                     while(nrCaminho!=0) {
    
                             do{
                          encontrado=false;
                      try{
                         out.println("Inser o local onde guardou as outras caches: " );
                         do{
                         out.print("Inser o grau da Latitude     ");
                      
                         grauLatitude=input.lerInt();
                        } while(0<grauLatitude && grauLatitude>90);
                   
                        do{
                          out.print ("Inser a direcao  da latitude 'N' ou 'S':       ");
                          latitude=input.lerChar();
   
                       }while(latitude !='N' && latitude !='S');
                         out.print("Inser os minutos da latitude :   ");
                         minLatitude=input.lerDouble();

                           do{
                          out.print ("Inser o grau da Longitude ");
                          grauLongitude=input.lerInt();
                         } while(0<grauLongitude && grauLongitude>180);
                     
                        do{
                          out.print("Inser a direcção da Longitude  'W' ou 'E'   :      ");
                          longitude=input.lerChar();
                        
                          }while(longitude != 'W' &&  longitude !='E');
                     
                         out.print("Inser os minutos da longitude :     ");
                         minLongitude=input.lerDouble();
                         
                         u =new Coordenada(grauLatitude,latitude,minLatitude,grauLongitude,longitude,minLongitude);
                        
                        this.verificaCoord(u);
                         
                         } catch(CoordenadaException e) {
                        out.println(e.getMessage());
                        out.println("Prima Enter para continuar\n");
                        input.lerString();
                        encontrado=true;
                        
                        }
                     }while(encontrado);
                         caminho.add(u.clone());
                        nrCaminho--;
                        
                        }         
                     
                
                         
                     do {
                         out.print ("Inser o mes que a colucou:   ");
                         mes=input.lerInt();
                        
                        }while(mes > 12 || mes <= 0);
                    
                        do{
                         
                            out.print("Inser o ano que a colucou:   ");
                            ano=input.lerInt();
                        }while(ano > 2015 || ano < 1850);
                     
                       if (mes == 2 && (( ((ano % 4) == 0) && (ano % 100 != 0) ) || ((ano % 400) == 0))){
                        do {
                         
                         out.println("Dia: ");
                         dia = input.lerInt();
                           }while (dia > 29 || dia <= 0);
                       }
        
                       else { 
                       if (mes == 2) {
                           do{
                            
                             out.println("Dia: ");
                             dia = input.lerInt();
                           }while (dia >= 29 || dia <= 0);
                           }
        
                     else { 
                       if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            
                       do{
                        
                        out.println("Dia: ");
                        dia = input.lerInt();
                           }while (dia > 31 || dia <= 0);
                           }
        
                         else 
                        do{
                           
                           out.println("Dia: ");
                           dia = input.lerInt();
                            }while (dia > 30 || dia <= 0);
                         }
                     }
                     
                      do{
                        try{
                        encontrado=false;
                         
                        out.print ("Inser o nome da cache:  ");
                        nomeCache=input.lerString();
                         this.verificaNome(nomeCache);
                      } catch(CacheException e) {
                        out.println(e.getMessage());
                        out.println("Prima Enter para continuar");
                         input.lerString();
                         encontrado=true;
                        
                        }
                    
                     } while(nomeCache.equals("") || encontrado );
                       
                        GregorianCalendar a = new GregorianCalendar (ano,mes,dia);
                        this.geoCach.criarCacheMult(nomeCache,tipo,u,tamanho,a,caminho,this.user.getEmail());
                      Mult_cache mult = new Mult_cache(nomeCache,tamanho,tipo,u,null,a,caminho,this.user.getEmail());
                     
                     return mult;
                 }
                   else {
                    tipo="CacheMisterio";
                    String pergunta ="";
                    String resposta="";
                    Coordenada localDopuzzle = new Coordenada();
                    int op=-1;
                     do{
                            out.println(menu.tamanhosDeCache());
                            op=input.lerInt();
                            
                            }while(op<0 || op>3);
                            
                            if(op==1) {tamanho="Small";}
                            else {
                                if(op==2) {tamanho="Medium"; }
                                else {tamanho ="Large";}
                                 
                            }
                    
                      do{
                          encontrado=false;
                      try{
                         out.println("Inser o local onde guardou a cache final: " );
                         do{
                         out.print("Inser o grau da Latitude     ");
                      
                         grauLatitude=input.lerInt();
                        } while(0<grauLatitude && grauLatitude>90);
                   
                        do{
                          out.print ("Inser a direcao  da latitude 'N' ou 'S':       ");
                          latitude=input.lerChar();
   
                       }while(latitude !='N' && latitude !='S');
                    
                         out.print("Inser os minutos da latitude :   ");
                         minLatitude=input.lerDouble();

                           do{
                          out.print ("Inser o grau da Longitude ");
                          grauLongitude=input.lerInt();
                         } while(0<grauLongitude && grauLongitude>180);
                     
                        do{
                          out.print("Inser a direcção da Longitude  'W' ou 'E'   :      ");
                          longitude=input.lerChar();
                        
                          }while(longitude != 'W' &&  longitude !='E');
                     
                         out.print("Inser os minutos da longitude :     ");
                         minLongitude=input.lerDouble();
                         
                         u =new Coordenada(grauLatitude,latitude,minLatitude,grauLongitude,longitude,minLongitude);
                        
                        this.verificaCoord(u);
                         
                      } catch(CoordenadaException e) {
                        out.println(e.getMessage());
                        out.println("Prima Enter para continuar\n");
                        input.lerString();
                        encontrado=true;
                        
                        }
                     }while(encontrado);
                     
                      do{
                          encontrado=false;
                      try{
                         out.println("Inser o local esta o puzzle: " );
                         do{
                         out.print("Inser o grau da Latitude     ");
                      
                         grauLatitude=input.lerInt();
                        } while(0<grauLatitude && grauLatitude>90);
                   
                        do{
                          out.print ("Inser a direcao  da latitude 'N' ou 'S':       ");
                          latitude=input.lerChar();
   
                       }while(latitude !='N' && latitude !='S');
                    
                         out.print("Inser os minutos da latitude :   ");
                         minLatitude=input.lerDouble();

                           do{
                          out.print ("Inser o grau da Longitude ");
                          grauLongitude=input.lerInt();
                         } while(0<grauLongitude && grauLongitude>180);
                     
                        do{
                          out.print("Inser a direcção da Longitude  'W' ou 'E'   :      ");
                          longitude=input.lerChar();
                        
                          }while(longitude != 'W' &&  longitude !='E');
                     
                         out.print("Inser os minutos da longitude :     ");
                         minLongitude=input.lerDouble();
                         
                         localDopuzzle =new Coordenada(grauLatitude,latitude,minLatitude,grauLongitude,longitude,minLongitude);
                        
                        this.verificaCoord(u);
                         
                      } catch(CoordenadaException e) {
                        out.println(e.getMessage());
                        out.println("Prima Enter para continuar\n");
                        input.lerString();
                        encontrado=true;
                        
                        }
                     }while(encontrado);
                     
                     do{
                        out.println("Introduza a pergunta para o puzzle");
                        pergunta=input.lerString();
                        
                        
                        }while(pergunta.equals(""));
                     
                        do{
                         out.println("Introduza a resposta a sua pergunta ");
                         resposta=input.lerString();
                            
                        }while(resposta.equals(""));
                     
                     
                      do 
                      {
                         out.print ("Inser o mes que a colucou:   ");
                         mes=input.lerInt();
                        
                        }while(mes > 12 || mes <= 0);
                    
                        do{
                         
                            out.print("Inser o ano que a colucou:   ");
                            ano=input.lerInt();
                        }while(ano > 2015 || ano < 1850);
                     
                       if (mes == 2 && (( ((ano % 4) == 0) && (ano % 100 != 0) ) || ((ano % 400) == 0))){
                        do {
                         
                         out.println("Dia: ");
                         dia = input.lerInt();
                           }while (dia > 29 || dia <= 0);
                       }
        
                       else { 
                       if (mes == 2) {
                           do{
                            
                             out.println("Dia: ");
                             dia = input.lerInt();
                           }while (dia >= 29 || dia <= 0);
                           }
        
                     else { 
                       if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            
                       do{
                        
                        out.println("Dia: ");
                        dia = input.lerInt();
                           }while (dia > 31 || dia <= 0);
                           }
        
                         else 
                        do{
                           
                           out.println("Dia: ");
                           dia = input.lerInt();
                            }while (dia > 30 || dia <= 0);
                         }
                     }
                     
                      do{
                        try{
                        encontrado=false;
                         
                        out.print ("Inser o nome da cache:  ");
                        nomeCache=input.lerString();
                         this.verificaNome(nomeCache);
                      } catch(CacheException e) {
                        out.println(e.getMessage());
                        out.println("Prima Enter para continuar");
                         input.lerString();
                         encontrado=true;
                        
                        }
                    
                     } while(nomeCache.equals("") || encontrado );
                    
                    
                        GregorianCalendar a = new GregorianCalendar (ano,mes,dia);
                        this.geoCach.criarCacheMisterio(nomeCache,resposta,pergunta,tipo,u,tamanho,a,this.user.getEmail(),localDopuzzle);
                        
                      Cache_misterio misterio =new Cache_misterio(nomeCache,resposta.toLowerCase(),pergunta,tamanho,tipo,u,null,a,localDopuzzle,this.user.getEmail());
                      return misterio;
 
                    } 

                }
      }
    
    
    
    
    public void leObjS() throws IOException,ClassNotFoundException,ParseException{
        GeoCaching a=null;
        try { 
            FileInputStream carreg = new FileInputStream("Estado.dat"); 
            ObjectInputStream obj = new ObjectInputStream(carreg); 
            
            a= (GeoCaching)obj.readObject();
            
            obj.close();
        }
        catch (IOException e) { 
            out.println(e.getMessage());
        }
        catch (ClassNotFoundException e) {
            out.println(e.getMessage());
        }
        this.geoCach=a;
        
    }
    
    public void gravaObjS() throws IOException {
        try {
         FileOutputStream carrega=new  FileOutputStream("Estado.dat");
        ObjectOutputStream oos = new ObjectOutputStream(carrega);
        oos.writeObject(this.geoCach);
        oos.flush();
        oos.close();
      }
      
      catch(IOException e) {out.println (e.getMessage());}
      
   }
   
 
  
}

