
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author 2830482321037
 */
public class FornecedorDAO { 
    
    private conexao conexao; 
    private Connection conn; 
    

 
 public FornecedorDAO () {
        this.conexao = new conexao ();
        this.conn = this.conexao.getconexao();
    }   
 
  public void inserir (Fornecedor fornecedor){
        String sql = "INSERT INTO fornecedores(for_idFornecedores, for_nome , for_nomeFantasia)VALUES (?,?,?);";
        
        try { 
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setInt(1, fornecedor.getIdfornecedor());
                stmt.setString(2, fornecedor.getNome());
                stmt.setString(3, fornecedor.getNomefantasia());
               
                
                stmt.execute();
        } 
        
        catch (SQLException ex) {
            System.out.println("ERRO AO INSERIR Fornecedor:"+ ex.getMessage());
        }
        
        
    }  
   public Fornecedor getFornecedor(int id) {
        String sql = "SELECT * from fornecedores Where for_idFornecedores= ?";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE); 
            stmt.setInt(1,id); 
            ResultSet rs = stmt.executeQuery();
            Fornecedor f = new Fornecedor(); 
            rs.first();
            f. setIdfornecedor(id);
            f.setIdfornecedor(rs.getInt("for_idFornecedores"));
            f.setNome(rs.getString("for_nome"));
            f.setNomefantasia(rs.getString("for_nomeFantasia"));
         
            
            return f;        
            
        } catch (SQLException ex) {
        System.out.println("ERRO ao Consultar fornecedor"+ ex.getMessage()); 
        }
        return null;
    }     
   
    public void editar(Fornecedor fornecedor) {
        
        try {
            String sql = "UPDATE pessoa set for_idFornecedores=?, for_nome=?, for_nomeFantasia=? WHERE for_idFornecedores=?"; 
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,fornecedor.getIdfornecedor());
            stmt.setString(2,fornecedor.getNome()); 
            stmt.setString(3,fornecedor.getNomefantasia());
          
            stmt.execute (); 
            
        }  catch (SQLException ex) {
            System.out.println("ERRO ao atualizar fornecedores"+ ex.getMessage());
        }
        
    }  
     
    public void excluir ( int id) {
        try {
            String sql = "delete from fornecedores WHERE for_idFornecedores=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.execute(); 
            
        } catch (SQLException ex) {
            System.out.println("ERRO AI EXCLUIR Fornecedor"+ex.getMessage());
        }
        
    }
        
    

}