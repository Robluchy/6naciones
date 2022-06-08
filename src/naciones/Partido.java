package naciones;

import java.util.ArrayList;
import java.util.Date;

public class Partido {

    private Equipo equipoVisitante;
    private Equipo equipoLocal;
    private ArrayList<Arbitro> arbitros;
    private ArrayList<Entrenador> entrenadores;
    private Date fecha;
    private int id;
    private int golesLocal;
    private int golesVisitante;

    public Partido() {
        arbitros = new ArrayList<>();
        entrenadores = new ArrayList<>();
        equipoLocal = null;
        equipoVisitante = null;
        fecha = new Date();
    }
    public Partido(Equipo equipoVisitante, Equipo equipoLocal, ArrayList<Arbitro> arbitros, Date fecha) {
        this.equipoVisitante = equipoVisitante;
        this.equipoLocal = equipoLocal;
        this.arbitros = arbitros;
        this.fecha = fecha;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public ArrayList<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(ArrayList<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public Date getFechaPartido() {
        return fecha;
    }

    public void setFechaPartido(Date fecha) {
        this.fecha = fecha;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void seEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public ArrayList<Arbitro> getArbitros() {
        return arbitros;
    }

    public void setArbitros(ArrayList<Arbitro> arbitros) {
        this.arbitros = arbitros;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Equipo Visitante: " + equipoVisitante.getNombre() + ", Equipo Local: " + equipoLocal.getNombre()
                + ", arbitros: "
                + arbitros + ", fecha=" + fecha;
    }

    public Equipo calcularGanador() {
        if (equipoVisitante.obtenerMedia() > equipoLocal.obtenerMedia()) {
            return equipoVisitante;
        } else if (equipoVisitante.obtenerMedia() < equipoLocal.obtenerMedia()) {
            return equipoLocal;
        } else {
            return null;
        }
    }

    private int randomInt(int min, int max) {
        return (int) Math.floor((Math.random() * (max - min + 1)) + min);
    }
    
    public void jugar(Estadio estadio) {
        estadio.setPartido(this);
        Equipo equipoGanador = this.calcularGanador();
        // System.out.println("\n" + this.toString());
				if (equipoGanador == this.getEquipoLocal()) {
					this.getEquipoLocal().addGanado();
					this.getEquipoVisitante().addPerdido();
					golesLocal=randomInt(20,50);
					golesVisitante=randomInt(0,19);
					
					// System.out.println("Ha ganado " + this.getEquipoLocal());
				} else if (equipoGanador == this.getEquipoVisitante()) {
					this.getEquipoVisitante().addGanado();
					this.getEquipoLocal().addPerdido();
					golesLocal=randomInt(0,35);
					golesVisitante=randomInt(36,70);
					// System.out.println("Ha ganado " + this.getEquipoVisitante());
				} else {
					this.getEquipoLocal().addEmpate();
					this.getEquipoVisitante().addEmpate();
					int auxGoles = randomInt(0,75);
					golesLocal=auxGoles;
					golesVisitante=auxGoles;
					// System.out.println("Empate");
				}
				arbitros.get(0).finalizarPartido(this);
				arbitros.get(0).escribirActa(this);
				
    }
}
