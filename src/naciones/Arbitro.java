package naciones;

import java.util.Date;

public class Arbitro extends Persona {

    private int precision;

    public Arbitro() {
        super();
        precision = randomInt(1, 100);
    }

    private int randomInt(int min, int max) {
        return (int) Math.floor((Math.random() * (max - min + 1)) + min);
    }


    public Arbitro(String nombreCompleto, double peso, Date fechaNacimiento, int precision) {
        super(nombreCompleto, peso, fechaNacimiento);
        this.precision = precision;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    @Override

    public String toString() {
        return  this.getNombreCompleto() + " precision " + precision +"\n";
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
