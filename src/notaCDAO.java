import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class notaCDAO {

    private conexao conexao;
    private Connection conn;

    public notaCDAO() {
        this.conexao = new conexao();
        this.conn = this.conexao.getconexao();
    }

    public int inserir(notaC nota) throws SQLException {
        String sql = "INSERT INTO nota_cabecario (data, vlr_total) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, nota.getData());
        stmt.setFloat(2, nota.getVlrTotal());
        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        int generatedId = -1;
        if (rs.next()) {
            generatedId = rs.getInt(1);
        }
        rs.close();
        stmt.close();
        return generatedId;
    }

    public notaC getNotac(int id) {
        String sql = "SELECT * FROM notacabecario WHERE notac_id= ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                notaC n = new notaC();
                n.setId(rs.getInt("notac_id"));
                n.setData(rs.getString("notac_data"));
                n.setVlrTotal(rs.getFloat("notac_VlrTotal"));
                rs.close();
                stmt.close();
                return n;
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("ERRO ao buscar nota cabecario " + ex.getMessage());
        }
        return null;
    }

    public void editar(notaC notacabecario) {
        try {
            String sql = "UPDATE notacabecario SET notac_data=?, notac_VlrTotal=? WHERE notac_id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, notacabecario.getData());
            stmt.setFloat(2, notacabecario.getVlrTotal());
            stmt.setInt(3, notacabecario.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("ERRO ao editar nota cabecario " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        try {
            String sql = "DELETE FROM notacabecario WHERE notac_id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("ERRO ao excluir nota cabecario " + ex.getMessage());
        }
    }
}

