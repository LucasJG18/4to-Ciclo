package practica_threads;

import Clases.TablaNum;
import Logica.TablaNumJpaController;

public class Practica_Threads {
    public static void main(String[] args) {
        TablaNum objN;
        TablaNumJpaController objCtr = new TablaNumJpaController();
        for (int i = 0; i < 1000; i++){
            for (int j = 0; j < 1000; j++){
                objN = new TablaNum((int)(Math.random() * 20) + 1, 
                        (int)(Math.random() * 20) + 1, (int)(Math.random() * 20) + 1, 
                        (int)(Math.random() * 20) + 1, (int)(Math.random() * 20) + 1);
                objCtr.create(objN);
            }
        }
    }
}


