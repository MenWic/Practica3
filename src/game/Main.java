package src.game;

public class Main {

    /*
        Mi idea es comenzar pidiendo 10 jugadores (aunque solo se elegira a 2) que se almacenaran
        en el vectorJugadores, luego crear un tablero, llenarlo con los colores... Luego crear
        2 tipos de fichas y un arreglo de fichas que pida tenga como parametro un tablero creado 
        y se llene con fichas1 arriba y las fichas 2 abajo pero, para eso se jugara piedra papel 
        y tijeras por un metodo random para determinar a un vencedor que eliga las fichas que quiere
        usar, luego de eso... se empieza una partida donde se han establecido la mayoria de reglas
        de Daas chinas... - Lunes
    */

    public static void main(String[] args){
        System.out.println("(Pinch* Ant no corria)");
        System.out.println("\n\n * * * Bienvenido al Juego de Damas * * *");

        Menu menu=new Menu();
        menu.menuInicial();
    }
}
