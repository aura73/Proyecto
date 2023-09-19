import java.util.Scanner;

public class Barcos {
    //Variables que existen para todo el codigo 
    static char[][] matriz;
    static int[] tiposBarcos = {0, 0, 1, 1, 2, 3};
    static int TAMANO = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        matriz = inicializarMatriz();
        boolean posicionValida = true;

        String[] mensajes = {
                "Ingrese la coordenada del barco %d (fila columna) tenga encuenta que el barco  ocupa 1 casilla",
                "Ingrese la coordenada del barco %d (fila columna) tenga encuenta que el barco  ocupa 1 casilla",
                "Ingrese la coordenada del barco %d (fila columna) tenga encuenta que el barco  ocupa 2 casilla verticalmente",
                "Ingrese la coordenada del barco %d (fila columna) tenga encuenta que el barco  ocupa 2 casilla verticalmente" ,
                "Ingrese la coordenada del barco %d (fila columna) tenga encuenta que el barco  ocupa 3 casilla horizontalmente" ,
                "Ingrese la coordenada del barco %d (fila columna) tenga encuenta que el barco  ocupa 4 casilla horizontalmente"
        };

        for(int i = 0; i < tiposBarcos.length; i++){
            int tipoBarco = tiposBarcos[i];
            do {
                System.out.print(String.format(mensajes[i], i+1));
                int f1 = scanner.nextInt();
                int c1 = scanner.nextInt();
                posicionValida = adicionarBarco(f1, c1, tipoBarco);
                imprimirMatriz();
            }while (posicionValida == false);
        }
    }
    //char[][] significa devolver matriz
    private static char[][] inicializarMatriz() {
        char[][] matriz = new char[TAMANO][TAMANO];
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                matriz[i][j] = '*';
            }
        }
        return matriz;
    }

    static boolean posicionValida(int coordenada){
        return (coordenada >= 0 && coordenada <= TAMANO);
    }

    static boolean adicionarBarco(int f1, int c1, int tipoBarco){
        if (!(posicionValida(f1) && posicionValida(c1))){
            System.out.println("Posición por fuera de la matriz");
            return false;
        }

        switch (tipoBarco){
            case 0:
                return barco1(f1, c1);
            case 1:
                return barco2(f1, c1);
            case 2:
                return barco3(f1, c1);
            case 3:
                return barco4(f1, c1);
            default:
                System.out.println("Barco inválido");
                return false;
        }
    }

    //Método para ubicar barcos de UNA casilla
    private static boolean barco1(int f1, int c1) {
        int fila = f1;
        int columna = c1;
        if (matriz[fila][columna] != '*') {
            System.out.println("Casilla ocupada");
            return false;
        }

        char barco =  'D';
        matriz[fila][columna] = barco;
        return true;
    }

    private static boolean barco2(int f1, int c1) {
        int fila = f1;
        int columna = c1;
        if(fila > TAMANO - 2){
            System.out.println("Espacio insuficiente");
            return false;
        }
        if (matriz[fila][columna] != '*' || matriz[fila + 1][columna] != '*') {
            System.out.println("Casilla ocupada");
            return false;
        }
        char barco = 'A';
        matriz[fila][columna] = barco;
        matriz[fila + 1][columna] = barco;
        return true;
    }
    //Método para ubicar barco de TRES casillas
    private static boolean barco3(int f1, int c1) {
        int fila = f1;
         int columna = c1;
        if(columna > TAMANO - 3){
            System.out.println("Espacio insuficiente");
            return false;
        }
        if (matriz[fila][columna] != '*' || matriz[fila][columna + 1] != '*' || matriz[fila][columna + 2] != '*') {
            System.out.println("Casilla ocupada");
            return false;
        }
        char barco = 'C';
        matriz[f1][c1] = barco;
        matriz[f1][c1 + 1] = barco;
        matriz[f1][c1 + 2] = barco;
        return true;
    }
    //Método para ubicar barcos de CUATRO casillas horizontal
    private static boolean barco4(int f1, int c1) {
        int fila = f1;
        int columna = c1;
        if(columna > TAMANO - 4){
            System.out.println("Espacio insuficiente");
            return false;
        }
        if (matriz[fila][columna] != '*' || matriz[fila][columna + 1] != '*' || matriz[fila][columna + 2] != '*' || matriz[fila][columna + 3] != '*') {
            System.out.println("Casilla ocupada");
            return false;
        }

        char barco = 'F';
        matriz[fila][columna] = barco;
        matriz[fila][columna + 1] = barco;
        matriz[fila][columna + 2] = barco;
        matriz[fila][columna + 3] = barco;
        return true;
    }
    private static void imprimirMatriz() {
        System.out.println("Matriz con barcos:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
