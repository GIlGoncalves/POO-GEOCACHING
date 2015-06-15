

import static java.lang.System.out;
import java.io.*;
public class Menus implements Serializable
{
    public Menus() { }
    
    public String MenuRemoverAtividade() {
        StringBuilder s = new StringBuilder();
        s.append("\n1 - Remover");
        s.append("\n0 - Voltar Atrás\n\n");
        return s.toString();
    }
    
    public String MenuVerDetalhesAtividade() {
        StringBuilder s = new StringBuilder();
        s.append("\n1 - Ver Detalhes");
        s.append("\n0 - Voltar Atrás\n\n");
        s.append("Opcao: ");
        return s.toString();
    }
    
    public String MenuRemoverCache(){
      StringBuilder s = new StringBuilder();
        s.append("\n1 - Remover");
        s.append("\n0 - Voltar Atrás\n\n");
        return s.toString();
    
    }
    
    public String MenuVerDetalhesCache() {
        StringBuilder s = new StringBuilder();
        
        s.append("1 - Ver Detallhes\n");
        s.append("0 - Volta atras\n");
        s.append("Opcao: ");
        return s.toString();
    }
    
    public String MenuDetalhesAtividade() {
        StringBuilder s = new StringBuilder();
        s.append("1 - Remover Atividade\n");
        s.append("0 - Voltar Atrás\n\n");
        s.append("Opção: ");
        return s.toString();
    }
    
    public String MenuConsultaAtividades() {
        StringBuilder s = new StringBuilder();
        s.append("1 - Ver Detalhes\n");
        s.append("2 - Remover Atividade\n");
        s.append("0 - Voltar Atrás\n\n");
        s.append("Opção: ");
        return s.toString();
    }
    
    public String MenuAtividades() {
        StringBuilder s = new StringBuilder();
        s.append("========= ATIVIDADES =========\n");
        s.append("1 - Registar Atividade\n");
        s.append("2 - Consultar Atividades Mais Recentes\n");
        s.append("3 - Consultar Lista Completa Atividades\n");
        s.append("4 - Estatísticas\n");
        s.append("0 - Voltar Atrás\n\n");
        s.append("Opção: ");
        return s.toString();
    }
    
    public String MenuAmigos() {
        StringBuilder s = new StringBuilder();
        s.append("========= AMIGOS =========\n");
        s.append("1 - Lista de Amigos\n");
        s.append("2 - Adicionar Amigo\n");
        s.append("3 - Remover Amigo\n");
        s.append("4 - Consultar Atividades Recentes de Amigos\n");
        s.append("5 - Consultar Estatísticas das actividades dos Amigos\n");
        s.append("6 - Consultar Caches encontradas pelo Amigo\n");
        s.append("7 - Consultar Estatísticas das caches dos Amigos\n");
        s.append("8 - Consultar caches criadas pelos amigo\n");
        
        s.append("0 - Voltar Atrás\n\n");
        s.append("Opção: ");
        return s.toString();
    }
    
    public String MenuClienteLogado(String nome) {
        StringBuilder s = new StringBuilder();
        s.append("Bem-vindo, " + nome +"\n");
        s.append("-----------------------------------\n");
        s.append("1  -  Ver Dados Pessoais\n");
        s.append("2  -  Amigos\n");
        s.append("3  -  Atividades\n");
        s.append("4  -  Gravar Dados\n");
        s.append("5  -  Caches\n");
        s.append ("6 - Ver os pedidos de amizade\n");
        s.append ("7 - Enviar um pedido de amizade \n");
        s.append("0  -  Logout\n");
        s.append("Opcao: ");
        return s.toString();
    }
        
    public String MenuPrincipal() {
        StringBuilder s = new StringBuilder();
        s.append("========================\n");
        s.append("==== Menu Principal ====\n");
        s.append("1 - Registar\n");
        s.append("2 - Login\n");
        s.append("3 - Carregar Dados\n");
        s.append("4 - Adim\n");
        s.append("0 - Fechar Aplicação\n");
        s.append("========================\n");
        s.append("Opcao: ");
        return s.toString();
    }
    
    
    public String MenuCache(){
    StringBuilder s = new StringBuilder();
    s.append("=================\n");
    s.append("=======Caches=======\n");
    s.append("1  -  Consultar caches encontradas\n");
    s.append("2  -  Consultar estatistica das caches\n");
    s.append ("3 -  Report abuse cache\n");
    s.append ("4 -  Consultar caches  criada\n");
    s.append ("5  - Consultar caches do sistema\n");
    s.append("0  -   Voltar Atrás\n\n");
    s.append("Opção: ");
    return s.toString();
    }
    
    public String MenuAdminLogado(String nome){
    StringBuilder s = new StringBuilder();
    s.append("Bem-vindo, " + nome +"\n");
    s.append("1   - Criar caches\n");
    s.append("2   - Remover Caches criadas\n");
    s.append ("3  - Remover caches reportadas\n");
    s.append ("4  - Consultas caches criadas\n");
    s.append("0  -  Logout\n");
    s.append("Opcao:   ");
    
    return s.toString();
    }
    
    public String tipoDeCache(){
    StringBuilder s = new StringBuilder();
    s.append("1 - MicroCache\n");
    s.append("2 - MultCache\n");
    s.append("3 - CacheMisterio\n");
    s.append("Opcao:   ");
    return s.toString();
    }
    
    public String tamanhosDeCache(){
     StringBuilder s = new StringBuilder();
     s.append("Introduza o tamanho :");
     s.append("1 - Small\n");
     s.append("2 - Medium\n");
     s.append("3 - Large\n");
     s.append("Opcao:     ");
     
     return s.toString();
    
    }
    
    public String meteorologia() {
    
       StringBuilder s = new StringBuilder();
       s.append("Introduza o tempo :\n");
       s.append("1 -  Sol\n");
       s.append("2 - Chuca\n");
       s.append("3 - Vento\n");
       s.append("Opcao:     ");
     
       return s.toString();
   
    }
    
}
