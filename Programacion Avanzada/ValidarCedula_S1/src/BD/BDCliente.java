package BD;
import Clases.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author LucasJG
 * Clase para CRUD de los clientes
 */

public class BDCliente {
    Conexion BLcon = new Conexion();
    public int InsertarCliente(Cliente objCliente)
            throws ClassNotFoundException, SQLException {
        String Sentencia = "insert into clientes (cedula, nombre, idclient)"
                + "values (?,?,?)" ;
        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);
        ps.setString(1,objCliente.getCedula());
        ps.setString(2,objCliente.getNombre());
        ps.setInt(3, 0);
        return ps.executeUpdate();
    }

    /*public int InsertarCliente1 (Cliente objCliente){ //no se debe hacer
        Statement st = (Statement) BLcon.AbrirConexion().createStatement();
        String Sentencia = "Insert into CLIENTEs (cedula, nombres) "
                + "values  (" + objCliente.getCedula()+","+objCliente.getNombre()+")";
        return st.executeUpdate(Sentencia);
    }*/

    public ResultSet BuscarClienteCedula(Cliente objCliente)
            throws SQLException, ClassNotFoundException {
        String Sentencia = "SELECT * FROM Clientes where cedula = ?";
        PreparedStatement ps= BLcon.getConnection().prepareStatement(Sentencia);
        ps.setString(1, objCliente.getCedula());
        return ps.executeQuery();
    }

    public boolean ActualizarClienteCedula(String cedulaVieja, Cliente objCliente)
            throws ClassNotFoundException, SQLException {
        String Sentencia = "UPDATE Clientes SET cedula = ?, nombre = ? WHERE cedula = ?";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);
        ps.setString(1, objCliente.getCedula());
        ps.setString(2, objCliente.getNombre());
        ps.setString(3, cedulaVieja);
        return ps.executeUpdate() > 0;
    }

    public ResultSet ListarClientes()
            throws ClassNotFoundException, SQLException {
        String Sentencia = "SELECT * FROM Clientes";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);
        return ps.executeQuery();
    }
}