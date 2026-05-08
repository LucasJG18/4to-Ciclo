package Logica;
public class Matriz {
    private int[][] matriz;
    
    public void generarMatriz(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++) {
                matriz[i][j] = (int)(Math.random() * 10);
            }
        }
    }
}