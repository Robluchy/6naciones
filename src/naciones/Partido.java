package naciones;

import java.util.ArrayList;
import java.util.Date;

public class Partido {

    private Equipo equipoVisitante;
    private Equipo equipoLocal;
    private ArrayList<Arbitro> arbitros;
    private ArrayList<Entrenador> entrenadores;
    private Date fecha;
    private Estadio estadio;

    public Partido(Equipo equipoVisitante, Equipo equipoLocal, ArrayList<Arbitro> arbitros, Date fecha) {
        this.equipoVisitante = equipoVisitante;
        this.equipoLocal = equipoLocal;
        this.arbitros = arbitros;
        this.fecha = fecha;
    }

    public ArrayList<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
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

    private void setEstadio(Estadio estadio) {
        this.estadio = estadio;
	}

    public Estadio getEstadio() {
        return estadio;
    }

    public void jugar(Estadio estadio) {
        estadio.setPartido(this);
        this.setEstadio(estadio);
        Equipo equipoGanador = this.calcularGanador();
        // System.out.println("\n" + this.toString());
        if (equipoGanador == this.getEquipoLocal()) {
            this.getEquipoLocal().addGanado();
            this.getEquipoVisitante().addPerdido();
            // System.out.println("Ha ganado " + this.getEquipoLocal());
        } else if (equipoGanador == this.getEquipoVisitante()) {
            this.getEquipoVisitante().addGanado();
            this.getEquipoLocal().addPerdido();
            // System.out.println("Ha ganado " + this.getEquipoVisitante());
        } else {
            this.getEquipoLocal().addEmpate();
            this.getEquipoVisitante().addEmpate();
            // System.out.println("Empate");
        }
    }
}
