package src.tableboard;

import src.players.*;
import java.util.Scanner;

public class Ficha {
    //Variables globales de clase
    private static String ficha1;
    private static String ficha2;
    private Tablero tablero;
    private String lettWhite;
    private String lettRed;
    private String lettReset;
    Scanner scanner =new Scanner(System.in);

    public Ficha(Tablero tablero){
        //Variables locales del constructor
        lettWhite = "\u001B[37m";
        lettRed = "\u001B[31m";
        lettReset ="\u001B[0m";
        ficha1=lettWhite+" Q "+lettReset;
        ficha2=lettRed+" O "+lettReset;
        this.tablero=tablero;
    }

    //Getters y Setters
    public Tablero getTablero(){
        return tablero;
    }
    public void setTablero(Tablero tablero){
        this.tablero=tablero;
    }

    public static String getFicha1() {
        return ficha1;
    }

    public static String getFicha2() {
        return ficha2;
    }
    

    //Metodo para asignar fichas a lugares correspondientes en tablero
    public void addFichaTablero(){
        for(int i=1;i<4;i++){
            for(int j=1;j<9;j++){
                if((i%2)!=0 && (j%2)==0){
                    this.tablero.getTablero()[i][j]=ficha1;
                }
                if((i%2)==0 && (j%2)!=0){
                    this.tablero.getTablero()[i][j]=ficha1; //2
                }
            }
        }
        for(int i=6;i<9;i++){
            for(int j=1;j<9;j++){
                if((i%2)==0 && (j%2)!=0){
                    this.tablero.getTablero()[i][j]=ficha2; //1
                }
                if((i%2)!=0 && (j%2)==0){
                    this.tablero.getTablero()[i][j]=ficha2;
                }
            }
        }
        System.out.println("\n");
        this.tablero.imprimirTablero(); //Imprime tablero ya seteado con las fichas en el
    }

    //Metodo para mover fichas o comer, me arden los ojos por esto
    public void turnoJugador1(Jugador jugador1,String ficha1,String ficha2){
        //Variales locales del metodo
        boolean celdaVacia=true;
        boolean puedeComer=true;

        //Ciclo de ingreso de coordena de la ficha a mover y coordenada a traspasar
        do{
            System.out.print("\n"+jugador1.getName()+" Ingrese la fila de la ficha que quiere seleccionar (Cordenadas Horizontales): ");
            int coordInicialX=scanner.nextInt();
            System.out.print(jugador1.getName()+" Ingrese columna de la ficha que quiere seleccionanar (Cordenadas Verticales): ");
            int coordInicialY=scanner.nextInt();
            if(this.tablero.getTablero()[coordInicialY+1][coordInicialX+1].equals(ficha2) && this.tablero.getTablero()[coordInicialY+2][coordInicialX+2].equals(Tablero.getSpace()) || (this.tablero.getTablero()[coordInicialY+1][coordInicialX-1].equals(ficha2) && this.tablero.getTablero()[coordInicialY+2][coordInicialX-2].equals(Tablero.getSpace()))){
                
                //Si puede comer, se muestra un aviso de que puede comer
                puedeComer=true;

                System.out.println("\n AVISO: Puede comer una ficha! ");
                System.out.print(jugador1.getName()+", ingrese la fila de celda a la que quiere mover su ficha (Cordenadas Horizontales):  ");
                int coordFinalX=scanner.nextInt();
                System.out.print(jugador1.getName()+", ingrese la columna de celda a la que quiere mover su ficha (Cordenadas Verticales): ");
                int coordFinalY=scanner.nextInt();

                if(coordFinalY==coordInicialY+2 && coordFinalX==coordInicialX+2 ){
                    this.tablero.getTablero()[coordFinalY][coordFinalX]=this.tablero.getTablero()[coordInicialY][coordInicialX];
                    this.tablero.getTablero()[coordInicialY][coordInicialX]=Tablero.getSpace();
                    this.tablero.getTablero()[coordInicialY+1][coordInicialX+1]=Tablero.getSpace();
                    System.out.println(" - - - - Ficha comida - - - -\n");
                    celdaVacia=false;
                } 
                else if(coordFinalY==coordInicialY+2 && coordFinalX==coordInicialX-2){
                    this.tablero.getTablero()[coordFinalY][coordFinalX]=this.tablero.getTablero()[coordInicialY][coordInicialX];
                    this.tablero.getTablero()[coordInicialY][coordInicialX]=Tablero.getSpace();
                    this.tablero.getTablero()[coordInicialY+1][coordInicialX-1]=Tablero.getSpace();
                    System.out.println(" - - - - Ficha comida - - - - \n");
                    celdaVacia=false;
                } 
                else {
                    this.tablero.imprimirTablero();
                }
            } 
            else {
                puedeComer=false;
            }
            //Si no puede comer... todo sigue normal
            if(puedeComer==false){
                if(this.tablero.getTablero()[coordInicialY][coordInicialX].equals(ficha1)){
                    if(this.tablero.getTablero()[coordInicialY][coordInicialX]!=Tablero.getSpace()){
                        System.out.print(jugador1.getName()+" Ingrese la fila de celda destino (Coordenadas Horizontales): ");
                        int coordFinalX=scanner.nextInt();
                        System.out.print(jugador1.getName()+" Ingrese la columna de celda destino (Coordenadas Verticales): ");
                        int coordFinalY=scanner.nextInt();
                        
                        if(this.tablero.getTablero()[coordFinalY][coordFinalX].equals(Tablero.getSpace()) && coordFinalY>coordInicialY && coordFinalY<coordInicialY+2 &&(coordFinalX<coordInicialX+2 && coordFinalX>coordInicialX-2)){
                            this.tablero.getTablero()[coordFinalY][coordFinalX]=this.tablero.getTablero()[coordInicialY][coordInicialX];
                            this.tablero.getTablero()[coordInicialY][coordInicialX]=Tablero.getSpace();
                            celdaVacia=false;
                        } 
                        else {
                            System.out.println("Movimiento no valido, no sea baboso xD");
                            this.tablero.imprimirTablero();
                        }
                    } 
                    else {
                        System.out.println("- * - Coordena inicial de su ficha indicada no encontrada - * -");
                        this.tablero.imprimirTablero();
                    }
                } else {
                    System.out.println("- * - Coordenada indicada, no valida - * -");
                    this.tablero.imprimirTablero();
                }
            }
        } 
        while(celdaVacia!=false); //Mostrar indicaciones anteriores eimpre que la celda destino no este vacia
    }

