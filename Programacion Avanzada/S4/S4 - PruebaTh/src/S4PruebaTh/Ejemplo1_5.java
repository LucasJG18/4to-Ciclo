package S4PruebaTh;

import java.util.concurrent.atomic.AtomicBoolean;

public class Ejemplo1_5 {
    public static void main(String[] args) {
        corredor t1, t2, t3, t4;
        t1 = new corredor(0);
        t2 = new corredor(0);
        t3 = new corredor(0);
        t4 = new corredor(0);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class corredor extends Thread {
    static AtomicBoolean hayGanador = new AtomicBoolean(false);

    int pasos;

    public corredor(int paso) {
        this.pasos = paso;
    }

    public void run() {
        int num;

        while (!hayGanador.get()) {
            num = (int) (Math.random() * 5);
            pasos += num;

            System.out.println(getName() + "  " + pasos);

            if (pasos > 100 && hayGanador.compareAndSet(false, true)) {
                System.out.println(getName() + "  GANO");
                break;
            }

            try {
                sleep(num);
            } catch (InterruptedException e) {
            }
        }
    }
}