package naciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Entrenador extends Persona {

    private int id;
    private ArrayList<Jugador> alineacion;
    private int experiencia;
    private Equipo equipo;

    public Entrenador() {
        experiencia = randomInt(1, 100);
        equipo = null;
        id = 0;
    }

    private int randomInt(int min, int max) {
        return (int) Math.floor((Math.random() * (max - min + 1)) + min);
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
        return this.getNombreCompleto() + "  experiencia " + experiencia + "\n";
    }

    public void alinearEquipos(Equipo equipo) {
        
    }
    
    public void setEntrenadores(Equipo equipo) {
            
    }

    public void getEntrenadores(Equipo equipo) {
        
        return;
    }

    public void ponerAlineacion(ArrayList<Jugador> alineacion) {

        Collections.sort(alineacion);

        int count = 0;

        for (Jugador jugador : alineacion) {
            if (count >= 15) {
                break;
            }
            this.alineacion.add(jugador);

            count++;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
}