    public void turnoJugador2(Jugador jugador2,String ficha2,String ficha1){
        boolean celdaVacia=true;
        boolean puedeComer=true;

        do{
            System.out.print("\n"+jugador2.getName()+" Ingrese la fila de la ficha que quiere seleccionar (Cordenadas Horizontales): ");
            int coordInicialX=scanner.nextInt();
            System.out.print(jugador2.getName()+" Ingrese la columna de la ficha que quiere seleccionar (Cordenadas Verticales): ");
            int coordInicialY=scanner.nextInt();
            if(this.tablero.getTablero()[coordInicialY-1][coordInicialX-1].equals(ficha1) &&this.tablero.getTablero()[coordInicialY-2][coordInicialX-2].equals(Tablero.getSpace()) || (this.tablero.getTablero()[coordInicialY-1][coordInicialX+1].equals(ficha1) &&this.tablero.getTablero()[coordInicialY-2][coordInicialX+2].equals(Tablero.getSpace()))){
                puedeComer=true;
                System.out.println("\n ! Hay posibilidad de comerte una ficha !");
                System.out.print(jugador2.getName()+" Ingrese la fila de celda destino (Coordenadas Horizontales): ");
                int posicionFinalX=scanner.nextInt();
                System.out.print(jugador2.getName()+" Ingrese la columna de celda destino (Coordenadas Verticales): ");
                int posicionFinalY=scanner.nextInt();
                if(posicionFinalY==coordInicialY-2 && posicionFinalX==coordInicialX+2 ){
                    this.tablero.getTablero()[posicionFinalY][posicionFinalX]=this.tablero.getTablero()[coordInicialY][coordInicialX];
                    this.tablero.getTablero()[coordInicialY][coordInicialX]=Tablero.getSpace();
                    this.tablero.getTablero()[coordInicialY-1][coordInicialX+1]=Tablero.getSpace();
                    System.out.println(" - - - - Ficha comida - - - - \n");                    celdaVacia=false;
                } 
                else if(posicionFinalY==coordInicialY-2 && posicionFinalX==coordInicialX-2){
                    this.tablero.getTablero()[posicionFinalY][posicionFinalX]=this.tablero.getTablero()[coordInicialY][coordInicialX];
                    this.tablero.getTablero()[coordInicialY][coordInicialX]=Tablero.getSpace();
                    this.tablero.getTablero()[coordInicialY-1][coordInicialX-1]=Tablero.getSpace();
                    System.out.println(" - - - - Ficha comida - - - - \n");                    celdaVacia=false;
                } 
                else {
                    this.tablero.imprimirTablero();
                }    
            } 
            else {
                puedeComer=false;
            }
            //Si no puede comer... todo sigue normal
            if(puedeComer==false){
                if(this.tablero.getTablero()[coordInicialY][coordInicialX].equals(ficha2) ){
                    if(this.tablero.getTablero()[coordInicialY][coordInicialX]!=Tablero.getSpace()){
                        System.out.print(jugador2.getName()+" Ingrese la fila de celda destino (Coordenadas Horizontales): ");
                        int coordFinalX=scanner.nextInt();
                        System.out.print(jugador2.getName()+" Ingrese la columna de celda destino (Coordenadas Verticales): ");
                        int coordFinalY=scanner.nextInt();

                        if(this.tablero.getTablero()[coordFinalY][coordFinalX].equals(Tablero.getSpace())&& coordFinalY<coordInicialY && coordFinalY>coordInicialY-2 &&(coordFinalX<coordInicialX+2 && coordFinalX>coordInicialX-2)){
                            this.tablero.getTablero()[coordFinalY][coordFinalX]=this.tablero.getTablero()[coordInicialY][coordInicialX];
                            this.tablero.getTablero()[coordInicialY][coordInicialX]=Tablero.getSpace();
                            celdaVacia=false;
                        } 
                        else {
                            System.out.println("Movimiento no valido, no sea baboso xD");
                            this.tablero.imprimirTablero();
                        }
                    } 
                    else {
                        System.out.println("- * - Coordena inicial de su ficha indicada no encontrada - * -");
                        this.tablero.imprimirTablero();
                    }
                } 
                else {
                    System.out.println("- * - Coordenada indicada, no valida - * -");
                    this.tablero.imprimirTablero();
                }
            }
        } 
        while(celdaVacia!=false); //Mostrar indicaciones anteriores eimpre que la celda destino no este vacia
    }
    
