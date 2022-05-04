package naciones;

import java.util.Date;

public class Jugador extends Persona {
    private Equipo equipo;
    private int velocidad;
    private int fuerza;
    private int resistencia;

    public Jugador() {
        super();
        equipo = null;
        velocidad = 0;
        fuerza = 0;
        resistencia = 0;
    }

    public Jugador(Jugador jugador) {
        super(jugador);
        equipo = jugador.equipo;
        velocidad = jugador.velocidad;
        fuerza = jugador.fuerza;
        resistencia = jugador.resistencia;
    }

    public Jugador(String nombreCompleto, double peso, Date fechaNacimiento, Equipo equipo, int velocidad, int fuerza, int resistencia) {
        super(nombreCompleto, peso, fechaNacimiento);
        this.equipo = equipo;
        this.velocidad = velocidad;
        this.fuerza = fuerza;
        this.resistencia = resistencia;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "equipo=" + equipo +
                ", velocidad=" + velocidad +
                ", fuerza=" + fuerza +
                ", resistencia=" + resistencia +
                '}';
    }
}
