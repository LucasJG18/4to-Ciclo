package celurecarga;

import Clases.*;
import Logica.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

public class CeluRecarga {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        UsuarioJpaController ctrU = new UsuarioJpaController();
        CelularJpaController ctrC = new CelularJpaController();
        ChipJpaController ctrCh = new ChipJpaController();
        RecargaJpaController ctrR = new RecargaJpaController();

        int opcion;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Crear usuario");
            System.out.println("2. Crear celular");
            System.out.println("3. Crear chip");
            System.out.println("4. Realizar recarga");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    System.out.print("Nombre usuario: ");
                    String nombre = sc.nextLine();

                    Usuario user = new Usuario(nombre);
                    ctrU.create(user);

                    System.out.println("Usuario creado con ID: " + user.getIdUsuario());
                    break;

                case 2:
                    System.out.print("ID usuario: ");
                    int idUser = sc.nextInt();
                    sc.nextLine();

                    Usuario userRef = ctrU.findUsuario(idUser);
                    if (userRef == null) {
                        System.out.println("Usuario no existe");
                        break;
                    }

                    System.out.print("Marca: ");
                    String marca = sc.nextLine();

                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();

                    Celular cel = new Celular(marca, modelo, userRef);
                    ctrC.create(cel);

                    System.out.println("Celular creado con ID: " + cel.getIdCelular());
                    break;

                case 3:
                    System.out.print("ID celular: ");
                    int idCel = sc.nextInt();
                    sc.nextLine();

                    Celular celRef = ctrC.findCelular(idCel);
                    if (celRef == null) {
                        System.out.println("Celular no existe");
                        break;
                    }

                    int cantidad = ctrCh.countChipsByCelular(idCel);

                    if (cantidad >= 2) {
                        System.out.println("ERROR: maximo 2 chips");
                        break;
                    }

                    System.out.print("Numero: ");
                    String numero = sc.nextLine();

                    System.out.print("Saldo inicial: ");
                    String saldoStr = sc.nextLine();

                    Chip chip = new Chip(numero, new BigDecimal(saldoStr), celRef);
                    ctrCh.create(chip);

                    System.out.println("Chip creado con ID: " + chip.getIdChip());
                    break;

                case 4:
                    System.out.print("ID chip: ");
                    int idChip = sc.nextInt();
                    sc.nextLine();

                    Chip chipRef = ctrCh.findChip(idChip);
                    if (chipRef == null) {
                        System.out.println("Chip no existe");
                        break;
                    }

                    System.out.print("Valor recarga: ");
                    String valorStr = sc.nextLine();

                    BigDecimal valor = new BigDecimal(valorStr);

                    Recarga rec = new Recarga(valor, new Date(), chipRef);

                    // actualizar saldo
                    chipRef.setSaldo(chipRef.getSaldo().add(valor));
                    ctrCh.edit(chipRef);

                    ctrR.create(rec);

                    System.out.println("Recarga realizada");
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 0);

        sc.close();
    }
}