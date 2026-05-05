package Presentacion;
import Clases.Cliente;
import Logica.LogCliente;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class D_semana01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        LogCliente objLogCliente = new LogCliente();
        int opc;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Insertar cliente");
            System.out.println("2. Buscar cliente");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Listar clientes");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    System.out.print("Cedula: ");
                    String cedula = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    Cliente objCliente = new Cliente(cedula, nombre);
                    if (objLogCliente.ValidarCedula(objCliente))
                        System.out.println("Cliente insertado!");
                    else
                        System.out.println("Cedula incorrecta");
                    break;

                case 2:
                    System.out.print("Cedula a buscar: ");
                    String cedulaBuscar = sc.nextLine();
                    Cliente encontrado = objLogCliente.BuscarCliente(new Cliente(cedulaBuscar, ""));
                    if (encontrado != null) {
                        System.out.println("Cedula: " + encontrado.getCedula());
                        System.out.println("Nombre: " + encontrado.getNombre());
                    } else {
                        System.out.println("Cliente no encontrado");
                    }
                    break;

                case 3:
                    System.out.print("Cedula actual: ");
                    String cedulaVieja = sc.nextLine();
                    System.out.print("Nueva cedula: ");
                    String cedulaNueva = sc.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nombreNuevo = sc.nextLine();
                    boolean actualizado = objLogCliente.ActualizarCliente(cedulaVieja, new Cliente(cedulaNueva, nombreNuevo));
                    if (actualizado)
                        System.out.println("Cliente actualizado!");
                    else
                        System.out.println("Cedula no encontrada");
                    break;

                case 4:
                    ArrayList<Cliente> lista = objLogCliente.ListarClientes();
                    for (Cliente c : lista) {
                        System.out.println(c.getCedula() + " - " + c.getNombre());
                    }
                    break;

                case 0:
                    System.out.println("Hasta luego!");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opc != 0);
        sc.close();
    }
}