package naciones;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class Arbitro extends Persona {

    private int precision;
    private HashMap <Partido, String> actas;
    private int id;

    public Arbitro() {
        super();
        precision = randomInt(1, 100);
        actas = new HashMap <Partido, String>();
        id = 0;
    }

    public Arbitro(String nombreCompleto, double peso, Date fechaNacimiento, int precision) {
        super(nombreCompleto, peso, fechaNacimiento);
        this.precision = precision;
        actas = new HashMap <Partido, String>();

        
    }
    private int randomInt(int min, int max) {
        return (int) Math.floor((Math.random() * (max - min + 1)) + min);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void empezarPartido(Partido partido) {
        System.out.println("El arbitro empieza el partido");
    }

    public void finalizarPartido(Partido partido) {
        System.out.println("El arbitro finaliza el partido");
    }

    public void escribirActa(Partido partido) {
        //    	HashMap<Partido, String> copia = new HashMap <>(actas);
        //    	Set<Partido>setPartidos = Partido.keySet();
        //    	Partido partidoMax = null;
        //    	String act ="/nHISTORIAL DE ACTAS";
        //    	act += "\n acta: V - D - E" + jugar();
        //    	
        //    	if (copia.containsValue(0)) {
        //    		System.out.println("El primer arbitro escribe las actas");
        //    	}
                
        actas.put(partido, partido.toString() );
        
    }
}
