
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author 2830482321037
 */
public class ClienteDAO {  
    
      private conexao conexao; 
    private Connection conn; 
   

 public ClienteDAO () {
        this.conexao = new conexao ();
        this.conn = this.conexao.getconexao();
    }  
public void inserir (Cliente cliente){
        String sql = "INSERT INTO cliente(cli_cpf,cli_nome ,cli_email)VALUES (?,?,?);";
        
        try { 
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setString(1, cliente.getCpf());
                stmt.setString(2, cliente.getNome());
                stmt.setString(3, cliente.getEmail());
                
                stmt.execute();
        } 
        
        catch (SQLException ex) {
            System.out.println("ERRO AO INSERIR CLIENTE:"+ ex.getMessage());
        }
        
         
    }  
 public Cliente getCliente(String id) {
        String sql = "SELECT * from cliente Where cli_cpf= ?";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE); 
            stmt.setString(1,id); 
            ResultSet rs = stmt.executeQuery();
            Cliente r = new Cliente(); 
            rs.first();
            r.setCpf(id);
            r.setNome(rs.getString("cli_nome"));
            r.setEmail(rs.getString("cli_email")); 
            
            return r;        
            
        } catch (SQLException ex) {
        System.out.println("ERRO ao Consultar Cliente"+ ex.getMessage()); 
        }
        return null;
    }    
         public void editar(Cliente cliente) {
        
        try {
            String sql = "UPDATE cliente set cli_cpf=?, cli_nome=?, cli_email=? WHERE cli_cpf=?"; 
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,cliente.getCpf());
            stmt.setString(2,cliente.getNome()); 
            stmt.setString(3,cliente.getEmail());
            stmt.execute (); 
            
        }  catch (SQLException ex) {
            System.out.println("ERRO ao atualizar Cliente"+ ex.getMessage());
        }
        
    }  
         
          public void excluir ( int id) {
        try {
            String sql = "delete from cliente WHERE cli_cpf=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.execute(); 
            
        } catch (SQLException ex) {
            System.out.println("ERRO AI EXCLUIR Cliente"+ex.getMessage());
        }
        
    }  
          public List<Cliente> listarClientes() {
    List<Cliente> lista = new ArrayList<>();
    String sql = "SELECT * FROM cliente";

    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Cliente c = new Cliente();
            c.setCpf(rs.getString("cli_cpf"));
            c.setNome(rs.getString("cli_nome"));
            c.setEmail(rs.getString("cli_email"));
            lista.add(c);
        }
    } catch (SQLException ex) {
        System.out.println("Erro ao listar clientes: " + ex.getMessage());
    }

    return lista;
}
          

}
