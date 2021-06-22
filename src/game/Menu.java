package src.game;

import java.util.Scanner;
import src.players.*;
import src.tableboard.*;

public class Menu {
    VectorJugadores vec1 = new VectorJugadores();
    Tablero tablero = new Tablero();
    Scanner scanner = new Scanner(System.in);
    Ficha ficha = new Ficha(tablero);
    PiedraPapelTijera turno = new PiedraPapelTijera(ficha);

    public Menu() {

    }

    public void menuInicial() {
        tablero.llenarTablero();
        int opcion = 0;

        //Metodo de funcionamiento del Menu inicial
        while (opcion != 4) {
            System.out.println("\n\n * * * Damas * * * ");
            System.out.println("1. Crear un Jugador");
            System.out.println("2. Jugadores registrados");
            System.out.println("3. Jugar una partida");
            System.out.println("4. Salir del Juego");
            System.out.print("\nIngrese la opcion: ");
            opcion=scanner.nextInt();
            scanner.nextLine();

            if(opcion==1){
                vec1.ingresarJugador();
            } 
            else if(opcion==2){
                vec1.ordenarJugadores();
            } 
            else if(opcion==3){
                int id1;
                int id2;
                if(VectorJugadores.getJugador()[0]!=null && VectorJugadores.getJugador()[1]!=null){
                    tablero.llenarTablero();
                    vec1.ordenarJugadores();
                    System.out.println("\n");
                    System.out.print("Ingrese el ID del Primer jugador para la partida: ");
                    id1=scanner.nextInt();
                    System.out.print("Ingrese ID del Segundo jugador para la partida: ");
                    id2=scanner.nextInt();
                    turno.turnoJugador(id1, id2);
                }
                    System.out.println("\n- - - No se han registrado 2 jugadores minimo para jugar - - -");
                }
                else if(opcion==4){
                System.out.println("\n - - - Adiouuus - - -");
            }
        }
    }
}
