package naciones;

import java.util.ArrayList;
import java.util.Date;

public class Partido {

    private Equipo equipoVisitante;
    private Equipo equipoLocal;
    private ArrayList<Arbitro> arbitros;
    private Date fecha;

    public Partido(Equipo equipoVisitante, Equipo equipoLocal, ArrayList<Arbitro> arbitros, Date fecha) {
        this.equipoVisitante = equipoVisitante;
        this.equipoLocal = equipoLocal;
        this.arbitros = arbitros;
        this.fecha = fecha;
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
        return "Equipo Visitante: " + equipoVisitante.getNombre() + ", Equipo Local: " + equipoLocal.getNombre() + ", arbitros: "
                + arbitros + ", fecha=" + fecha ;
    }

    public Equipo calcularGanador() {
        // se pide a cada equipo su media y se comparan, el que mayor media tiene gana
        if (equipoVisitante.obtenerMedia() > equipoLocal.obtenerMedia()) {
            return equipoVisitante;
        } else if (equipoVisitante.obtenerMedia() < equipoLocal.obtenerMedia()) {
            return equipoLocal;
        } else {
            return null;
        }
    }

    public void jugar(Estadio estadio) {
        estadio.addPartido(this);
    }

}
