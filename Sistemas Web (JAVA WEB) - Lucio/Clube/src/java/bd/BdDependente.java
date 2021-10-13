package bd;

import vo.Dependente;
import vo.Socio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pcnov
 */
public class BdDependente {

    public void insere(Dependente dependente) {
        String sql = "insert into dependente(nome,idade,idSocio) values(?,?,?)";
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setString(1, dependente.getNome());
            ps.setInt(2, dependente.getIdade());
            ps.setInt(3, dependente.getIdSocio());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }
    }

    public void salva(Dependente dependente) {
        if (dependente.getId() == 0) {
            insere(dependente);
        } else {
            String sql = "update dependente set nome=?,idade=?,idSocio=? where id=?";
            try {
                PreparedStatement ps = Bd.getCon().prepareStatement(sql);
                ps.setInt(4, dependente.getId());
                ps.setString(1, dependente.getNome());
                ps.setInt(2, dependente.getIdade());
                ps.setInt(3, dependente.getIdSocio());
                ps.execute();
            } catch (SQLException e) {
                System.out.println("Erro SQL: " + e.getMessage());
            }
        }
    }

    public Dependente localiza(int id) {
        String sql = "select * from dependente where id=?";
        Dependente registro = new Dependente();
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                registro.setId(rs.getInt("id"));
                registro.setNome(rs.getString("nome"));
                registro.setIdade(rs.getInt("idade"));
                registro.setIdSocio(rs.getInt("idSocio"));
            }
        } catch (SQLException e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }
        return registro;
    }

    public List pesquisa(Integer busca) {
        String sql = "select * from dependente where idSocio like ?";
        List lista = new ArrayList();
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setString(1, "%" + busca + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Dependente registro = new Dependente();
                registro.setId(rs.getInt("id"));
                registro.setNome(rs.getString("nome"));
                registro.setIdade(rs.getInt("idade"));
                registro.setIdSocio(rs.getInt("idSocio"));
                lista.add(registro);
            }
        } catch (SQLException e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }
        return lista;
    }

    public void exclui(int id) {
        String sql = "delete from dependente where id=?";
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }
    }
}
