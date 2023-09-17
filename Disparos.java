import java.util.Random;
import java.util.Scanner;
public class Disparos {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int TAMANO = 7;
        char[][] matriz = inicializarMatriz(TAMANO);
        barco1(matriz,TAMANO);
        imprimirMatriz(matriz);
    }
    private static char[][] inicializarMatriz(int TAMANO) {
        char[][] matriz = new char[TAMANO][TAMANO];
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                matriz[i][j] = '*';
            }
        }
        return matriz;
    }
    private static void barco1(char[][] matriz, int TAMANO) {
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            int fila = random.nextInt(TAMANO);
            int columna = random.nextInt(TAMANO);

            while (matriz[fila][columna] != '*') {
                fila = random.nextInt(TAMANO);
                columna = random.nextInt(TAMANO);
            }

            char barco = (char) ('D' + i); // 'A', 'B', 'C', ...
            matriz[fila][columna] = barco;
        }    }
    private static void imprimirMatriz(char[][] matriz) {
        System.out.println("Matriz con barcos:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void barco2(char[][] matriz, int TAMANO) {
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            int fila = random.nextInt(TAMANO-1);
            int columna = random.nextInt(TAMANO );

            while (matriz[fila][columna] != '*' || matriz[fila+1][columna] != '*') {
                fila = random.nextInt(TAMANO-1);
                columna = random.nextInt(TAMANO );
            }

            char barco = (char) ('A' + i);
            matriz[fila][columna] = barco;
            matriz[fila+1][columna] = barco;

        }

    }
    private static void barco3(char[][] matriz, int TAMANO) {
        Random random = new Random();
        int fila = random.nextInt(TAMANO);
        int columna = random.nextInt(TAMANO - 2);

        while (matriz[fila][columna] != '*' || matriz[fila][columna + 1] != '*' || matriz[fila][columna + 2] != '*') {
            fila = random.nextInt(TAMANO);
            columna = random.nextInt(TAMANO - 2);
        }

        char barco = (char) ('C' ); // 'A', 'B', 'C', ...
        matriz[fila][columna] = barco;
        matriz[fila][columna + 1] = barco;
        matriz[fila][columna + 2] = barco;
    }
    private static void barco4(char[][] matriz, int TAMANO) {
        Random random = new Random();
        int fila = random.nextInt(TAMANO);
        int columna = random.nextInt(TAMANO - 3);

        while (matriz[fila][columna] != '*' || matriz[fila][columna + 1] != '*' || matriz[fila][columna + 2] != '*'|| matriz[fila][columna +3] != '*') {
            fila = random.nextInt(TAMANO);
            columna = random.nextInt(TAMANO -3);
        }

        char barco = (char) ('F' ); // 'A', 'B', 'C', ...
        matriz[fila][columna] = barco;
        matriz[fila][columna + 1] = barco;
        matriz[fila][columna + 2] = barco;
        matriz[fila][columna + 3] = barco;
    }
}
