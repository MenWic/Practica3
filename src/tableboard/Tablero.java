package src.tableboard;

public class Tablero {
    //Variables globales de la clase
    private static String space;
    /* --- ESTAS VARIABES LAS USE EN src.tablero.Ficha ---
    private String ficha1 = " O ";
    private String ficha2 = " X ";
    private String lettWhite;
    */
    private String fondWhite; 
    private String fondBlack;
    private String fondReset;
    private String lettReset;
    protected String [][] tablero;

    //Posicion 0,0 es igual a "___" (3 espacios para no alterar el orden de los cuadros)
    public Tablero(){
        //Inicializando tablero de 8x8 mas 1x1 extra para ngresar referencia de coordenadas
        this.tablero = new String[10][10];

        //Variables locales de tablero
        tablero[0][0]="   "; //Posicion 0,0 es igual a "   " (3 espacios para no alterar el orden de los cuadros)
        space = "   ";
        fondWhite = "\u001B[47m"; //Color fondo blanco
        fondBlack = "\u001B[40m"; //Color fondo negro
        /*lettWhite = "\u001B[37m"; //Color letra blanco
        lettBlack = "\u001B[30m"; //color letra negra */
        fondReset = "\u001B[10m"; // Color fondo default
        lettReset = "\u001B[0m"; //color letra default
    }

    //Getters y Setters
    public static String getSpace() {
        return space;
    }

    public static void setSpace(String space) { //No lo pienso usar
        Tablero.space = space;
    }

    public String[][] getTablero() { 
        return tablero;
    }

    public void setTablero(String[][] tablero) { //Quiza se use para los movimientos de fichas
        this.tablero = tablero;
    }
    
    //Metodo para imprimir Tablero
    public void imprimirTablero() {
        System.out.println("\n");
        for(int i=1;i<9;i++){ //Imprme numeros de referencia superiores "X"
            System.out.print(" "+tablero[0][i]);
        }
        System.out.println(""); //Para continuar en siguiente fila, si no "out of bounds"

        for (int i = 1; i < 9; i++) { //Imprime numeros de referencia laterales "Y", la posicion 1 equivale a la 2da posicion del array
            System.out.print(tablero[i][0]+" ");

            /* Continua imprimiendo las celdas a partir de la posicion 1 en X y Y 
            (o sea a partir de la 2da posicion de filas y de columnas) para no 
            tener error por la celdas ya ocupdas en [0][Column: 0-8]= Primera fila (posicion 0), 
            y en [Fila: 0-8][0]= Primera column (posicion 0) */

            for (int j = 1; j < 9; j++) {
                if ((i + j) % 2 == 0) { //imprimir en celdas multiplos de 2 (pares)
                    System.out.print(fondWhite+tablero[i][j]+fondReset+lettReset); 
                } 
                else {
                    System.out.print(fondBlack+tablero[i][j]+fondReset+lettReset);   
                }
            }
            System.out.println(""+fondReset);
        }   
        System.out.println("\n");
    }

    //Metodo para llenar Tablero y luego imprimirlo
    public void llenarTablero(){
        for(int i=0;i<10;i++){ //9
            for(int j=0;j<10;j++){ //9
                tablero[j][0]=""+j; //Imprimir nuevamente los numero de referencia laterales
                tablero[0][i]=" "+i; //Imprimir nuevamente los numeros de referncia superiores
                tablero[i][j]=space; 
            }
        }
        //imprimirTablero();
    }

    /* --- YA NO LO USE POR QUE SE MODIFICO PARA EL INGRESO DE FICHAS ---
    private void llenarImprimirTablero() {

        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if ((i + j) % 2 == 0) {
                    tablero[0][i] = " "+i+" "; //
                    tablero[i][j] = fondWhite+lettBlack+f1+fondReset+lettReset; //Se llena con fondo negro, letra blanca, O y se resetea
                }
                else {
                    tablero[j][0] = " "+j+" ";
                    tablero[i][j] = fondBlack+lettWhite+f2+fondReset+lettReset; //Se llena con fondo blanco,letra negra, X y se resetea
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println("");
        }
    }
    */
}
