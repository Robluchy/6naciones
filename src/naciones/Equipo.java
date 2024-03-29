package naciones;

import java.util.ArrayList;

public class Equipo {

    private int id;
    private Nacion nacion;
    private ArrayList<Jugador> alineacion;
    private int partidosGanados;
    private int partidosJugados;
    private int partidosPerdidos;
    private int partidosEmpatados;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Entrenador> entrenadores;
    private int mediaEquipo;

    public Equipo(Nacion nacion) {
        this.nacion = nacion;
        jugadores = new ArrayList<>();
        entrenadores = new ArrayList<>();
        partidosEmpatados = 0;
        partidosGanados = 0;
        partidosJugados = 0;
        partidosPerdidos = 0;
        id = 0;

    }

    public Equipo(int partidosGanados, int partidosJugados, int partidosPerdidos, int partidosEmpatados,
            ArrayList<Jugador> jugadores, ArrayList<Entrenador> entrenadores) {
        this.partidosGanados = partidosGanados;
        this.partidosJugados = partidosJugados;
        this.partidosPerdidos = partidosPerdidos;
        this.partidosEmpatados = partidosEmpatados;
        this.jugadores = jugadores;
        this.entrenadores = entrenadores;
    }

	public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public void setPartidosEmpatados(int partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void addJugador(Jugador jugador) {

        this.jugadores.add(jugador);
    }

    public void addEntrenador(Entrenador entrenador) {
        this.entrenadores.add(entrenador);
    }

    public ArrayList<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(ArrayList<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    public int obtenerMedia() {
        for (int i = 0; i < jugadores.size(); i++) {
            mediaEquipo = jugadores.get(i).media();
        }
        return mediaEquipo;
    }

    @Override
    public String toString() {
        String aux = "Id:" + id  +" "+ nacion +
                ", partidosGanados " + partidosGanados +
                ", partidosJugados " + partidosJugados +
                ", partidosPerdidos " + partidosPerdidos +
                ", partidosEmpatados " + partidosEmpatados + '}'
                + "\nJugadores: " + jugadores.size() + "\nEntrenadores: " + entrenadores.size();
                
                // for (Jugador jugador : jugadores) {
                // aux += "\n" + jugador.toString();
                // }
                // for (Entrenador entrenador : entrenadores) {
                // aux += "\n" + entrenador.toString();
                // }
        return aux;
    }

    public void addEmpate() {
        partidosEmpatados++;
    }

    public void addGanado() {
        partidosGanados++;
    }

    public void addVictoria() {
        partidosJugados++;
    }

    public void addPerdido() {
        partidosPerdidos++;
    }

    public void addPartidoJugado() {
        partidosJugados++;
    }

    public Nacion getNombre() {
        return this.nacion;

    }
    
    public void setAlineacion(ArrayList<Jugador> alineacion){
        this.alineacion = alineacion;
    }

    public ArrayList<Jugador> getAlineacion(){
        return this.alineacion;
    }
}