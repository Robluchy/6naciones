package naciones;

import java.util.Date;

public class Arbitro extends Persona {

    private int presicion;

    public Arbitro() {
        super();
        presicion = randomInt(1, 100);
    }

    private int randomInt(int min, int max) {
        return (int) Math.floor((Math.random() * (max - min + 1)) + min);
    }


    public Arbitro(String nombreCompleto, double peso, Date fechaNacimiento, int presicion) {
        super(nombreCompleto, peso, fechaNacimiento);
        this.presicion = presicion;
    }

    public int getPresicion() {
        return presicion;
    }

    public void setPresicion(int presicion) {
        this.presicion = presicion;
    }

    @Override

    public String toString() {
        return  this.getNombreCompleto() + " presicion " + presicion +"\n";
    }

    // METODO EMPEZAR PARTIDO
    public void empezarPartido(Partido partido) {
        System.out.println("El arbitro empieza el partido");
    }

    // METODO FINALIZAR PARTIDO
    public void finalizarPartido(Partido partido) {
        System.out.println("El arbitro finaliza el partido");
    }

}
