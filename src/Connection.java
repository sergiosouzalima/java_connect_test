
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Connection {
  
  public static void main ( String[] args ) {
    String stringDeConexao = "jdbc:mysql://localhost:3306/testdb";
    String usuario = "root";
    String senha = "123456";
    try {
      System.out.println("Abrindo conexão...");
      java.sql.Connection conexao =
        DriverManager.getConnection( stringDeConexao, usuario, senha );
      String sql = "SELECT * FROM Test;";
      PreparedStatement comando = conexao.prepareStatement(sql);
      System.out.println("Executando comando...") ;
      ResultSet resultado = comando.executeQuery () ;
      System.out.println("Resultados encontrados:\n");
      while ( resultado.next () ) {
        System.out.printf (" %d : %s - %s\n" ,
          resultado.getInt("id"),
          resultado.getString("name") ,
          resultado.getString("email") );
      } 
      System.out.println ("\nFechando conexão...");
      conexao.close();
    } catch ( Exception e ) { e.printStackTrace(); }
  }

}