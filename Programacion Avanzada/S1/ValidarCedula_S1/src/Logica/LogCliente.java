package Logica;
import BD.BDCliente;
import Clases.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LogCliente {
    BDCliente objBDCliente = new BDCliente();
    public boolean ValidarCedula(Cliente objCliente)
            throws ClassNotFoundException, SQLException {
        if (objCliente.getCedula().length()==10)
            objBDCliente.InsertarCliente(objCliente);
        else
            return false;
        return true;
    }

    public Cliente BuscarCliente(Cliente cliente)
            throws SQLException, ClassNotFoundException {
        ResultSet rs = objBDCliente.BuscarClienteCedula(cliente);
        if(rs.next()){
            return new Cliente(rs.getString("cedula"), rs.getString("nombre"));
        }
        return null;
    }

    public boolean ActualizarCliente(String cedulaVieja, Cliente cliente)
            throws SQLException, ClassNotFoundException {
        return objBDCliente.ActualizarClienteCedula(cedulaVieja, cliente);
    }

    public ArrayList<Cliente> ListarClientes()
            throws SQLException, ClassNotFoundException {
        ResultSet rs = objBDCliente.ListarClientes();
        ArrayList<Cliente> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Cliente(rs.getString("cedula"), rs.getString("nombre")));
        }
        return lista;
    }
}