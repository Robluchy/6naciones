package naciones;

import java.util.Date;

public class Jugador extends Persona implements Comparable<Jugador> {

    private int id;
    private Equipo equipo;
    private int velocidad;
    private int fuerza;
    private int resistencia;

    public Jugador() {
        super();

        equipo = null;
        velocidad = randomInt(1, 100);
        fuerza = randomInt(1, 100);
        resistencia = randomInt(1, 100);
        id = 0;
    }

    private int randomInt(int min, int max) {
        return (int) Math.floor((Math.random() * (max - min + 1)) + min);
    }

    public Jugador(String nombreCompleto, double peso, Date fechaNacimiento, Equipo equipo, int velocidad, int fuerza,
            int resistencia) {
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
        return this.getNombreCompleto() +
                ", velocidad " + velocidad +
                ", fuerza " + fuerza +
                ", resistencia " + resistencia + "\n";
    }

    public int media() {
        int media = (this.velocidad + this.fuerza + this.resistencia) / 3;
        return media;
    }

    @Override
    public int compareTo(Jugador jugador) {

        int media = (this.velocidad + this.fuerza + this.resistencia) / 3;
        int mediaJugador = (jugador.velocidad + jugador.fuerza + jugador.resistencia) / 3;

        if (media < mediaJugador)
            return 1;
        else if (media > mediaJugador)
            return -1;
        else
            return 0;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
