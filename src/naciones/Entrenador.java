package naciones;

import java.util.Date;

public class Entrenador extends Persona {

    private int experiencia;
    private Equipo equipo;

    public Entrenador() {
        experiencia = 0;
        equipo = null;
    }

    public Entrenador(Entrenador entrenador) {
        experiencia = entrenador.experiencia;
        equipo = entrenador.equipo;

    }

    public Entrenador(String nombreCompleto, double peso, Date fechaNacimiento, int experiencia, Equipo equipo) {
        super(nombreCompleto, peso, fechaNacimiento);
        this.experiencia = experiencia;
        this.equipo = equipo;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Entrenador{" + "experiencia=" + experiencia + ", equipo=" + equipo + '}';
    }

    // metodo poner alineacion de jugadores
    public void ponerAlineacion(Jugador jugador) {
        return;
    }

}