    //Metodo para comprobar si ya no hay fichas del oponente, y asi declarar ganador al Jugador1
    public boolean testJugador1(Jugador jugador1,String ficha1){
        int contador=0;

        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                if(!this.tablero.getTablero()[i][j].equals(ficha1)){
                    contador++;
                }
            }
        }
        if(contador==64){ //Al recorrer los64 espacio (por ser arreglo de 8x8) y no encontrar una ficha oponente es ganador
            jugador1.setChampion(1);
            System.out.println("\n* * * Ganador: "+jugador1.getInformacion()+" * * *\n");
            return true;
        } 
        else {
            return false;
        }
    }

    //Metodo para comprobar si ya no hay fichas del oponente, y asi declarar ganador al Jugador2 (recorriendo todo el arreglo)
    public boolean testJugador2(Jugador jugador2,String ficha2){
        int contador=0;

        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                if(!this.tablero.getTablero()[i][j].equals(ficha2)){
                    contador++;
                }
            }
        } 
        if(contador==64){ //Al recorrer los64 espacio (por ser arreglo de 8x8) y no encontrar una ficha oponente es ganador
            jugador2.setChampion(1);
            System.out.println("Ganador: "+jugador2.getInformacion());
            return true;
        } 
        else{
            return false;
        }        
    }
    
    //Metodo para pedir Coordenada de cambio
    public void pedirCoordDeCambio(Jugador jugador1, Jugador jugador2, String ficha1, String ficha2,int opc){
        //Variable local del metodo
        boolean ganador=false;

        while(ganador!=true){
            if(opc==1){
                turnoJugador1(jugador1,ficha1,ficha2);
                this.tablero.imprimirTablero();
                turnoJugador2(jugador2,ficha2,ficha1);
                this.tablero.imprimirTablero();

                ganador=testJugador1(jugador1,ficha2);
                ganador=testJugador2(jugador2,ficha1);
            } 
            else if (opc==2){
                turnoJugador2(jugador2,ficha2,ficha1);
                this.tablero.imprimirTablero();
                turnoJugador1(jugador1,ficha1,ficha2);
                this.tablero.imprimirTablero();

                ganador=testJugador1(jugador1,ficha1);
                ganador=testJugador2(jugador2,ficha2);
            }
        }
    }
}
