package practica_th;

import Clases.Hilo;
import Clases.TablaNum;
import Logica.TablaNumJpaController;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Practica_TH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 0;
        int grupos = 0;

        do {
            System.out.print("Ingrese N (1-20): ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n < 1 || n > 20) {
                    System.out.println("Error: debe estar entre 1 y 20");
                }
            } else {
                System.out.println("Error: ingrese un número válido");
                sc.next();
            }
        } while (n < 1 || n > 20);

        do {
            System.out.print("Ingrese numero de grupos (1-10): ");
            if (sc.hasNextInt()) {
                grupos = sc.nextInt();
                if (grupos < 1 || grupos > 10) {
                    System.out.println("Error: debe estar entre 1 y 10");
                }
            } else {
                System.out.println("Error: ingrese un número válido");
                sc.next();
            }
        } while (grupos < 1 || grupos > 10);

        TablaNumJpaController controller = new TablaNumJpaController();
        List<TablaNum> lista = controller.findTablaNumEntities();
        
        int numF = lista.size();
        int capacidadHilo = numF / grupos;
        int resto = numF % grupos;
        
        AtomicInteger total = new AtomicInteger(0);
        int inicio = 0;
        
        crearHilos(grupos, n, capacidadHilo, resto, inicio, lista, total);
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        
        System.out.println("Coincidencias del numero " + n + ": " + total.get());

        sc.close();
    }

    private static void crearHilos(int grupos, int n, int capacidadHilo, int resto, int inicio, List<TablaNum> lista, AtomicInteger total) {

        for (int i = 0; i < grupos; i++) {

            int fin = inicio + capacidadHilo;

            if (resto > 0) {
                fin++;
                resto--;
            }

            Thread h = new Hilo(lista, inicio, fin, n, total);
            h.start();

            inicio = fin;
        }
    }
}