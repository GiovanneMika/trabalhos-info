package bd;
import java.sql.*;
/**
 *
 * @author pcnov
 */
public class Bd {
    private static Connection con = null;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost/aluno";
    private static final String usuario = "root";
    private static final String senha = "vertrigo";
    public static Connection getCon() {
        try {
            if (con == null || con.isClosed()) {
                Class.forName(driver);
                con = DriverManager.getConnection(url, usuario, senha);
            }
        } catch (Exception e) {
            System.out.println(" erro na conexao\n" + e.getMessage());
        }
        return con;
    }
    public static void setCon(Connection cone) {
        con = cone;
    }
}

