package Logica;

public class Hilo extends Thread {
    private int[][] matriz;
    private int fila;
    private int idHilo;

    public Hilo(int[][] matriz, int fila, int idHilo) {
        this.matriz = matriz;
        this.fila = fila;
        this.idHilo = idHilo;
    }

    @Override
    public void run() {
        int suma = 0;

        for (int j = 0; j < 10; j++) {
            suma += matriz[fila][j];
        }

        matriz[fila][10] = suma;     // total
        matriz[fila][11] = idHilo;   // hilo que hizo la suma
    }
}