
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
public class ProdutoDAO { 
     private conexao conexao; 
    private Connection conn; 
    
 

  public ProdutoDAO () {
        this.conexao = new conexao ();
        this.conn = this.conexao.getconexao();
}  
   public void inserir (Produto produto){
        String sql = "INSERT INTO Produto(pro_codigoDeBarra,pro_nome,pro_peso,Categoria_cat_idCategoria)VALUES (?,?,?,?);";
        
        try { 
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setString(1, produto. getCodigodebarra());
                stmt.setString(2, produto.getNome()); 
                stmt.setFloat (3, produto.getPeso());
                stmt.setInt(4, produto.getIdcategoria());
                
                stmt.execute();
        } 
        
   
        
        catch (SQLException ex) {
            System.out.println("ERRO AO INSERIR PRODUTO:"+ ex.getMessage());
        }  
        
   }
        
        public Produto getProduto(int id) {
        String sql = "SELECT * from produto Where pro_codigoDeBarra= ?";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE); 
            stmt.setInt(1,id); 
            ResultSet rs = stmt.executeQuery();
            Produto p = new Produto(); 
            rs.first();
            p.setIdcategoria(id);
            p.setNome(rs.getString("pro_nome"));
            p.setCodigodebarra(rs.getString("pro_codigoDeBarra"));
            p.setPeso(rs.getFloat("pro_peso"));  
             p.setIdcategoria(rs.getInt("Idcategoria")); 
            
            return p;        
            
        } catch (SQLException ex) {
        System.out.println("ERRO ao Consultar PRODUTO"+ ex.getMessage()); 
        }
        return null;
    }    
     
        public void editar(Produto produto) {
        
        try {
            String sql = "UPDATE produto set pro_codigoDeBarra=?, pro_nome=?, pro_peso=?,Categoria_cat_idCategoria=? WHERE pro_codigoDeBarra=?"; 
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,produto.getCodigodebarra());
            stmt.setString(2,produto.getNome());
            stmt.setFloat (3,produto.getPeso()); 
            stmt.setString(4,produto.getCategoria());
            
            stmt.execute (); 
            
        }  catch (SQLException ex) {
            System.out.println("ERRO ao atualizar Produto"+ ex.getMessage());
        }
        
    }  
        public void excluir ( int id) {
        try {
            String sql = "delete from produto WHERE pro_codigoDeBarra=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.execute(); 
            
        } catch (SQLException ex) {
            System.out.println("ERRO AI EXCLUIR PRODUTO"+ex.getMessage());
        }
        
    }

} 
