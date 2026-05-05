package Clases;
import Clases.TablaNum;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Hilo extends Thread {

    private List<TablaNum> lista;
    private int inicio;
    private int fin;
    private int n;
    private AtomicInteger total;

    public Hilo(List<TablaNum> lista, int inicio, int fin, int n, AtomicInteger total) {
        this.lista = lista;
        this.inicio = inicio;
        this.fin = fin;
        this.n = n;
        this.total = total;
    }

    @Override
    public void run() {
        int contador = 0;

        for (int i = inicio; i < fin; i++) {
            TablaNum t = lista.get(i);

            if (t.getCol1() == n) contador++;
            if (t.getCol2() == n) contador++;
            if (t.getCol3() == n) contador++;
            if (t.getCol4() == n) contador++;
            if (t.getCol5() == n) contador++;
        }

        total.addAndGet(contador);
    }
}