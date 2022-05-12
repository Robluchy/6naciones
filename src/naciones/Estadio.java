package naciones;

import java.util.ArrayList;

public class Estadio {

    private ArrayList<Partido> partidos;
    private int capacidad;
    private String nombre;

    public Estadio() {
        partidos = new ArrayList<>();
        capacidad = 0;
        nombre = "";
    }

    public Estadio(ArrayList<Partido> partidos, int capacidad, String nombre) {
        this.partidos = partidos;
        this.capacidad = capacidad;
        this.nombre = nombre;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addPartido(Partido partido) {
        partidos.add(partido);
    }

    @Override
    public String toString() {
        return "Estadio{" + "partidos=" + partidos + ", capacidad=" + capacidad + ", nombre=" + nombre + '}';
    }

}
