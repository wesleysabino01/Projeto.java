import java.sql.Connection; 
import java.sql.DriverManager;

/**
 *
 * @author 2830482321037
 */
public class conexao { 
    public Connection getconexao(){
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/At1?useTimezone=true&serverTimezone=UTC","root","root");
            System.out.println("conexão realizada com sucesso"); 
            return conn; 
            
        } 
        catch (Exception e) {
            System.out.println("ERRO ao conectar no BD"+e.getMessage()); 
            return null;
        }
    }
    
}
