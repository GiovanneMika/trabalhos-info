package bd;


import java.sql.*;
import javax.swing.JOptionPane;
import vo.Usuario;

/**
 *
 * @author pcnov
 */
public class BdUsuario {

    public void insere(Usuario usuario) {
        String sql = "insert into usuario (nome,user,senha) values(?,?,?)";
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getUser());
            ps.setString(3, usuario.getSenha());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }

    public void atualiza(Usuario usuario) {
        String sql = "update usuario set nome=?, senha=? where user=?";
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getUser());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }

    public Usuario localiza(String user) {
        String sql = "select * from usuario where user=?";
        Usuario registro = new Usuario();
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                registro.setUser(rs.getString("user"));
                registro.setNome(rs.getString("nome"));
                registro.setSenha(rs.getString("senha"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
        return registro;
    }

    public void exclui(String user) {
        String sql = "delete from usuario where user=?";
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setString(1, user);
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }
}
