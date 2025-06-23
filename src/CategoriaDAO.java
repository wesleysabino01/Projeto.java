import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2830482321037
 */
public class CategoriaDAO {  
    
    private conexao conexao; 
    private Connection conn;  
    
    
    public CategoriaDAO () {
         this.conexao = new conexao ();
        this.conn = this.conexao.getconexao();
    } 
    public void inserir (Categoria categoria){
        String sql = "INSERT INTO Categoria(cat_nome, cat_descricao)VALUES (?,?);";
        
        try { 
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setString(1, categoria.getNome());
                stmt.setString(2, categoria.getDescricao());
             
                
                stmt.execute();
        } 
        
        catch (SQLException ex) {
            System.out.println("ERRO AO INSERIR CATEGORIA:"+ ex.getMessage());
        }
        
        
    }  
    
   /* public Categoria getIdcategoria(int id) {
        String sql = "SELECT * from categoria Where cat_IdCategoria= ?";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE); 
            stmt.setInt(1,id); 
            ResultSet rs = stmt.executeQuery();
            Categoria c = new Categoria(); 
            rs.first();
            c.setIdcategoria(id);
            c.setNome(rs.getString("cat_nome"));
            c.setDescricao(rs.getString("cat_descricao"));
          
            
            return c;        
            
        } catch (SQLException ex) {
        System.out.println("ERRO ao Consultar Categoria"+ ex.getMessage()); 
        }
        return null;
    } */ 

public List<Categoria> getCategoria(){
        String sql = "SELECT * FROM categoria ";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            List<Categoria> listaCategoria = new ArrayList();
            while(rs.next()){
               Categoria c = new Categoria(); 
               c.setIdcategoria(rs.getInt("cat_idCategoria"));
               c.setNome(rs.getString("cat_nome"));
               c.setDescricao(rs.getString("cat_descricao"));
               listaCategoria.add(c);
            }
            return listaCategoria;
        } catch(SQLException ex){
            System.out.println("Erro ao consultar categorias: " + ex.getMessage());
            return null;
        }
    }    
    
    public void editar(Categoria categoria) {
        
        try {
            String sql = "UPDATE categoria set cat_idCategoria=?, cat_nome=?, cat_descricao=? WHERE cat_IdCategoria=?"; 
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,categoria.getIdcategoria());
            stmt.setString(2,categoria.getNome());
            stmt.setString(3,categoria.getDescricao()); 
           
            stmt.execute (); 
            
        }  catch (SQLException ex) {
            System.out.println("ERRO ao atualizar Categoria"+ ex.getMessage()); 
        }
        
    }  
    public void excluir ( int id) {
        try {
            String sql = "delete from categoria WHERE cat_IdCategoria=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.execute(); 
            
        } catch (SQLException ex) {
            System.out.println("ERRO AI EXCLUIR CATEGORIA"+ex.getMessage());
        }
        
    }
    
}
