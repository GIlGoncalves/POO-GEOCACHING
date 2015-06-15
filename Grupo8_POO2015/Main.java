

import java.io.*;
import java.text.ParseException;
import java.util.*;
public class Main implements Serializable
{
   
    public static void main(String[] args) throws IOException,UtilizadorException,ParseException,ClassNotFoundException,EmailExisteException,CredenciaisException,AmizadeException,CoordenadaException
    ,CacheException,ActividadeException
    {
       GeoCaching geo = new GeoCaching ();
        geo.adicionaAtividade("Lazer");
        geo.adicionaAtividade("Procurar cache");
        geo.adicionaAtividade("Esconder cache");
        geo.adicionaAtividade("Evento");
       
        ArrayList<Coordenada> caminho1 = new ArrayList<Coordenada>(); 
       ArrayList<Coordenada> caminho2 = new ArrayList<Coordenada>(); 
       ArrayList<Coordenada> caminho3 = new ArrayList<Coordenada>(); 
       ArrayList<Coordenada> caminho4 = new ArrayList<Coordenada>(); 
       ArrayList<Coordenada> caminho5 = new ArrayList<Coordenada>(); 
       ArrayList<Coordenada> caminho6 = new ArrayList<Coordenada>(); 
       ArrayList<Coordenada> caminho7 = new ArrayList<Coordenada>(); 
       ArrayList<Coordenada> caminho8 = new ArrayList<Coordenada>();
       ArrayList<Coordenada> caminho9 = new ArrayList<Coordenada>(); 
       ArrayList<Coordenada> caminho10 = new ArrayList<Coordenada>(); 
       ArrayList<Coordenada> caminho11 = new ArrayList<Coordenada>(); 
       ArrayList<Coordenada> caminho12 = new ArrayList<Coordenada>(); 
       ArrayList<Coordenada> caminho13 = new ArrayList<Coordenada>(); 
       ArrayList<Coordenada> caminho14 = new ArrayList<Coordenada>(); 
       ArrayList<Coordenada> caminho15= new ArrayList<Coordenada>(); 
       ArrayList<Coordenada> caminho16= new ArrayList<Coordenada>();
       
       
        Utilizador a =new Utilizador("gil@gmail.com","Bolinhas","Gil","Masculino","Rua Vasco da Gama",23,11,1994);
        Utilizador b =new Utilizador("celia@gmail.com","Celia","Celia","Femenino","Rua Vasco da Gama",23,11,1995);
        Utilizador c =new Utilizador("antonio@gmail.com","Bolinhas","Antonio","Masculino","Rua Vasco da Gama",23,10,1998);
        Utilizador d =new Utilizador("margarida@gmail.com","Celia","Margarida","Femenino","Rua Vasco da Gama",23,1,1995);
        Utilizador e =new Utilizador("carlos@gmail.com","Bolinhas","Carlos","Masculino","Rua Vasco da Gama",23,2,1994);
        Utilizador f =new Utilizador("sandra@gmail.com","Celia","Sandra","Femenino","Rua Vasco da Gama",25,11,1995);
        Utilizador g =new Utilizador("jose@gmail.com","Bolinhas","Jose","Masculino","Rua Vasco da Gama",25,3,1994);
        Utilizador h =new Utilizador("carolina@gmail.com","Celia","Carolina","Femenino","Rua Vasco da Gama",23,11,1995);
        
        geo.adicionaUtilizador(a.clone());
        geo.adicionaUtilizador(b.clone());
        geo.adicionaUtilizador(c.clone());
        geo.adicionaUtilizador(d.clone());
         geo.adicionaUtilizador(e.clone());
        geo.adicionaUtilizador(f.clone());
          geo.adicionaUtilizador(g.clone());
        geo.adicionaUtilizador(h.clone());
        
        Coordenada u =new Coordenada(10,'N',29,19,'W',39);//
        Coordenada u2 =new Coordenada(10,'N',29,15,'W',39);//
        Coordenada u3 =new Coordenada(10,'N',29,1,'W',39);//
        Coordenada u4 =new Coordenada(10,'N',19,15,'W',39);//
        Coordenada u5 =new Coordenada(10,'N',9,19,'W',39);//
        Coordenada u6 =new Coordenada(10,'N',2,15,'W',39);//
        Coordenada u7 =new Coordenada(10,'N',29,19,'E',39);//
        Coordenada u8 =new Coordenada(10,'N',29,15,'W',40);//
        Coordenada u9 =new Coordenada(11,'N',29,1,'W',39);//
        Coordenada u10 =new Coordenada(18,'N',19,15,'W',39);//
        Coordenada u11 =new Coordenada(10,'N',239,19,'W',39);//
        Coordenada u12 =new Coordenada(10,'S',2,15,'W',139);//
        
        
        Coordenada u13 =new Coordenada(20,'N',29,19,'W',39);//
        Coordenada u14 =new Coordenada(30,'N',29,15,'W',39);//
        Coordenada u15 =new Coordenada(40,'N',29,1,'W',39);//
        Coordenada u16 =new Coordenada(50,'S',19,15,'W',39);//
        Coordenada u17 =new Coordenada(10,'N',90,19,'W',39);//
        Coordenada u18 =new Coordenada(10,'N',206,15,'W',39);//
        Coordenada u19 =new Coordenada(10,'N',292,19,'E',39);//
        Coordenada u20 =new Coordenada(48,'N',29,15,'W',40);//
        Coordenada u21 =new Coordenada(49,'N',29,1,'W',39);//
        Coordenada u22 =new Coordenada(50,'N',19,15,'W',39);//
        Coordenada u23 =new Coordenada(52,'N',239,19,'W',39);//
        Coordenada u24 =new Coordenada(54,'S',2,15,'W',139);//
        
        
        Coordenada u25 =new Coordenada(51,'S',19,15,'W',39);//
        Coordenada u26 =new Coordenada(52,'S',243,19,'W',39);//
        Coordenada u27 =new Coordenada(54,'S',212,15,'W',139);//
        Coordenada u28 =new Coordenada(55,'N',19,15,'W',39);//
        Coordenada u29 =new Coordenada(52,'N',239,8,'W',39);//
        Coordenada u30 =new Coordenada(56,'S',2,15,'W',139);//
        Coordenada u31 =new Coordenada(57,'N',19,15,'W',39);//
        Coordenada u32 =new Coordenada(58,'N',239,19,'W',39);//
        Coordenada u33 =new Coordenada(59,'S',2,15,'W',139);//
        Coordenada u34 =new Coordenada(60,'N',19,15,'W',39);//
        Coordenada u35 =new Coordenada(61,'N',239,19,'W',39);//
        Coordenada u36 =new Coordenada(62,'S',2,15,'W',139);//
        Coordenada u37 =new Coordenada(63,'N',19,15,'W',39);//
        Coordenada u38 =new Coordenada(64,'N',239,19,'W',39);//
        Coordenada u39 =new Coordenada(65,'S',2,15,'W',139);//
        Coordenada u40 =new Coordenada(66,'N',19,15,'W',39);//
        Coordenada u41 =new Coordenada(67,'N',239,19,'W',39);//
        Coordenada u42 =new Coordenada(68,'S',2,15,'W',139);//
        Coordenada u43 =new Coordenada(69,'N',19,15,'W',39);//
        Coordenada u44 =new Coordenada(70,'N',239,19,'W',39);//
        Coordenada u45 =new Coordenada(71,'S',2,15,'W',139);//
          
        Coordenada u46 =new Coordenada(72,'N',19,15,'W',39);//
        Coordenada u47 =new Coordenada(73,'N',239,19,'W',39);//
        Coordenada u48 =new Coordenada(74,'S',2,15,'W',139);//
        Coordenada u49 =new Coordenada(75,'N',19,15,'W',39);//
        Coordenada u50 =new Coordenada(76,'N',239,19,'W',39);//
        Coordenada u51 =new Coordenada(77,'S',2,15,'W',139);//
        Coordenada u52 =new Coordenada(78,'N',19,15,'W',39);//
        Coordenada u53 =new Coordenada(79,'N',239,19,'W',39);//
        Coordenada u54 =new Coordenada(80,'S',2,15,'W',139);//
        Coordenada u55 =new Coordenada(81,'N',19,15,'W',39);//
        Coordenada u56 =new Coordenada(82,'N',239,19,'W',39);//
        Coordenada u57 =new Coordenada(83,'S',2,15,'W',139);//
        
        Coordenada u58 =new Coordenada(84,'N',19,15,'W',39);//
        Coordenada u59 =new Coordenada(85,'N',239,19,'W',39);//
        Coordenada u60 =new Coordenada(86,'S',2,15,'W',139);//
        Coordenada u61 =new Coordenada(87,'N',19,15,'W',39);//
        Coordenada u62 =new Coordenada(88,'N',239,19,'W',39);//
        Coordenada u63 =new Coordenada(89,'S',2,15,'W',139);//
        Coordenada u64 =new Coordenada(90,'N',19,15,'W',39);
        Coordenada u65 =new Coordenada(82,'N',239,18,'W',39);
        Coordenada u66 =new Coordenada(83,'S',2,19,'W',139);
        Coordenada u67 =new Coordenada(81,'N',19,20,'W',39);
        Coordenada u68 =new Coordenada(82,'N',239,32,'W',39);
        Coordenada u69 =new Coordenada(83,'S',2,33,'W',139);
        
        
        
        

        
        
        
        GregorianCalendar  d1 = new GregorianCalendar (2014,1,10);
        GregorianCalendar  d2 = new GregorianCalendar (2014,2,1);
        GregorianCalendar  d3 = new GregorianCalendar (2014,3,12);
        GregorianCalendar d4 =new GregorianCalendar(2014,4,3);
        GregorianCalendar  d5 = new GregorianCalendar (2014,5,2);
        GregorianCalendar  d6 = new GregorianCalendar (2014,6,1);
        GregorianCalendar  d7 = new GregorianCalendar (2014,7,10);
        GregorianCalendar d8 =new GregorianCalendar(2014,8,10);
         GregorianCalendar  d9 = new GregorianCalendar (2014,9,15);
        GregorianCalendar  d10 = new GregorianCalendar (2014,10,13);
        GregorianCalendar  d11 = new GregorianCalendar (2014,11,13);
        GregorianCalendar d12 =new GregorianCalendar(2014,12,13);
         GregorianCalendar  d13 = new GregorianCalendar (2014,12,1);
        GregorianCalendar  d14 = new GregorianCalendar (2014,12,2);
        GregorianCalendar  d15 = new GregorianCalendar (2014,12,3);
        GregorianCalendar d16 =new GregorianCalendar(2015,1,3);
        GregorianCalendar  d17 = new GregorianCalendar (2015,1,5);
        GregorianCalendar  d18 = new GregorianCalendar (2015,1,6);
        GregorianCalendar  d19 = new GregorianCalendar (2015,1,7);
        GregorianCalendar d20 =new GregorianCalendar(2015,1,9);
         GregorianCalendar  d21 = new GregorianCalendar (2015,2,15);
        GregorianCalendar  d22 = new GregorianCalendar (2015,2,18);
        GregorianCalendar  d23 = new GregorianCalendar (2015,2,19);
        GregorianCalendar d24 =new GregorianCalendar(2015,2,20);
        
        geo.adicionarActividadeEsconder(200,u5,"CacheMisterio","Large",d1,"Esconder cache","Chuva","celia@gmail.com");
        geo.adicionarActividadeEsconder(200,u6,"CacheMisterio","Large",d2,"Esconder cache","Chuva","celia@gmail.com");
        geo.adicionarActividadeEsconder(200,u7,"CacheMisterio","Large",d3,"Esconder cache","Chuva","antonio@gmail.com");
        geo.adicionarActividadeEsconder(200,u8,"CacheMisterio","Large",d4,"Esconder cache","Chuva","gil@gmail.com");
        geo.adicionarActividadeEsconder(200,u9,"CacheMisterio","Large",d5,"Esconder cache","Chuva","carolina@gmail.com");
        geo.adicionarActividadeEsconder(200,u10,"CacheMisterio","Large",d6,"Esconder cache","Chuva","jose@gmail.com");
        geo.adicionarActividadeEsconder(200,u11,"CacheMisterio","Large",d7,"Esconder cache","Chuva","antonio@gmail.com");
        geo.adicionarActividadeEsconder(200,u12,"CacheMisterio","Large",d8,"Esconder cache","Chuva","antonio@gmail.com");
        geo.adicionarActividadeEsconder(200,u13,"CacheMisterio","Large",d9,"Esconder cache","Chuva","margarida@gmail.com");
                 
        geo.criarCacheMisterio("d1","6","Que dia é hoje","CacheMisterio",u5,"Medium",d1,"celia@gmail.com",u14);
        geo.criarCacheMisterio("d2","9","3*3","CacheMisterio",u6,"Medium",d2,"celia@gmail.com",u15);
        geo.criarCacheMisterio("d3","15","3*4","CacheMisterio",u7,"Medium",d3,"antonio@gmail.com",u16);
        geo.criarCacheMisterio("d4","12","6+6","CacheMisterio",u8,"Medium",d4,"gil@gmail.com",u17);
        geo.criarCacheMisterio("d5","f","15 em hexedecimal","CacheMisterio",u9,"Medium",d5,"carolina@gmail.com",u18);
        geo.criarCacheMisterio("d6","quaresma","ricardo","CacheMisterio",u10,"Medium",d6,"jose@gmail.com",u19);
        geo.criarCacheMisterio("d7","6","mes","CacheMisterio",u11,"Medium",d7,"antonio@gmail.com",u20);
        geo.criarCacheMisterio("d8","2015","ano","CacheMisterio",u12,"Medium",d8,"antonio@gmail.com",u21);
        geo.criarCacheMisterio("d9","porto","vinho do","CacheMisterio",u13,"Medium",d9,"margarida@gmail.com",u22);
        
        
        geo.adicionarActividadeEsconder(200,u25,"MultCache","Small",d1,"Esconder cache","Chuva","gil@gmail.com");
        geo.adicionarActividadeEsconder(200,u26,"MultCache","Small",d2,"Esconder cache","Chuva","jose@gmail.com");
        geo.adicionarActividadeEsconder(200,u27,"MultCache","Small",d3,"Esconder cache","Chuva","carolina@gmail.com");
        geo.adicionarActividadeEsconder(200,u28,"MultCache","Small",d4,"Esconder cache","Chuva","margarida@gmail.com");
        geo.adicionarActividadeEsconder(200,u29,"MultCache","Small",d5,"Esconder cache","Chuva","antonio@gmail.com");
        geo.adicionarActividadeEsconder(200,u30,"MultCache","Small",d6,"Esconder cache","Chuva","gil@gmail.com");
        geo.adicionarActividadeEsconder(200,u31,"MultCache","Small",d7,"Esconder cache","Chuva","antonio@gmail.com");
        geo.adicionarActividadeEsconder(200,u32,"MultCache","Small",d8,"Esconder cache","Chuva","jose@gmail.com");
        geo.adicionarActividadeEsconder(200,u33,"MultCache","Small",d9,"Esconder cache","Chuva","jose@gmail.com");
         
        geo.criarCacheMult("a","MultCache",u25,"Small",d1,caminho1,"gil@gmail.com");
        geo.criarCacheMult("b","MultCache",u26,"Small",d2,caminho2,"jose@gmail.com");
        geo.criarCacheMult("c","MultCache",u27,"Small",d3,caminho3,"carolina@gmail.com");
        geo.criarCacheMult("d","MultCache",u28,"Small",d4,caminho4,"margarida@gmail.com");
        geo.criarCacheMult("e","MultCache",u29,"Small",d5,caminho5,"antonio@gmail.com");
        geo.criarCacheMult("f","MultCache",u30,"Small",d6,caminho6,"gil@gmail.com");
        geo.criarCacheMult("g","MultCache",u31,"Small",d7,caminho7,"antonio@gmail.com");
        geo.criarCacheMult("h","MultCache",u32,"Small",d8,caminho8,"jose@gmail.com");
        geo.criarCacheMult("i","MultCache",u33,"Small",d9,caminho9,"jose@gmail.com");
        
        caminho1.add(u34);
        caminho1.add(u35);
        caminho1.add(u36);
        
        caminho2.add(u37);
        caminho2.add(u38);
        
        caminho3.add(u39);
        caminho3.add(u40);
        caminho3.add(u41);
        
        caminho4.add(u42);
        caminho4.add(u43);
        
        caminho5.add(u44);
        caminho5.add(u46);
        
        caminho6.add(u47);
        caminho6.add(u48);
        
        caminho7.add(u49);
        caminho7.add(u50);
        
        caminho8.add(u51);
        caminho8.add(u52);
        
        caminho9.add(u53);
        caminho9.add(u54);
         
        Mult_cache jk =new Mult_cache("u","Meduim","MultCache",u25,d5,d1,caminho1,"gil@gmail.com");
        Mult_cache jl =new Mult_cache("oi","Meduim","MultCache",u26,d6,d2,caminho2,"jose@gmail.com");
        Mult_cache jj =new Mult_cache("fafe","Meduim","MultCache",u27,d7,d3,caminho3,"carolina@gmail.com");
         
        geo.adicionaActividadeProcura(d5,"MultCache","Sol","Procurar cache", caminho1,200,"carlos@gmail.com");
          geo.adicionaActividadeProcura(d6,"MultCache","Sol","Procurar cache", caminho12,200,"sandra@gmail.com");
           geo.adicionaActividadeProcura(d7,"MultCache","Sol","Procurar cache", caminho13,200,"margarida@gmail.com");
           
           geo.encontrarCache("carlos@gmail.com",jj);
           geo.encontrarCache("sandra@gmail.com",jl);
           geo.encontrarCache("margarida@gmail.com",jk);
           
        
        
        geo.adicionarActividadeEsconder(200,u55,"MicroCache","Small",d4,"Esconder cache","Chuva","gil@gmail.com");
        geo.adicionarActividadeEsconder(200,u56,"MicroCache","Small",d5,"Esconder cache","Chuva","celia@gmail.com");
        geo.adicionarActividadeEsconder(200,u57,"MicroCache","Small",d6,"Esconder cache","Chuva","antonio@gmail.com");
        geo.adicionarActividadeEsconder(200,u58,"MicroCache","Small",d7,"Esconder cache","Chuva","jose@gmail.com");
        geo.adicionarActividadeEsconder(200,u59,"MicroCache","Small",d8,"Esconder cache","Chuva","carolina@gmail.com");
        geo.adicionarActividadeEsconder(200,u60,"MicroCache","Small",d9,"Esconder cache","Chuva","sandra@gmail.com");
        geo.adicionarActividadeEsconder(200,u61,"MicroCache","Small",d10,"Esconder cache","Chuva","gil@gmail.com");
        geo.adicionarActividadeEsconder(200,u62,"MicroCache","Small",d11,"Esconder cache","Chuva","antonio@gmail.com");
        geo.adicionarActividadeEsconder(200,u63,"MicroCache","Small",d12,"Esconder cache","Chuva","carlos@gmail.com");
        
        geo.criarCacheMicro("gil","MicroCache",u55,"Large",d4,"gil@gmail.com");
        geo.criarCacheMicro("gil1","MicroCache",u56,"Large",d5,"celia@gmail.com");
        geo.criarCacheMicro("gil2","MicroCache",u57,"Large",d6,"antonio@gmail.com");
        geo.criarCacheMicro("gil3","MicroCache",u58,"Large",d7,"jose@gmail.com");
        geo.criarCacheMicro("gil4","MicroCache",u59,"Large",d8,"carolina@gmail.com");
        geo.criarCacheMicro("gil5","MicroCache",u60,"Large",d9,"sandra@gmail.com");
        geo.criarCacheMicro("gil6","MicroCache",u61,"Large",d10,"gil@gmail.com");
        geo.criarCacheMicro("gil7","MicroCache",u62,"Large",d11,"antonio@gmail.com");
        geo.criarCacheMicro("gil8","MicroCache",u63,"Large",d12,"carlos@gmail.com");
        
         Micro_cache k1= new Micro_cache("gil1","Micro","MicroCache",u55,d7,d4,"gil@gmail.com");
         Micro_cache k2= new Micro_cache("gil2","Micro","MicroCache",u56,d8,d5,"celia@gmail.com");
         Micro_cache k3= new Micro_cache("gil3","Micro","MicroCache",u57,d9,d6,"antonio@gmail.com");
         
         geo.adicionaActividadeProcura(d7,"MultCache","Sol","Procurar cache", caminho1,200,"carlos@gmail.com");
         geo.adicionaActividadeProcura(d8,"MultCache","Sol","Procurar cache", caminho1,200,"carlos@gmail.com");
         geo.adicionaActividadeProcura(d9,"MultCache","Sol","Procurar cache", caminho1,200,"carlos@gmail.com");
         
         geo.encontrarCache("carlos@gmail.com",k1);
         geo.encontrarCache("carlos@gmail.com",k2);
         geo.encontrarCache("carlos@gmail.com",k3);
         
        
        
        geo.adicionarActividadeLazer("Lazer","Chuva",d1,u2,20,"celia@gmail.com");
        geo.adicionarActividadeLazer("Lazer","Sol",d2,u,20,"celia@gmail.com");
        geo.adicionarActividadeLazer("Lazer","Chuva",d3,u2,20,"celia@gmail.com");
        geo.adicionarActividadeLazer("Lazer","Vento",d4,u,20,"celia@gmail.com");
        geo.adicionarActividadeLazer("Lazer","Chuva",d5,u2,20,"celia@gmail.com");
        geo.adicionarActividadeLazer("Lazer","Vento",d6,u,20,"celia@gmail.com");
        geo.adicionarActividadeLazer("Lazer","Chuva",d7,u2,20,"celia@gmail.com");
        
        geo.adicionarActividadeLazer("Lazer","Chuva",d2,u,20,"gil@gmail.com");
        geo.adicionarActividadeLazer("Lazer","Sol",d4,u2,20,"antonio@gmail.com");
        
        
        geo.adicionarActividadeLazer("Lazer","Vento",d5,u,20,"sandra@gmail.com");
        geo.adicionarActividadeLazer("Lazer","Sol",d7,u2,20,"jose@gmail.com");
        geo.adicionarActividadeLazer("Lazer","Vento",d8,u,20,"carolina@gmail.com");
        geo.adicionarActividadeLazer("Lazer","Chuva",d9,u2,20,"carlos@gmail.com");
        geo.adicionarActividadeLazer("Lazer","Sol",d12,u,20,"margarida@gmail.com");
        
        caminho10.add(u55);
        caminho11.add(u56);
        caminho12.add(u57);
       
        geo.adicionaActividadeProcura(d7,"MicroCache","Sol","Procurar cache", caminho10,200,"carlos@gmail.com");
        geo.adicionaActividadeProcura(d8,"MicroCache","Sol","Procurar cache", caminho11,200,"carlos@gmail.com");
        geo.adicionaActividadeProcura(d9,"MicroCache","Sol","Procurar cache", caminho12,200,"carlos@gmail.com");
        
        
        geo.adicionaAmigoAoUtilizador("celia@gmail.com","gil@gmail.com");
         
        
        
        
        Mult_cache kk =new Mult_cache("batata","Meduim","CacheMisterio",u2,d2,d3,caminho1,"carlos@gmail.com");
        Cache_misterio ip =new Cache_misterio("guimarães","4","2+2","Medium","CacheMisterio",u3,d3,d2,u3,"margarida@gmail.com");
        Mult_cache ki =new Mult_cache("r","Samll","CacheMisterio",u4,d3,d2,caminho1,"celia@gmail.com");
        
        
        
       
        
        Gestor menu = new Gestor(geo);
        menu.inicial();
       
        
     
            
 
       
       
        }
}
