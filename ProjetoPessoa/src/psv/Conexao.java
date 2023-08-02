/* Esse arquivo tem o intuido de fazer a conexão do Banco de dados (database) com a aplicação.
*
*/

package psv;

//Isso sera um pacote para usar a classe "Connection"
import java.sql.*;

public class Conexao {
    public static Connection abrirConexao(){
        Connection con = null;
        
        try{
            //Driver que será usado para as conexões da aplicação com o Banco de dados
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            //Endereço do servidor do banco de dados
            String url = "";
            url += "jdbc:mysql://127.0.0.1/projetopessoa?";
            
            //Nome do usuário e senha
            url += "user=root&password=";
            
            //Fazer a conexão e passar o valor da nossa String criada
            con = DriverManager.getConnection(url);
            //Vai fazer a impressão de uma mensagem caso a conexão tenha sido feita
            System.out.println("Conexão Aberta");
            
            
        } catch(SQLException e){
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return con;
    }
    
    public static void fecharConexao(Connection con) {
        try{
            con.close();
            System.out.println("Conexão Fechada"); 
            
        } catch(SQLException e){
            System.out.println(e.getMessage());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
