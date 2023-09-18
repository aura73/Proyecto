import java.util.Random;
import java.util.Scanner;
public class Disparos {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int TAMANO = 7;
        char[][] matriz = inicializarMatriz(TAMANO);
        barco1(matriz,TAMANO);
        barco2(matriz, TAMANO);
        barco3(matriz, TAMANO);
        barco4(matriz, TAMANO);
        imprimirMatriz(matriz);


        int barcosRestantes =6; // Inicialmente hay 6 barcos

        while (barcosRestantes > 0) {
            System.out.print("Ingrese una coordenada (fila columna): ");
            int filaUsuario = scanner.nextInt();
            int columnaUsuario = scanner.nextInt();

            if (verificarCoordenada(matriz, filaUsuario, columnaUsuario)) {
                barcosRestantes--;
                if (barcosRestantes == 0) {
                    System.out.println("¡Has hundido todos los barcos!");
                    break;
                }
            }
        }

        System.out.println("Fin del juego.");

    }
    private static boolean verificarCoordenada(char[][] matriz, int filaUsuario, int columnaUsuario) {
        if (filaUsuario >= 0 && filaUsuario < matriz.length && columnaUsuario >= 0 && columnaUsuario < matriz[0].length) {
            char objeto = matriz[filaUsuario][columnaUsuario];
            if (objeto != '*') {
                System.out.println("¡Hay un barco en esa coordenada! (" + objeto + ")");
                matriz[filaUsuario][columnaUsuario] = '/';
                return true; // Devuelve true si se acertó un barco
            } else {
                System.out.println("No hay un barco en esa coordenada.");
            }
        } else {
            System.out.println("Coordenada fuera de rango.");
        }
        return false; // Devuelve false si no se acertó un barco o la coordenada estaba fuera de rango
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
