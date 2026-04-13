package BD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    public Connection con;
    public Connection getConnection () throws SQLException, ClassNotFoundException {
        String driver = "com.mysql.cj.jdbc.Driver"; //"com.mysql.jdbc.Driver" => Conexion antigua
        String url = "jdbc:mysql://localhost:3306/pad2026";
        Class.forName(driver);
        return DriverManager.getConnection(
                url,
                "root",
                "Lucasjumbolol00_");
    }

    public Connection AbrirConexion() throws SQLException, ClassNotFoundException {
        con = getConnection();
        return con;
    }

    public void CerrarConexion() throws SQLException {
        con.close();
    }
}