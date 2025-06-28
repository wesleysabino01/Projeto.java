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
public class notaCDAO { 
    
      private conexao conexao; 
    private Connection conn;  
    
     public notaCDAO () {
        this.conexao = new conexao ();
        this.conn = this.conexao.getconexao();
    
}   
      public void inserir (notaC notacabecario ){
        String sql = "INSERT INTO notacabecario (notac_id,notac_data,notac_VlrTotal)VALUES (?,?,?);";
        
        try { 
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setInt (1,notacabecario. getId());
                stmt.setString(2,notacabecario.getData()); 
                stmt.setFloat (3, notacabecario.getVlrTotal());
              
                
                stmt.execute();
        } 
          catch (SQLException ex) {
            System.out.println("ERRO na nota de cabecario:"+ ex.getMessage());
        }        

}  public notaC getNotac(int id) {
        String sql = "SELECT * from notacabecario Where notac_id= ?";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE); 
            stmt.setInt(1,id); 
            ResultSet rs = stmt.executeQuery();
            notaC n = new notaC(); 
            rs.first();
            n.setId(id);
            n.setData(rs.getString("notac_data"));
            n.setVlrTotal(rs.getFloat("notac_VlrTotal")); 
             n.setId(rs.getInt("notac_id")); 
            
            return n;       
            
            
        } catch (SQLException ex) {
        System.out.println("ERRO ao gerar nota cabecario "+ ex.getMessage()); 
        } 
        return null;
    }     

public void editar(notaC notacabecario) {
        
        try {
            String sql = "UPDATE notacabecario set notac_id=?, notac_data=?, notac_VlrTotal=? WHERE notac_id=?"; 
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,notacabecario.getId());
            stmt.setString(2,notacabecario.getData()); 
            stmt.setFloat(3,notacabecario.getVlrTotal());
          
            stmt.execute (); 
            
        }  catch (SQLException ex) {
            System.out.println("ERRO ao gerar nota cabecario "+ ex.getMessage()); 
        }
         
} 
  public void excluir ( int id) {
        try {
            String sql = "delete from notacabecario WHERE notac_id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.execute(); 
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO GERAR NOTA CABECARIO"+ex.getMessage());
        }
  }
}

