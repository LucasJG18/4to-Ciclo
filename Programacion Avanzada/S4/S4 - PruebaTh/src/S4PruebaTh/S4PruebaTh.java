package S4PruebaTh;
import static java.lang.Thread.sleep;
public class S4PruebaTh{
    public static void main(String[] args) {
        PruebaTh t1, t2, t3;
        
        t1 = new PruebaTh("Thread 1", (int)(Math.random()*2000));
        t2 = new PruebaTh("Thread 2", (int)(Math.random()*2000));
        t3 = new PruebaTh("Thread 3", (int)(Math.random()*2000));
        
        t1.start();
        t2.start();
        t3.start();
    }
}

class PruebaTh extends Thread {
    private String nombre;
    private int retardo;

    public PruebaTh(String s, int d) {
        nombre = s;
        retardo = d;
    }

    public void run() {
        try {
            sleep(retardo);
        } catch (Exception e) {
        }

        System.out.println("Hola Mundo! " + nombre + " " + retardo);
    }
}