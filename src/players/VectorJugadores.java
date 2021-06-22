package src.players;

import java.util.Scanner;

public class VectorJugadores {
    //Variables globales de la clase
    Scanner scanner=new Scanner(System.in);
    private static Jugador[] jugadores = new Jugador[10]; //El inge dijo que se debia elegir a 2 jugadores de 5 que habran disponibles
    private static int contador;

    //Metodos estaticos por que quiero conservar los datos del vector de jugadores siempre
    public VectorJugadores(){
        contador = 0;
    }

    public static Jugador[] getJugador(){
        return jugadores;
    }
    public static void setJugador(Jugador[] jugador){
        jugadores=jugador;
    }

    public static int getContador(){
        return contador;
    }

    public void ingresarJugador(){
        String nombre;
        System.out.print("Ingrese el nombre del Jugador: ");
        nombre=scanner.next();

        //Si no escribe caracteres validos... no quize usar try catch
        if(nombre!=null){
            //Se registra un nuevo Jugador
            jugadores[contador] = new Jugador(contador, nombre, 0, 0, 0);
            System.out.println("- - - Se registo correctamente - - -");
            contador++;
        } 
        else {
            System.out.println("- - - Nombre no valido, ingrese uno correcto - - -");
        }
    }

    public void ordenarJugadores(){
        for (int i = 0; i <contador; i++) {
            for (int j = 0; j < (contador-i-1); j++) {
                if(jugadores[j].getChampion()<jugadores[j+1].getChampion()){
                    Jugador aux = jugadores[j];
                    jugadores[j] = jugadores[j+1];
                    jugadores[j+1]= aux;
                }
            }
        }
        mostrarJugador();
    }

    public void mostrarJugador(){
        System.out.println("\n\n - * - Perfiles registrados del Juego - * -  \n");
        for(int i=0;i<contador;i++){
            System.out.print(jugadores[i].getInformacion());
            System.out.println("\n");
        }
        if(jugadores[0]==null){
            System.out.println("\n - - - No hay perfiles guardados aun - - - \n\n");
        }
    }
}
