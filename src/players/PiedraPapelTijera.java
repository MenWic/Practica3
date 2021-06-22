package src.players;

import java.util.Scanner;
import src.tableboard.*;

public class PiedraPapelTijera {
    //Variables Globales de clase
    Ficha ficha;
    Scanner scanner=new Scanner(System.in);
    
    public PiedraPapelTijera(Ficha ficha){
        this.ficha=ficha;
    }

    //Metodos de la accion Piedra Papel y Tijera para dictar quien inica el juego
    public void turnoJugador(int id1, int id2){
        //Variables locales del metodo
        boolean id1Existe=false;
        boolean id2Existe=false;

        for(int i=0;i<VectorJugadores.getContador();i++){
            if(VectorJugadores.getJugador()[i].getId()==id1){
                id1Existe=true;
            }
        }
        for(int i=0;i<VectorJugadores.getContador();i++){
            if(VectorJugadores.getJugador()[i].getId()==id2){
                id2Existe=true;
            }        
        }
        if(id1Existe==true && id2Existe==true){ //Cumplir ambas para continuar
            if(id1==id2){
                System.out.println("No puede ingresar el mismo ID");
            } 
            else {
                //Variable del ciclo inicializada con el resultado de Piedra Palel y Tijera
                int idGanador=opcGanadora(id1, id2);

                if(idGanador==id1){
                    eleccionGanador(id1, id2);
                }
                if(idGanador==id2){
                    eleccionGanador(id2, id1);
                }
            }
        } 
        else {
            System.out.println("\n - - - El ID ingresado no existe aun, intente nuevamente - - ");
        }
    }

    //Metodo que realiza Piedra Papel y Tijera y dicta el ganador
    public int opcGanadora(int id1,int id2){
        int num1=(int)((Math.random()*(3-1))+1);
        int num2=(int)((Math.random())*(3-1)+1);
        int ganador=12;

        System.out.println("\n - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * -\n");
        System.out.println(" * * * Generando aleatoriamente Piedra, Papel o Tijera * * *");
        System.out.println("\n - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * -\n");
        
        //Se crearan presets de resultados para no hacer un proceso complejo
        if(num1==1 && num2==1){
            System.out.println(VectorJugadores.getJugador()[id1].getName()+ "= Piedra");
            System.out.println(VectorJugadores.getJugador()[id2].getName()+" = Piedra");
            System.out.println("* * * EMPTAE * * *\n");
        } 
        else if(num1==1 && num2==2){
            System.out.println(VectorJugadores.getJugador()[id1].getName()+" = Piedra ");
            System.out.println(VectorJugadores.getJugador()[id2].getName()+" = Papel");
            System.out.println("* * * Ganador: "+VectorJugadores.getJugador()[id2].getName()+" * * *\n");
            ganador=id2;
        } 
        else if(num1==1 && num2==3){
            System.out.println(VectorJugadores.getJugador()[id1].getName()+" = Piedra");
            System.out.println(VectorJugadores.getJugador()[id2].getName()+" = Tijeras");
            System.out.println("* * * Ganador: "+VectorJugadores.getJugador()[id1].getName()+" * * *\n");
            ganador=id1;
        }

        if(num1==2 && num2==1){
            System.out.println(VectorJugadores.getJugador()[id1].getName()+" = Papel");
            System.out.println(VectorJugadores.getJugador()[id2].getName()+" = Piedra");
            System.out.println("* * * Ganador: "+VectorJugadores.getJugador()[id1].getName()+" * * *\n");
            ganador=id1;
        } 
        else if(num1==2 && num2==2){
            System.out.println(VectorJugadores.getJugador()[id1].getName()+" = Papel");
            System.out.println(VectorJugadores.getJugador()[id2].getName()+" = Papel");
            System.out.println("* * * EMPATE * * *\n");
        } 
        else if(num1==2 && num2==3){
            System.out.println(VectorJugadores.getJugador()[id1].getName()+" = Papel");
            System.out.println(VectorJugadores.getJugador()[id2].getName()+" = Tijeras");
            System.out.println("* * * Ganador: "+VectorJugadores.getJugador()[id2].getName()+" * * *\n");
            ganador=id2;
        }

        if(num1==3 && num2==1){
            System.out.println(VectorJugadores.getJugador()[id1].getName()+" = Tijeras");
            System.out.println(VectorJugadores.getJugador()[id2].getName()+" = Piedra");
            System.out.println("* * * Ganador: "+VectorJugadores.getJugador()[id2].getName()+" * * *\n");
            ganador=id2;
        }

        if(num1==3 && num2==2){
            System.out.println(VectorJugadores.getJugador()[id1].getName()+" = Tijeras");
            System.out.println(VectorJugadores.getJugador()[id1].getName()+" = Papel");
            System.out.println("* * * Ganador: "+VectorJugadores.getJugador()[id1].getName()+" * * *\n");
            ganador=id1;
        }

        if(num1==3 && num2==3){
            System.out.println(VectorJugadores.getJugador()[id1].getName()+" = Tijeras");
            System.out.println(VectorJugadores.getJugador()[id1].getName()+" = Tijeras");
            System.out.println("* * * EMPATE * * *\n");
        }
        return ganador;
    }

    //Metodo para asiganar fichas al Ganador y al Perdedor segun quien haya ganado en Piedra Papel y Tijera
    public void eleccionGanador(int idGanador,int idPerdedor){
        //Variables del Metodo
        System.out.println("GANADOR, elija el simbolo que quiere usar (1 = Q ... 2 = O): ");
        int opc=scanner.nextInt();

        //Si el ganador  elige 1, coloca arriba al ganador con fichas "Q"
        if(opc==1){
            System.out.println("\n- - ID: "+VectorJugadores.getJugador()[idGanador].getId()+",  Nombre: "+VectorJugadores.getJugador()[idGanador].getName()+" - -");
            this.ficha.addFichaTablero();
            System.out.println("\n\n- - ID: "+VectorJugadores.getJugador()[idPerdedor].getId()+". Nombre: "+VectorJugadores.getJugador()[idPerdedor].getName()+" - -\n");
           
            this.ficha.pedirCoordDeCambio(VectorJugadores.getJugador()[idGanador], VectorJugadores.getJugador()[idPerdedor], Ficha.getFicha1(),Ficha.getFicha2(),1);
        } 
        //Si el ganador elige 2, coloca abajo al ganador con fichas "O"
        else if(opc==2){
            System.out.println("\n- - ID: "+VectorJugadores.getJugador()[idPerdedor].getId()+", Nombre: "+VectorJugadores.getJugador()[idPerdedor].getName()+" - -");
            this.ficha.addFichaTablero();
            System.out.println("\n\n- - ID: "+VectorJugadores.getJugador()[idGanador].getId()+", Nombre: "+VectorJugadores.getJugador()[idGanador].getName()+" - -\n");
            
            this.ficha.pedirCoordDeCambio(VectorJugadores.getJugador()[idGanador],VectorJugadores.getJugador()[idPerdedor],Ficha.getFicha2(),Ficha.getFicha1(),2);
        }
    } 
}
