package naciones;

import java.util.ArrayList;

public class Equipo {

    private enum nombreNacion {
        Irlanda,
        Escocia,
        Francia,
        Gales,
        Italia,
        Inglaterra
    }

   
    private int partidosGanados;
    private int partidosJugados;
    private int partidosPerdidos;
    private int partidosEmpatados;
    private ArrayList<Jugador> alineacion;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Entrenador> entrenadores;

    public Equipo() {
        jugadores = new ArrayList<>();
        entrenadores = new ArrayList<>();
        partidosEmpatados = 0;
        partidosGanados = 0;
        partidosJugados = 0;
        partidosPerdidos = 0;
        alineacion = new ArrayList<>();

    }

    public Equipo(int partidosGanados, int partidosJugados, int partidosPerdidos, int partidosEmpatados,
            ArrayList<Jugador> jugadores, ArrayList<Entrenador> entrenadores, ArrayList<Jugador> alineacion) {
        this.partidosGanados = partidosGanados;
        this.partidosJugados = partidosJugados;
        this.partidosPerdidos = partidosPerdidos;
        this.partidosEmpatados = partidosEmpatados;
        this.jugadores = jugadores;
        this.entrenadores = entrenadores;
        this.alineacion = alineacion;

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

    public ArrayList<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(ArrayList<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    public ArrayList<Jugador> getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(ArrayList<Jugador> alineacion) {
        this.alineacion = alineacion;
    }

    @Override
    public String toString() {
        return "Equipo{" + ", partidosGanados=" + partidosGanados + ", partidosJugados=" + partidosJugados
                + ", partidosPerdidos=" + partidosPerdidos + ", partidosEmpatados=" + partidosEmpatados + ", jugadores="
                + jugadores + ", entrenadores=" + entrenadores + '}';
    }

    // Metodos

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

}
