package src.players;

public class Jugador {
    //Variables globales de la clase
    private String name;
    private int score;
    private int champion;
    private int loser;
    private int id;

    public Jugador(int id,String name,int score,int champion,int loser){
        //Variables locales para cada Jugador
        this.id=id;
        this.name=name;
        this.score=score;
        this.champion=champion;
        this.loser=loser;
    }

    //Getters y Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public int getChampion() {
        return champion;
    }
    public void setChampion(int champion) {
        this.champion = champion;
    }

    public int getLoser() {
        return loser;
    }
    public void setLoser(int loser) {
        this.loser = loser;
    }

    //Metodo para imprimir info del jugador
    public String getInformacion(){
        return "ID: "+id+"... Nombre: "+name+"... Puntuacion: "+score+"... Partidas Ganadas: "+champion+"... Partidas Perdidas: "+loser;
    }
    
}
