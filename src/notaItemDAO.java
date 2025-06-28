import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


public class notaItemDAO {  
    
   
    
      private conexao conexao; 
      private Connection conn;  
    
     public notaItemDAO () {
        this.conexao = new conexao ();
        this.conn = this.conexao.getconexao();
    
} 
    
    
     public void inserir (notaItem notaI ){
        String sql = "INSERT INTO nota_itens (nota_id,nota_quantidade,nota_valor_unitario)VALUES (?,?,?);";
     
     
        try { 
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setInt (1,notaI. getId());
                stmt.setInt(2,notaI.getQuantidade()); 
                stmt.setFloat (3,notaI.getValor());
              
                
                stmt.execute();
        } 
          catch (SQLException ex) {
            System.out.println("ERRO na nota do item:"+ ex.getMessage());
        }        
     } 
       public notaItem getNotaitem(int id) {
        String sql = "SELECT * nota_itens Where nota_id= ?";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE); 
            stmt.setInt(1,id); 
            ResultSet rs = stmt.executeQuery();
            notaItem n1 = new notaItem(); 
            rs.first();
            n1.setId(id);
            n1.setQuantidade(rs.getInt("nota_id"));
            n1.setValor(rs.getFloat("nota_valor_unitario")); 
                       
            return n1;       
            
            
        } catch (SQLException ex) {
        System.out.println("ERRO ao gerar nota do item "+ ex.getMessage()); 
        } 
        return null;
} 
   public void editar(notaItem notaI) {
        
        try {
            String sql = "UPDATE nota_itens set nota_id=?, nota_quantidade=?, nota_valor_unitario=? WHERE nota_id=?"; 
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,notaI.getId());
            stmt.setInt(2,notaI.getQuantidade()); 
            stmt.setFloat(3,notaI.getValor());
          
            stmt.execute (); 
            
        }  catch (SQLException ex) {
            System.out.println("ERRO ao gerar nota do item "+ ex.getMessage()); 
        }
         
}  
   public void excluir ( int id) {
        try {
            String sql = "delete from nota_itens WHERE nota_id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.execute(); 
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO GERAR NOTA DOS ITENS "+ex.getMessage());
        }
  }
}
