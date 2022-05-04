package naciones;

import java.util.Date;

public class Arbitro extends Persona{


    private int presicion;

    public Arbitro() {
        super();
        presicion = 0;
    }

    public Arbitro(Arbitro arbitro) {
        super(arbitro);
        presicion = arbitro.presicion;
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
        return "Arbitro{" + "presicion=" + presicion + '}';
    }

    //METODO EMPEZAR PARTIDO
    public void empezarPartido(Partido partido){
        System.out.println("El arbitro empieza el partido");
    }
    //METODO FINALIZAR PARTIDO
    public void finalizarPartido(Partido partido){
        System.out.println("El arbitro finaliza el partido");
    }
    
    
}
